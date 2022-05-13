package com.example.sysstudentloan.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * money_plan
 * @author 
 */
@Data
public class MoneyPlan implements Serializable {
    private Integer id;

    private Long studentid;

    private Date time;

    private Double rate;

    private Long total;

    private Integer column6;

    private Integer status;

    private static final long serialVersionUID = 1L;
}