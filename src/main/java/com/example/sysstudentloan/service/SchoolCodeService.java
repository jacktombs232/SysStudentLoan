package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.SchoolCode;

import java.util.List;
import java.util.Map;

public interface SchoolCodeService {
    public List<Map> findSchoolCodex(int data);
    public List<Map> findSchoolCode(int data);
    public List<Map> findSchoolCode2(int data);
    public SchoolCode findSchoolCodeOne(int data);
    public int DelSchoolCode(int data);
    public int ModSchoolCode(SchoolCode data);
    public int AddSchoolCode(SchoolCode data);
}
