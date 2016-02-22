package com.agileengine.skeleton.dto;

import java.util.Date;

public class OrderDto {

    private String orderId;

    private String itemName;

    private Date timestamp;

    private int quantity;

    private int payment;

    private String deliveryAddress;

    private String customerUid;

    private String customerFirstName;

    private String customerLastName;

    private String customerCountry;

    private String customerAddress;

    public OrderDto(String orderId, String itemName, Date timestamp, int quantity, int payment, String deliveryAddress,
                    String customerUid, String customerFirstName, String customerLastName, String customerCountry,
                    String customerAddress) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.customerUid = customerUid;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCountry = customerCountry;
        this.customerAddress = customerAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerUid() {
        return customerUid;
    }

    public void setCustomerUid(String customerUid) {
        this.customerUid = customerUid;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}