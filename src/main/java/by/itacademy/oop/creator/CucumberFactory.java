package by.itacademy.oop.creator;

import by.itacademy.oop.entity.Cucumber;
import by.itacademy.oop.entity.Tomato;
import by.itacademy.oop.entity.Vegetables;
import by.itacademy.oop.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class CucumberFactory extends VegetablesFactory {
    @Override
    public Vegetables createVegetables(String[] stringCucumber) throws CustomException {
        String name = stringCucumber[0];
        boolean stateOfPurity = Boolean.parseBoolean(stringCucumber[1]);
        int price;
        int weight;
        int calories;
        List<Integer> listInt = new ArrayList<>();
        int number;
        for (int i = 2; i < stringCucumber.length; i++) {
            try {
                number = Integer.parseInt(stringCucumber[i]);
                listInt.add(number);

            } catch (NumberFormatException e) {
                throw new CustomException(e);
            }
        }

        price = listInt.get(0);
        weight = listInt.get(1);
        calories = listInt.get(2);

        return new Cucumber(name, stateOfPurity, price, weight, calories);
    }
}
