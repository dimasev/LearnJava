package by.itacademy.oop.reader.impl;

import by.itacademy.oop.exception.CustomException;
import by.itacademy.oop.reader.ReaderFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFileImpl implements ReaderFile {
    static Logger logger = LogManager.getLogger();
    static final  String STR_REGEX = "\\n+";

    public List<String> readFile(File file) throws CustomException {

        List<String> list = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String str;
            while ((str = reader.readLine()) != null) {
                String[] strings = str.split(STR_REGEX);
                for (String s : strings) {
                    list.add(s);
                }
            }
        } catch (IOException e) {
            throw new CustomException(e);
        }
        return list;
    }

    @Override
    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
}
