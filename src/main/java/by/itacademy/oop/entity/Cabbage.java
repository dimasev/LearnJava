package by.itacademy.oop.entity;

import java.util.StringJoiner;

public class Cabbage extends Vegetables{
    private boolean stateOfFreshess;

    public Cabbage(String name, boolean stateOfFreshess, int weight, int calories, int price) {
        super(name, weight, calories, price);
        this.stateOfFreshess = stateOfFreshess;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cabbage.class.getSimpleName() + "[", "]")
                .add(super.toString() + "stateOfFreshess=" + stateOfFreshess)
                .toString();
    }

    public boolean isStateOfFreshess() {
        return stateOfFreshess;
    }

    public void setStateOfFreshess(boolean stateOfFreshess) {
        this.stateOfFreshess = stateOfFreshess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cabbage cabbage = (Cabbage) o;

        return stateOfFreshess == cabbage.stateOfFreshess;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stateOfFreshess ? 1 : 0);
        return result;
    }
}
