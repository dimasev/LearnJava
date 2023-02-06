package by.itacademy.array.reader;

import by.itacademy.array.entity.ArrayObject;
import by.itacademy.oop.exception.CustomException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface ReaderArray {
    List<ArrayObject> readArray(String nameFile) throws CustomException;
}
