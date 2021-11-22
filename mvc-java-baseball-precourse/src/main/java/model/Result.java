package main.java.model;

public class Result {
    private int strikeCount;
    private int ballCount;

    private boolean isAllStrike = false;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

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
