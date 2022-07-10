package com.example.MqReceiver.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.distribution.DistributionService;
import com.entity.Favorite;
import com.example.MqReceiver.distribution.Distribution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Reference(version = "0.0.1")
    DistributionService distributionService;

    @ResponseBody
    @GetMapping("/")
    public String test(){
//        Distribution distribution = new Distribution();
//        System.out.println(distribution.distributionForHash(new Favorite("1", "1", 0)));
        System.out.println(distributionService.distributionForHash(new Favorite("1", "1", 0)));
        return "hello";
    }
}
