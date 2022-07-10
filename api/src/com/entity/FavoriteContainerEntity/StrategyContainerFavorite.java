package com.entity.FavoriteContainerEntity;

import com.entity.Favorite;

import java.io.Serializable;
import java.util.Set;

public class StrategyContainerFavorite extends AbstractStrategyContainerFavorite implements Serializable {

    public StrategyContainerFavorite(String videoId, Set<Favorite> favorites, int increase, int reduce, int total, long startTime) {
        super(videoId, favorites, increase, reduce, total, startTime);
    }

    public void addFavorite(Favorite favorite){
        if (containsFavorite(favorite)){
            deduplicationFavorite(favorite);
        }else {
            favorites.add(favorite);
            if (favorite.getAction() == INCREASE_CODE){
                total++;
                increase++;
            }else {
                total--;
                reduce++;
            }
        }
    }


    /**
      * @Description: todo 查询是否已经含有此 favroite 包括action不同两种
      * @Date: 2022/6/14 19:44
      * @Param favorite:
      * @return: boolean
      * @Version: 1.0
      **/
    public boolean containsFavorite (Favorite favorite){
        if (favorites.contains(favorite)){
            return true;
        }

        if (favorite.getAction() == INCREASE_CODE){
            return favorites.contains(new Favorite(favorite.getVideoId(),favorite.getUserId(),REDUCE_CODE));
        }else {
            return favorites.contains(new Favorite(favorite.getVideoId(),favorite.getUserId(),INCREASE_CODE));
        }
    }

    protected void deduplicationFavorite(Favorite favorite){
        //如果重复操作 直接返回不需要处理
        if (favorites.contains(favorite)){
            return;
        }else {
            //第二次判断 是否含有 防止误调用
            if (containsFavorite(favorite)){
                //如果到这 还有重复的 证明目前实在取消之前操作
                if (favorite.getAction() == INCREASE_CODE){
                    favorites.remove(new Favorite(favorite.getVideoId(),favorite.getUserId(),REDUCE_CODE));
                    total++;
                    reduce--;
                }else {
                    favorites.remove(new Favorite(favorite.getVideoId(),favorite.getUserId(),INCREASE_CODE));
                    total--;
                    increase--;
                }
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
