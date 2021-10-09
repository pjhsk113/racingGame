package racinggame.domain;

import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingGame {
    public void play() {
        // 자동차 이름 입력
        Cars cars = Cars.of(InputView.inputName());

        // 라운드 입력
        Round round = Round.of(InputView.inputRound());
        // 라운드 별 결과
        round.roundResult(cars);

        // 레이싱 우승자 출력
    }
}