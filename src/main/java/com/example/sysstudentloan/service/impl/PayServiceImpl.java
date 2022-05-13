package com.example.sysstudentloan.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.example.sysstudentloan.entity.AlipayBean;
import com.example.sysstudentloan.service.PayService;
import com.example.sysstudentloan.util.AlipayUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private AlipayUtile service;


    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException
    {
        return service.pay(alipayBean);
    }

    @Override
    public String notifyUrl(HttpServletRequest request) {
        String payStatus = "fail";
        Map<String , String > parmas = new HashMap<>();
        Map<String , String []> requestParmas = request.getParameterMap();

        for (Iterator<String> iter = requestParmas.keySet().iterator(); iter.hasNext() ; ){
            String name = iter.next();
            String [] values = requestParmas.get(name);
            String valStr = "";
            for (int i = 0 ; i < values.length ; i ++){
                valStr = (i == values.length - 1) ? valStr + values[i] : valStr + values[i] + ",";
            }
            parmas.put(name , valStr);
            //System.out.println("【异步通知的值】" + name + "\t\t:" + valStr);
        }
            String trade_status = request.getParameter("trade_status");//交易状态
            String out_trade_no = request.getParameter("out_trade_no");//商户订单号
            //System.out.println("【异步通知商户订单号】" + out_trade_no + "\t\t【异步通知交易状态】" + trade_status);
            if (trade_status.equals("TRADE_SUCCESS")){  //判断订单交易状态
                payStatus = out_trade_no;
            }
        return payStatus;
    }
}
