package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.LoanIssuanceMapper;
import com.example.sysstudentloan.dao.LoanIssuanceMapper;
import com.example.sysstudentloan.entity.LoanIssuance;
import com.example.sysstudentloan.entity.LoanIssuance;
import com.example.sysstudentloan.service.ApplicationService;
import com.example.sysstudentloan.service.LoanIssuanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoanIssuanceServiceImpl implements LoanIssuanceService {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(LoanIssuanceServiceImpl.class);


    @Autowired
    private LoanIssuanceMapper LoanIssuanceMapper;

    @Override
    public List<LoanIssuance> findAccount(LoanIssuance data) {
        try{
            List<LoanIssuance> list = LoanIssuanceMapper.selectByKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public LoanIssuance findAccountOne(int data) {
        try{
            LoanIssuance account = LoanIssuanceMapper.selectByPrimaryKey(data);
            return account;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelAccount(int data) {
        try{
            int i = LoanIssuanceMapper.deleteByPrimaryKey(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int ModAccount(Map data) {
        try{
            int i = LoanIssuanceMapper.updateByPrimaryKeySelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int AddAccount(Map data) {
        try{
            int i = LoanIssuanceMapper.insertSelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public Integer getAllMoney(Map map) {
        return LoanIssuanceMapper.getAllMoney(map);
    }
}
