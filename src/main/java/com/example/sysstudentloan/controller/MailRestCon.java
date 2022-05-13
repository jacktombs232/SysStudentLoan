package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.entity.Account;
import com.example.sysstudentloan.service.AccountService;
import com.example.sysstudentloan.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MailRestCon {

    @Value("spring.mail.username")
    private String uname;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private  AccountService accountService;

    @PostMapping("/sendMail")
    public ResultSet send(@RequestParam Map map) {

        Long data = Long.parseLong((String) map.get("studentId"));
        Account account = new Account();
        account.setId(data);
        Account list = accountService.findAccountOne(account);

        String email = list.getEmail();
        String text = (String) map.get("text");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("ZYX17711671157@163.com");
        simpleMailMessage.setTo(email.replace("\"", ""));
        simpleMailMessage.setSubject("A Wei's graduation project ");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

        return ResultSet.success(null);
    }

}