package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{
    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster master = new OrderMaster();
        master.setOrderId("123456");
        master.setBuyerName("德华");
        master.setBuyerAddress("香港");
        master.setBuyerPhone("15520029834");
        master.setBuyerOpenid("15520039845");
        master.setOrderStatus(OrderStatusEnum.NEW.getCode());
        master.setPayStatus(PayStatusEnum.NEW.getCode());
        master.setOrderAmount(new BigDecimal("0.02"));
        master.setCreateTime(new Date());
        master.setUpdateTime(new Date());
        OrderMaster result = orderMasterRepository.save(master);
        Assert.assertTrue(result!=null);
    }
}