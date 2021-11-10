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
    }

}
