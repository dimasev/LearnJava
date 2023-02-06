package by.itacademy.array.repository.spec;

import by.itacademy.array.entity.ArrayObject;

public class IntervalIdSpecification implements Specification{
    private int id;
    private int minId;
    private int maxId;

    public IntervalIdSpecification(int id, int minId, int maxId) {
        this.id = id;
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specify(ArrayObject array) {
        return array.getIdArray()>minId&&array.getIdArray()<maxId;
    }
}
