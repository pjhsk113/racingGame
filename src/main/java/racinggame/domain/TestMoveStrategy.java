package racinggame.domain;

public class TestMoveStrategy implements MoveStrategy {
    private int randomNumber;

    @Override
    public boolean moveAble() {
        return inputNumber(randomNumber);
    }

    public boolean inputNumber(int number) {
        this.randomNumber = number;
        return number >= 4;
    }
}
