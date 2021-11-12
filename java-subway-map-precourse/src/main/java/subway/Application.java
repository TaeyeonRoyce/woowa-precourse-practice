package subway;

import subway.routes.MainPage;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        new MainPage(scanner).initApplication();
    }
}
