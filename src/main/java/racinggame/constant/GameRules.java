package racinggame.constant;

public enum GameRules {
    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    STANDARD_NUMBER(4);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
