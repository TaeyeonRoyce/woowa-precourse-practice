package subway.routes.line;

import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LinePageController {
    Scanner scanner;

    public LinePageController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addLine(){
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String userInput = scanner.nextLine();
        checkAddLine(userInput);
    }

    private void checkAddLine(String userInput){
        for (Line i : LineRepository.lines()){
            if (i.getName().equals(userInput)){
                System.out.println("\n[ERROR] 이미 존재하는 노선입니다.");
                throw new IllegalArgumentException();
            }
        }
        ArrayList<String> addSection = (ArrayList<String>) Arrays.asList(new String[]{getFirstStation(),getLastStation()});
        SectionRepository.addSection(userInput, addSection);
        LineRepository.addLine(new Line(userInput));
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
    }

    private String getFirstStation(){
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String userInput = scanner.nextLine();
        checkStation(userInput);
        return userInput;
    }
    private String getLastStation(){
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String userInput = scanner.nextLine();
        checkStation(userInput);
        return userInput;
    }

    private void checkStation(String userInput){
        for (Station i : StationRepository.stations()){
            if(i.getName().equals(userInput)){
                return;
            }
        }
        System.out.println("\n[ERROR] 존재하지 않는 역 입니다.");
        throw new IllegalArgumentException();
    }

    public void deleteLine(){
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        String userInput = scanner.nextLine();
        LineRepository.deleteLineByName(userInput);
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void readLine(){
        System.out.println("\n## 노선 목록");
        for (Line i : LineRepository.lines()){
            System.out.println("[INFO]" + i.getName());
        }
    }

}
