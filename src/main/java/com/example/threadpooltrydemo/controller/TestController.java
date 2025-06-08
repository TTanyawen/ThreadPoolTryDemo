package com.example.threadpooltrydemo.controller;

import com.example.threadpooltrydemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/test2")
    public String testThreadPool() {
        testService.testThreadPool();
        return "test2";
    }
}
