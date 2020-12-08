package com.ksyun.aiot.controller;

import com.ksyun.aiot.mq.rabbit.rabbitmqProducer;
import org.springframework.beans.factory.annotation.Autowired;

//@RestController
//@RequestMapping(value = "/rabbit")
public class RabbitMqController {

    @Autowired
    rabbitmqProducer producer;

//    @GetMapping(value="/send")
    public void sendMq(){
        producer.send3();
    }
}
