package by.itacademy.array.repository.spec;

import by.itacademy.array.entity.ArrayObject;

public class IdSpecificationPredicate implements SpecificationPredicate{
    private int id;

    public IdSpecificationPredicate(int id) {
        this.id = id;
    }

    @Override
    public boolean test(ArrayObject array) {
        return array.getIdArray() == id;
    }
}
