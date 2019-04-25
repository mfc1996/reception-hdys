package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    /**
     * 跳转到首页面
     * @return
     */
    @RequestMapping("toHomePage")
    public String toHomePage(HttpServletResponse respose, Integer userId){
        /*Cookie[] coo = request.getCookies();
        if(coo!=null){
            String nam = "";
            for (Cookie co:coo) {
                nam += co.getValue();
                System.out.println("----" + co.getValue());
            }
        }*/
        //cookie名 key
        String cookieName="userId";
        System.out.println("---"+userId);
        //cookie值 value
        String cookieValue = String.valueOf(userId);
        //存入cookie
        Cookie myCookie=new Cookie(cookieName,cookieValue);
        //存入cookie后发送给浏览器
        respose.addCookie(myCookie);
        return "homepage";
    }

    /**
     * 跳转到评论
     * @return
     */
    @RequestMapping("toComment")
    public String toComment(){
        return "comment";
    }

    /**
     * 跳转到个人信息页面
     * @return
     */
    @RequestMapping("toInfo")
    public String toInfo(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(int a=0; a<cookies.length;a++){
            System.out.println("hhhhhhhhhhh----"+cookies[a].getValue());
        }
        return "info";
    }
    /**
     * 跳转到测试
     * @return
     */
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }
    /**
     * 跳转到机器人
     * @return
     */
    @RequestMapping("toRobot")
    public String toRobot(){
        return "robot";
    }
    /**
     * 跳转到搜索页面
     * @return
     */
    @RequestMapping("toSearchProduct")
    public String toSearchProduct(String comName,Model model){
        model.addAttribute("comName",comName);
        return "searchProduct";
    }
    /**
     * 跳转到订单页面
     * @return
     */
    @RequestMapping("toOrder")
    public String toOrder(){
        return "order";
}

    /**
     * 跳转到商品详情页面
     * @return
     */
    @RequestMapping("toProductInfo")
    public String toProductInfo(Integer productId, Model model){
        model.addAttribute("productId",productId);
        return "productInfo1";
    }
    /**
     * 跳转到不同类型页面
     * @return
     */
    @RequestMapping("toShowProduct")
    public String toShowProduct(Integer typeId, Model model){
        System.out.println("-------------------------------------------"+typeId);
        model.addAttribute("typeId",typeId);
        return "showProduct";
    }

    /**
     * 跳转到购物车页面
     * @return
     */
    @RequestMapping("toShop")
    public String toShop(){
        return "wodecar";
    }
    /**
     * 跳转到秒杀页面
     * @return
     */
    @RequestMapping("toSpike")
    public String toSpike(){
        return "spike";
    }
    //跳转到收藏页面
    @RequestMapping("toCollect")
    public String toCollect(){
        return "collect";
    }
}
