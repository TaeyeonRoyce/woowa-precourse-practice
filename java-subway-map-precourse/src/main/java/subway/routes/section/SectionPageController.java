package subway.routes.section;

import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SectionPageController {
    Scanner scanner;
    private String addLine;
    private String addStation;
    private int addSectionLocation;

    public SectionPageController(Scanner scanner) {
        this.scanner = scanner;
    }
    public void addSection(){
        getLine();
    }
    private void getLine() {
        System.out.println("\n## 노선을 입력하세요.");
        String line = scanner.nextLine();
        for (Line i : LineRepository.lines()) {
            if (i.getName().equals(line)) {
                this.addLine = line;
                getStation();
                return;
            }
        }
        System.out.println("\n[ERROR] 존재하지 않는 노선입니다.");
        throw new IllegalArgumentException();
    }

    private void getStation(){
        System.out.println("\n## 역이름을 입력하세요.");
        String station = scanner.nextLine();
        isValidStation(station);
    }

    private void isValidStation(String station){
        for (Station i : StationRepository.stations()) {
            if (i.getName().equals(station)) {
                isExistStation(station);
            }
        }
        System.out.println("\n[ERROR] 존재하지 않는 역입니다.");
        throw new IllegalArgumentException();
    }
    private void isExistStation(String station){
        ArrayList<String> section = SectionRepository.getSectionByLine(addLine);
        if (section.contains(station)) {
            System.out.println("\n[ERROR] 노선에 이미 존재하는 역입니다.");
            throw new IllegalArgumentException();
        }
        this.addStation = station;
        getSequence();
    }

    private void getSequence(){
        System.out.println("\n## 순서를 입력하세요.");
        String sequence = scanner.nextLine();
        isSequenceNumber(sequence);
    }
    private void isSequenceNumber(String sequence){
        try{
            isSequenceValidNumber(Integer.parseInt(sequence));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    private void isSequenceValidNumber(int sequence){
        ArrayList<String> section = SectionRepository.getSectionByLine(addLine);
        int sectionSize = section.size();
        if (sequence > 0
                || sequence < sectionSize){
            section.add(sequence - 1, this.addStation);
            System.out.println(section);
            return;
        } else if (sequence == sectionSize){
            section.add(this.addStation);
            System.out.println(section);
            return;
        }
        System.out.println("[ERROR] 해당 순서에 등록할 수 없습니다.");
        throw new IllegalArgumentException();
    }
}