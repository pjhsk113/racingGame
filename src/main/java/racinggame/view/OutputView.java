package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class OutputView {
    private static final String COLON = ":";
    private static final String HYPHEN = "-";

    private OutputView() { }

    public static void printRoundResult(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.valueOf(i);
            System.out.println(car.getName() + COLON + printHyphen(car.getPosition()));
        }

        System.out.println();
    }

    private static String printHyphen(int position) {
        StringBuilder hyphen = new StringBuilder();
        for (int i = 0; i < position; i++) {
            hyphen.append(HYPHEN);
        }

        return hyphen.toString();
    }
}
