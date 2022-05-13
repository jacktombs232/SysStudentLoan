package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.SchoolStudentInformation;
import com.example.sysstudentloan.service.SchoolStudentInformationService;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Info1")
public class Information1Controller {

    /*日志*/
    private String tag = "SchoolStudentInformationController====";
    private Logger logger = LoggerFactory.getLogger(Information1Controller.class);

    @Autowired
    private SchoolStudentInformationService SchoolStudentInformationService;

    @PostMapping("/FindInfo1One")
    public ResultSet FindSchoolStudentInformationOne(@RequestParam Map data1){
        try{
            logger.info(tag+"FindSchoolStudentInformationOne接收的数据："+data1);
            Integer data = Integer.parseInt((String) data1.get("id"));
            SchoolStudentInformation SchoolStudentInformation = new SchoolStudentInformation();
            SchoolStudentInformation.setStudentId(data);
            SchoolStudentInformation list = SchoolStudentInformationService.findInformationOne(SchoolStudentInformation);

            return ResultSet.success(list);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/AddInfo1")
    public  ResultSet AddSchoolStudentInformation(@RequestBody SchoolStudentInformation SchoolStudentInformation){
        try{
            int res = SchoolStudentInformationService.AddInformation(SchoolStudentInformation);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/DelInfo1")
    public  ResultSet DelSchoolStudentInformation(@RequestBody SchoolStudentInformation SchoolStudentInformation){
        try{
            int res = SchoolStudentInformationService.DelInformation(SchoolStudentInformation);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }

    @PostMapping("/ModInfo1")
    public  ResultSet ModSchoolStudentInformation(@RequestParam Map SchoolStudentInformation){
        try{
            logger.info(tag+SchoolStudentInformation);
            int res = SchoolStudentInformationService.ModInformation(SchoolStudentInformation);
            return ResultSet.success(res);
        }catch (Exception e){
            logger.info(tag+"数据查询异常"+e);
            return ResultSet.fail(e);
        }
    }
}
