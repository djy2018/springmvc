package com.wisely.highlight_springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by dujiayong on 2016/7/5.
 * WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口，从而实现了
 * 替代web.xml的位置。实现此接口将会自动被SpringServletContainerInitializer(用来启动
 * Servlet3.0容器)获取
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //新建WebApplicationContext,注册配置类，并将其和当前servletContext关联
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);
        //注册SpringMVC的DispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        // MultipartResolver：StandardServletMultipartResolver
        servlet.setMultipartConfig(new MultipartConfigElement("D:/temp/uploads",2019152,4194304,0));

        //开启对异步方法的支持
        servlet.setAsyncSupported(true);
    }

}
