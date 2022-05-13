package com.example.sysstudentloan.controller;

import com.alipay.api.AlipayApiException;
import com.example.sysstudentloan.entity.AlipayBean;
import com.example.sysstudentloan.entity.LoanIssuance;
import com.example.sysstudentloan.service.LoanIssuanceService;
import com.example.sysstudentloan.service.MoneyPlayService;
import com.example.sysstudentloan.service.PayService;
import com.example.sysstudentloan.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AliPayController
{
    @Autowired
    private PayService model;

    @Autowired
    private LoanIssuanceService loanIssuanceService;


    @Autowired
    private MoneyPlayService moneyPlayService;

    @PostMapping(value = "/order/alipay")
    public ResultSet alipay(@RequestParam("out_trade_no") String outTradeNo, @RequestParam("subject") String subject, @RequestParam("total_amount")String totalAmount, @RequestParam("body")String body) throws AlipayApiException{
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return ResultSet.success(model.aliPay(alipayBean));
    }
    /**【支付宝异步通知，支付宝支付后，会回调该接口】**/
    @PostMapping(value = "/order/notify_url")
    public String notifyUrl(HttpServletRequest request){
        String orderNumber = model.notifyUrl(request);
        System.out.println("【异步通知返回的订单号】" + orderNumber);
        if (!orderNumber.equals("fail")){
            Map map = new HashMap<>();
            map.put("id",orderNumber);
            map.put("repayment",1);
            Integer chargeInfo = loanIssuanceService.ModAccount(map);
            System.out.println("【是否成功】" + chargeInfo);
            if(chargeInfo == 0){
                Map map1 = new HashMap<>();
                map1.put("column6x",orderNumber);
                map1.put("status",1);
                System.out.println("分期付款："+moneyPlayService.ModAccount(map1));
            }
        }
        return "recordTab";
    }
}