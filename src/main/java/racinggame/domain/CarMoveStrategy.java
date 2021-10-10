package racinggame.domain;

import newtstep.utils.Randoms;
import racinggame.constant.GameRules;

public class CarMoveStrategy implements MoveStrategy {

    @Override
    public boolean moveAble() {
        int randomNumber = Randoms.pickNumberInRange(GameRules.START_INCLUSIVE.getValue(), GameRules.END_INCLUSIVE.getValue());
        return randomNumber >= GameRules.STANDARD_NUMBER.getValue();
    }
}
