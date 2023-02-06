package by.itacademy.oop.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Tomato extends Vegetables{
    private boolean stateOfPurity;

    public Tomato(String name, boolean stateOfPurity, int weight, int calories, int price) {
        super(name, weight, calories, price);
        this.stateOfPurity = stateOfPurity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tomato.class.getSimpleName() + "[", "]")
                .add(super.toString() + "stateOfPurity=" + stateOfPurity)
                .toString();
    }

    public boolean isStateOfPurity() {
        return stateOfPurity;
    }

    public void setStateOfPurity(boolean stateOfPurity) {
        this.stateOfPurity = stateOfPurity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tomato tomato = (Tomato) o;

        return stateOfPurity == tomato.stateOfPurity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stateOfPurity ? 1 : 0);
        return result;
    }
}
