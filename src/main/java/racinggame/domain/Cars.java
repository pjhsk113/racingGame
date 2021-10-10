package racinggame.domain;

import racinggame.validate.RacingGameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> carNames) throws IllegalArgumentException {
        return new Cars(carNames);
    }

    public void moveCars() {
        CarMoveStrategy moveStrategy = new CarMoveStrategy();
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(cars, carName);
            cars.add(Car.of(carName));
        }
        return cars;
    }

    public Car valueOf(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    private static void validateCarName(List<Car> cars, String name) {
        for (Car car : cars) {
            RacingGameValidator.isDuplicateCarName(car, name);
        }
    }
}
