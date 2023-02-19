package by.itacademy.thread.entity;

import by.itacademy.thread.comparator.TruckComparator;
import by.itacademy.thread.util.GenerateId;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
    private ReentrantLock locker = new ReentrantLock(true);
    private ArrayDeque<Truck> m= new ArrayDeque<>();
    private PriorityQueue<Truck>  w= new PriorityQueue<>(new TruckComparator());
    private LinkedList<Truck>deque = new LinkedList<>();
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

    public  void run() {
        locker.lock();
        Storage storage = Storage.getInstance();
        if (this.getCargoType()!=null) {
            if(this.getCargoType() ==CargoType.PERISHABLE){
             deque.addFirst(this);

            }
            else{
               deque.add(this);}}
            locker.unlock();

            while (!deque.isEmpty()) {
                System.out.println(deque.poll());
            }

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
            }
        }
        storage.releaseRamp(ramp);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append("type=").append(type);
        if (!(cargoType == null)) {
            sb.append(", cargoType=").append(cargoType);
        }
        sb.append(", truckId=").append(truckId);
        sb.append(", countBox=").append(countBox);
        sb.append('}');
        return sb.toString();
    }
}
