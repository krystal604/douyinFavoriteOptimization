package com.example.PersistenceStrategy.container;


import com.entity.FavoriteContainerEntity.StrategyContainerFavorite;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ContainerMap {
    private static volatile Map<String, StrategyContainerFavorite> containerMap = null;

    private ContainerMap() {
    }

    public static Map<String, StrategyContainerFavorite> getContainerMap(){
        if (containerMap == null){
            synchronized (ContainerMap.class){
                if (containerMap == null){
                    containerMap = new ConcurrentHashMap<>();
                }
            }
        }
        return containerMap;
    }


}
