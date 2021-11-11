package model;

import java.util.HashMap;

public class Game {
    private HashMap<Car, Integer> cars;
    private int gameTimes;

    public HashMap<Car, Integer> getCars() {
        return cars;
    }

    public void addCars(Car car){
        this.cars.put(car, 0);
    }
    public void setGameTimes(String gameTimes){
        int times = Integer.parseInt(gameTimes);
        this.gameTimes = times;
    }
}
