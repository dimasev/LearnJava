package by.itacademy.oop.util;

public class GenerateId {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 99;
    private static int saladId = MIN_VALUE;

    private GenerateId() {
    }

    public static int generateNextId() {
        if (saladId > MAX_VALUE) {
            saladId = MIN_VALUE;
        }
        return saladId++;
    }
}
