package com.ksyun.aiot.mq.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    //todo 定义队列名称
    final static String eventMessage = "device_event_consume_queue";
//    final static String testTopicMessage ="paas_default_consume_queue";

    //todo 定义交换器名称
    final static String eventExchange = "device_event_exchange";

    @Bean
    public Queue fanoutQueue() {
        return new Queue(RabbitConfig.eventMessage);
    }



    /**
     * 这里的exchange是交换机的名称字符串和发送消息时的名称必须相同
     * this.rabbitTemplate.convertAndSend("exchange", "topic.1", context);
     */
    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(RabbitConfig.eventExchange);
    }



    /**
     * @param queueMessages
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingFanoutExchange(@Qualifier("fanoutQueue") Queue queueMessages, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueMessages).to(fanoutExchange);
    }



}
