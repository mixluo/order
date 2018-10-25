package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

public interface OrderService {
   OrderDTO create(OrderDTO orderDTO);

   /**
    * 完结订单（只能卖家操作）
    * @param orderId
    * @return
    */
   OrderDTO finish(String orderId);
}
