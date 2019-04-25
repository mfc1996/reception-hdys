package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.*;
import com.jk.service.HomeServiceFeign;
import com.jk.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    public HomeServiceFeign homeServiceFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户名称
     * @param userId
     * @return
     */
    @GetMapping("queryLoginByName/{userId}")
    public HashMap<String,Object> queryLoginByName(@PathVariable("userId")Integer userId){
        System.out.println("===="+userId);
        String names = homeServiceFeign.queryLoginByName(userId);
        HashMap<String,Object> hash = new HashMap<>();
        hash.put("names",names);
        return hash;
    }

    /**
     * 查询悬浮菜单
     * @return
     */
    @GetMapping("queryType")
    public List<Type> queryType(@RequestParam("pid") Integer pid){
       // String key = "queryType";
        List<Type> list = homeServiceFeign.queryType(pid);
        //redisTemplate.opsForList().leftPush(key,list);
        return list;
    }

    /**
     * 查询商品
     * @return
     */
    @GetMapping("queryProduct")
    public List<Product> queryProduct(){
        String key = "queryProduct";
        List<Product> list = homeServiceFeign.queryProduct();
        redisTemplate.opsForList().leftPush(key,list);
        return list;
    }

    /**
     * 回显商品
     * @param productId
     * @return
     */
    @GetMapping("queryProductById/{productId}")
    public Product queryProductById(@PathVariable("productId") Integer productId){
        return homeServiceFeign.queryProductById(productId);
    }

    /**
     * 根据类型回显商品
     * @param typeId
     * @return
     */
    @GetMapping("queryProductByTypeId/{typeId}")
    public List<Product> queryProductByTypeId(@PathVariable("typeId") Integer typeId){
        return homeServiceFeign.queryProductByTypeId(typeId);
    }

    /**
     * 加入购物车
     */
    /*@RequestMapping("saveProduct")
    public void saveProduct(HttpServletRequest request){
       homeServiceFeign.saveProduct(productId);
    }*/

    /**
     * 店铺查询
     */
    @GetMapping("queryStore")
    public List<Store> queryStore(){
        List<Store> stores = homeServiceFeign.queryStore();
        return stores;
    }

    /**
     * 轮播图查询
     * @return
     */
    @GetMapping("queryImg")
    public List<Lun> queryImg(){
        return homeServiceFeign.queryImg();
    }

    /**
     * 订单查询
     */
    @GetMapping("queryOrder")
    public List<Order> queryOrder(@RequestParam("name") String name){
        return homeServiceFeign.queryOrder(name);
    }

   /* @GetMapping("queryOrder")
    public List<Order> queryOrder(){
        return homeServiceFeign.queryOrder();
    }
*/
    /**
     * 生成订单
     */
    @PostMapping("saveOrder")
    public void saveOrder(@RequestBody Order order){
        homeServiceFeign.saveOrder(order);
    }

    /**
     * 订单状态修改
     */
    @PutMapping("updateStatus")
    public void updateStatus(@RequestParam("id") String id,@RequestParam("orderStatus") String orderStatus){
        homeServiceFeign.updateStatus(id,orderStatus);
    }

    /**
     * 属性查询
     */
    @GetMapping("queryAttribute/{productId}")
    public Attribute queryAttribute(@PathVariable("productId") Integer productId){
        int typeId = homeServiceFeign.queryProdutType(productId);
        return homeServiceFeign.queryAttribute(typeId);
    }

    /**
     * 新增评论
     */
    @PostMapping("saveComment")
    public void saveComment(@RequestBody Comment comment){
        System.out.println("进来了 ");
        String str = comment.getCommentInfo().replace("靠", "***");
        String url = "http://192.168.0.130:8080/user/findUser";
        HashMap<String, Object> params = new HashMap<>();
        /*String returnStr = HttpClientUtil.get(url, params);*/
        System.out.println("info+++"+comment.getCommentInfo());
        params.put("commentInfo",str);
        params.put("status",comment.getStatus());
        params.put("orderId",comment.getOrderId());
        params.put("userId",comment.getUserId());
        String returnStr =HttpClientUtil.post(url,params);
        System.out.println("------------"+returnStr);
    }
    /**
     * 查询评论
     */
    @GetMapping("queryCommentList")
    public JSONArray queryCommentList(){
        HashMap<String, Object> params = new HashMap<>();
       /* params.put("page", 1);l
        params.put("rows", 10);*/
        String url = "http://192.168.0.118:8080/user/findUser";
        String returnStr = HttpClientUtil.get(url,params);
        System.out.println("-----------"+returnStr);
        JSONObject parseObject = JSON.parseObject(returnStr);
        JSONArray array = parseObject.getJSONArray("rows");
        for (int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
        return null;
    }
    //初始化物流信息
    @GetMapping("findLogistics")
    @ResponseBody
    public List<Logistics> findLogistics(){
        return homeServiceFeign.findLogistics();
    }

    //收藏商品
    @PostMapping("collectProduct")
    @ResponseBody
    public void collectProduct(@RequestBody Collect collect){
        homeServiceFeign.collectProduct(collect);
    }
    //我的收藏
    @GetMapping("queryCollect")
    @ResponseBody
    public JSONObject queryCollect(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){
        return homeServiceFeign.queryCollect(page,rows);
    }
}
