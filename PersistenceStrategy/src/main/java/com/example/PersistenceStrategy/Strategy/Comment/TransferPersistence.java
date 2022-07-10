package com.example.PersistenceStrategy.Strategy.Comment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dao.DaoService;
import com.example.PersistenceStrategy.ThreadPool.MyThreadPool;
import com.example.PersistenceStrategy.container.ContainerMap;
import org.springframework.stereotype.Component;

@Component
public class TransferPersistence {
    @Reference(version = "0.0.1")
    DaoService daoService;

    public void TransferDaoService(String videoId){
        MyThreadPool.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                daoService.persistenceFavorite(ContainerMap.getContainerMap().get(videoId));
                System.out.println("is run");
            }
        });
    }
}
