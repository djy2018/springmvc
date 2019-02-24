package com.wisely.highlight_springmvc4.web.rabbit;

import com.wisely.highlight_springmvc4.message.rabbit.AlertService;
import com.wisely.highlight_springmvc4.message.rabbit.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
@RequestMapping(value = "/rabbit")
@RestController
public class RabbitController {

    @Autowired
    AlertService alertService;

//    @RequestMapping(value = "/sendMessage")
//    public String sendMessage(Spittle spittle){
//        alertService.sendSpittleAlert(spittle);
//        return "success";
//    }

    @RequestMapping(value = "/sendMessage")
    public String sendMessage(Spittle spittle){
        Map<String,Spittle> map = new HashMap<>();
        map.put("object",spittle);
        alertService.sendSpittleAlert(map);
        return "success";
    }

    @RequestMapping(value = "/receiveMessage")
    public Spittle receiveMessage(){
        return alertService.receiveSpittleAlert();
    }

}
