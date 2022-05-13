package com.example.sysstudentloan.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * school_code
 * @author 
 */
@Data
public class SchoolCode implements Serializable {
    /**
     * 编号
     */
    private Integer number;

    /**
     * 父类编号
     */
    private Integer parentNumber;

    /**
     * 名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}