package racinggame.domain;

import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingGame {
    public void play() {
        Cars cars = Cars.from(InputView.inputCarName());

        Round round = Round.from(InputView.inputRound());
        round.roundResult(cars);

        OutputView.printWinner(cars.getWinner());
    }
}
