package com.example.PersistenceStrategy.Strategy;

import com.example.PersistenceStrategy.Strategy.Comment.TransferPersistence;
import com.example.PersistenceStrategy.ThreadPool.MyThreadPool;
import com.example.PersistenceStrategy.container.ContainerMap;
import com.example.PersistenceStrategy.container.HelperTimeWheel;
import com.example.PersistenceStrategy.container.entry.TimeWheelEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class HelperTImeWheelStrategy implements Runnable{
    @Autowired
    TransferPersistence transferPersistence;

//    @Reference(version = "0.0.1")
//    DaoService daoService;

    @PostConstruct
    public void init(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("辅助线程启动成功");
        while (true){

            List<String> all = HelperTimeWheel.getNowTimeList();

            for (String videoId : all) {
                transferPersistence.TransferDaoService(videoId);
                //用完了别忘了删除
                ContainerMap.getContainerMap().remove(videoId);
            }

            HelperTimeWheel.goTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
