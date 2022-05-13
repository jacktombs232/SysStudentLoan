package com.example.sysstudentloan.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * school_student_information
 * @author 
 */
@Data
public class SchoolStudentInformation implements Serializable {
    /**
     * 学生账号
     */
    private Integer studentId;

    /**
     * 学校编号
     */
    private Integer schoolCode;

    /**
     * 院系编号
     */
    private Integer schoolCode2;

    /**
     * 学历
     */
    private String education;

    /**
     * 专业类别
     */
    private Integer professionalCategory;

    /**
     * 入学时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date admissionTime;

    /**
     * 毕业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date graduationTime;

    private static final long serialVersionUID = 1L;
}