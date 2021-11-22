package main.java.utils.userinput;

public class NumberException implements UserInputException {

    @Override
    public void isValidInput(String userInput) throws IllegalArgumentException {
        if(userInput.length() != 3){
            throw new IllegalArgumentException();
        }
        isDigits(userInput);
    }
    private void isDigits(String userInput){
        try{
            Integer.parseInt(userInput);
            isDiffDigits(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    private void isDiffDigits(String userInput) throws IllegalArgumentException{
        String[] userInputArray = userInput.split("");
        if (userInputArray[0].equals(userInputArray[1])
                ||userInputArray[1].equals(userInputArray[2])
                ||userInputArray[0].equals(userInputArray[2])){
            throw new IllegalArgumentException();
        }
        isNotZero(userInputArray);
    }
    private void isNotZero(String[] userInputArray){
        for (String s : userInputArray) {
            if (s.equals("0")){
                throw new IllegalArgumentException();
            }
        }
    }



}
