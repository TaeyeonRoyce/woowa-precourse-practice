package main.java.controller;

import main.java.model.Game;
import main.java.model.Result;
import main.java.utils.CreateRandomNumber;
import main.java.utils.userinput.NumberException;
import main.java.utils.userinput.ReplayInputException;
import main.java.utils.userinput.UserInputException;
import main.java.view.GameView;

import java.util.Scanner;

public class GameController {

    Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    Game game;
    GameView gameView;
    UserInputException userInputHandler;


    public void initApplication() {
        this.game = new Game();
        this.gameView = new GameView(scanner, game);

        createComputerRandomNumber();
        getUserInputView();
    }

    private void createComputerRandomNumber() {
        int[] computerNumber = CreateRandomNumber.createRandomNumber();
        game.setComputerRandomNumber(computerNumber);
    }

    private void getUserInputView() {
        String userInput = gameView.getUserInput();
        userInputHandler = new NumberException();
        try{
            userInputHandler.isValidInput(userInput);
            setUserInput(userInput);
            setResult();
        } catch (IllegalArgumentException e){
            getUserInputView();
        }
    }

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

    private void setResult() {
        Result result = new Result();
        ResultController resultController = new ResultController(result);

        resultController.gameResult(game.getComputerRandomNumber(), game.getUserInputNumber());

        game.setGameResult(result);
        printResultView();
    }
    private void printResultView(){
        gameView.printResult();
        if (game.getGameResult().getStrikeCount() != 3){
            getUserInputView();
            return;
        }
        printReplayView();
    }
    private void printReplayView(){
        gameView.printReplayView();
        checkReplay();
    }

    private void checkReplay(){
        String userReplayInput = gameView.getReplayInput();
        userInputHandler = new ReplayInputException();
        try {
            userInputHandler.isValidInput(userReplayInput);
            replay(userReplayInput);
        } catch (IllegalArgumentException e) {
            checkReplay();
        }
    }

    private void replay(String userReplayInput){
        if (userReplayInput.equals("1")){
            initApplication();
        }
    }
}
