package com.ksyun.aiot.mq.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksyun.aiot.callback.EventObject;
import com.ksyun.aiot.callback.EventSource;
import com.ksyun.aiot.utils.Timekeeper;
import com.ksyun.aiot.utils.WitchOnEventBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Timer;

@Slf4j
@Component
public class RabbitMqConsumer {
  static  Timekeeper timekeeper = new Timekeeper();
    @Autowired
    EventSource eventSource;

    @RabbitListener(queues = {RabbitConfig.eventMessage})
    public void handler(Message object) {
        byte[] body = object.getBody();
        log.info("消费消息 = {}", new String(body));
        ObjectMapper mapper = new ObjectMapper();
        WitchOnEventBean witchOnEventBean = null;
        try {
            witchOnEventBean = mapper.readValue(body, WitchOnEventBean.class);
            log.debug(witchOnEventBean.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (witchOnEventBean != null) {

            timekeeper.setCount(witchOnEventBean.getDeviceId());
        }
        timekeeper.showMap();

        //todo 控制设备时回调用
//     eventSource.notifyListenerEvents(new EventObject(new String(body)));

    }

}
