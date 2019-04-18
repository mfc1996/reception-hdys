﻿/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MyRealm
 * Author:   zyl
 * Date:     2018/12/26 13:56
 * Description: test
 * History:
 */
package com.jk.shiro;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.jk.mfc.model.User;
import com.jk.mfc.service.UserService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author zyl
 * @create 2018/12/26
 * @since 1.0.0
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userServcice;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取主身份信息
        String userCode = (String) principals.getPrimaryPrincipal();
        User user = userServcice.queryUserByName(userCode);
        //根据身份信息获取权限信息
        //模拟从数据库获取到数据
        /*List<String> permissions = new ArrayList<String>();
        permissions.add("user:create"); //用户的创建权限
        permissions.add("user:update"); //商品的添加权限
        permissions.add("user:delete"); //商品的添加权限*/
        Integer id = user.getId();
        List<String> permissions = userServcice.queryUserById(id);

        //将查询到授权信息填充到对象中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.从token取出用户身份信息
        String accountNumber = (String)token.getPrincipal();
        //根据账号查询数据
        User user = userServcice.queryUserByName(accountNumber);
        System.out.println(token.getCredentials());
        //如果查询不到则返回null，对比账号是否存在
        if(user==null){
            throw new UnknownAccountException();
        }
        //从token取出用户密码
        /*String password = (String) token.getCredentials();*/
        //对比密码

        //2.根据用户userCode查询数据库
        
        
        //模拟从数据库查询到的密码

        //查询不到返回null

        //查询到返回认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getAccountNumber(),user.getPassword(),this.getName());
        SecurityUtils.getSubject().getSession().setAttribute("login", accountNumber);
        return authenticationInfo;
    }

}
