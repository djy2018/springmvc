package com.wisely.springmvc.web.sso_cross_domain;

import com.wisely.springmvc.web.sso_cross_domain.utils.Demo1Tool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dujiayong on 2017/2/15.
 */
@RequestMapping(value = "/demo2")
@Controller
public class Demo2Controller {

    @RequestMapping(value = "/main")
    public String main(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie:cookies){
                Map<String,String> map = new HashMap<>();
                map.put("cookieName",cookie.getName());
                map.put("cookieValue",cookie.getValue());
                if(cookie.getName().equals("ssocookie")){
                    String result = Demo1Tool.doGet("http://www.x.com:8082/sso/checkCookie",map);
                    if(result.equals("1")){
                        return "sso_cross_domain/success2";
                    }
                }
            }
        }
        //返回登录界面
        request.setAttribute("path","demo2");
        request.setAttribute("gotoUrl","http://www.b.com:8082/demo2/main");
        return "sso_cross_domain/login";
    }

    @RequestMapping(value = "/login")
    public String login(String username,String password,HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        String result = Demo1Tool.doGet("http://www.x.com:8082/sso/login",map);
        if(result.equals("1")){
            List<String> hiddenUrl = new ArrayList<>();
            hiddenUrl.add("http://www.a.com:8082/demo1/addCookie");
            hiddenUrl.add("http://www.b.com:8082/demo2/addCookie");
            request.setAttribute("hiddenUrl",hiddenUrl);
            return "sso_cross_domain/success2";
        }
        return "sso_cross_domain/login";
    }

    @RequestMapping(value = "/addCookie")
    public void addCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("ssocookie","sso");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
