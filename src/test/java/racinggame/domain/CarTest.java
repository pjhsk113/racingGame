package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("a");
    }

    @DisplayName("값이 4이상일때만 1칸 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"4 : 1", "5 : 1", "6 : 1", "7 : 1", "2 : 0", "3 : 0" }, delimiter = ':')
    void carMoveTest(int moveNumber, int expectPosition) {
        TestMoveStrategy moveStrategy = new TestMoveStrategy();
        moveStrategy.inputNumber(moveNumber);
        car.move(moveStrategy);

        assertThat(car.getPosition()).isEqualTo(expectPosition);
    }

    @DisplayName("자동차 이름이 5글자를 초과하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaaaa", "bbbbbbb", "cccccc"})
    void carNameLengthTest(String inputName) {
        assertThatThrownBy(() -> {
            Car.from(inputName);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("자동차 이름에 빈 값이 입력되면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "     "})
    void carNameBlankTest(String inputName) {
        assertThatThrownBy(() -> {
            Car.from(inputName);
        }).isInstanceOf(NoSuchElementException.class);
    }
}