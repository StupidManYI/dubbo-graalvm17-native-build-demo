package com.ingsha.nativeDemo.controller;

import com.ingsha.nativeDemo.dubboService.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @DubboReference(version = "1.0.0", group = "dubbo")
    private DemoService demoService;

    public WebController() {
        System.out.println("test");
    }

    // user GET to avoid resubmit warning on browser side.
    @RequestMapping(value = "/dubbo-sae", method = RequestMethod.GET)
    @ResponseBody
    String test() {
        return "Here is the response from provider: \"" + demoService.getUserById(1L) + "\".";
    }

}