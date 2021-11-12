package subway.routes;

import subway.domain.*;
import subway.routes.line.LinePage;
import subway.routes.station.StationPage;

import java.util.Scanner;

public class MainPage {
    private Scanner scanner;
    public MainPage(Scanner scanner) {
        this.scanner = scanner;
    }
    public void initApplication(){
        initStation();
        initLine();
        initSection();
        mainPage();
    }
    private void initStation(){
        final String[] INIT_STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        for (String i : INIT_STATIONS){
            Station station = new Station(i);
            StationRepository.addStation(station);
        }
    }
    private void initLine(){
        final String[] INIT_LINES = {"2호선", "3호선", "신분당선"};
        for (String i : INIT_LINES){
            Line line = new Line(i);
            LineRepository.addLine(line);
        }
    }
    private void initSection(){
        final String[] INIT_SECTION_1 = {"교대역", "강남역", "역삼역"};
        final String[] INIT_SECTION_2 = {"교대역", "남부터미널역", "양재역", "매봉역"};
        final String[] INIT_SECTION_3 = {"강남역", "양재역", "양재시민의숲역"};
        SectionRepository.addSection("2호선", INIT_SECTION_1);
        SectionRepository.addSection("3호선", INIT_SECTION_2);
        SectionRepository.addSection("신분당선", INIT_SECTION_3);
    }

    private void mainPage(){
        System.out.println(
            "\n## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n"
        );
        getInput();
    }


    private void getInput(){
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        if (userInput.equals("Q")){
            return;
        }
        try{
            routes(userInput);
            mainPage();
        }catch (IllegalArgumentException e){
            getInput();
        }
    }

    private void routes(String userInput) throws IllegalArgumentException{
        if (userInput.equals("1")){
            new StationPage(scanner).startStation();
            return;
        } else if (userInput.equals("2")){
            new LinePage(scanner).startLine();
            return;
        } else if (userInput.equals("3")){
            return;
        } else if (userInput.equals("4")){
            return;
        }
        throw new IllegalArgumentException();
    }
}
