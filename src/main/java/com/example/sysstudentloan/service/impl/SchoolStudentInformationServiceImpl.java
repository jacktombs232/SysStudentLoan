package com.example.sysstudentloan.service.impl;

import com.example.sysstudentloan.dao.SchoolStudentInformationMapper;
import com.example.sysstudentloan.entity.SchoolStudentInformation;
import com.example.sysstudentloan.service.SchoolStudentInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SchoolStudentInformationServiceImpl implements SchoolStudentInformationService {

    /*日志*/
    private Logger logger = LoggerFactory.getLogger(SchoolStudentInformationServiceImpl.class);


    @Autowired
    private SchoolStudentInformationMapper SchoolStudentInformationMapper;

    @Override
    public SchoolStudentInformation findInformationOne(SchoolStudentInformation data) {
        try{
            SchoolStudentInformation SchoolStudentInformation = SchoolStudentInformationMapper.selectByPrimaryKey(data.getStudentId());
            return SchoolStudentInformation;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return null;
        }
    }

    @Override
    public int DelInformation(SchoolStudentInformation data) {
        try{
            int i = SchoolStudentInformationMapper.deleteByPrimaryKey(data.getStudentId());
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int ModInformation(Map data) {
        try{
            int i = SchoolStudentInformationMapper.updateByPrimaryKeySelective(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }

    @Override
    public int AddInformation(SchoolStudentInformation data) {
        try{
            int i = SchoolStudentInformationMapper.insert(data);
            return i;
        }catch (Exception e){
            logger.info("查找出错："+e);
            return 3;
        }
    }
}
