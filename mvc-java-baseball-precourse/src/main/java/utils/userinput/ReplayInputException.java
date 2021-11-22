package main.java.utils.userinput;


/*
리플레이 여부 확인
"1", "2" 두가지 경우만 가능
*/
public class ReplayInputException implements  UserInputException{

    @Override
    public void isValidInput(String userInput) throws IllegalArgumentException{
        if (!userInput.equals("1") && !userInput.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
