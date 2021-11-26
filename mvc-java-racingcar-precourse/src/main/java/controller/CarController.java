package controller;

import model.Car;
import utils.RandomUtils;

public class CarController {
    final Car car;

    public CarController(Car car) {
        this.car = car;
    }

    public void moveCar() {
        if (shouldMove()) {
            car.addPosition();
        }
    }

    private boolean shouldMove() {
        int randomInteger = RandomUtils.nextInt(1, 9);
        if (randomInteger > 3) {
            return true;
        }
        return false;
    }

    public String createPositionMessage() {
        int position = car.getPosition();
        String positionMessage = car.getName() + " : ";
        for (int i = 0; i < position; i++) {
            positionMessage += "-";
        }
        return positionMessage;
    }
}
