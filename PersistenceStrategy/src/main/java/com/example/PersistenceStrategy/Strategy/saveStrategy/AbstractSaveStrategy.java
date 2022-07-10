package com.example.PersistenceStrategy.Strategy.saveStrategy;

import org.springframework.stereotype.Component;

@Component
//持久化策略的抽象顶级父类
public abstract class AbstractSaveStrategy {
    protected long currentTimeMillis;

    public AbstractSaveStrategy() {
        currentTimeMillis = System.currentTimeMillis();
    }

}
