package racinggame.domain;

import racinggame.view.OutputView;

public class Round {
    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round of(int round) {
        return new Round(round);
    }

    public void roundResult(Cars cars) {
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            OutputView.printRoundResult(cars);
        }
    }
}
