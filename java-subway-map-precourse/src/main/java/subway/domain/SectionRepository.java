package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SectionRepository {
    private static final HashMap<String, ArrayList<String>> sections = new HashMap<>();
    public static void addSection(String line, ArrayList<String> stations){
        sections.put(line, stations);
    }
    public static ArrayList<String> getSectionByLine(String line){
        return sections.get(line);
    }
}
