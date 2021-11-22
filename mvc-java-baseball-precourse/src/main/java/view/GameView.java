package main.java.view;

import main.java.model.Game;

import java.util.Scanner;

public class GameView {

    Scanner scanner;

    public GameView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserInput(){
        System.out.println("숫자를 입력하세요");
        String userInputNumber = scanner.nextLine();
        return userInputNumber;
    }

}
