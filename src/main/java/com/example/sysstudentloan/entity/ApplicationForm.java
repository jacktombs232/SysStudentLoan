package com.example.sysstudentloan.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * application_form
 * @author 
 */
@Data
public class ApplicationForm implements Serializable {
    /**
     * 申请表ID
     */
    private Integer id;

    /**
     * 申请主题
     */
    private String title;

    /**
     * 贷款金额
     */
    private Integer loanAmount;

    /**
     * 申请理由
     */
    private String reason;

    /**
     * 自我说明
     */
    private String explanation;

    /**
     * 学生账号
     */
    private Long studentId;

    /**
     * 提交时间
     */
    private Date commitTime;

    /**
     * 学院审批
     */
    private int approvalSchool;

    /**
     * 银行审批人
     */
    private Long approverBank;

    /**
     * 银行审批
     */
    private int approvalBank;

    /**
     * 学院审批人
     */
    private Long approverSchool;

    /**
     * 结果
     */
    private Integer resultApproval;

    /**
     * 申请表状态
     */
    private Integer formStatus;

    /**
     * 学院代号
     */
    private Integer schoolCode;

    private static final long serialVersionUID = 1L;
}