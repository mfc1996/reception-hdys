package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface HomeService {

    /**
     * 悬浮式菜单
     * @param pid
     * @return
     */
    @GetMapping("queryType")
    @ResponseBody
    List<Type> queryType(@RequestParam("pid") Integer pid);

    /**
     * 查询商品
     * @return
     */
    @GetMapping("queryProduct")
    @ResponseBody
    List<Product> queryProduct();

    /**
     * 根据产品id回显商品
     * @param productId
     * @return
     */
    @GetMapping("queryProductById/{productId}")
    @ResponseBody
    Product queryProductById(@PathVariable("productId") Integer productId);

    /**
     * 查询店铺
     * @return
     */
    @GetMapping("queryStore")
    @ResponseBody
    List<Store> queryStore();

    /**
     * 查询轮播图
     * @return
     */
    @GetMapping("queryImg")
    @ResponseBody
    List<Lun> queryImg();

    /**
     * 订单查询
     * @param name
     * @return
     */
    @GetMapping("queryOrder")
    @ResponseBody
    List<Order> queryOrder(@RequestParam("name") String name);

    /**
     * 加入购物车
     * @param productId
     */
    @PostMapping("saveProduct")
    @ResponseBody
    void saveProduct(@RequestParam("productId") Integer productId);

    /**
     * 生成订单
     * @param order
     */
    @PostMapping("saveOrder")
    @ResponseBody
    void saveOrder(Order order);

    /**
     * 订单状态修改
     * @param id
     * @param orderStatus
     */
    @PutMapping("updateStatus")
    @ResponseBody
    void updateStatus(@RequestParam("id")String id,@RequestParam("orderStatus") String orderStatus);

    /**
     * 根据类型查询属性
     * @param typeId
     * @return
     */
    @GetMapping("queryAttribute")
    @ResponseBody
    Attribute queryAttribute(@RequestParam("typeId")Integer typeId);

    /**
     * 根据产品id查询类型
     * @param productId
     * @return
     */
    @GetMapping("queryAttribute/{productId}")
    @ResponseBody
    int queryProdutType(@PathVariable("productId")Integer productId);

    /**
     * 根据类型查询商品
     * @param typeId
     * @return
     */
    @GetMapping("queryProductByTypeId/{typeId}")
    @ResponseBody
    List<Product> queryProductByTypeId(@PathVariable("typeId")Integer typeId);

    /**
     * 根据id回显用户信息
     * @param userId
     * @return
     */
    @GetMapping("findByIdUser")
    @ResponseBody
    UserBean findByIdUser(@RequestParam("userId")Integer userId);

    /**
     * 修改用户信息
     * @param user
     */
    @PutMapping("updateUser")
    @ResponseBody
    void updateUser(UserBean user);

    @GetMapping("selectCar")
    @ResponseBody
    Product selectCar(@RequestParam("spid")Integer spid);

    //查询秒杀商品
    @GetMapping("querySeckill")
    @ResponseBody
    List querySeckill();

    //加入购物车
    @PostMapping("addSeckill")
    @ResponseBody
    void addSeckill(@RequestBody WebShoppingcCart cart);

    //秒杀商品倒计时
    @GetMapping("findSeckillDate")
    @ResponseBody
    List<SpikeBean> findSeckillDate();

    /**
     * 新增订单
     * @param goodsId
     */
    @GetMapping("queryGoodsId")
    @ResponseBody
    void queryGoodsId(@RequestParam("goodsId") Integer goodsId,@RequestParam("orderNo")String orderNo);

    @GetMapping("queryProductByIds")
    @ResponseBody
    Product queryProductByIds(@RequestParam("spid") Integer spid);

    @GetMapping("queryLoginByName/{userId}")
    @ResponseBody
    String queryLoginByName(@PathVariable("userId") Integer userId);

    //初始化物流信息
    @GetMapping("findLogistics")
    @ResponseBody
    public List<Logistics> findLogistics();
    @PostMapping("collectProduct")
    @ResponseBody
    void collectProduct(Collect collect);
    @GetMapping("queryCollect")
    @ResponseBody
    JSONObject queryCollect(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows);
}
