package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
    public List<Account> findAccount(Map data);
    public Account findAccountOne(Account data);
    public int DelAccount(Map data);
    public int ModAccount(Map data);
    public int AddAccount(Map data);

    public Account queryByEmail(String email);
}
