package com.sso.service;

import com.common.utils.E3Result;

public interface LoginService {

    /*
    1.判断用户名密码是否正确
    2.如果不正确,返回登陆失败
    3.如果正确生成token
    4.把用户信息写入redis  key :token  value:用户信息
    5.设置session的过期时间
    6.把token返回
     */
    E3Result userLogin(String username,String password);
}
