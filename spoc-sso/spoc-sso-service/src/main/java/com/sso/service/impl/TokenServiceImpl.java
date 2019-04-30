package com.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import com.common.jedis.JedisClient;
import com.common.utils.E3Result;
import com.common.utils.JsonUtils;
import com.spoc.pojo.TbUser;
import com.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JedisClient jedisClient;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;
    @Override
    public E3Result getUserByToken(String token) {
        //根据token到redis里取用户信息
        String json = jedisClient.get("SESSION:"+token);
        //取不到用户信息,登录已过期.返回登录过期
        if(StringUtils.isBlank(json)){
            return E3Result.build(201,"用户登录已经过期");
        }
        //取到用户信息,更新token的过期时间
        jedisClient.expire("SESSION:"+token,SESSION_EXPIRE);
        //返回结果  E3Result包含TbUser对象
        TbUser user = JsonUtils.jsonToPojo(json,TbUser.class);
        return E3Result.ok(user);
    }
}
