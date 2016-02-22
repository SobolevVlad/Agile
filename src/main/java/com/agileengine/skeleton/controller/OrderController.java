package com.agileengine.skeleton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/orders")
public class OrderController {

    @RequestMapping()
    public Object search() {
        return  new Object();
    }


}