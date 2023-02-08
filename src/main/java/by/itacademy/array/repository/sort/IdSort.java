package by.itacademy.array.repository.sort;

import by.itacademy.array.entity.ArrayObject;

import java.util.Comparator;

public class IdSort implements Comparator<ArrayObject> {
    @Override
    public int compare(ArrayObject o1, ArrayObject o2) {
        return o1.getIdArray()- o2.getIdArray();
    }
}
