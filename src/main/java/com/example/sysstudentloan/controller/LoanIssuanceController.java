package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.LoanIssuance;
import com.example.sysstudentloan.service.LoanIssuanceService;
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
@RequestMapping("/LoanIssuance")
public class LoanIssuanceController {

    /*日志*/
    private String tag = "LoanIssuanceController====";
    private Logger logger = LoggerFactory.getLogger(LoanIssuanceController.class);

    @Autowired
    private LoanIssuanceService accountService;

    @PostMapping("/FindAccount")
    public ResultSet FindAccount(@RequestParam Map account){
        try{
            logger.info(tag+"Find:"+account);
            LoanIssuance loanIssuance = new LoanIssuance();
            String value = (String) account.get("studentId");
            int value1 = Integer.parseInt((String) account.get("state"));
            if(value!=null&&!value.equals("")){
                loanIssuance.setStudentId(Long.parseLong(value));
            }
            loanIssuance.setState(value1);
            List<LoanIssuance> list = accountService.findAccount(loanIssuance);
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
            LoanIssuance list = accountService.findAccountOne(data);

            return ResultSet.success(list);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/AddAccount")
    public  ResultSet AddAccount(@RequestParam Map account){
        try{
            account.put("commit_time",new Date());
            Date now = new Date();
            account.put("issueDate",now);
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
            logger.info(tag+"FindAccountOne接收的数据："+account);
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
            logger.info(tag+"sss:"+account);
            if(account.get("issueDate")!=null){
                Date now = new Date();
                Date now1 = new Date();
                account.put("issueDate",now);
                now1.setYear(now.getYear()+6);
                account.put("closingDate",now1);
            }
            int res = accountService.ModAccount(account);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/getAllMoney")
    public ResultSet getAllMoney(@RequestParam Map account){

        try{
            logger.info(tag+"sss:"+account);
            Integer integer = accountService.getAllMoney(account);
            return ResultSet.success(integer);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }
}
