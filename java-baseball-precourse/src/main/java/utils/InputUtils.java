package utils;

import baseball.model.Game;

public class InputUtils {
    private String userInput;
    private Game game;

    public InputUtils(String userInput, Game game) {
        this.userInput = userInput;
        this.game = game;
    }
    public InputUtils(String userInput) {
        this.userInput = userInput;
    }

    public void checkUserInputValid() throws IllegalArgumentException{
        String[] userInputArray = isUserInputDigit(userInput);
        DataUtils.saveUserInputNumber(userInputArray, game);
    }

    private String[] isUserInputDigit(String userInput) throws IllegalArgumentException{
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return isUserInputLength(userInput);
    }
    private String[] isUserInputLength(String userInput) throws IllegalArgumentException{
        if (userInput.length() != 3){
            throw new IllegalArgumentException();
        }
        return isUserInputDiffDigits(userInput);
    }

    private String[] isUserInputDiffDigits(String userInput) throws IllegalArgumentException{
        String[] userInputArray = userInput.split("");
        if (userInputArray[0] == userInputArray[1]
                ||userInputArray[1] == userInputArray[2]
                ||userInputArray[0] == userInputArray[2]){
            throw new IllegalArgumentException();
        }
        return userInputArray;
    }
    public void checkRestart() throws IllegalArgumentException{
        if (!userInput.equals("1") && !userInput.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
