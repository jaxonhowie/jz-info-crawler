package org.jz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Hongyi Zheng
 * @date 2018/7/13
 */
@Controller
public class HomePageController extends BaseController {

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

}
