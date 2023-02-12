package by.itacademy.array.observer.impl;

import by.itacademy.array.entity.ArrayObject;
import by.itacademy.array.entity.ArrayStatistics;
import by.itacademy.array.entity.Warehouse;
import by.itacademy.array.observer.ArrayStatisticsObserver;

public class ArrayStatisticsObserverImpl implements ArrayStatisticsObserver {
    @Override
    public void changeArrayElement(ArrayObject arrayObject) {
    ArrayStatistics statistics = new ArrayStatistics(arrayObject);
    int id = arrayObject.getIdArray();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, statistics);
    }
}
