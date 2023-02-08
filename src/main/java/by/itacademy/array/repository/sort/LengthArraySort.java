package by.itacademy.array.repository.sort;

import by.itacademy.array.entity.ArrayObject;

import java.util.Comparator;

public class LengthArraySort implements Comparator<ArrayObject> {
    @Override
    public int compare(ArrayObject o1, ArrayObject o2) {
        return o1.getArray().length-o2.getArray().length;
    }
}
