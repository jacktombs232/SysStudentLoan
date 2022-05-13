package com.example.sysstudentloan.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * student_information
 * @author 
 */
@Data
public class StudentInformation implements Serializable {
    /**
     * 学生账号
     */
    private Long accountId;

    /**
     * 银行卡号
     */
    private Long bankCard;

    /**
     * 性别:true->男;false->女
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系地址
     */
    private String address;

    private static final long serialVersionUID = 1L;
}