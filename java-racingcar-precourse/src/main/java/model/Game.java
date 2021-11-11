package model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Car> cars = new ArrayList<>();
    private int gameTimes = 0;
    private int winnerMove = 0;
    private ArrayList<String> winners = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getGameTimes(){
        return gameTimes;
    }

    public ArrayList<String> getWinners() {
        return winners;
    }

    public void addCars(Car car){
        this.cars.add(car);
    }
    public void setGameTimes(String gameTimes){
        int times = Integer.parseInt(gameTimes);
        this.gameTimes = times;
    }
    public void setWinnerMove(int move){
        if (move > winnerMove){
            this.winnerMove = move;
        }
    }
    public void setWinners(Car car){
        if (car.getPosition() == winnerMove){
            winners.add(car.getName());
        }
    }
}
