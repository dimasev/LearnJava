package by.itacademy.array.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Integer, ArrayStatistics> mapArray = new HashMap<>();
    private Warehouse(){

    }
    public static Warehouse getInstance(){
        return instance;
    }
    public ArrayStatistics put(Integer key, ArrayStatistics value){
        return mapArray.put(key, value);
    }
    public ArrayStatistics remove(Integer key){
        return mapArray.remove(key);
    }
    public ArrayStatistics replace(Integer key, ArrayStatistics value){
        return mapArray.replace(key, value);
    }
}
