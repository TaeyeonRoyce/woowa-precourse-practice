package main.java.view;

import main.java.model.Game;
import main.java.model.Result;

import java.util.Scanner;

public class GameView {

    Scanner scanner;
    Game game;

    public GameView(Scanner scanner, Game game) {
        this.scanner = scanner;
        this.game = game;
    }

    public String getUserInput(){
        System.out.print("숫자를 입력하세요 : ");
        String userInputNumber = scanner.nextLine();
        return userInputNumber;
    }

    public void printResult(){
        Result gameResult = game.getGameResult();
        System.out.println(gameResult.getPrintMessage());
    }

    public void printReplayView(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public String getReplayInput(){
        String userReplayInput = scanner.nextLine();
        return userReplayInput;
    }
}
