package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.SchoolStudentInformation;

import java.util.Map;

public interface SchoolStudentInformationMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(SchoolStudentInformation record);

    int insertSelective(SchoolStudentInformation record);

    SchoolStudentInformation selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(SchoolStudentInformation record);
}