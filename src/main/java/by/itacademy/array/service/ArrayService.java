package by.itacademy.array.service;

import by.itacademy.array.entity.ArrayObject;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {
    OptionalInt searchMinMax(ArrayObject arrayObject, int numberMinMax);
    OptionalInt searchMinMaxStream(ArrayObject arrayObject, int numberMinMax);
    void replacementElement (ArrayObject arrayObject,int ordinalNumber, int newValue);
    OptionalDouble searchAverageValue(ArrayObject arrayObject);
    OptionalDouble searchAverageValueStream(ArrayObject arrayObject);
    OptionalInt searchSum(ArrayObject arrayObject);
    OptionalInt searchSumStream(ArrayObject arrayObject);
    OptionalInt searchNumberPositiveOrNegative(ArrayObject arrayObject, int numberPositiveNegative);
    OptionalInt searchNumberPositiveOrNegativeStream (ArrayObject arrayObject, int numberPositiveNegative);
    void sort1st(ArrayObject arrayObject);
    void sort2nd(ArrayObject arrayObject);
    void sort3d(ArrayObject arrayObject);
}
