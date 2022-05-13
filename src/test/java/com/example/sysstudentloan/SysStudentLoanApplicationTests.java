package com.example.sysstudentloan;

import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.entity.ParentAuthority;
import com.example.sysstudentloan.service.AccountService;
import com.example.sysstudentloan.service.LoginService;
import com.example.sysstudentloan.util.ResultSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SysStudentLoanApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    AccountService accountService;
    @Test
    void contextLoads() {

        Account account = new Account();
        Long x = Long.valueOf(2022000001);
        account.setId(x);
        Account list = accountService.findAccountOne(account);

        String email = list.getEmail();
        String text = "测试代码发送";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("ZYX17711671157@163.com");
        simpleMailMessage.setTo(email.replace("\"", ""));
        simpleMailMessage.setSubject("A Wei's graduation project ");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }

}
