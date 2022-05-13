package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.LoanIssuance;

import java.util.List;
import java.util.Map;

public interface LoanIssuanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanIssuance record);

    int insertSelective(Map record);

    LoanIssuance selectByPrimaryKey(Integer id);

    Integer getAllMoney(Map map);

    List<LoanIssuance> selectByKey(LoanIssuance search);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(LoanIssuance record);
}