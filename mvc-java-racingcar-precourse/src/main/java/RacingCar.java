import controller.CarController;
import controller.CarRepositoryController;
import controller.WinnerCarController;
import model.Car;
import model.CarRepository;
import model.WinnerCar;
import view.MainView;

import java.util.Scanner;

public class RacingCar {
    Scanner scanner;
    MainView mainView;
    CarRepository carRepository;
    CarRepositoryController carRepositoryController;
    WinnerCar winnerCar;
    WinnerCarController winnerCarController;

    public RacingCar(Scanner scanner) {
        this.scanner = scanner;
    }

    public void initRacingCar() {
        carRepository = new CarRepository();
        loadMainView();
    }

    private void loadMainView() {
        mainView = new MainView(scanner);

        getUserCarInput();
    }

    private void getUserCarInput() {
        String[] userCarInput = mainView.userCarInputView().split(",");

        saveUserCarInput(userCarInput);
    }

    private void saveUserCarInput(String[] userCarInput) {
        carRepositoryController = new CarRepositoryController(carRepository);

        for (String s : userCarInput) {
            carRepositoryController.addCarByName(s);
        }

        getUserProcessInput();
    }

    private void getUserProcessInput() {
        String userProcessInput = mainView.userProcessInputView();

        isValidProcess(userProcessInput);
    }

    private void isValidProcess(String userProcessInput) {
        try {
            int processAmount = Integer.parseInt(userProcessInput);

            isPositiveProcess(processAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 0보다 큰 정수를 입력하세요");
        }
    }

    private void isPositiveProcess(int process) throws NumberFormatException {
        if (process <= 0) {
            throw new NumberFormatException();
        }

        printResultMessage();

        startRacing(process);
    }

    private void printResultMessage() {
        mainView.printResultMessageView();
    }

    private void startRacing(int process) {
        for (int i = 0; i < process; i++) {
            racingCars();
            System.out.println();
        }

        setWinnerPosition();
    }

    private void racingCars() {
        for (Car car : carRepository.getCarArrayList()) {
            CarController carController = new CarController(car);
            carController.moveCar();

            printResult(carController);
        }

    }

    private void printResult(CarController carController) {
        mainView.printCarPositionView(carController.createPositionMessage());
    }

    private void setWinnerPosition() {
        winnerCar = new WinnerCar();
        winnerCarController = new WinnerCarController(winnerCar);

        winnerCarController.setWinnerPosition(carRepository);

        setWinnerCar();
    }

    private void setWinnerCar() {
        for (Car car : carRepository.getCarArrayList()) {
            winnerCarController.setWinnerCarList(car);
        }

        printWinner();
    }

    private void printWinner() {
        mainView.printWinnerView(winnerCar);
    }
}
