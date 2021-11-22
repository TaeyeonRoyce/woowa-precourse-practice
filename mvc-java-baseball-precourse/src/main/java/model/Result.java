package main.java.model;

public class Result {
    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean isAllStrike = false;
    private boolean isNothing = false;

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isAllStrike() {
        return isAllStrike;
    }

    public void setAllStrike(boolean allStrike) {
        isAllStrike = allStrike;
    }
}
