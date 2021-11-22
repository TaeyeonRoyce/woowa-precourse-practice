package main.java.utils;

public class CreateRandomNumber {

    public static int[] createRandomNumber(){
        final int  START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int COMPUTER_NUMBER_LEN = 3;

        int[] computerNumber = new int[3];
        boolean[] checkOverlappedNum = new boolean[END_INCLUSIVE];
        int cursor = 0;
        while(cursor < COMPUTER_NUMBER_LEN){
            int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (!checkOverlappedNum[number - 1]){
                computerNumber[cursor] = number;
                checkOverlappedNum[number - 1] = true;
                cursor += 1;
            }
        }
        return computerNumber;
    }

}
