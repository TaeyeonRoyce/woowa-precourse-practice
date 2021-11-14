package subway.routes.section;

import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SectionPageController {
    Scanner scanner;
    private String line;
    private String station;

    public SectionPageController(Scanner scanner) {
        this.scanner = scanner;
    }
    public void addSection(){
        System.out.println("\n## 노선을 입력하세요.");
        getLine();
        String addStation = getStation();
        if(isExistStation(addStation)){
            System.out.println("[ERROR] 노선에 이미 존재하는 역입니다.");
            throw new IllegalArgumentException();
        }
        this.station = addStation;
        getSequence();
    }
    private void getLine() {
        String line = scanner.nextLine();
        for (Line i : LineRepository.lines()) {
            if (i.getName().equals(line)) {
                this.line = line;
                return;
            }
        }
        System.out.println("\n[ERROR] 존재하지 않는 노선입니다.");
        throw new IllegalArgumentException();
    }

    private String getStation(){
        System.out.println("\n## 역이름을 입력하세요.");
        String station = scanner.nextLine();
        isValidStation(station);
        return station;
    }

    private void isValidStation(String station){
        for (Station i : StationRepository.stations()) {
            if (i.getName().equals(station)) {
                return;
            }
        }
        System.out.println("[ERROR] 존재하지 않는 역 입니다.");
        throw new IllegalArgumentException();
    }
    private boolean isExistStation(String station){
        ArrayList<String> section = SectionRepository.getSectionByLine(line);
        if (section.contains(station)) {
            return true;
        }
        return false;
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
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            throw new IllegalArgumentException();
        }
    }
    private void isSequenceValidNumber(int sequence){
        ArrayList<String> section = SectionRepository.getSectionByLine(line);
        int sectionSize = section.size();
        if (sequence > 0
                || sequence < sectionSize){
            section.add(sequence - 1, this.station);
            System.out.println("[INFO] 구간이 등록되었습니다.");
            return;
        } else if (sequence == sectionSize){
            section.add(this.station);
            System.out.println(section);
            return;
        }
        System.out.println("[ERROR] 해당 순서에 등록할 수 없습니다.");
        throw new IllegalArgumentException();
    }


    public void deleteSection(){
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        getLine();
        String deleteStation = getStation();
        if (!isExistStation(deleteStation)){
            System.out.println("[ERROR] 노선에 존재하지 않는 역입니다.");
            throw new IllegalArgumentException();
        }
        this.station = deleteStation;
        findSectionStation();
    }

    private void findSectionStation(){
        ArrayList<String> section = SectionRepository.getSectionByLine(line);
        section.remove(station);
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }
}