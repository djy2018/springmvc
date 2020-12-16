package com.wisely.springmvc;
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

    // tomcat在初始化web容器的时候会调用onStartup方法
    // ServletContext web上下文对象
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //单独使用Spring MVC不会处理静态资源
        //Spring Boot会处理静态资源 静态资源位置保存起来


        // 传统做法: ClassPathXmlApplicationContext  使用xml形式配置spring 作用一致，都是初始化spring上下文
        // 使用注解形式开发(配置)spring 零配置  => spring 3.0之后
        // 初始化spring
        // 初始化spring mvc
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //新建WebApplicationContext,注册配置类，并将其和当前servletContext关联
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);

        ctx.refresh();


        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        //注册SpringMVC的DispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        // MultipartResolver：StandardServletMultipartResolver
        servlet.setMultipartConfig(new MultipartConfigElement("D:/temp/uploads", 2019152, 4194304, 0));

        //开启对异步方法的支持
        servlet.setAsyncSupported(true);
    }


}
