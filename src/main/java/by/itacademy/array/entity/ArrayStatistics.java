package by.itacademy.array.entity;

import by.itacademy.array.service.ArrayService;
import by.itacademy.array.service.impl.ArrayServiceImpl;

public class ArrayStatistics {
    private int sum;
    private int max;
    private int min;
    private double average;

    public ArrayStatistics(ArrayObject array) {
        ArrayService as = new ArrayServiceImpl();
        this.sum = as.searchSumStream(array.getArray()).getAsInt();
        this.max = as.searchMinMax(array.getArray(),1).getAsInt();
        this.min = as.searchMinMax(array.getArray(),-1).getAsInt();
        this.average = as.
    }
}
