package by.itacademy.array.util;

public class GenerateId {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 99;
    private static int arrayObjectId = MIN_VALUE;

    private GenerateId() {
    }

    public static int generateNextId() {
        if (arrayObjectId > MAX_VALUE) {
            arrayObjectId = MIN_VALUE;
        }
        return arrayObjectId++;
    }
}
