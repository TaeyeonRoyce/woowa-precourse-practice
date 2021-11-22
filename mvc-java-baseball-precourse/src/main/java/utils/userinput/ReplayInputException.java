package main.java.utils.userinput;

public class ReplayInputException implements  UserInputException{

    @Override
    public void isValidInput(String userInput) throws IllegalArgumentException{
        if (!userInput.equals("1") && !userInput.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
