package com.javaclimb.drug.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laojie
 * @create 2021-04-17 0:27
 */
@RestController
public class TestController {
    @RequestMapping("/testString")
    public String testString(){
        return "大家好！";
    }

}
