package main.java.utils;


/*
컴퓨터로부터 한 자리 난수를 받고,
숫자야구를 위한 유효한 세자리 난수를 만든다.
유효한 숫자 : 중복 X, 1 ~ 9의 정수
*/

public class CreateRandomNumber {

    public static int[] createRandomNumber(){
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int COMPUTER_NUMBER_LEN = 3;

        int[] computerNumber = new int[3];

        /* 중복 검사를 위한 1~9까지 숫자표 */
        boolean[] checkOverlappedNum = new boolean[END_INCLUSIVE];
        int cursor = 0;
        while(cursor < COMPUTER_NUMBER_LEN){
            /* 한 자리 난수 생성 */
            int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);

            /* 중복 검사 */
            if (!checkOverlappedNum[number - 1]){
                computerNumber[cursor] = number;
                checkOverlappedNum[number - 1] = true;
                cursor += 1;
            }
        }
        return computerNumber;
    }

}
