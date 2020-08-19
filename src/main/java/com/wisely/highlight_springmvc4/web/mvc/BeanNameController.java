package com.wisely.highlight_springmvc4.web.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring MVC有2种类型的Controller ： 1.注解 2.beanName
 * 3种实现方式，@Controller注解 加载类上 实现Controller 实现HttpRequestHandler
 * Created by dujiayong on 2020/4/7.
 */
@Component("/handle2.do") //BeanName
public class BeanNameController implements Controller{


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("beanName形式定义Controller ---- implement Controller");
        return null;
    }
}
