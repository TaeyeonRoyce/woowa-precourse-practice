package racingcar;

import model.Car;
import model.Game;
import utils.InputUtils;

import java.util.Scanner;

public class Process {
    Scanner scanner;
    Game newGame;
    Process(Scanner scanner) {
        this.scanner = scanner;
    }
    public void start(){

        getCar();
    }

    private void getCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = scanner.next();
        try {
            new InputUtils(userInput).checkUserCarInput();
            saveCarList(userInput);
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하여야 한다.\n");
            getCar();
        }
    }

    private void saveCarList(String cars){
        this.newGame = new Game();
        String[] carArray = cars.split(",");
        for (String i : carArray) {
            Car newCar = new Car(i);
            newGame.addCars(newCar);
        }
        getTimes();
    }

    private void getTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = scanner.next();
        try {
            new InputUtils(userInput).checkUserTimesInput();
            saveGameTimes(userInput);
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.\n");
            getTimes();
        }
    }

    private void saveGameTimes(String gameTimes) {
        newGame.setGameTimes(gameTimes);

    }

}
