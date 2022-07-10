package com.entity;


import java.io.Serializable;
import java.util.Objects;

public class Favorite implements Serializable {
    private String videoId;
    private String userId;
    private int action;

    public Favorite(String videoId, String userId, int action) {
        this.videoId = videoId;
        this.userId = userId;
        this.action = action;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return action == favorite.action && videoId.equals(favorite.videoId) && userId.equals(favorite.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, userId, action);
    }



    public Favorite() {
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
