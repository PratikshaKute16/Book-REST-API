package com.SpringAPI.SpringAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        int a=121;
        int b=20;
        return "this is for testing"+(a+b);
    }

}
