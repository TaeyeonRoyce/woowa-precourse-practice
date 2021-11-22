package main.java.model;

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
