package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dujiayong on 2016/7/6.
 * 通过@ControllerAdvice我们可以将对于控制器的全局配置放置在同一个位置
 * 这里@ControllerAdvice声明了一个控制器建言，@ControllerAdvice组合了@Component注解
 * 所以自动注册为Spring的Bean
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    /**
     * @ExceptionHandler
     * 该注解在此定义全局处理，通过value属性可以过滤拦截的条件，在此处
     * 我们可以拦截所有的Exception
     */
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error"); //实例化时的参数指定了跳转的页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //@InitBinder：用来设置WebDataBinder,WebDataBinder用来自动绑定前台请求参数到Model中
        //如果我们需要看更多的WebDataBinder文档，请参考WebDataBinder的API文档
        //webDataBinder.setDisallowedFields("id");
    }
}