package by.itacademy.array.service.impl;

import by.itacademy.array.service.ArrayService;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServiceImpl implements ArrayService {


    @Override
    public OptionalInt searchMinMax(int[] array, int numberMinMax) {
        int numberResult = 0;
        if (numberMinMax > 0) {
            numberResult = array[0];
            for (int i = 1; i < array.length; i++) {
                if (numberResult < array[i]) {
                    numberResult = array[i];
                }
            }
        } else if (numberMinMax < 0) {
            numberResult = array[0];
            for (int i = 1; i < array.length; i++) {
                if (numberResult > array[i]) {
                    numberResult = array[i];
                }
            }
        }
        return OptionalInt.of(numberResult);
    }

    @Override
    public OptionalInt searchMinMaxStream(int[] array, int numberMinMax) {
        OptionalInt number = null;
        if (numberMinMax > 0) {
            number = Arrays.stream(array).max();
        }
        if (numberMinMax < 0) {
            number = Arrays.stream(array).min();
        }
        return number;
    }

    @Override
    public void replacementElement(int[] array, int ordinalNumber, int newValue) {
        array[ordinalNumber] = newValue;
    }

    @Override
    public OptionalDouble searchMeanValue(int[] array) {
        double meanValue = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        meanValue = sum / array.length;
        return OptionalDouble.of(meanValue);
    }

    @Override
    public OptionalDouble searchMeanValueStream(int[] array) {
        return Arrays.stream(array).average();
    }

    @Override
    public OptionalInt searchSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += array[i];
        }
        return OptionalInt.of(sum);
    }

    @Override
    public OptionalInt searchSumStream(int[] array) {
        return OptionalInt.of(Arrays.stream(array).sum());
    }

    @Override
    public OptionalInt searchNumberPositiveOrNegative(int[] array, int numberPositiveNegative) {
        int numberResult = 0;
        if (numberPositiveNegative > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0) {
                    numberResult++;
                }
            }
        } else if (numberPositiveNegative < 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 0) {
                    numberResult++;
                }
            }
        }
        return OptionalInt.of(numberResult);
    }

    @Override
    public OptionalInt searchNumberPositiveOrNegativeStream(int[] array, int numberPositiveNegative) {
        long number = 0;
        if (numberPositiveNegative > 0) {
            number = Arrays.stream(array).filter(i -> i > 0).count();
        }
        if (numberPositiveNegative < 0) {
            number = Arrays.stream(array).filter(i -> i < 0).count();
        }
        return OptionalInt.of((int) number);
    }

    @Override
    public void sort1st(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[j];
                    array[j] = array[i];
                    array[i] = k;
                }
            }
        }
    }

    @Override
    public void sort2nd(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
    }

    @Override
    public void sort3d(int[] array) {
        Arrays.sort(array);
    }


}
