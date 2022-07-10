package com.example.PersistenceStrategy.container;

import com.example.PersistenceStrategy.Strategy.Comment.TimeAndTimesStrategyConfig;
import com.example.PersistenceStrategy.container.entry.TimeWheelEntry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelperTimeWheel {

    private static TimeWheelEntry[] timeWheel;
    private static int nowTimeIndex = 0;
    private static final int capacity = Math.toIntExact(TimeAndTimesStrategyConfig.MAX_SAVE_TIME / TimeAndTimesStrategyConfig.MILLISECOND);

    private static Set<String> set;

    public static TimeWheelEntry[] getTimeWheel(){
        if (timeWheel == null){
            synchronized (ContainerMap.class){
                if (timeWheel == null){
                    timeWheel = new TimeWheelEntry[capacity];
                    set = new HashSet<>();
                }
            }
        }
        return timeWheel;
    }

    public static void addVideo(String video){
        if (set.contains(video)){
            return;
        }
        TimeWheelEntry[] timeWheel = getTimeWheel();
        timeWheel[(nowTimeIndex - 1) % capacity].add(video);
        set.add(video);
    }

    public static List<String> getNowTimeList(){
        List<String> all = HelperTimeWheel.getTimeWheel()[nowTimeIndex].getAll();
        for (String s : all) {
            set.remove(s);
        }
        return all;
    }


    public static void goTime(){
        nowTimeIndex++;
        nowTimeIndex %= capacity;
    }





    public static int getNowTimeIndex() {
        return nowTimeIndex;
    }

    public static void setNowTimeIndex(int nowTimeIndex) {
        HelperTimeWheel.nowTimeIndex = nowTimeIndex;
    }


}
