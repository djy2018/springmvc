package com.wisely.springmvc.web.ch4_4;

import com.wisely.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dujiayong on 2016/7/6.
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public void getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        //如果从浏览器进行请求，首先经@ModelAttribute注解，
        //接着是@InitBinder注解，最后是@RequestMapping注解
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg);
    }
}
