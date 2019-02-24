package com.wisely.highlight_springmvc4.web.sso;

import com.wisely.highlight_springmvc4.util.SSOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dujiayong on 2017/2/15.
 */
//@RequestMapping(value = "/sso")
//@Controller
//public class LoginController {
//
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(String username, String password, String gotoUrl, HttpServletRequest request,HttpServletResponse response){
//        if(SSOUtil.checkLogin(username,password)){
//            Cookie cookie = new Cookie("ssologin","sso");
//            cookie.setPath("/");
//            response.addCookie(cookie);
//            return "redirect:" + gotoUrl;
//        }else{
//            request.setAttribute("gotoUrl",gotoUrl);
//            return "/sso/login";
//        }
//
//    }
//}
