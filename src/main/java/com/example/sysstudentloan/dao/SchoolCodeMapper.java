package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.SchoolCode;

import java.util.List;
import java.util.Map;

public interface SchoolCodeMapper {
    int deleteByPrimaryKey(Integer number);

    int insert(SchoolCode record);

    int insertSelective(SchoolCode record);

    SchoolCode selectByPrimaryKey(Integer number);

    List<Map> selectTopKey(int data);

    List<Map> selectSecondKey(int data);

    int updateByPrimaryKeySelective(SchoolCode record);

    int updateByPrimaryKey(SchoolCode record);
}