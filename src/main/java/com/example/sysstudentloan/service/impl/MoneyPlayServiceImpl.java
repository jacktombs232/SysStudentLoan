package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.MoneyPlanMapper;
import com.example.sysstudentloan.entity.MoneyPlan;
import com.example.sysstudentloan.service.MoneyPlayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MoneyPlayServiceImpl implements MoneyPlayService {
    /*日志*/
    private Logger logger = LoggerFactory.getLogger(MoneyPlayServiceImpl.class);


    @Autowired
    private com.example.sysstudentloan.dao.MoneyPlanMapper MoneyPlanMapper;

    @Override
    public List<MoneyPlan> findAccount(Long data) {
        try{
            List<MoneyPlan> list = MoneyPlanMapper.selectByKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public MoneyPlan findAccountOne(int data) {
        try{
            MoneyPlan account = MoneyPlanMapper.selectByPrimaryKey(data);
            return account;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelAccount(int data) {
        try{
            int i = MoneyPlanMapper.deleteByPrimaryKey(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int ModAccount(Map data) {
        try{
            int i = MoneyPlanMapper.updateByPrimaryKeySelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int AddAccount(Map data) {
        try{
            int i = MoneyPlanMapper.insertSelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }
    
}
