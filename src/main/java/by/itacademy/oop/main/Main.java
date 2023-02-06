package by.itacademy.oop.main;

import by.itacademy.oop.comparator.PriceComparator;
import by.itacademy.oop.entity.Salad;
import by.itacademy.oop.entity.Vegetables;
import by.itacademy.oop.exception.CustomException;
import by.itacademy.oop.reader.ReaderFile;
import by.itacademy.oop.reader.impl.ReaderFileImpl;
import by.itacademy.oop.service.SaladService;
import by.itacademy.oop.service.impl.SaladServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws CustomException {

        ReaderFile readerFile = new ReaderFileImpl();
        SaladService saladService = new SaladServiceImpl();
        File file = new File("res\\doc.txt");
        if (!readerFile.isFileEmpty(file)){
            List<String> stringVegetable = readerFile.readFile(file);
            List<Vegetables> billet = saladService.createBillet(stringVegetable);
            saladService.preparationOfVegetables(billet);
            Salad salad =  new Salad("Caesar", billet);
            logger.log(Level.INFO, saladService.calculatePriceSalad(billet));
            Collections.sort(billet, new PriceComparator());
            for (Vegetables vb : billet){
                logger.log(Level.INFO, vb.toString());}
            saladService.searchingForVegetablesByCalories(salad, 523);
        }
        else{ throw new CustomException("File is empty");}
    }
}
