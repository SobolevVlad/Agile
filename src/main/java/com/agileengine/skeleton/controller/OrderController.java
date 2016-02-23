package com.agileengine.skeleton.controller;

import com.agileengine.skeleton.connector.OrderConnector;
import com.agileengine.skeleton.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderConnector")
    private OrderConnector connector;

    @RequestMapping(value = "/api/orders/", method = RequestMethod.GET)
    public @ResponseBody List<Order> getOrders() {
        return connector.get();
    }

    @RequestMapping(value = "/api/orders", method = RequestMethod.GET, params = "orderBy")
    public @ResponseBody List<Order> getSortedOrders(@RequestParam(value = "orderBy") String columnName) {
        return connector.getSorted(columnName);
    }

    @RequestMapping(value = "/api/orders", method = RequestMethod.GET, params = {"offset", "limit"})
    public @ResponseBody List<Order> getOrderByOffset(@RequestParam(value = "offset") int offset,
                                                      @RequestParam(value = "limit") int limit) {
        return connector.getWithOffsetAndLimit(offset, limit);
    }

    @RequestMapping(value = "/api/orders", method = RequestMethod.GET, params = {"orderBy", "offset", "limit"})
    public @ResponseBody List<Order> getSortedOrdersByPage(@RequestParam(value = "orderBy") String columnName,
                                                           @RequestParam(value = "offset") int offset,
                                                           @RequestParam(value = "limit") int limit) {
        return connector.getSortedByPage(columnName, offset, limit);
    }

    @RequestMapping(value = "/api/orders/", method = RequestMethod.GET)
    public @ResponseBody List<Order> getOrderStatistics() {
        return connector.getOrderStatistics();
    }
}