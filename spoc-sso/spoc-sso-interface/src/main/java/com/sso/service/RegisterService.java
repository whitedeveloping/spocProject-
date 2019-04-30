package com.sso.service;


import com.common.utils.E3Result;
import com.spoc.pojo.TbUser;

public interface RegisterService {

    E3Result checkData(String param, int type);

    E3Result register(TbUser user);
}
