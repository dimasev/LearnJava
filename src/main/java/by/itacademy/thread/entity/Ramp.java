package by.itacademy.thread.entity;

import by.itacademy.thread.util.GenerateId;

import java.util.StringJoiner;

public class Ramp {
    private int idRamp;

    public Ramp() {
        this.idRamp = GenerateId.generateNextIdForRamp();
    }

    public int getIdRamp() {
        return idRamp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ramp.class.getSimpleName() + "[", "]")
                .add("idRamp=" + idRamp)
                .toString();
    }
}
