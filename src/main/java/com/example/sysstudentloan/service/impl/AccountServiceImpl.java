package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.AccountMapper;
import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAccount(Map data) {
        try{
            List<Account> list = accountMapper.selectByKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public Account findAccountOne(Account data) {
        try{
            Account account = accountMapper.selectByPrimaryKey(data.getId());
            return account;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelAccount(Map data) {
        try{
            int i = accountMapper.deleteByPrimaryKey(Long.parseLong((String)data.get("id")));
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int ModAccount(Map data) {
        try{
            int i = accountMapper.updateByPrimaryKeySelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int AddAccount(Map data) {
        try{
            int i = accountMapper.insert(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public Account queryByEmail(String email) {
        return accountMapper.queryByEmail(email);
    }
}
