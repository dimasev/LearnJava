package by.itacademy.array.entity;

import by.itacademy.array.observer.ArrayStatisticsObserver;
import by.itacademy.array.observer.impl.ArrayStatisticsObserverImpl;
import by.itacademy.array.util.GenerateId;

import javax.print.attribute.standard.JobSheets;
import java.util.Arrays;

public class ArrayObject {
    private int idArray;
    private int[] array;
    private ArrayStatisticsObserver observer;

    public ArrayObject(int[] array) {
        this.idArray = GenerateId.generateNextId();
        setArray(array);
        observer = new ArrayStatisticsObserverImpl();
    }

    public int getIdArray() {
        return idArray;
    }
    public void addObserver(){
        observer = new ArrayStatisticsObserverImpl();
    }
    public void removeObserver(){
        observer = null;
    }


    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        notifyObserver();
    }

    public void setElement(int value, int i) {
        array[i] = value;
        notifyObserver();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayObject{");
        sb.append("idArray=").append(idArray);
        sb.append(", array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayObject that = (ArrayObject) o;
        if (idArray != that.idArray) return false;
        return Arrays.equals(array, that.array);
    }
    private void notifyObserver(){
        if (observer != null) {
            observer.changeArrayElement(this);
        }

    }

    @Override
    public int hashCode() {
        int result = idArray;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}

