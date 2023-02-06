package by.itacademy.oop.reader;

import by.itacademy.oop.exception.CustomException;

import java.io.File;
import java.util.List;

public interface ReaderFile {
    List<String> readFile(File file) throws CustomException;
    boolean isFileEmpty(File file);
}