package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.SchoolCodeMapper;
import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.entity.SchoolCode;
import com.example.sysstudentloan.service.SchoolCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchoolCodeServiceImpl implements SchoolCodeService {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(SchoolCodeServiceImpl.class);

    @Autowired
    private SchoolCodeMapper schoolCodeMapper;

    @Override
    public List<Map> findSchoolCodex(int data) {
        return null;
    }

    @Override
    public List<Map> findSchoolCode(int data) {
        try{
            List<Map> list = schoolCodeMapper.selectTopKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public List<Map> findSchoolCode2(int data) {
        try{
            List<Map> list = schoolCodeMapper.selectSecondKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public SchoolCode findSchoolCodeOne(int data) {
        try{
            SchoolCode list = schoolCodeMapper.selectByPrimaryKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelSchoolCode(int data) {
        try{
            int list = schoolCodeMapper.deleteByPrimaryKey(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 0;
        }
    }

    @Override
    public int ModSchoolCode(SchoolCode data) {
        try{
            int list = schoolCodeMapper.updateByPrimaryKeySelective(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 0;
        }
    }

    @Override
    public int AddSchoolCode(SchoolCode data) {
        try{
            int list = schoolCodeMapper.insertSelective(data);
            return list;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 0;
        }
    }
}
