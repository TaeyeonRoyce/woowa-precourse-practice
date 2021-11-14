package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SectionRepository {
    private static final HashMap<String, ArrayList<String>> sections = new HashMap<>();
    public static void addSection(String line, ArrayList<String> stations){
        sections.put(line, stations);
    }
    public static ArrayList<String> getSectionByLine(String line){
        return sections.get(line);
    }

    public static void printSubway(){
        List<Line> lines = LineRepository.lines();
        System.out.println("## 지하철 노선도");
        for (Line i : lines){
            printLine(i);
        }
    }

    private static void printLine(Line line){
        System.out.println("[INFO] " + line.getName() +
                "\n[INFO] ---");
        ArrayList<String> stations = sections.get(line.getName());
        for (String i : stations) {
            System.out.println("[INFO] " + i);
        }
        System.out.println("");
    }
}
