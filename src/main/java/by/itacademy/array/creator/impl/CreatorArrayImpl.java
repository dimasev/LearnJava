package by.itacademy.array.creator.impl;

import by.itacademy.array.creator.CreatorArray;
import by.itacademy.array.entity.ArrayObject;

public class CreatorArrayImpl implements CreatorArray {

    @Override
    public ArrayObject  creatorArray(int[] array) {
        return new ArrayObject(array);
    }
}
