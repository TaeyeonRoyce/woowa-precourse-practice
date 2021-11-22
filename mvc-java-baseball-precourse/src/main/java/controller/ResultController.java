package main.java.controller;

import main.java.model.Result;

/*
사용자 입력으로부터
결과를 관리하는 클래스
strike와 ball의 수를 세고,
결과 메세지를 작성해준다.
*/

public class ResultController {

    Result result;

    public ResultController(Result result) {
        this.result = result;
    }

    /* 입력받은 숫자를 통해 strike와 ball의 수 결정 */
    public void gameResult(int[] computerNumber, int[] userNumber){
        int strikeCount = isStrike(computerNumber, userNumber);
        int ballCount = isBall(computerNumber, userNumber);

        result.setStrikeCount(strikeCount);
        result.setBallCount(ballCount - strikeCount); //스트라이크에서 볼을 중복으로 세기 때문에 빼주어야 함
        setResultMessage();
    }

    /* 결과의 정보에 의존하여 결과 메세지 작성 */
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

    /* 스트라이크 검사 */
    private int isStrike(int[] computerNumber, int[] userNumber){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber[i] == userNumber[i]){
                cnt += 1;
            }
        }
        return cnt;
    }

    /* 볼 검사 */
    private int isBall(int[] computerNumber, int[] userNumber){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if(isContain(userNumber[i], computerNumber)){
                cnt += 1;
            }
        }
        return cnt;
    }

    /* 볼 검사를 위한 배열에 값이 존재하는지 확인하는 메서드*/
    private boolean isContain(int a,  int[] b){
        for (int i = 0; i < b.length; i++) {
            if (a == b[i]){
                return true;
            }
        }
        return false;
    }
}
