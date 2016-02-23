package com.agileengine.skeleton.translator;

import com.agileengine.skeleton.dto.OrderDto;
import com.agileengine.skeleton.model.Order;

public class OrderTranslator {
    
    public static void fromDto(OrderDto source, Order destination) {
        destination.setOrderId(source.getOrderId());
        destination.setItemName(source.getItemName());
        destination.setTime(source.getTimestamp());
        destination.setQuantity(source.getQuantity());
        destination.setPayment(source.getPayment());
        destination.setDeliveryAddress(source.getDeliveryAddress());
        destination.setCustomerUid(source.getCustomerUid());
        destination.setCustomerFirstName(source.getCustomerFirstName());
        destination.setCustomerLastName(source.getCustomerLastName());
        destination.setCustomerCountry(source.getCustomerCountry());
        destination.setCustomerAddress(source.getCustomerAddress());
    }

    public static void toDto(Order source, OrderDto destination) {
        destination.setOrderId(source.getOrderId());
        destination.setItemName(source.getItemName());
        destination.setTimestamp(source.getTime());
        destination.setQuantity(source.getQuantity());
        destination.setPayment(source.getPayment());
        destination.setDeliveryAddress(source.getDeliveryAddress());
        destination.setCustomerUid(source.getCustomerUid());
        destination.setCustomerFirstName(source.getCustomerFirstName());
        destination.setCustomerLastName(source.getCustomerLastName());
        destination.setCustomerCountry(source.getCustomerCountry());
        destination.setCustomerAddress(source.getCustomerAddress());
    }
}
