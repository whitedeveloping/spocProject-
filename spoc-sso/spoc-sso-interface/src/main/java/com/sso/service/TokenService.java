package com.sso.service;


import com.common.utils.E3Result;

/*
    根据token查询用户信息
 */
public interface TokenService {

    E3Result getUserByToken(String token);
}
