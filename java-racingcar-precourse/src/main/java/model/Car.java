package model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPosition(){
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }
    // 추가 기능 구현
}
