package racinggame.domain;

import racinggame.validate.RacingGameValidator;

public class Car {
    private String name;
    private int position;

    private Car(String name) {
        RacingGameValidator.carNameValidator(name);
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
}
