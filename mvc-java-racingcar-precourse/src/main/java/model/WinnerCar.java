package model;

import java.util.ArrayList;

public class WinnerCar {
    private int winnerPosition;
    private ArrayList<Car> carArrayList = new ArrayList<>();
    private ArrayList<String> carNameArrayList = new ArrayList<>();

    public int getWinnerPosition() {
        return winnerPosition;
    }

    public void setWinnerPosition(int winnerPosition) {
        this.winnerPosition = winnerPosition;
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public void addCarArrayList(Car car) {
        carArrayList.add(car);
    }

    public ArrayList<String> getCarNameArrayList() {
        return carNameArrayList;
    }

    public void addCarNameArrayList(Car car) {
        carNameArrayList.add(car.getName());
    }

}
