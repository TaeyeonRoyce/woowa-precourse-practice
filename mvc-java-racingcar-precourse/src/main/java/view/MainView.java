package view;

import model.WinnerCar;

import java.util.Scanner;

public class MainView {
    Scanner scanner;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userCarInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return scanner.nextLine();
    }

    public String userProcessInputView() {
        System.out.println("시도할 회수는 몇회인가요?");

        return scanner.nextLine();
    }

    public void printResultMessageView() {
        System.out.println("\n실행 결과");
    }

    public void printCarPositionView(String carPosition) {
        System.out.println(carPosition);
    }

    public void printWinnerView(WinnerCar winnerCar) {
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winnerCar.getCarNameArrayList()));
    }
}
