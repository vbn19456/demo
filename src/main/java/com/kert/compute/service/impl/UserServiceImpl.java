package com.kert.compute.service.impl;

import com.kert.compute.dao.UserDao;
import com.kert.compute.exception.BusinessException;
import com.kert.compute.exception.ErrCode;
import com.kert.compute.model.entity.User;
import com.kert.compute.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements com.kert.compute.service.UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public String login(User user) {
        int count = userDao.selectCount(user);
        if (count>0){
            return JWTUtil.getToken(user);
        }
        return "";
    }

    @Override
    public String flush(String token){
        if(token!=null&&!"".equals(token)){
           return JWTUtil.flush(token);
        }
        return "";
    }
    @Override
    public boolean verify(String token){
        if(token!=null&&!"".equals(token)){
            JWTUtil.verify(token);
            return true;
        }else{
            //throw new BusinessException(ErrCode.LOGIN_ERROR);
            return false;
        }
    }
    public void logout(){

    }

}
