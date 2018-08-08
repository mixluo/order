package com.imooc.order.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
public class OrderMaster {
  /**订单ID*/
  @Id
  private String orderId;
  //买家名字
  private String buyerName;
  //买家手机号
  private String buyerPhone;
  //买家地址
  private String buyerAddress;
  //买家微信ID
  private String buyerOpenid;
  //订单金额
  private BigDecimal orderAmount;
  //订单状态
  private Integer orderStatus;
  //支付状态
  private Integer payStatus;
  //下单时间
  private Date createTime;
  //更新时间
  private Date updateTime;

}
