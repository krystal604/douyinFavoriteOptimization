package com.example.MqReceiver.rabbitMq.Receiver;

import com.entity.Favorite;
import com.example.MqReceiver.distribution.Distribution;
import com.example.MqReceiver.rabbitMq.MqConfig.MqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = MqConfig.Favorite_QUEUE),
        exchange = @Exchange(value = MqConfig.Favorite_EXCHANGE),
        key = MqConfig.Favorite_ROUTING
))
@Slf4j
public class FavoriteReceiver {

    @Autowired
    Distribution distribution;


    @RabbitHandler
    public void process(Map<String, String> testMessage) {
        log.info("DirectReceiver消费者收到消息  : " + testMessage.toString());
        String videoId = testMessage.get("videoId");
        String userId = testMessage.get("userId");
        String actionString = testMessage.getOrDefault("action", "0");
        int action = Integer.parseInt(actionString);
        Favorite favorite = new Favorite(videoId, userId, action);


        boolean b = distribution.distributionForHash(favorite);

        if (b) {
            log.info("success" + "DirectReceiver" + favorite );
        } else {
            log.info("false"+ "DirectReceiver" + favorite);
        }
    }




}
