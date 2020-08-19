package com.wisely.springmvc.web.sso;

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
