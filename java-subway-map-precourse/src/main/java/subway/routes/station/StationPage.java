package subway.routes.station;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.routes.MainPage;

import java.util.Scanner;

public class StationPage {
    Scanner scanner;

    public StationPage(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startStation(){
        System.out.println("\n" +
            "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
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
            startStation();
        }
    }
    private void routes(String userInput) throws IllegalArgumentException{
        StationController stationController = new StationController(scanner);
        if (userInput.equals("1")){
            stationController.addStation();
            return;
        } else if (userInput.equals("2")){
            stationController.deleteStation();
            return;
        } else if (userInput.equals("3")) {
            stationController.readStation();
            return;
        }
        throw new IllegalArgumentException();
    }

}
