package com.jk.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.HomeMapper;
import com.jk.model.*;
import com.jk.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 悬浮式菜单
     * @param pid
     * @return
     */
    @Override
    @ResponseBody
    public List<Type> queryType(@RequestParam("pid") Integer pid) {
        List<Type> list = nodeType(pid);
        return list;
    }
    private List<Type> nodeType(Integer pid) {
        List<Type> list = homeMapper.queryType(pid);
        for (Type type: list ) {
            Integer id = type.getId();
            List<Type> nodes = nodeType(id);
            if(nodes.size()<=0){
                type.setSelectable(true);
            }else{
                type.setSelectable(false);
                type.setNodes(nodes);
            }
        }
        return list;
    }

    /**
     * 查询商品
     * @return
     */
    @Override
    @ResponseBody
    public List<Product> queryProduct() {
        return homeMapper.queryProduct();
    }

    /**
     * 根据s商品id回显
     * @param productId
     * @return
     */
    @Override
    @ResponseBody
    public Product queryProductById(Integer productId) {
        return homeMapper.queryProductById(productId);
    }

    /**
     * 查询店铺
     * @return
     */
    @Override
    @ResponseBody
    public List<Store> queryStore() {
        return homeMapper.queryStore();
    }

    /**
     * 查询轮播图
     * @return
     */
    @Override
    @ResponseBody
    public List<Lun> queryImg() {
        return homeMapper.queryImg();
    }

    /**
     * 订单查询
     * @param name
     * @return
     */
    @Override
    @ResponseBody
    public List<Order> queryOrder(@RequestParam("name") String name) {
        Order order = JSON.parseObject(name, Order.class);
        List<Order> list = homeMapper.queryOrder(order);
        return list;
    }

   /* @Override
    @ResponseBody
    public Json queryOrder() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC,"orderTime"));
        return mongoTemplate.find(query, Order.class);
    }*/

    /**
     * 加入购物车 mongodb
     * @param productId
     */
    @Override
    @ResponseBody
    public void saveProduct(@RequestParam("productId") Integer productId) {
        Product product = homeMapper.queryProductById(productId);
        Shop shop = new Shop();
        shop.setProductId(product.getProductId());
        shop.setProductImg(product.getProductImg());
        shop.setProductName(product.getProductName());
        shop.setProductPrice(product.getProductPrice());
        mongoTemplate.save(shop);
    }

    /**
     * 生成订单
     * @param order
     */
    @Override
    @ResponseBody
    public void saveOrder(@RequestBody Order order) {
        long orderId = (long) (Math.ceil((Math.random()*899999))+100000);
        order.setOrderId(orderId);
        order.setOrderImg("111");
        order.setOrderName("买买买");
        order.setOrderPrice(12.5);
        order.setOrderStatus(3);
        order.setOrderTime(new Date());
        mongoTemplate.save(order);
    }

    /**
     * 修改订单状态
     * @param id
     * @param orderStatus
     */
    @Override
    @ResponseBody
    public void updateStatus(@RequestParam("id") String id, @RequestParam("orderStatus")String orderStatus) {
        homeMapper.updateStatus(id,orderStatus);
    }

    /**
     * 根据类型id查询属性
     * @param typeId
     * @return
     */
    @Override
    @ResponseBody
    public Attribute queryAttribute(@RequestParam("typeId") Integer typeId) {
        return homeMapper.queryAttribute(typeId);
    }

    /**
     * 根据产品id查询类型
     * @param productId
     * @return
     */
    @Override
    @ResponseBody
    public int queryProdutType(Integer productId) {
        return homeMapper.queryProdutType(productId);
    }

    /**
     * 根据类型id查询产品
     * @param typeId
     * @return
     */
    @Override
    @ResponseBody
    public List<Product> queryProductByTypeId(Integer typeId) {
        return homeMapper.queryProductByTypeId(typeId);
    }

    /**
     * 根据用户id
     * 回显用户信息
     * @param userId
     * @return
     */
    @ResponseBody
    @Override
    public UserBean findByIdUser(@RequestParam("userId")Integer userId) {
        UserBean bean = homeMapper.findByIdUser(userId);
        System.out.println(bean);
        return bean;
    }

    /**
     * 修改用户信息
     * @param user
     */
    @ResponseBody
    @Override
    public void updateUser(@RequestBody UserBean user) {
        homeMapper.updateUser(user);
    }

    @Override
    @ResponseBody
    public Product selectCar(@RequestParam("spid") Integer spid) {
        Product cpBean = homeMapper.selectCar(spid);
        return cpBean;
    }

    //秒杀商品倒计时
    @ResponseBody
    @Override
    public List<SpikeBean> findSeckillDate() {

        return homeMapper.findSeckillDate();
    }

    @Override
    @ResponseBody
    public void queryGoodsId(@RequestParam("goodsId")Integer goodsId,@RequestParam("orderNo")String orderNo) {

        Long aLong = Long.valueOf(orderNo);
        Product pro = homeMapper.queryByGoodId(goodsId);
        Order order = new Order();
        order.setOrderId(aLong);
        order.setOrderName(pro.getProductName());
        order.setOrderTime(new Date());
        order.setOrderStatus(1);
        order.setOrderPrice(pro.getProductPrice());
        order.setOrderImg(pro.getProductImg());
        order.setProductId(goodsId);
        homeMapper.saveOrders(order);
    }

    @Override
    @ResponseBody
    public Product queryProductByIds(Integer spid) {
        return homeMapper.queryProductByIds(spid);
    }

    @Override
    @ResponseBody
    public String queryLoginByName(Integer userId) {
        return homeMapper.queryLoginByName(userId);
    }

    //查询秒杀商品
    @ResponseBody
    @Override
    public List querySeckill() {

        return homeMapper.querySeckill();
    }

    //加入购物车
    @ResponseBody
    @Override
    public void addSeckill(@RequestBody WebShoppingcCart cart) {

        homeMapper.addSeckill(cart);
    }
    //初始化物流信息
    @ResponseBody
    @Override
    public List<Logistics> findLogistics(){
        return  homeMapper.findLogistics();
    }
    //收藏商品
    @Override
    @ResponseBody
    public void collectProduct(@RequestBody Collect collect) {
        Product product = new Product();
        collect.setProductId(product.getProductId());
        collect.setProductImg(product.getProductImg());
        collect.setProductName(product.getProductName());
        collect.setProductPrice(product.getProductPrice());
        /*collect.setUserId();*/
        mongoTemplate.save(collect);
    }
    //我的收藏
    @Override
    @ResponseBody
    public JSONObject queryCollect(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows) {
        JSONObject jsonObject = new JSONObject();
        Query query = new Query();
        long total = mongoTemplate.count(query, Collect.class);
        int start = (page-1)*rows;
        query.skip(start).limit(rows);
        List<Collect> list = mongoTemplate.find(query, Collect.class);
        jsonObject.put("total", total);
        jsonObject.put("rows", list);
        return jsonObject;
    }
}
