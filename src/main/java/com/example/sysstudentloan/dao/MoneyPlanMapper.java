package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.MoneyPlan;

import java.util.List;
import java.util.Map;

public interface MoneyPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoneyPlan record);

    int insertSelective(Map record);

    MoneyPlan selectByPrimaryKey(Integer id);

    List<MoneyPlan> selectByKey(Long  studentId);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(MoneyPlan record);
}