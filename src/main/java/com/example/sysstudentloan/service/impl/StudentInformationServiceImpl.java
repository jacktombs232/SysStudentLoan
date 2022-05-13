package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.StudentInformationMapper;
import com.example.sysstudentloan.entity.StudentInformation;
import com.example.sysstudentloan.entity.StudentInformation;
import com.example.sysstudentloan.service.StudentInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentInformationServiceImpl implements StudentInformationService {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(StudentInformationServiceImpl.class);


    @Autowired
    private com.example.sysstudentloan.dao.StudentInformationMapper StudentInformationMapper;

    @Override
    public StudentInformation findInformationOne(StudentInformation data) {
        try{
            StudentInformation StudentInformation = StudentInformationMapper.selectByPrimaryKey(data.getAccountId());
            return StudentInformation;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelInformation(StudentInformation data) {
        try{
            int i = StudentInformationMapper.deleteByPrimaryKey(data.getAccountId());
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int ModInformation(Map data) {
        try{
            int i = StudentInformationMapper.updateByPrimaryKeySelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int AddInformation(Map data) {
        try{
            int i = StudentInformationMapper.insert(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }
}
