package com.zhang.mall;

// OrderStatus.java
public enum OrderStatus {
    PENDING_PAYMENT(0, "待支付"),
    PAID(1, "已支付"),
    PENDING_SHIPMENT(2, "待发货"),
    SHIPPED(3, "已发货"),
    COMPLETED(4, "已完成"),
    CANCELLED(5, "已取消");

    private final int code;
    private final String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    // 构造函数、getter方法等


    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}