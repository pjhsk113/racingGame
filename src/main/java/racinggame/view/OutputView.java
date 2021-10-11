package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String COMMA = ",";
    private static final String WINNER_IS = "최종 우승자는 %s 입니다.";
    private OutputView() { }

    public static void printRoundResult(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.valueOf(i);
            System.out.println(car.getName() + COLON + printHyphen(car.getPosition()));
        }

        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        StringJoiner winner = new StringJoiner(COMMA);
        for (Car car : cars) {
            winner.add(car.getName());
        }
        System.out.println(String.format(WINNER_IS, winner));
    }

    private static String printHyphen(int position) {
        StringBuilder hyphen = new StringBuilder();
        for (int i = 0; i < position; i++) {
            hyphen.append(HYPHEN);
        }

        return hyphen.toString();
    }
}
