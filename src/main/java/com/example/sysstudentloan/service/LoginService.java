package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.ParentAuthority;

import java.util.List;
import java.util.Map;

public interface LoginService {
    public Map Verification(String username, String password);

    public List<ParentAuthority> selectAuthorityInfo(Map searchMap);
}
