/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: pageController
 * Author:   郭晨凯
 * Date:     2019-04-16 21:46
 * Description: 页面跳转
 * History:
 * 郭晨凯        <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈页面跳转〉
 *
 * @author chenkai
 * @create 2019-04-16
 * @since 1.0.0
 */

@Controller
public class pageController {

    @RequestMapping("chenkaidata")
    public String chenkaidata() {

        return "chenkaiData";
    }


    @RequestMapping("mycar")
    public String mycars() {

        return "Mycar";
    }

}
