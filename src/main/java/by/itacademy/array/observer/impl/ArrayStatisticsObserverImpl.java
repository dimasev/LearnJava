package by.itacademy.array.observer.impl;

import by.itacademy.array.entity.ArrayObject;
import by.itacademy.array.entity.ArrayStatistics;
import by.itacademy.array.entity.Warehouse;
import by.itacademy.array.observer.ArrayStatisticsObserver;

public class ArrayStatisticsObserverImpl implements ArrayStatisticsObserver {
    @Override
    public void changeArrayElement(ArrayObject array) {
    ArrayStatistics statistics = new ArrayStatistics(array);
    int id = array.getIdArray();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, statistics);
    }
}
