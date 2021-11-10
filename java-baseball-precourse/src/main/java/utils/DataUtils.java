package utils;

import baseball.model.Game;

import java.util.ArrayList;

public class DataUtils {
    public static void createComputerNumber(Game game){
        final int  START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int COMPUTER_NUMBER_LEN = 3;

        ArrayList<Integer> computerNumber = new ArrayList<>();
        while(computerNumber.size() < COMPUTER_NUMBER_LEN) {
            int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        game.setComputerNumber(computerNumber);
    }

    public static void saveUserInputNumber(String[] userInput, Game game){
        ArrayList<Integer> userInputNumber= new ArrayList<>();
        for (String i: userInput){
            userInputNumber.add(Integer.parseInt(i));
        }
        game.setUserInputNumber(userInputNumber);
    }

    public static int countBalls(ArrayList<Integer> computerNumber, ArrayList<Integer> userNumber){
        int counts = 0;
        for (int i = 0; i < 3; i++){
            int cmpNum = userNumber.get(i);
            if(computerNumber.contains(cmpNum)
                    && computerNumber.indexOf(cmpNum) != i){
                counts += 1;
            }
        }
        return counts;
    }
    public static int countStrikes(ArrayList<Integer> computerNumber, ArrayList<Integer> userNumber){
        int counts = 0;
        for (int i = 0; i < 3; i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                counts += 1;
            }
        }
        return counts;
    }

}
