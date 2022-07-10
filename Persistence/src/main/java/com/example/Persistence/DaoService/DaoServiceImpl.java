package com.example.Persistence.DaoService;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.DaoService;
import com.entity.FavoriteContainerEntity.StrategyContainerFavorite;
import org.springframework.stereotype.Component;

@Component
@Service(version = "0.0.1")
public class DaoServiceImpl implements DaoService {
    @Override
    public void persistenceFavorite(StrategyContainerFavorite favorite) {
        System.out.println("调用成功");
    }
}
