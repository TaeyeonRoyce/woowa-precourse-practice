package subway.domain;

import java.util.HashMap;

public class SectionRepository {
    private static final HashMap<String, String[]> sections = new HashMap<>();
    public static void addSection(String line, String[] stations){
        sections.put(line, stations);
    }
}
