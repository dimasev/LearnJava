package by.itacademy.array.arraymain;


import by.itacademy.array.entity.ArrayObject;
import by.itacademy.array.reader.ReaderArray;
import by.itacademy.array.reader.impl.ReaderArrayImpl;
import by.itacademy.array.repository.ArrayRepository;
import by.itacademy.array.repository.spec.IDSpecification;
import by.itacademy.array.service.ArrayService;
import by.itacademy.array.service.impl.ArrayServiceImpl;
import by.itacademy.oop.exception.CustomException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArrayMain {
    public static void main(String[] args) throws CustomException {
        ReaderArray readerArray =  new ReaderArrayImpl();
        ArrayService arrayService = new ArrayServiceImpl();
        List<ArrayObject> listArrays = readerArray.readArray("res\\arraydata.txt");
        ArrayRepository repository = new ArrayRepository(listArrays);
        System.out.println(repository.query(new IDSpecification(1)));
    }
}

