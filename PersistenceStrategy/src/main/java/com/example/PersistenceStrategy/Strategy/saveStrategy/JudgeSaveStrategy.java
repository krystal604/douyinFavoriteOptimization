package com.example.PersistenceStrategy.Strategy.saveStrategy;

import org.springframework.stereotype.Component;

@Component
//策略模式
//用于判断 何时持久化
public interface JudgeSaveStrategy<T> {
    boolean judgeSave(T object);
}
