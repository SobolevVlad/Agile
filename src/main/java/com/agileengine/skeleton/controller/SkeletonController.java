package com.agileengine.skeleton.controller;

import com.agileengine.skeleton.connector.OrderConnector;
import com.agileengine.skeleton.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SkeletonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkeletonController.class);

    @Autowired
    @Qualifier("orderConnector")
    private OrderConnector connector;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "orders";
    }

    @RequestMapping(value = "/api/orders/all", method = RequestMethod.GET)
    public @ResponseBody List<Order> getOrders() {
        return connector.get();
    }
}