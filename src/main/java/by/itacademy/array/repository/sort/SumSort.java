package by.itacademy.array.repository.sort;

import by.itacademy.array.entity.ArrayObject;

import java.util.Arrays;
import java.util.Comparator;

public class SumSort implements Comparator<ArrayObject> {
    @Override
    public int compare(ArrayObject o1, ArrayObject o2) {
        return Arrays.stream(o1.getArray()).sum()-Arrays.stream(o2.getArray()).sum();
    }
}
