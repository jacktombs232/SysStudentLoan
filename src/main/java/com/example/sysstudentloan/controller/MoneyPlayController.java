package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.LoanIssuance;
import com.example.sysstudentloan.entity.MoneyPlan;
import com.example.sysstudentloan.service.LoanIssuanceService;
import com.example.sysstudentloan.service.MoneyPlayService;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/MoneyPlay")
public class MoneyPlayController {

    /*日志*/
    private String tag = "MoneyPlayController====";
    private Logger logger = LoggerFactory.getLogger(MoneyPlayController.class);

    @Autowired
    private MoneyPlayService accountService;

    @PostMapping("/FindAccount")
    public ResultSet FindAccount(@RequestParam Map account){
        try{
            List<MoneyPlan> list = null;
            String x = (String) account.get("studentId");
            if(x == ""){
                list = accountService.findAccount(0L);
            }else {
                list = accountService.findAccount(Long.parseLong(x));
            }

            logger.info(tag+"Find=>:"+list);
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
            int data = Integer.parseInt((String) data1.get("studentId"));
            MoneyPlan list = accountService.findAccountOne(data);

            return ResultSet.success(list);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/AddAccount")
    public  ResultSet AddAccount(@RequestParam Map account){
        try{
            int res = accountService.AddAccount(account);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据增加异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/DelAccount")
    public  ResultSet DelAccount(@RequestParam Map account){
        try{
            logger.info(tag+"DelAccount："+account);
            int data = Integer.parseInt((String) account.get("id"));
            int res = accountService.DelAccount(data);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/ModAccount")
    public  ResultSet ModAccount(@RequestParam Map account){
        try{
            logger.info(tag+"ModAccount:"+account);
            int res = accountService.ModAccount(account);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

}
