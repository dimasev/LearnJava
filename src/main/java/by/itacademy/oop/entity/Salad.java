package by.itacademy.oop.entity;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static by.itacademy.oop.util.GenerateId.generateNextId;

public class Salad {
    private int saladId;
    private String name;
    private List<Vegetables> vegetables;

    public Salad(String name, List<Vegetables> vegetables) {
        this.name = name;
        this.vegetables = vegetables;
        this.saladId = generateNextId();
    }

    public int getSaladId() {
        return saladId;
    }

    public void setSaladId(int saladId) {
        this.saladId = saladId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vegetables> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetables> vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salad salad = (Salad) o;

        if (saladId != salad.saladId) return false;
        if (!Objects.equals(name, salad.name)) return false;
        return Objects.equals(vegetables, salad.vegetables);
    }

    @Override
    public int hashCode() {
        int result = saladId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (vegetables != null ? vegetables.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Salad.class.getSimpleName() + "[", "]")
                .add("saladId=" + saladId)
                .add("name='" + name + "'")
                .add("vegetables=" + vegetables)
                .toString();
    }
}
