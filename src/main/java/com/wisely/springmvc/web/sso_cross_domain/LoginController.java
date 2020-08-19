package com.wisely.springmvc.web.sso_cross_domain;

import com.wisely.springmvc.web.sso_cross_domain.utils.SSOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dujiayong on 2017/2/15.
 */
@RequestMapping(value = "/sso")
@Controller
public class LoginController {

    /**
     * 统一登录接口
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String username, String password){
        boolean ok = SSOUtil.checkLogin(username,password);
        String result = "0";
        if(ok){
            result = "1";
        }
        return result;
    }

    /**
     * 统一验证接口
     * @param cookieName cookie名称
     * @param cookieValue cookie内容
     * @return 验证cookie是否有效，有效返回1，否则返回0
     */
    @RequestMapping(value = "/checkCookie")
    @ResponseBody
    public String checkCookie(String cookieName,String cookieValue){
        boolean ok = SSOUtil.checkCookie(cookieName,cookieValue);
        String result = "0";
        if(ok){
            result = "1";
        }
        return result;
    }
}
