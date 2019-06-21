package com.sso.service.impl;

import com.common.utils.E3Result;
import com.spoc.mapper.TbUserMapper;
import com.spoc.pojo.TbUser;
import com.spoc.pojo.TbUserExample;
import com.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;


/*
    用户注册处理
 */
@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private TbUserMapper userMapper;

    @Override
    public E3Result checkData(String param, int type) {

        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        // 2、查询条件根据参数动态生成。
        //1、2、3分别代表username、phone、email
        if (type == 1) {
            criteria.andUsernameEqualTo(param);
        } else if (type == 2) {
            criteria.andPhoneEqualTo(param);
        } else if (type == 3) {
            criteria.andEmailEqualTo(param);
        } else {
            return E3Result.build(400, "非法的参数");
        }
        //执行查询
        List<TbUser> list = userMapper.selectByExample(example);
        // 3、判断查询结果，如果查询到数据返回false。
        if (list == null || list.size() == 0) {
            // 4、如果没有返回true。
            return E3Result.ok(true);
        }
        // 5、使用e3Result包装，并返回。
        return E3Result.ok(false);
    }

    @Override
    public E3Result register(TbUser user) {
        //对数据有效性校验
        if("".equals(user.getUsername())||"".equals(user.getPassword())||"".equals(user.getPhone())){
            return E3Result.build(400,"用户数据不完整");
        }
        E3Result result = checkData(user.getUsername(),1);
        if(!(boolean) result.getData()){
            return E3Result.build(400,"此用户已经被占用");
        }
        result = checkData(user.getUsername(),2);
        if(!(boolean) result.getData()){
            return E3Result.build(400,"手机号已经被占用");
        }
        //补全pojo属性
        user.setCreated(new Date());
        user.setUpdated(new Date());
        //对密码进行MD5加密
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Pass);
        //把用户数据添加到数据库中
        userMapper.insert(user);
        //返回添加成功
        return E3Result.ok();
    }
}
