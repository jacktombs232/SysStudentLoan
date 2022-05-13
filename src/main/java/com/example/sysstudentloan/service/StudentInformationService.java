package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.StudentInformation;

import java.util.Map;

public interface StudentInformationService {

    StudentInformation findInformationOne(StudentInformation data);

    int DelInformation(StudentInformation data);

    int ModInformation(Map data);

    int AddInformation(Map data);
}
