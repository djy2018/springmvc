//package com.wisely.springmvc.web.sso_same_father;
//
//import com.wisely.springmvc.web.sso_same_father.util.Demo1Tool;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by dujiayong on 2017/2/15.
// */
//@RequestMapping(value = "/demo1")
//@Controller
//public class Demo1Controller {
//
//    @RequestMapping(value = "/main")
//    public String main(HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();
//        if(cookies != null){
//            for(Cookie cookie:cookies){
//                if(cookie.getName().equals("ssocookie")){
//                    String result = Demo1Tool.doGet("http://check.x.com:8082/sso/checkCookie",cookie.getName(),cookie.getValue());
//                    if(result.equals("1")){
//                        return "sso_same_father/success1";
//                    }
//                }
//            }
//        }
//        //返回登录界面
//        request.setAttribute("gotoUrl","http://demo1.x.com:8082/demo1/main");
//        return "sso_same_father/login";
//    }
//}
