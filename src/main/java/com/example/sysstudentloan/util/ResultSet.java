package com.example.sysstudentloan.util;

import java.io.Serializable;
import java.util.Map;

public class ResultSet implements Serializable{
    private int code;
    private String msg;
    private Object data;
    private boolean success;

    public static ResultSet success(int code, String msg, Object data) {
        ResultSet resultSet = new ResultSet();
        resultSet.setCode(code);
        resultSet.setMsg(msg);
        resultSet.setData(data);
        resultSet.setSuccess(true);
        return resultSet;
    }

    public static ResultSet fail(int code, String msg, Object data) {
        ResultSet resultSet = new ResultSet();
        resultSet.setCode(code);
        resultSet.setMsg(msg);
        resultSet.setData(data);
        resultSet.setSuccess(false);
        return resultSet;
    }

    public static ResultSet success(Object data) {
        return success(200, "success!", data);
    }

    public static ResultSet fail(String msg) {
        return fail(400, msg, null);
    }

    public static ResultSet fail(String msg, Object data) {
        return fail(400, msg, data);
    }
    public static ResultSet fail(Object msg) {
        return fail(400, msg+"",null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
