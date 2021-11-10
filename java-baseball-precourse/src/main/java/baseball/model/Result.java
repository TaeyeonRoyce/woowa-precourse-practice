package baseball.model;

import utils.DataUtils;

import java.util.ArrayList;

public class Result{
    int ballCount;
    int strikeCount;
    Game game;

    public Result(Game game) {
        this.ballCount = DataUtils.countBalls(game.getComputerNumber(), game.getUserInputNumber());
        this.strikeCount = DataUtils.countStrikes(game.getComputerNumber(), game.getUserInputNumber());
        this.game = game;
    }
    public String getResult(){
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
        return printMessage;
    }
    public boolean checkResult(){
        if (strikeCount == 3){
            return false;
        }
        return true;
    }
}
