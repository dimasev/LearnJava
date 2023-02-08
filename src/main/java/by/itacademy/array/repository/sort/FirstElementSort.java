package by.itacademy.array.repository.sort;

import by.itacademy.array.entity.ArrayObject;

import java.util.Comparator;

public class FirstElementSort implements Comparator<ArrayObject> {
    @Override
    public int compare(ArrayObject o1, ArrayObject o2) {
        return o1.getArray()[0]-o2.getArray()[0];
    }
}
