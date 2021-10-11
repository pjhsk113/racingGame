package racinggame.domain;

import racinggame.validate.RacingGameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> carNames) {
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
            cars.add(Car.from(carName));
        }
        return cars;
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            winners = isWinner(winners, car);
        }
        return winners;
    }

    private List<Car> isWinner(List<Car> winners, Car car)  {
        if (car.getPosition() == getMaxPosition()) {
            winners.add(car);
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPostion = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxPostion = Math.max(maxPostion, car.getPosition());
        }
        return maxPostion;
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
