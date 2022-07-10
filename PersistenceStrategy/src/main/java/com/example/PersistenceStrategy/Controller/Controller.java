package com.example.PersistenceStrategy.Controller;

import com.entity.Favorite;
import com.example.PersistenceStrategy.receivceDistribution.DistributionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    DistributionServiceImpl distributionService;

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        boolean b = distributionService.distributionForHash(new Favorite("0", "0", 0));
        System.out.println(b);
        return "h";
    }
}
