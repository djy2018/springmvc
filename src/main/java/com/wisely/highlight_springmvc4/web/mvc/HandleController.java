package com.wisely.highlight_springmvc4.web.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dujiayong on 2020/4/7.
 */
@Component("/handle1.do") //BeanName
public class HandleController implements HttpRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("beanName形式定义Controller --- implement HttpRequestHandler");
    }

}
