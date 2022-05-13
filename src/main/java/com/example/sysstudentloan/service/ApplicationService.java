package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.entity.ApplicationForm;

import java.util.List;
import java.util.Map;

public interface ApplicationService {
    public List<ApplicationForm> findAccount(ApplicationForm data);
    public ApplicationForm findAccountOne(int data);
    public int DelAccount(int data);
    public int DelAll();
    public int ModAccount(Map data);
    public int AddAccount(Map data);
}
