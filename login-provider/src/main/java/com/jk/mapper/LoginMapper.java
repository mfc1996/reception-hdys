package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    //账号登录
    User toLogin(String account);

    //手机号登录
    User findUserPhone(String userPhone);

    //注册
    void saveLoginAccount(User user);

    //判断账号是否已经存在
    int findUserByuserPhone(String userPhone);

    //新增用户角色
    void saveUserRole(Integer id);

    //企业登录
    User qylogin(String haccount);

    //修改密码
    void updateUserByPassword(@Param("userPhone")String userPhone, @Param("userPassword")String userPassword);
}
