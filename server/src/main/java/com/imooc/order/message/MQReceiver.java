package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MQReceiver {
    /**
     * s水果供应商消息接收
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrderExchange"),
            key = "fruit",
            value = @Queue("myFruitQueue")
    ))
    public void fruitReceiver(String message){
        log.info("fruit MQReceiver message:{} ",message);
    }

    /**
     * 数码供应商消息接收
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrderExchange"),
            key = "computer",
            value = @Queue("myComputerQueue")
    ))
    public void computerReceiver(String message){
        log.info("computer MQReceiver message:{} ",message);
    }
}
