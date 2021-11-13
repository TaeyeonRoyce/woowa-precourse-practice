package subway.routes.station;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StationController {
    Scanner scanner;

    public StationController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStation(){
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        String userInput = scanner.nextLine();
        checkAddStation(userInput);
    }

    private void checkAddStation(String userInput){
        for (Station i : StationRepository.stations()){
            checkAddOverlap(i.getName(),userInput);
        }
        StationRepository.addStation(new Station(userInput));
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }
    private void checkAddOverlap(String  existStation, String addStation) throws IllegalArgumentException{
        if(existStation.equals(addStation)){
            System.out.println("\n[ERROR] 이미 등록된 역 이름입니다.");
            throw new IllegalArgumentException();
        }
    }


    public void deleteStation(){
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String userInput = scanner.nextLine();
        StationRepository.deleteStation(userInput);
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }


    public void readStation(){
        System.out.println("## 역 목록");
        for (Station i : StationRepository.stations()){
            System.out.println("[INFO]" + i.getName());
        }
    }
}