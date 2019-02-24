package com.wisely.highlight_springmvc4.web.jms;

import com.wisely.highlight_springmvc4.message.jms.AlertService;
import com.wisely.highlight_springmvc4.message.jms.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dujiayong
 * @date 2018/11/29
 **/
@RequestMapping(value = "/jms")
@RestController
public class JmsController {

//    @Autowired
//    AlertService alertService;
//
//    @RequestMapping(value = "/sendMessage")
//    public String sendMessage(Spittle spittle){
//        alertService.sendSpittleAlert(spittle);
//        return "success";
//    }
//
//    @RequestMapping(value = "/receiveMessage")
//    public Spittle receiveMessage(){
//        return alertService.receiveSpittleAlert();
//    }

}
