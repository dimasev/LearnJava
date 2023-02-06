package by.itacademy.array.entity;

import by.itacademy.array.util.GenerateId;

import java.util.Arrays;

public class ArrayObject {
    private int idArray;
    private int[] array;
    private int i = 0;

    public ArrayObject(int[] array) {
        this.idArray = GenerateId.generateNextId();
        this.array = array;
    }

    public int getIdArray() {
        return idArray;
    }


    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
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

    @Override
    public int hashCode() {
        int result = idArray;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}

