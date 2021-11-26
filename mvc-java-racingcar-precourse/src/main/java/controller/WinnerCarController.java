package controller;

import model.Car;
import model.CarRepository;
import model.WinnerCar;

import java.util.ArrayList;
import java.util.Collections;

public class WinnerCarController {
    WinnerCar winnerCar;

    public WinnerCarController(WinnerCar winnerCar) {
        this.winnerCar = winnerCar;
    }

    public void setWinnerPosition(CarRepository carRepository) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : carRepository.getCarArrayList()) {
            positions.add(car.getPosition());
        }
        int winnerPosition = Collections.max(positions);
        winnerCar.setWinnerPosition(winnerPosition);
    }

    public void setWinnerCarList(Car car) {
        int winnerPosition = winnerCar.getWinnerPosition();
        if (car.getPosition() == winnerPosition) {
            winnerCar.addCarArrayList(car);
            winnerCar.addCarNameArrayList(car);
        }
    }

}
