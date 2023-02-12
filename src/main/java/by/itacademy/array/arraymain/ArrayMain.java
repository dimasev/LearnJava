package by.itacademy.array.arraymain;


import by.itacademy.array.entity.ArrayObject;
import by.itacademy.array.observer.ArrayStatisticsObserver;
import by.itacademy.array.observer.impl.ArrayStatisticsObserverImpl;
import by.itacademy.array.reader.ReaderArray;
import by.itacademy.array.reader.impl.ReaderArrayImpl;
import by.itacademy.array.repository.ArrayRepository;
import by.itacademy.array.repository.spec.IDSpecification;
import by.itacademy.array.service.ArrayService;
import by.itacademy.array.service.impl.ArrayServiceImpl;
import by.itacademy.oop.exception.CustomException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayMain {
    public static void main(String[] args) throws CustomException {
        ReaderArray readerArray =  new ReaderArrayImpl();
        ArrayService arrayService = new ArrayServiceImpl();
        ArrayStatisticsObserver arrayStatisticsObserver = new ArrayStatisticsObserverImpl();
        List<ArrayObject> listArrays = readerArray.readArray("res\\arraydata.txt");
        ArrayRepository repository = new ArrayRepository(listArrays);
        for(ArrayObject ao:listArrays){
        arrayStatisticsObserver.changeArrayElement(ao);}

    }
}

