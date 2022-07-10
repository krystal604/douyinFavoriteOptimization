package com.example.PersistenceStrategy.receivceDistribution;


import com.alibaba.dubbo.config.annotation.Service;
import com.distribution.DistributionService;
import com.entity.Favorite;
import com.example.PersistenceStrategy.Strategy.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "0.0.1")
public class DistributionServiceImpl implements DistributionService {


    @Autowired
    StrategyService strategy;

    @Override
    public boolean distributionForHash(Favorite favorite) {

        return strategy.addFavorite(favorite);

    }


}
