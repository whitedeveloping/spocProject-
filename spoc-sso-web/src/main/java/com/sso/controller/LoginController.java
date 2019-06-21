package com.sso.controller;

import com.common.utils.CookieUtils;
import com.common.utils.E3Result;
import com.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
用户登录处理
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @RequestMapping("/page/login")
    public String showLogin(){
        return "login";
    }
    @RequestMapping(value="/user/login", method= RequestMethod.POST)
    @ResponseBody
    public E3Result login(String username, String password,
                          HttpServletRequest request, HttpServletResponse response) {
        // 1、接收两个参数。
        // 2、调用Service进行登录。
        E3Result e3Result = loginService.userLogin(username,password);
        // 3、从返回结果中取token，写入cookie。Cookie要跨域。
        String token = e3Result.getData().toString();
        CookieUtils.setCookie(request, response, TOKEN_KEY, token);
        // 4、响应数据。Json数据。e3Result，其中包含Token。
        return e3Result;

    }
}


