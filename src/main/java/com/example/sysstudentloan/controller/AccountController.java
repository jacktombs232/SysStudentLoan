package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.service.AccountService;
import com.example.sysstudentloan.util.MapToBean;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Account")
public class AccountController {

    /*日志*/
    private String tag = "AccountController====";
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/FindAccount")
    public ResultSet FindAccount(@RequestParam Map account){
        try{
            logger.info(tag+"FindAccount:"+account);
            List<Account> list = accountService.findAccount(account);
            logger.info(tag+"FindAccount:"+list);
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/FindAccountOne")
    public ResultSet FindAccountOne(@RequestParam Map data1){
        try{
            logger.info(tag+"FindAccountOne接收的数据："+data1);
            Long data = Long.parseLong((String) data1.get("id"));
            Account account = new Account();
            account.setId(data);
            Account list = accountService.findAccountOne(account);

            return ResultSet.success(list);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/AddAccount")
    public  ResultSet AddAccount(@RequestParam Map data1){
        try{
            logger.info("map=" + data1);
            data1.put("id",Long.parseLong(MapToBean.getRandomNickname(10)));
            data1.put("enable",Integer.parseInt((String) data1.get("enable")));
            int res = accountService.AddAccount(data1);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/DelAccount")
    public  ResultSet DelAccount(@RequestParam Map data1){
        try{
            int res = accountService.DelAccount(data1);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/ModAccount")
    public  ResultSet ModAccount(@RequestParam Map account){
        try{
            logger.info(tag+"sss:"+account);
            int res = accountService.ModAccount(account);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }
}
