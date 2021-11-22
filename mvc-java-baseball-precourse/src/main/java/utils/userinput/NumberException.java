package main.java.utils.userinput;


/*
예외처리하는 인터페이스를 구현한 클래스
사용자 입력이
3자리, 정수, 중복 X, 1~9의 숫자인지 확인
*/

public class NumberException implements UserInputException {

    /* 3자리 확인 */
    @Override
    public void isValidInput(String userInput) throws IllegalArgumentException {
        if(userInput.length() != 3){
            throw new IllegalArgumentException();
        }
        isDigits(userInput);
    }

    /* 숫자인지 확인 */
    private void isDigits(String userInput){
        try{
            Integer.parseInt(userInput);
            isDiffDigits(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    /* 중복이 없는지 확인 */
    private void isDiffDigits(String userInput) throws IllegalArgumentException{
        String[] userInputArray = userInput.split("");
        if (userInputArray[0].equals(userInputArray[1])
                ||userInputArray[1].equals(userInputArray[2])
                ||userInputArray[0].equals(userInputArray[2])){
            throw new IllegalArgumentException();
        }
        isNotZero(userInputArray);
    }

    /* 0이 아닌 정수인지 확인 */
    private void isNotZero(String[] userInputArray){
        for (String s : userInputArray) {
            if (s.equals("0")){
                throw new IllegalArgumentException();
            }
        }
    }



}
