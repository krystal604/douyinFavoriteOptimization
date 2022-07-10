package com.example.PersistenceStrategy.Strategy.saveStrategy.impl;

import com.entity.FavoriteContainerEntity.StrategyContainerFavorite;
import com.example.PersistenceStrategy.Strategy.Comment.TimeAndTimesStrategyConfig;
import com.example.PersistenceStrategy.Strategy.saveStrategy.AbstractSaveStrategy;
import com.example.PersistenceStrategy.Strategy.saveStrategy.JudgeSaveStrategy;
import org.springframework.stereotype.Component;

@Component
public class AsRDBSaveStrategy extends AbstractSaveStrategy implements JudgeSaveStrategy<StrategyContainerFavorite> {

    @Override
    public boolean judgeSave(StrategyContainerFavorite object) {

        return judgeSave(object.getTotal() , object.getStartTime());

    }

    private boolean judgeSave(int total , long startTime){

        total = Math.abs(total);

//        if (total >= 1){
//            return true;
//        }

        if (currentTimeMillis - startTime >= TimeAndTimesStrategyConfig.SAVE_900_1_MILLIS
                && total >= TimeAndTimesStrategyConfig.SAVE_900_1_TIMES){
            return true;
        }
        if (currentTimeMillis - startTime >= TimeAndTimesStrategyConfig.SAVE_300_10_MILLIS
                && total >= TimeAndTimesStrategyConfig.SAVE_300_10_TIMES){
            return true;
        }
        if (currentTimeMillis- startTime >= TimeAndTimesStrategyConfig.SAVE_60_1000_MILLIS
                && total >= TimeAndTimesStrategyConfig.SAVE_60_1000_TIMES){
            return true;
        }


        return false;
    }
}
