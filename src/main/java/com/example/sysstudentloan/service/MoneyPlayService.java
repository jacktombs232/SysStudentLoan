package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.LoanIssuance;
import com.example.sysstudentloan.entity.MoneyPlan;

import java.util.List;
import java.util.Map;

public interface MoneyPlayService {
    public List<MoneyPlan> findAccount(Long data);
    public MoneyPlan findAccountOne(int data);
    public int DelAccount(int data);
    public int ModAccount(Map data);
    public int AddAccount(Map data);
}
