package com.example.sysstudentloan.service;

import com.example.sysstudentloan.entity.SchoolStudentInformation;

import java.util.List;
import java.util.Map;

public interface SchoolStudentInformationService {

    SchoolStudentInformation findInformationOne(SchoolStudentInformation data);

    int DelInformation(SchoolStudentInformation data);

    int ModInformation(Map data);

    int AddInformation(SchoolStudentInformation data);
}
