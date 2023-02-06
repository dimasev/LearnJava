package by.itacademy.array.repository.spec;

import by.itacademy.array.entity.ArrayObject;

public class IDSpecification implements Specification{
    private int id;

    public IDSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(ArrayObject array) {
        return array.getIdArray() == id;
    }
}
