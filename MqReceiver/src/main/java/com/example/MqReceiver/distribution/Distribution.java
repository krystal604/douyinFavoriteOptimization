package com.example.MqReceiver.distribution;

import com.alibaba.dubbo.config.annotation.Reference;
import com.distribution.DistributionService;
import com.entity.Favorite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Distribution {

    @Reference(version = "0.0.1",loadbalance="consistenthash")
    DistributionService distributionService;


    public boolean distributionForHash(Favorite favorite){

        boolean state = false;
        for (int i = 0; i < RpcConfig.RPC_RETRY_TIMES; i++) {
            state = distributionService.distributionForHash(favorite);
            if (state){
                log.info("success distributionForHash" + favorite);
                break;
            }
        }

        if (!state){
            log.info("false distributionForHash" + favorite);
        }

        return state;
    }

}
