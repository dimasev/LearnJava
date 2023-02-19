package by.itacademy.thread.comparator;

import by.itacademy.oop.entity.Vegetables;
import by.itacademy.thread.entity.Truck;

import java.util.Comparator;

public class TruckComparator implements Comparator<Truck> {
    @Override
    public int compare(Truck o1, Truck o2) {
        int truck1 = 0;
        int truck2 = 0;
        if (o1.getCargoType() == Truck.CargoType.PERISHABLE){
            truck1 = 1;
        }
        if (o2.getCargoType() == Truck.CargoType.PERISHABLE){
            truck2 = 1;
        }
        return truck2-truck1;
    }
}
