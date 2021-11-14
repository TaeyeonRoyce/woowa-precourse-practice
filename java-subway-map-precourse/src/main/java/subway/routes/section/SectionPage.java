package subway.routes.section;

import subway.routes.line.LinePageController;

import java.util.Scanner;

public class SectionPage {
    Scanner scanner;

    public SectionPage(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startSection(){
        System.out.println("\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기"
        );
        getInput();
    }
    private void  getInput() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        if (userInput.equals("B")){
            return;
        }
        try{
            routes(userInput);
        }catch (IllegalArgumentException e){
            startSection();
        }
    }
    private void routes(String userInput){
        SectionPageController sectionController = new SectionPageController(scanner);
        if (userInput.equals("1")){
            sectionController.addSection();
            return;
        } else if (userInput.equals("2")) {
            sectionController.deleteSection();
            return;
        }
        throw new IllegalArgumentException();
    }
}
