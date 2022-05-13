package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.StudentInformation;

import java.util.Map;

public interface StudentInformationMapper {
    int deleteByPrimaryKey(Long accountId);

    int insert(Map record);

    int insertSelective(Map record);

    StudentInformation selectByPrimaryKey(Long accountId);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(StudentInformation record);
}