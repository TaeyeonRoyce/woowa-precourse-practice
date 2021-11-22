package main.java.controller;

import main.java.model.Game;
import main.java.view.GameView;

import java.util.Scanner;

public class GameController {

    Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    Game newGame;
    GameView newGameView;




    public void initApplication(){
        this.newGame = new Game();
        this.newGameView = new GameView(scanner);

        getUserInputView();
    }

    private void getUserInputView(){
        String userInputNumber = newGameView.getUserInput();
    }


}
