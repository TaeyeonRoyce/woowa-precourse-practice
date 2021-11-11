package racingcar;

import model.Car;
import model.Game;
import utils.DataUtils;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    Scanner scanner;
    private Game newGame;
    Process(Scanner scanner) {
        this.scanner = scanner;
    }
    public void start(){
        getCar();
    }

    private void getCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = scanner.nextLine();
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
            Car newCar = new Car(i.trim());
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
        System.out.println("실행 결과");
        accelerateCars(0, newGame.getGameTimes());
    }

    private void accelerateCars(int depth, int limit){
        if (depth == limit){
            saveWinnerMove();
            return;
        }
        for(Car i : newGame.getCars()){
            DataUtils.checkGoStop(i);
            printResult(i);
        }
        System.out.printf("%n");
        accelerateCars(depth+1, limit);
    }
    private void printResult(Car car){
        String printMessage = "";
        int position = car.getPosition();
        for(int i = 0; i < position; i++){
            printMessage += "-";
        }
        printMessage = car.getName() + " : " + printMessage;
        System.out.println(printMessage);
    }
    private void saveWinnerMove(){
        for (Car i : newGame.getCars()){
            newGame.setWinnerMove(i.getPosition());
        }
        saveWinner();
    }
    private void saveWinner(){
        for (Car i : newGame.getCars()){
            newGame.setWinners(i);
        }
        printWinner();
    }
    private void printWinner(){
        String winnerMessage = "최종 우승자: ";
        ArrayList<String> winnerList = newGame.getWinners();
        int winnerListSize = winnerList.size();
        for (int i = 0; i< winnerListSize - 1; i++) {
            winnerMessage += winnerList.get(i) + ", ";
        }
        winnerMessage += winnerList.get(winnerListSize - 1);
        System.out.println(winnerMessage);
    }
}
