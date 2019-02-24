//package com.wisely.highlight_springmvc4.web.sso_same_father;
//
//import com.wisely.highlight_springmvc4.web.sso_same_father.util.SSOUtil;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by dujiayong on 2017/2/15.
// */
//@RequestMapping(value = "/sso")
//@Controller
//public class LoginController {
//
//    /**
//     * 统一登录接口
//     */
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(String username, String password, String gotoUrl, HttpServletRequest request,HttpServletResponse response){
//        if(SSOUtil.checkLogin(username,password)){
//            Cookie cookie = new Cookie("ssocookie","sso");
//            cookie.setDomain(".x.com"); //设置父级域名
//            cookie.setPath("/");
//            response.addCookie(cookie);
//            return "redirect:" + gotoUrl;
//        }else{
//            request.setAttribute("gotoUrl",gotoUrl);
//            return "sso_same_father/login";
//        }
//
//    }
//
//    /**
//     * 统一验证接口
//     * @param cookieName cookie名称
//     * @param cookieValue cookie内容
//     * @return 验证cookie是否有效，有效返回1，否则返回0
//     */
//    @RequestMapping(value = "/checkCookie")
//    @ResponseBody
//    public String checkCookie(String cookieName,String cookieValue){
//        boolean ok = SSOUtil.checkCookie(cookieName,cookieValue);
//        String result = "0";
//        if(ok){
//            result = "1";
//        }
//        return result;
//    }
//}
