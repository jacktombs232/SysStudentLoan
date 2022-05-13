package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.StudentInformation;
import com.example.sysstudentloan.service.StudentInformationService;
import com.example.sysstudentloan.service.StudentInformationService;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/Info2")
public class Information2Controller {
    /*日志*/
    private String tag = "Information2Controller====";
    private Logger logger = LoggerFactory.getLogger(Information2Controller.class);

    @Autowired
    private StudentInformationService studentInformationService;

    @PostMapping("/FindInfo1One")
    public ResultSet FindStudentInformationOne(@RequestParam Map data1){
        try{
            logger.info(tag+"FindStudentInformationOne接收的数据："+data1);
            long data = Long.parseLong((String) data1.get("id"));
            StudentInformation StudentInformation = new StudentInformation();
            StudentInformation.setAccountId(data);
            StudentInformation list = studentInformationService.findInformationOne(StudentInformation);

            return ResultSet.success(list);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/AddInfo1")
    public  ResultSet AddStudentInformation(@RequestParam Map StudentInformation){
        try{
            int res = studentInformationService.AddInformation(StudentInformation);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/DelInfo1")
    public  ResultSet DelStudentInformation(@RequestBody StudentInformation StudentInformation){
        try{
            int res = studentInformationService.DelInformation(StudentInformation);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/ModInfo1")
    public  ResultSet ModStudentInformation(@RequestParam Map StudentInformation){
        try{
            logger.info(tag+StudentInformation);
            StudentInformation.put("commitTime",new Date());
            int res = studentInformationService.ModInformation(StudentInformation);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }
}
