package com.example.sysstudentloan.controller;

import com.example.sysstudentloan.config.LoginInterceptor;
import com.example.sysstudentloan.entity.ParentAuthority;
import com.example.sysstudentloan.service.LoginService;
import com.example.sysstudentloan.util.JwtUtil;
import com.example.sysstudentloan.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    /*日志*/
    private String tag = "LoginController====";
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginx")
    public ResultSet Login(@RequestParam Map loginData){
        try {
            logger.info(tag+"Login方法接收数据为："+loginData);

            String username = (String) loginData.get("username");
            String password = (String) loginData.get("password");

            Map result = loginService.Verification(username,password);

            Map info = new HashMap();
/*            info.put("sign","沉默无言");
            info.put("flag","michael");
            info.put("king","joker");*/
            info.put("password",result.get("password"));
            info.put("userid",result.get("id"));
            info.put("authorityId",result.get("role"));

            //生成JWT字符串
            String token = JwtUtil.sign(username, info);

            result.put("token",token);

            logger.info(tag+"Login方法处理完数据返回结果为："+result);
            if(result!=null){
                return ResultSet.success(result);
            }else {
                return ResultSet.fail("数据查找失败");
            }

        }catch (Exception e){
            return ResultSet.fail(e);
        }
    }

    @GetMapping("/menu")
    public ResultSet limits(@RequestParam(value = "token",required = false) String token){
        {

            //验证 token
            JwtUtil.checkSign(token);

            String userId = JwtUtil.getUserId(token);

            Map<String, Object> info = JwtUtil.getInfo(token);

            List<ParentAuthority> list = loginService.selectAuthorityInfo(info);

            return ResultSet.success(list);
        }
    }
}
