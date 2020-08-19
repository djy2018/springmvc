package com.wisely.springmvc.web.ch4_6;

import com.wisely.springmvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dujiayong on 2016/7/7.
 */
@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    /**
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图，对于 InternalResourceViewResolver 视图解析器 通过
     * prefix + returnVal + 后缀这样的方式得到实际的物理视图，然后做转发操作
     * /WEB-INF/classes/views/page.jsp
     *
     * @param model
     * @return
     */
    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg",demoService.saySomething());
        return "page";
    }
}
