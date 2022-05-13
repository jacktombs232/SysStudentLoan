package com.example.sysstudentloan.service;

import com.alipay.api.AlipayApiException;
import com.example.sysstudentloan.entity.AlipayBean;

import javax.servlet.http.HttpServletRequest;

public interface PayService {
    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

    /**【异步通知会返回一个request】**/
    public String notifyUrl(HttpServletRequest request);
}
