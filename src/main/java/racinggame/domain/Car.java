package racinggame.domain;

public class Car {
    private String name;
    private int position;

    private Car(String name) {
        validator(name);
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveAble()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validator(String name) {
        validateNameLength(name);
        validateInputBlank(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 입력 가능합니다.");
        }
    }

    private void validateInputBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백은 입력할 수 없습니다.");
        }
    }
}
