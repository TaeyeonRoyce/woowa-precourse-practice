package controller;

import model.Car;
import model.CarRepository;

public class CarRepositoryController {

    final CarRepository carRepository;

    public CarRepositoryController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void addCarByName(String carName) {
        try {
            isValidCarName(carName.replace(" ",""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Car car = new Car(carName);
        carRepository.getCarArrayList().add(car);
    }

    private boolean isValidCarName(String carName) throws Exception{
        if (carName.length() > 5) {
            throw new Exception("[ERROR] 올바른 자동차 이름을 입력하세요");
        }
        return true;
    }

}
