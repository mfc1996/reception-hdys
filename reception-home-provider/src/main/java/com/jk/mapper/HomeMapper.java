package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeMapper {
    /**
     * 查询悬浮菜单
     * @return
     */
    List<Type> queryType(Integer pid);
    /**
     * 查询商品
     * @return
     */
    List<Product> queryProduct();
    /**
     * 回显商品
     * @param productId
     * @return
     */
    Product queryProductById(Integer productId);

    /**
     * 查询店铺
     * @return
     */
    List<Store> queryStore();

    /**
     * 查询轮播图
     * @return
     */
    List<Lun> queryImg();

    /**
     * 查询订单
     * @param order
     * @return
     */
    List<Order> queryOrder(@Param("order") Order order);
    /**
     * 订单状态修改
     */
    void updateStatus(String id,String orderStatus);
    /**
     * 属性查询
     */
    Attribute queryAttribute(@Param("typeId") Integer typeId);

    /**
     * 根据产品id查询类型
     */
    int queryProdutType(Integer productId);

    /**
     * 根据类型id查询商品
     */
    List<Product> queryProductByTypeId(Integer typeId);

    /**
     * 根据用户id回显用户信息
     */
    UserBean findByIdUser(Integer userId);

    /**
     * 修改用户信息
     */
    void updateUser(UserBean user);
    Product selectCar(Integer spid);

    //查询秒杀商品
    List querySeckill();

    //加入购物车
    void addSeckill(WebShoppingcCart cart);

    //秒杀时间倒计时
    List<SpikeBean> findSeckillDate();
    //c查询产品id
    Product queryByGoodId(int goodId);
        //生成订单
    void saveOrders(Order order);

    Product queryProductByIds(Integer spid);

    String queryLoginByName(Integer userId);
    //初始化物流信息
    List<Logistics> findLogistics();
}
