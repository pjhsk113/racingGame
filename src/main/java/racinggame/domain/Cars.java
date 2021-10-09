package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        return new Cars(createCars(carNames));
    }

    public void moveCars() {
        CarMoveStrategy moveStrategy = new CarMoveStrategy();
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public Car valueOf(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(cars, carName);
            cars.add(Car.of(carName));
        }
        return cars;
    }

    private static void validateCarName(List<Car> cars, String name) {
        for (Car car : cars) {
            isDuplicateName(car, name);
        }
    }

    private static void isDuplicateName(Car car, String name) {
        if (car.getName().equals(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
