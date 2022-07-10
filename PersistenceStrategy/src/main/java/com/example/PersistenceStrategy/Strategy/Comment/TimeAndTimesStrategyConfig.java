package com.example.PersistenceStrategy.Strategy.Comment;

public class TimeAndTimesStrategyConfig {
    public static final int MILLISECOND = 1000;

    public static final int SAVE_900_1_TIMES = 1;
    public static final long SAVE_900_1_MILLIS = 900*MILLISECOND;


    public static final int SAVE_300_10_TIMES = 10;
    public static final long SAVE_300_10_MILLIS = 300*MILLISECOND;

    public static final int SAVE_60_1000_TIMES = 1000;
    public static final long SAVE_60_1000_MILLIS = 60*MILLISECOND;

    public static final long MAX_SAVE_TIME = Math.max(SAVE_900_1_MILLIS , Math.max(SAVE_300_10_MILLIS , SAVE_60_1000_MILLIS) );


}
