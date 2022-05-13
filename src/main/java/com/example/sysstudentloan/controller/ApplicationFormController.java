package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.entity.ApplicationForm;
import com.example.sysstudentloan.service.AccountService;
import com.example.sysstudentloan.service.ApplicationService;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ApplicationForm")
public class ApplicationFormController {

    /*日志*/
    private String tag = "ApplicationFormController====";
    private Logger logger = LoggerFactory.getLogger(ApplicationFormController.class);

    @Autowired
    private ApplicationService accountService;

    @Autowired
    private AccountService realAccountService;

    @PostMapping("/FindAccount")
    public ResultSet FindAccount(@RequestParam Map account){
        try{
            logger.info(tag+"Find:"+account);
            ApplicationForm applicationForm = new ApplicationForm();
            if(account!=null){
                String value1 =(String) account.get("schoolCode");
                String value2 = (String) account.get("studentId");
                String value3 = (String) account.get("id");
                if(value1 != null ){
                    if(!(value1.equals(""))){
                        applicationForm.setSchoolCode(Integer.parseInt(value1));
                    }
                }
                if(value2 !=null){
                    if(!(value2.equals(""))){
                        applicationForm.setStudentId(Long.parseLong(value2));
                    }
                }
                if(value3 !=null){
                    if(!(value3.equals(""))){
                        applicationForm.setId(Integer.parseInt(value3));
                    }
                }
            }
            logger.info(tag+"ApplicationForm:"+applicationForm);
            List<ApplicationForm> list = accountService.findAccount(applicationForm);
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
            int data = Integer.parseInt((String) data1.get("id"));
            ApplicationForm list = accountService.findAccountOne(data);

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
            int res = accountService.ModAccount(account);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/DelAll")
    public  ResultSet DellAll(){
        try{
            logger.info("删除所有申请");
            int res = accountService.DelAll();

            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }
}
