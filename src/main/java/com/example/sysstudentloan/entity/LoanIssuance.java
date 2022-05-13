package com.example.sysstudentloan.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * loan_issuance
 * @author 
 */
@Data
public class LoanIssuance implements Serializable {
    private Integer id;

    /**
     * 发放的总金额
     */
    private Integer totalAmount;

    /**
     * 是否发放
     */
    private Integer state;

    /**
     * 发放日期
     */
    private Date issueDate;

    /**
     * 截止日期
     */
    private Date closingDate;

    /**
     * 是否还款
     */
    private Integer repayment;

    /**
     * 学生账号
     */
    private Long studentId;

    private static final long serialVersionUID = 1L;
}