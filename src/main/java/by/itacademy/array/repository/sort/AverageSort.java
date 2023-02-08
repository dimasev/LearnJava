package by.itacademy.array.repository.sort;

import by.itacademy.array.entity.ArrayObject;

import java.util.Arrays;
import java.util.Comparator;

public class AverageSort implements Comparator<ArrayObject> {

    @Override
    public int compare(ArrayObject o1, ArrayObject o2) {
        return (int) (Arrays.stream(o1.getArray()).average().getAsDouble()-Arrays.stream(o2.getArray()).average().getAsDouble());
    }
}
