package com.bbva.shopping.pay.api.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class TestController {

    @GetMapping("/")
    public String getTestStatus() {
        return "Test API Status";
    }

}
