package utils;

import java.util.ArrayList;

public class InputUtils {
    String userInput;

    public InputUtils(String userInput) {
        this.userInput = userInput;
    }

    public void checkUserCarInput() throws IllegalArgumentException{
        String[] carList = userInput.split(",");
        for (String i : carList){
            if(!isCarLength(i)){
                throw new IllegalArgumentException();
            }
        }
    }
    private boolean isCarLength(String car){
        int carLength = car.length();
        if (carLength > 5 || carLength == 0){
            return false;
        }
        return true;
    }

    public void checkUserTimesInput() throws IllegalArgumentException{
        try {
            int times = Integer.parseInt(userInput);
            isPositive(times);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private void isPositive(int times) throws IllegalArgumentException{
        if (times < 0){
            throw new IllegalArgumentException();
        }
    }
}
