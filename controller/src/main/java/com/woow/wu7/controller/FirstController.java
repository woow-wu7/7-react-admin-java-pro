package com.woow.wu7.controller;

import com.woow.wu7.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Autowired
    FirstService firstService;

    @GetMapping("/data")
    public String getData() {
        return firstService.getData();
    }
}
