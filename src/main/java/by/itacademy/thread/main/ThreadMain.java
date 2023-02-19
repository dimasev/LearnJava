package by.itacademy.thread.main;

import by.itacademy.thread.entity.Ramp;
import by.itacademy.thread.entity.Storage;
import by.itacademy.thread.entity.Truck;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static by.itacademy.thread.entity.Truck.CargoType.PERISHABLE;
import static by.itacademy.thread.entity.Truck.CargoType.USUAL;


public class ThreadMain {
    public static void main(String[] args) {
        ArrayDeque<Ramp> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            Ramp ramp = new Ramp();
            arrayDeque.add(ramp);
        }
        Storage storage = Storage.getInstance();
        storage.setArrayDeque(arrayDeque);
        Thread t = null;
        for (int i = 0; i < 10; i++) {
            switch ((int) (Math.random() * 3)) {
                case (0) -> t = new Truck(Truck.Type.FULL, PERISHABLE);
                case (1) -> t = new Truck(Truck.Type.FULL, USUAL);
                case (2) -> t = new Truck(Truck.Type.EMPTY);
            }
            ExecutorService service = Executors.newFixedThreadPool(10);
            service.execute(t);
            service.shutdown();
        }

    }
}
