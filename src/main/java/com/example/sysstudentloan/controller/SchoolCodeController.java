package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.dao.SchoolCodeMapper;
import com.example.sysstudentloan.entity.SchoolCode;
import com.example.sysstudentloan.service.SchoolCodeService;
import com.example.sysstudentloan.service.impl.SchoolCodeServiceImpl;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/SchoolCode")
public class SchoolCodeController {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(SchoolCodeServiceImpl.class);

    @Autowired
    private SchoolCodeService schoolCodeService;

    @PostMapping("/findSchoolCode")
    public ResultSet findSchoolCode(int data) {
        try{
            List<Map> list = schoolCodeService.findSchoolCode(data);
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info("查找出错："+e);
            return ResultSet.fail(null);
        }
    }

    @PostMapping("/findSchoolCode2")
    public ResultSet findSchoolCode2(int data) {
        try{
            List<Map> list = schoolCodeService.findSchoolCode2(data);
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info("查找出错："+e);
            return ResultSet.fail(null);
        }
    }

    @PostMapping("/findSchoolCodeOne")
    public ResultSet findSchoolCodeOne(@RequestParam Map data) {
        try{
            SchoolCode list = schoolCodeService.findSchoolCodeOne(Integer.parseInt((String) data.get("code")));
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info("查找出错："+e);
            return ResultSet.fail(null);
        }
    }

    @PostMapping("/DelSchoolCode")
    public ResultSet DelSchoolCode(int data) {
        try{
            int list = schoolCodeService.DelSchoolCode(data);
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info("查找出错："+e);
            return ResultSet.fail(null);
        }
    }

    @PostMapping("/ModSchoolCode")
    public ResultSet ModSchoolCode(SchoolCode data) {
        try{
            int list = schoolCodeService.ModSchoolCode(data);
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info("查找出错："+e);
            return ResultSet.fail(null);
        }
    }

    @PostMapping("/AddSchoolCode")
    public ResultSet AddSchoolCode(SchoolCode data) {
        try{
            int list = schoolCodeService.AddSchoolCode(data);
            return ResultSet.success(list);
        }catch (Exception e){
            logger.info("查找出错："+e);
            return ResultSet.fail(null);
        }
    }
}
