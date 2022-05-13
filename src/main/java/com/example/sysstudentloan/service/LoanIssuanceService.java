package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.ApplicationForm;
import com.example.sysstudentloan.entity.LoanIssuance;

import java.util.List;
import java.util.Map;

public interface LoanIssuanceService {
    public List<LoanIssuance> findAccount(LoanIssuance data);
    public LoanIssuance findAccountOne(int data);
    public int DelAccount(int data);
    public int ModAccount(Map data);
    public int AddAccount(Map data);

    public Integer getAllMoney(Map map);
}
