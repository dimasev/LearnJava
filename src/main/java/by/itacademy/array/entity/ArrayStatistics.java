package by.itacademy.array.entity;

import by.itacademy.array.service.ArrayService;
import by.itacademy.array.service.impl.ArrayServiceImpl;

public class ArrayStatistics {
    private int sum;
    private int max;
    private int min;
    private double average;

    public ArrayStatistics(ArrayObject arrayObject) {
        ArrayService as = new ArrayServiceImpl();
        this.sum = as.searchSumStream(arrayObject).getAsInt();
        this.max = as.searchMinMax(arrayObject,1).getAsInt();
        this.min = as.searchMinMax(arrayObject,-1).getAsInt();
        this.average = as.searchAverageValue(arrayObject).getAsDouble();
    }

    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayStatistics{");
        sb.append("sum=").append(sum);
        sb.append(", max=").append(max);
        sb.append(", min=").append(min);
        sb.append(", average=").append(average);
        sb.append('}');
        return sb.toString();
    }
}
