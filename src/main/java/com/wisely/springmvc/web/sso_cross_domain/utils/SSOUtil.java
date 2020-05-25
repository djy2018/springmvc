package com.wisely.springmvc.web.sso_cross_domain.utils;

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

    public static boolean checkCookie(String cookieName,String cookieValue){
        if(cookieName.equals("ssocookie") && cookieValue.equals("sso"))
            return true;
        return false;
    }
}
