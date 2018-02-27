package com.feng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(ModelMap model)  {
        model.put("message", "hello world222222222222222222");
        return "index";
    }
}
