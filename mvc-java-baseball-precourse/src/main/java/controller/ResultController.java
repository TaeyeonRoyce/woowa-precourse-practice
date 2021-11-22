package main.java.controller;

import main.java.model.Result;

public class ResultController {

    Result result;

    public ResultController(Result result) {
        this.result = result;
    }

    public void gameResult(int[] computerNumber, int[] userNumber){
        int strikeCount = isStrike(computerNumber, userNumber);
        int ballCount = isBall(computerNumber, userNumber);

        result.setStrikeCount(strikeCount);
        result.setBallCount(ballCount - strikeCount);
        setResultMessage();

    }
    private void setResultMessage(){
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();
        String printMessage = "";
        if (ballCount == 0 && strikeCount == 0){
            printMessage += "낫싱";
        }
        if(ballCount != 0){
            printMessage += ballCount + "볼 ";
        }
        if(strikeCount != 0){
            printMessage += strikeCount + "스트라이크 ";
        }

        result.setPrintMessage(printMessage);

    }
    private int isStrike(int[] computerNumber, int[] userNumber){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber[i] == userNumber[i]){
                cnt += 1;
            }
        }
        return cnt;
    }

    private int isBall(int[] computerNumber, int[] userNumber){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if(isContain(userNumber[i], computerNumber)){
                cnt += 1;
            }
        }
        return cnt;
    }

    private boolean isContain(int a,  int[] b){
        for (int i = 0; i < b.length; i++) {
            if (a == b[i]){
                return true;
            }
        }
        return false;
    }
}
