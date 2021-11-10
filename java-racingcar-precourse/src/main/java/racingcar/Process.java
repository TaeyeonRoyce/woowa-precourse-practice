package racingcar;

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
        this.newGame = new Game();
        getCar();
    }

    private void getCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = scanner.next();
        try {
            new InputUtils(userInput).checkUserCarInput();
            saveCarList(userInput);
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다");
            getCar();
        }
    }

    private void saveCarList(String cars){

    }

    private void getTimes(){

    }

}
