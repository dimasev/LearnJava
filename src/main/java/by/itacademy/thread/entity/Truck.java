package by.itacademy.thread.entity;

import by.itacademy.thread.util.GenerateId;

import java.util.StringJoiner;

public class Truck extends Thread {

    public enum Type {
        PERISHABLE, USUAL, EMPTY, FULL
    }

    private Type type;
    private int idTruck;
    private int countBox;

    public Truck(Type type) {
        this.type = type;
        this.idTruck = GenerateId.generateNextIdForTruck();
        if (!(type == Type.EMPTY)) {
            this.countBox = (int) (Math.random() * (50 - 20) + 20);
        }
    }

    public void setCountBox(int countBox) {
        this.countBox = countBox;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void run() {
        Storage storage = Storage.getInstance();
        Ramp ramp = storage.getRamp();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        switch (type) {
            case EMPTY -> {
                setCountBox(storage.loading());
                setType(Type.FULL);
            }
            case USUAL -> {
                setCountBox(storage.unloading(countBox));
                setType(Type.EMPTY);
            }
            case PERISHABLE -> {
                setCountBox(storage.unloading(countBox));
                setType(Type.EMPTY);
            }
        }
        storage.releaseRamp(ramp);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Truck.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("idTruck=" + idTruck)
                .add("countBox=" + countBox)
                .toString();
    }
}
