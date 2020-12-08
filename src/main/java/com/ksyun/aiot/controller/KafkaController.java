package com.ksyun.aiot.controller;

import com.ksyun.aiot.mq.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

//@RestController
@Slf4j
public class KafkaController {

    @Autowired
    KafkaProducer producer;


//    @GetMapping(value="/send")
    public void send(){
       // producer.send("{\"name\":\"小红\",\"age\":18}");
        producer.send("{\"clientId\":\"test_key\",\"messageType\":\"DISCONNECT\",\"message\":\"{\\\"name\\\":\\\"xiaohong\\\",\\\"age\\\":11,\\\"msgType\\\":\\\"3\\\"}\"}");
    }
}
