package com.example.PersistenceStrategy.Strategy.saveStrategy.impl;

import com.entity.FavoriteContainerEntity.StrategyContainerFavorite;
import com.example.PersistenceStrategy.Strategy.saveStrategy.AbstractSaveStrategy;
import com.example.PersistenceStrategy.Strategy.saveStrategy.JudgeSaveStrategy;
import org.springframework.stereotype.Component;

@Component
public class TestSaveStrategy extends AbstractSaveStrategy implements JudgeSaveStrategy<StrategyContainerFavorite> {
    @Override
    public boolean judgeSave(StrategyContainerFavorite object) {
        return true;
    }
}
