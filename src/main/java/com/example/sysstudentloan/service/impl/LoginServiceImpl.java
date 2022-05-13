package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.LoginMapper;
import com.example.sysstudentloan.entity.ParentAuthority;
import com.example.sysstudentloan.service.LoginService;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {
    /*日志*/
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map Verification(String username, String password) {
        logger.info("进入VerificationStu方法，接收数据为："+username+"，"+password);
        Map data = loginMapper.VerificationStduent(username, password);
        if (data!=null){
            logger.info("用户验证成功，用户角色为"+data.get("role"));
            return data;
        }
        return null;
    }

    @Override
    public List<ParentAuthority> selectAuthorityInfo(Map searchMap) {
        logger.info("进入VerificationStu方法，接收数据为："+searchMap);
        List<ParentAuthority> parentAuthorities = loginMapper.selectAuthorityInfo(searchMap);
        return parentAuthorities;
    }
}
