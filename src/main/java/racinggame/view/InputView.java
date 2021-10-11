package racinggame.view;

import newtstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.validate.RacingGameValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";

    private InputView() { }

    public static List<Car> inputCarName() {
        System.out.println(INPUT_NAME_MESSAGE);
        try {
            return Cars.createCars(convertList(Console.readLine()));
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.out.println(INPUT_NAME_MESSAGE);
            return Cars.createCars(convertList(Console.readLine()));
        }
    }

    public static int inputRound() {
        try {
            System.out.println(INPUT_ROUND_MESSAGE);
            String input = Console.readLine();
            RacingGameValidator.validateRoundInput(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputRound();
        }
    }

    private static List<String> convertList(String inputName) {
        List<String> names = new ArrayList<>();
        for (String name : inputName.split(COMMA)) {
            names.add(name.trim());
        }
        return names;
    }
}
