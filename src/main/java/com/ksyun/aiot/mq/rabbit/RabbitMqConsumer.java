package com.ksyun.aiot.mq.rabbit;

import com.ksyun.aiot.callback.EventObject;
import com.ksyun.aiot.callback.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqConsumer {

    @Autowired
    EventSource eventSource;

    @RabbitListener(queues = {RabbitConfig.eventMessage})
    public void handler(Message object) {
        byte[] body = object.getBody();
        log.info("消费消息 = {}",new String(body));

        if(eventSource==null){
            System.out.println("null");
        }
        eventSource.notifyListenerEvents(new EventObject(new String(body)));

    }

}
