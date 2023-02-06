package by.itacademy.oop.creator;

import by.itacademy.oop.entity.Vegetables;
import by.itacademy.oop.exception.CustomException;

public abstract class VegetablesFactory {
    public abstract Vegetables createVegetables(String[] stringVegetables) throws CustomException;
}
