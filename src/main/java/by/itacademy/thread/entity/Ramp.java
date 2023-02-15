package by.itacademy.thread.entity;

import by.itacademy.thread.util.GenerateId;

import java.util.StringJoiner;

public class Ramp {
    private int rampId;

    public Ramp() {
        this.rampId = GenerateId.generateNextIdForRamp();
    }

    public int getRampId() {
        return rampId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ramp.class.getSimpleName() + "[", "]")
                .add("rampId=" + rampId)
                .toString();
    }
}
