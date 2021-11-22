package main.java.controller;

import main.java.model.Game;
import main.java.utils.CreateRandomNumber;
import main.java.utils.RandomUtils;
import main.java.utils.userinput.NumberException;
import main.java.utils.userinput.UserInputException;
import main.java.view.GameView;

import java.util.Scanner;

public class GameController {

    Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    Game newGame;
    GameView newGameView;
    UserInputException userInputHandler;


    public void initApplication(){
        this.newGame = new Game();
        this.newGameView = new GameView(scanner);

        createComputerRandomNumber();
    }

    private void createComputerRandomNumber(){
        int[] computerNumber = CreateRandomNumber.createRandomNumber();
        newGame.setComputerRandomNumber(computerNumber);
        getUserInputView();
    }

    private void getUserInputView(){
        String userInput = newGameView.getUserInput();
        userInputHandler = new NumberException();
        try{
            userInputHandler.isValidInput(userInput);
            setUserInput(userInput);
            checkResult();
        } catch (IllegalArgumentException e){
            getUserInputView();
        }
    }

    private void setUserInput(String userInput){
        String[] userInputArray = userInput.split("");
        int[] userInputNumber = new int[3];
        int cursor = 0;
        for (String s : userInputArray) {
            userInputNumber[cursor] = Integer.parseInt(s);
        }
        newGame.setUserInputNumber(userInputNumber);
    }

    private void checkResult(){

    }


}
