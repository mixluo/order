package com.imooc.order.message;

import com.imooc.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MQSendTest extends OrderApplicationTests{
    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * myOrderExchange 交换机绑定了两个队列。通过key判断发送到哪个队列
     */
    @Test
    public void MQSend(){
        amqpTemplate.convertAndSend("myOrderExchange","computer","now:"+new Date());
    }
}
