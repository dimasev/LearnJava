package by.itacademy.oop.service;

import by.itacademy.oop.entity.*;
import by.itacademy.oop.exception.CustomException;

import java.util.List;

public interface SaladService {
    int calculatePriceSalad(List<Vegetables> list);
    void washingTomato(Tomato tomato);
    void peelingCucumber(Cucumber cucumber);
    void replacementCabbage(Cabbage cabbage);
    void preparationOfVegetables(List <Vegetables> vegetables);
    void searchingForVegetablesByCalories(Salad salad, int calories);
    List<Vegetables> createBillet(List<String> stringVegetable) throws CustomException;

}