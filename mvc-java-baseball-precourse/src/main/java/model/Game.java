package main.java.model;

/*
게임에 대한 정보
사용자 입력값, 컴퓨터 난수, 결과를 저장
*/


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
