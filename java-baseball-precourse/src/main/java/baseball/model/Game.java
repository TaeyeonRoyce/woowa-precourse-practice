package baseball.model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> computerNumber;
    private ArrayList<Integer> userInputNumber;

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(ArrayList<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public ArrayList<Integer> getUserInputNumber() {
        return userInputNumber;
    }

    public void setUserInputNumber(ArrayList<Integer> userInputNumber) {
        this.userInputNumber = userInputNumber;
    }

}
