package by.itacademy.array.service;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {
    Optional<Integer> searchMinMax(int[] array, int numberMinMax);
    OptionalInt searchMinMaxStream(int[] array, int numberMinMax);
    void replacementElement (int[] array,int ordinalNumber, int newValue);
    Optional<Double> searchMeanValue(int[] array);
    OptionalDouble searchMeanValueStream(int[] array);
    Optional<Integer> searchSum(int[] array);
    Optional<Integer> searchSumStream(int[] array);
    Optional<Integer> searchNumberPositiveOrNegative(int[]array, int numberPositiveNegative);
    Optional<Integer> searchNumberPositiveOrNegativeStream (int[]array, int numberPositiveNegative);
    void sort1st(int[] array);
    void sort2nd(int[] array);
    void sort3d(int[] array);
}
