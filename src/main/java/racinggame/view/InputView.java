package racinggame.view;

import newtstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";

    private InputView() { }

    public static List<String> inputName() {
        System.out.println(INPUT_NAME_MESSAGE);
        return convertList(Console.readLine());
    }

    public static int inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static List<String> convertList(String inputName) {
        List<String> names = new ArrayList<>();
        for (String name : inputName.split(COMMA)) {
            names.add(name.trim());
        }
        return names;
    }
}
