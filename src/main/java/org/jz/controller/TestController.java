package org.jz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hongyi Zheng
 * @date 2018/7/11
 */
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test(){
        return "This application is on";
    }

}
