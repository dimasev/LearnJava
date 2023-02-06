package by.itacademy.array.repository.spec;

import by.itacademy.array.entity.ArrayObject;

public class IntervalIdSpecificationPredicate implements SpecificationPredicate{
    private int maxId;
    private int minId;
    private int Id;

    public IntervalIdSpecificationPredicate(int maxId, int minId, int id) {
        this.maxId = maxId;
        this.minId = minId;
        Id = id;
    }

    @Override
    public boolean test(ArrayObject array) {
        return array.getIdArray()>minId&&array.getIdArray()<maxId;
    }
}
