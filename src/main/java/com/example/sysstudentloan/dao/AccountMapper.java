package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.Account;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Map record);

    int insertSelective(Map record);

    Account selectByPrimaryKey(Long id);

    List<Account> selectByKey(Map account);

    int updateByPrimaryKeySelective(Map record);

    int updateByPrimaryKey(Account record);

    Account queryByEmail(String email);
}