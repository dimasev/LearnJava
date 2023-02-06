package by.itacademy.array.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Integer,ArrayStatistic> allData= new HashMap<>();
    private Warehouse(){

    }
    public static Warehouse getInstance(){
        return instance;
    }
    public ArrayStatistic put(Integer key, ArrayStatistic value){
        return allData.put(key, value);
    }
    public ArrayStatistic remove(Integer key){
        return allData.remove(key);
    }
    public ArrayStatistic replace(Integer key, ArrayStatistic value){
        return allData.replace(key, value);
    }
}
