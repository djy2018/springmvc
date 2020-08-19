package com.wisely.springmvc.web.ch4_4;

import com.wisely.springmvc.domain.DemoObj;
import com.wisely.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by dujiayong on 2016/7/6.
 */
@Controller
public class AdviceController {

    public static final String SUCCESS = "index";

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        if (id != null) {
            // 模拟从数据库中获取对象
            User user = new User(1, "Tom", "123456", "tom@gmail.com", 12);
            System.out.println("从数据库中获取对象为:" + user);
            map.put("user", user);
        }
    }

    @RequestMapping("/advice")
    public void getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        //如果从浏览器进行请求，首先经@ModelAttribute注解，
        //接着是@InitBinder注解，最后是@RequestMapping注解
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg);
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("User :" + user);
        return SUCCESS;
    }
}
