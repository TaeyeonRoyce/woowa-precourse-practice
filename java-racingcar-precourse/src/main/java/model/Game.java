package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<Car> cars = new ArrayList<>();
    private int gameTimes = 0;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getGameTimes(){
        return gameTimes;
    }

    public void addCars(Car car){
        this.cars.add(car);
    }
    public void setGameTimes(String gameTimes){
        int times = Integer.parseInt(gameTimes);
        this.gameTimes = times;
    }
}
