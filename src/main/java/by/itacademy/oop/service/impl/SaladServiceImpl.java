package by.itacademy.oop.service.impl;

import by.itacademy.oop.creator.CabbageFactory;
import by.itacademy.oop.creator.CucumberFactory;
import by.itacademy.oop.creator.TomatoFactory;
import by.itacademy.oop.entity.*;
import by.itacademy.oop.exception.CustomException;
import by.itacademy.oop.service.SaladService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SaladServiceImpl implements SaladService {
    static Logger logger = LogManager.getLogger();
    @Override
    public int calculatePriceSalad(List<Vegetables> list) {
        int price = 0;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                price += list.get(i).getPrice();
            }
        }
        return price;
    }

    @Override
    public void washingTomato(Tomato tomato) {
        boolean condition = tomato.isStateOfPurity();
        if (!condition) {
            tomato.setStateOfPurity(true);
        }
    }

    @Override
    public void peelingCucumber(Cucumber cucumber) {
        boolean condition = cucumber.isStateOfPeel();
        if (!condition) {
            cucumber.setStateOfPeel(true);
        }
    }

    @Override
    public void replacementCabbage(Cabbage cabbage) {
        boolean condition = cabbage.isStateOfFreshess();
        if (!condition) {
            cabbage.setStateOfFreshess(true);
        }
    }

    @Override
    public void preparationOfVegetables(List <Vegetables> notVerifiedVegetables) {
        List<Vegetables> vegetables= notVerifiedVegetables;
        for(Vegetables vb: vegetables){
            switch (vb.getName()){
                case "Cucumber" -> peelingCucumber((Cucumber) vb);
                case "Cabbage" -> replacementCabbage((Cabbage) vb);
                case "Tomato" -> washingTomato((Tomato) vb);
            }
        }
    }

    @Override
    public void searchingForVegetablesByCalories(Salad salad, int calories) {
        List<Vegetables> list = salad.getVegetables();
        List<Vegetables> listFoundVegetables = new ArrayList<>();
        for(Vegetables vb:list){
            if (vb.getCalories()==calories){
                listFoundVegetables.add(vb);
            }
        }
        if (listFoundVegetables.size() != 0){
            for (Vegetables vb: listFoundVegetables){
                logger.log(Level.INFO, vb);}
        }else{
            logger.log(Level.WARN, "No vegetables");
        }
    }

    @Override
    public List<Vegetables> createBillet(List<String> stringVegetable) throws CustomException{
        List<Vegetables> billet = new ArrayList<>();
        CucumberFactory cucumberFactory = new CucumberFactory();
        TomatoFactory tomatoFactory = new TomatoFactory();
        CabbageFactory cabbageFactory = new CabbageFactory();
        for (String str : stringVegetable) {
            String[] strings = str.split("\\s+");
            switch (strings[0]) {
                case "Cucumber" -> billet.add(cucumberFactory.createVegetables(strings));
                case "Cabbage" -> billet.add(cabbageFactory.createVegetables(strings));
                case "Tomato" -> billet.add(tomatoFactory.createVegetables(strings));
                default -> {
                    break;
                }
            }
        }
        return billet;
    }

}
