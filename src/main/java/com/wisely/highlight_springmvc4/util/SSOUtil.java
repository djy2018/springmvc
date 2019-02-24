package com.wisely.highlight_springmvc4.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dujiayong on 2017/2/15.
 * SSO(Single Sign On)-单点登录
 */
public class SSOUtil {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "123";

    public static boolean checkLogin(String username,String password){
        if(USERNAME.equals(username) && PASSWORD.equals(password))
            return true;
        return false;
    }

    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("ssologin") && cookie.getValue().equals("sso")){
                return true;
            }
        }
        return false;
    }
}
