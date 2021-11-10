package baseball;

import baseball.model.Game;
import baseball.model.Result;
import utils.DataUtils;
import utils.InputUtils;

import java.util.Scanner;

public class Process {
    private Scanner scanner;
    private Game newGame;

    public Process(Scanner scanner) {
        this.scanner = scanner;
    }

    public void initialize(){
        this.newGame = new Game();
        DataUtils.createComputerNumber(newGame);
        getUserInput();
    }

    private void getUserInput(){
        System.out.printf("숫자를 입력해 주세요 : ");
        while(true) {
            try {
                String userInput = scanner.next();
                new InputUtils(userInput, newGame).checkUserInputValid();
                printResult();
                return;
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private void printResult(){
        Result result = new Result(newGame);
        System.out.println(result.getResult());
        if (result.checkResult()){
            getUserInput();
        } else if(!result.checkResult()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkRestart();
        }
    }
    private void checkRestart(){
        while(true) {
            String restart = scanner.next();
            if (restart.equals("1")) {
                initialize();
            }else if (restart.equals("2")){
                break;
            }
            try {
                new InputUtils(restart).checkRestart();
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }
}
