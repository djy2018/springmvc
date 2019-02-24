package com.wisely.highlight_springmvc4.web.sso;

import com.wisely.highlight_springmvc4.util.SSOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dujiayong on 2017/2/15.
 */
//@RequestMapping(value = "/demo2")
//@Controller
//public class Demo2Controller {
//
//    @RequestMapping(value = "/main")
//    public String main(HttpServletRequest request){
//        if(SSOUtil.checkCookie(request)){
//            //cookie有效
//            return "/sso/success2";
//        }
//        //返回登录界面
//        request.setAttribute("gotoUrl","/demo2/main");
//        return "/sso/login";
//    }
//}
