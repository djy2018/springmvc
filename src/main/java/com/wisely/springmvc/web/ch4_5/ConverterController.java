package com.wisely.springmvc.web.ch4_5;

import com.wisely.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dujiayong on 2016/7/6.
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert",produces = "application/x-wisely")
    public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
