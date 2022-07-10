package com.example.PersistenceStrategy.container.entry;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class TimeWheelEntry {

    private List<String> list;
    private Set<String> set;
    public TimeWheelEntry() {
        this.list = new LinkedList<String>();
        this.set = new ConcurrentSkipListSet<>();
    }

    public void add(String v){
        if (!set.contains(v)){
            set.add(v);
            list.add(v);
        }
    }

    public List<String> getAll (){
        List<String> tempList = new LinkedList<>(this.list);
        list.clear();
        set.clear();
        return tempList;
    }
}
