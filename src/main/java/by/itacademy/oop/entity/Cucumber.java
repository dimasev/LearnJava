package by.itacademy.oop.entity;

import java.util.StringJoiner;

public class Cucumber extends Vegetables{
    private boolean stateOfPeel;

    public Cucumber(String name, boolean stateOfPeel, int weight, int calories, int price) {
        super(name, weight, calories, price);
        this.stateOfPeel = stateOfPeel;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cucumber.class.getSimpleName() +  "[", "]")
                .add(super.toString() + "stateOfPeel=" + stateOfPeel)
                .toString();
    }

    public boolean isStateOfPeel() {
        return stateOfPeel;
    }

    public void setStateOfPeel(boolean stateOfPeel) {
        this.stateOfPeel = stateOfPeel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cucumber cucumber = (Cucumber) o;

        return stateOfPeel == cucumber.stateOfPeel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stateOfPeel ? 1 : 0);
        return result;
    }
}
