package com.example.sysstudentloan.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件
 */
@Configuration
@Data
@Component
public class AlipayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    @Value("${alipay.appId}")
    private String appId;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    @Value("${alipay.privateKey}")
    private String privateKey;

    /**
     * 支付宝公钥,
     */
    @Value("${alipay.publicKey}")
    private String publicKey;

    /**
     * 服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    @Value("${alipay.notifyUrl}")
    private String notifyUrl;

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    @Value("${alipay.returnUrl}")
    private String returnUrl;

    /**
     * 签名方式
     */
    @Value("${alipay.signType}")
    private String signType;

    /**
     * 字符编码格式
     */
    @Value("${alipay.charset}")
    private String charset;

    /**
     * 支付宝网关
     */
    @Value("${alipay.gatewayUrl}")
    private String gatewayUrl;

    /**
     * 支付宝网关
     */
    @Value("${alipay.logPath}")
    private String logPath;
}
