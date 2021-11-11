package utils;

import model.Car;

import java.util.ArrayList;

public class DataUtils {
    public static int getRandomNumber(){
        final int START_INDEX = 1;
        final int END_INDEX = 9;
        return RandomUtils.nextInt(START_INDEX, END_INDEX);
    }

    public static void checkGoStop(Car car){
        if(getRandomNumber() > 3){
            car.addPosition();
        }
    }

}
