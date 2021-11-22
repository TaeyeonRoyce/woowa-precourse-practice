package main.java.model;

public class Game {
    private int[] userInputNumber;
    private int[] computerRandomNumber;
    private Result gameResult;

    public int[] getUserInputNumber() {
        return userInputNumber;
    }

    public void setUserInputNumber(int[] userInputNumber) {
        this.userInputNumber = userInputNumber;
    }

    public int[] getComputerRandomNumber() {
        return computerRandomNumber;
    }

    public void setComputerRandomNumber(int[] computerRandomNumber) {
        this.computerRandomNumber = computerRandomNumber;
    }

    public Result getGameResult() {
        return gameResult;
    }

    public void setGameResult(Result gameResult) {
        this.gameResult = gameResult;
    }
}
