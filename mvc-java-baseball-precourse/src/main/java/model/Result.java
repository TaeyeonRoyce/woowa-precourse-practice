package main.java.model;


/*
하나의 게임에서
사용자 입력에 따른 결과에 대한 모델
strike, ball, 결과 메세지를 포함
*/
public class Result {
    private int strikeCount;
    private int ballCount;
    private String printMessage = "";

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public String getPrintMessage() {
        return printMessage;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setPrintMessage(String printMessage) {
        this.printMessage = printMessage;
    }
}
