package subway.routes.line;

import subway.routes.station.StationController;

import java.util.Scanner;

public class LinePage {
    Scanner scanner;

    public LinePage(Scanner scanner) {
        this.scanner = scanner;
    }
    public void startLine(){
        System.out.println("\n## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기"
        );
        getInput();
    }
    private void getInput(){
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        if (userInput.equals("B")){
            return;
        }
        try{
            routes(userInput);
        }catch (IllegalArgumentException e){
            startLine();
        }
    }
    private void routes(String userInput){
        LinePageController lineController = new LinePageController(scanner);
        if (userInput.equals("1")){
            lineController.addLine();
            return;
        } else if (userInput.equals("2")){
            lineController.deleteLine();
            return;
        } else if (userInput.equals("3")) {
            lineController.readLine();
            return;
        }
        throw new IllegalArgumentException();
    }
}
