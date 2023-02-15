package by.itacademy.thread.entity;

import by.itacademy.thread.util.GenerateId;

import java.util.StringJoiner;

public class Truck extends Thread {

    public enum Type {
        EMPTY, FULL
    }

    public enum CargoType {
        PERISHABLE, USUAL
    }

    private Type type;
    private CargoType cargoType;
    private int truckId;
    private int countBox;

    public Truck(Type type) {
        this.type = type;
        this.truckId = GenerateId.generateNextIdForTruck();
        if (!(type == Type.EMPTY)) {
            this.countBox = (int) (Math.random() * (50 - 20) + 20);
        }
    }

    public Truck(Type type, CargoType cargoType) {
        this.type = type;
        this.cargoType = cargoType;
        this.truckId = GenerateId.generateNextIdForTruck();
        if (!(type == Type.EMPTY)) {
            this.countBox = (int) (Math.random() * (50 - 20) + 20);
        }
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public void setCountBox(int countBox) {
        this.countBox = countBox;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void run() {
        System.out.println(this);
        Storage storage = Storage.getInstance();
        Ramp ramp = storage.getRamp();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        switch (type) {
            case EMPTY -> {
                setCountBox(storage.loading());
                setType(Type.FULL);
                setCargoType(CargoType.USUAL);
            }
            case FULL -> {
                switch (cargoType) {
                    case USUAL -> {
                        setCountBox(storage.unloading(countBox));
                        setType(Type.EMPTY);
                        setCargoType(null);
                    }
                    case PERISHABLE -> {
                        setCountBox(storage.unloading(countBox));
                        setType(Type.EMPTY);
                        setCargoType(null);
                    }
            }
        }}
        System.out.println(this);
        storage.releaseRamp(ramp);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append("type=").append(type);
        if(!(cargoType==null)){
        sb.append(", cargoType=").append(cargoType);}
        sb.append(", truckId=").append(truckId);
        sb.append(", countBox=").append(countBox);
        sb.append('}');
        return sb.toString();
    }
}
