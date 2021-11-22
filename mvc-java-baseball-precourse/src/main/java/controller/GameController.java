package main.java.controller;

import main.java.model.Game;
import main.java.model.Result;
import main.java.utils.CreateRandomNumber;
import main.java.utils.userinput.NumberException;
import main.java.utils.userinput.ReplayInputException;
import main.java.utils.userinput.UserInputException;
import main.java.view.GameView;

import java.util.Scanner;



/*
게임의 진행을 담당.
게임에 필요한 데이터들을 결정 후 저장하고,
사용자에게 보여지는 부분을 결정한다.
*/

public class GameController {

    Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    Game game;
    GameView gameView;

    /* 예외처리하는 인터페이스 타입 선언 */
    UserInputException userInputHandler;


    /* 새로운 게임 생성 */
    public void initApplication() {
        this.game = new Game();
        this.gameView = new GameView(scanner, game);

        createComputerRandomNumber();
        getUserInputView();
    }

    /* 컴퓨터 난수 생성 */
    private void createComputerRandomNumber() {
        int[] computerNumber = CreateRandomNumber.createRandomNumber();
        game.setComputerRandomNumber(computerNumber);
    }

    /* 사용자에게 숫자 입력 받기 */
    private void getUserInputView() {
        String userInput = gameView.getUserInput();

        /* 사용자 숫자를 예외처리하는 클래스 */
        userInputHandler = new NumberException();
        try{
            userInputHandler.isValidInput(userInput);

            /* 적절한 입력 값이면 게임정보에 저장 */
            setUserInput(userInput);

            /* 저장된 입력 값과 컴퓨터 숫자를 비교하여 결과 확인*/
            setResult();
        } catch (IllegalArgumentException e){
            /* 예외 사항시 재입력 */
            getUserInputView();
        }
    }

    /* 게임 데이터에 사용자 입력 숫자 저장 */
    private void setUserInput(String userInput) {
        String[] userInputArray = userInput.split("");
        int[] userInputNumber = new int[3];
        int cursor = 0;
        for (String s : userInputArray) {
            userInputNumber[cursor] = Integer.parseInt(s);
            cursor += 1;
        }
        game.setUserInputNumber(userInputNumber);
    }

    /* 비교한 게임 결과 저장 */
    private void setResult() {
        /* 새로운 결과모델 생성*/
        Result result = new Result();
        ResultController resultController = new ResultController(result);

        /*
        입력값과 컴퓨터 숫자 비교 후
        스트라이크, 볼 수를 결과모델에 저장
        */
        resultController.gameResult(game.getComputerRandomNumber(), game.getUserInputNumber());

        game.setGameResult(result);
        printResultView();
    }

    /* 결과 출력 */
    private void printResultView(){
        gameView.printResult();
        /* 3스트라이크가 아니면 다시 시도*/
        if (game.getGameResult().getStrikeCount() != 3){
            getUserInputView();
            return;
        }
        printReplayView();
    }

    /* 리플레이 화면 출력*/
    private void printReplayView(){
        gameView.printReplayView();
        checkReplay();
    }

    /* 리플레이 여부 확인*/
    private void checkReplay(){
        String userReplayInput = gameView.getReplayInput();

        /* 리플레이 입력을 예외처리하는 클래스 */
        userInputHandler = new ReplayInputException();
        try {
            userInputHandler.isValidInput(userReplayInput);
            replay(userReplayInput);
        } catch (IllegalArgumentException e) {
            checkReplay();
        }
    }

    /* 리플레이 */
    private void replay(String userReplayInput){
        if (userReplayInput.equals("1")){
            initApplication();
        }
    }
}
