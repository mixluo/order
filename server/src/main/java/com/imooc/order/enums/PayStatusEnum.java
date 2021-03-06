package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    NEW(0,"待支付"),
    FINISHED(1,"支付成功"),
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
