package com.wisely.highlight_springmvc4.web.sso;

import com.wisely.highlight_springmvc4.util.SSOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dujiayong on 2017/2/15.
 */
//@RequestMapping(value = "/demo1")
//@Controller
//public class Demo1Controller {
//
//    @RequestMapping(value = "/main")
//    public String main(HttpServletRequest request){
//        if(SSOUtil.checkCookie(request)){
//            //cookie有效
//            return "/sso/success1";
//        }
//        //返回登录界面
//        request.setAttribute("gotoUrl","/demo1/main");
//        return "/sso/login";
//    }
//}