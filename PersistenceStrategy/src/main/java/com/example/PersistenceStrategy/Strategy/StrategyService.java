package com.example.PersistenceStrategy.Strategy;

import com.entity.Favorite;
import com.entity.FavoriteContainerEntity.StrategyContainerFavorite;
import com.example.PersistenceStrategy.Strategy.Comment.TimeAndTimesStrategyConfig;
import com.example.PersistenceStrategy.Strategy.Comment.TransferPersistence;
import com.example.PersistenceStrategy.Strategy.saveStrategy.JudgeSaveStrategy;
import com.example.PersistenceStrategy.Strategy.saveStrategy.impl.AsRDBSaveStrategy;
import com.example.PersistenceStrategy.container.ContainerMap;
import com.example.PersistenceStrategy.container.HelperTimeWheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

@Component
public class StrategyService {

    @Autowired
    TransferPersistence transferPersistence;

    @Autowired
    AsRDBSaveStrategy asRDBSaveStrategy;


    public boolean addFavorite(Favorite favorite){
        return addFavoriteMain(favorite , asRDBSaveStrategy);
    }




    private boolean addFavoriteMain(Favorite favorite , JudgeSaveStrategy<StrategyContainerFavorite> judgeSaveStrategy){
        String videoId = favorite.getVideoId();


        //加入辅助线程中 防止饿死
        HelperTimeWheel.addVideo(videoId);


        if (ContainerMap.getContainerMap().containsKey(videoId)){
            //添加新的favorite;
            ContainerMap.getContainerMap().get(videoId).addFavorite(favorite);



            if (judgeSaveStrategy.judgeSave(ContainerMap.getContainerMap().get(videoId))){
                //异步处理
                transferPersistence.TransferDaoService(videoId);
                //处理完成


                //用完了别忘了删除
                ContainerMap.getContainerMap().remove(videoId);
            }

        }else {
            ContainerMap.getContainerMap().put(favorite.getVideoId() ,
                    new StrategyContainerFavorite(favorite.getVideoId() , new HashSet<>() ,
                            0 ,0 ,0 ,System.currentTimeMillis()));

            ContainerMap.getContainerMap().get(favorite.getVideoId()).addFavorite(favorite);
        }

        return true;
    }





}
