package by.itacademy.thread.util;

public class GenerateId {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 20;
    private static int rampId = MIN_VALUE;
    private static int truckId = MIN_VALUE;

    private GenerateId() {
    }

    public static int generateNextIdForRamp() {
        if (rampId > MAX_VALUE) {
            rampId = MIN_VALUE;
        }
        return rampId++;
    }

    public static int generateNextIdForTruck() {
        if (rampId > MAX_VALUE) {
            rampId = MIN_VALUE;
        }
        return truckId++;
    }
}
