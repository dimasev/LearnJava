package by.itacademy.oop.comparator;

import by.itacademy.oop.entity.Vegetables;

import java.util.Comparator;

public class CaloriesComparator implements Comparator<Vegetables> {
    @Override
    public int compare(Vegetables v1, Vegetables v2) {
        return v1.getCalories()- v2.getCalories();
    }
}
