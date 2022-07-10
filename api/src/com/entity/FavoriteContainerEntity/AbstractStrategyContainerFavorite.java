package com.entity.FavoriteContainerEntity;

import com.entity.Favorite;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractStrategyContainerFavorite {
    protected String videoId;
    protected Set<Favorite> favorites;
    protected int increase;
    protected int reduce;

    protected int total;

    protected long startTime;

    // actionCode
    public static final int INCREASE_CODE = 1;
    public static final int REDUCE_CODE = 2;

    public AbstractStrategyContainerFavorite(String videoId, Set<Favorite> favorites, int increase, int reduce, int total, long startTime) {
        this.videoId = videoId;
        this.favorites = favorites;
        this.increase = increase;
        this.reduce = reduce;
        this.total = total;
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractStrategyContainerFavorite that = (AbstractStrategyContainerFavorite) o;
        return increase == that.increase && reduce == that.reduce && total == that.total && startTime == that.startTime && videoId.equals(that.videoId) && favorites.equals(that.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, favorites, increase, reduce, total, startTime);
    }


    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
