package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.ApplicationForm;

import java.util.List;
import java.util.Map;

public interface ApplicationFormMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteAllKey();

    int insert(Map record);

    int insertSelective(Map record);

    ApplicationForm selectByPrimaryKey(Integer id);

    List<ApplicationForm> selectByKey(ApplicationForm data);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(Map record);
}