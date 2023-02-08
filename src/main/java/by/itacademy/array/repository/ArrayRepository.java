package by.itacademy.array.repository;

import by.itacademy.array.entity.ArrayObject;
import by.itacademy.array.repository.spec.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class ArrayRepository {
    private List<ArrayObject> arrayObjects;

    public ArrayRepository(List<ArrayObject> arrayObjects) {
        this.arrayObjects = arrayObjects;
    }

    public List<ArrayObject> getArrayObjects() {
        return arrayObjects;
    }

    public void setArrayObjects(List<ArrayObject> arrayObjects) {
        this.arrayObjects = arrayObjects;
    }
    public List<ArrayObject> query (Specification specification){
        List <ArrayObject> results = new ArrayList<>();
        for(ArrayObject array: arrayObjects){
            if (specification.specify(array)){
                results.add(array);
            }
        }
        return results;
    }
    public List<ArrayObject> queryStream(Specification specification){
        return arrayObjects.stream().filter(array-> specification.specify(array)).toList();

    }
    public List<ArrayObject> queryPredicate(Predicate<ArrayObject> predicate){
        return arrayObjects.stream().filter(predicate).toList();
    }
    public boolean addArray(ArrayObject array){
        return arrayObjects.add(array);
    }
    public void removeArray(int id){
        for(ArrayObject arrayObject:arrayObjects){
            if (id==arrayObject.getIdArray()){
                arrayObjects.remove(arrayObject);
            }
        }
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayRepository.class.getSimpleName() + "[", "]")
                .add("arrayObjects=" + arrayObjects)
                .toString();
    }
}
