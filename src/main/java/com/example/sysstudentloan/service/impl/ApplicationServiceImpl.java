package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.AccountMapper;
import com.example.sysstudentloan.dao.ApplicationFormMapper;
import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.entity.ApplicationForm;
import com.example.sysstudentloan.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);


    @Autowired
    private ApplicationFormMapper applicationFormMapper;

    @Override
    public List<ApplicationForm> findAccount(ApplicationForm data) {
        try{
            List<ApplicationForm> list = applicationFormMapper.selectByKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public ApplicationForm findAccountOne(int data) {
        try{
            ApplicationForm account = applicationFormMapper.selectByPrimaryKey(data);
            return account;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelAccount(int data) {
        try{
            int i = applicationFormMapper.deleteByPrimaryKey(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int DelAll() {
        return applicationFormMapper.deleteAllKey();
    }

    @Override
    public int ModAccount(Map data) {
        try{
            int i = applicationFormMapper.updateByPrimaryKeySelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int AddAccount(Map data) {
        try{
            int i = applicationFormMapper.insertSelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }
}
