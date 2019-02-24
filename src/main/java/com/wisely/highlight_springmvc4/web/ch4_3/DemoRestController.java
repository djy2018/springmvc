package com.wisely.highlight_springmvc4.web.ch4_3;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dujiayong on 2016/7/6.
 * 使用@RestController，声明是控制器，并且返回数据时不需要@ResponseBody
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"}) //返回数据的媒体类型为json
    public DemoObj getjson(DemoObj obj){
        return new DemoObj(obj.getId() + 1,obj.getName() + "yy"); //直接返回对象，对象会自动转换为json
    }

    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"}) //返回数据的媒体类型为xml
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy"); //直接返回对象，对象会自动转换为xml
    }
}
