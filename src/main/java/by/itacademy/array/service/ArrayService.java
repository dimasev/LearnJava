package by.itacademy.array.service;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {
    OptionalInt searchMinMax(int[] array, int numberMinMax);
    OptionalInt searchMinMaxStream(int[] array, int numberMinMax);
    void replacementElement (int[] array,int ordinalNumber, int newValue);
    OptionalDouble searchMeanValue(int[] array);
    OptionalDouble searchMeanValueStream(int[] array);
    OptionalInt searchSum(int[] array);
    OptionalInt searchSumStream(int[] array);
    OptionalInt searchNumberPositiveOrNegative(int[]array, int numberPositiveNegative);
    OptionalInt searchNumberPositiveOrNegativeStream (int[]array, int numberPositiveNegative);
    void sort1st(int[] array);
    void sort2nd(int[] array);
    void sort3d(int[] array);
}
