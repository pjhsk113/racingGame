package racinggame.validate;

import racinggame.domain.Car;

import java.util.NoSuchElementException;

public class RacingGameValidator {
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 이름은 5자 이하만 입력 가능합니다.";
    private static final String BLANK_CANNOT_ENTERED_NAME = "[ERROR] 이름에 공백은 입력할 수 없습니다.";
    private static final String CAR_NAME_CANNOT_DUPLICATE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String ROUND_CAN_ENTERED_NUMBER = "[ERROR] 라운드는 숫자만 입력 가능합니다.";

    private RacingGameValidator() { }

    public static void validateRoundInput(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ROUND_CAN_ENTERED_NUMBER);
        }
    }

    public static void isDuplicateCarName(Car car, String name) {
        if (car.getName().equals(name)) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_DUPLICATE);
        }
    }

    public static void carNameValidator(String name) {
        validateNameLength(name);
        validateInputBlank(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new NoSuchElementException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validateInputBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new NoSuchElementException(BLANK_CANNOT_ENTERED_NAME);
        }
    }
}
