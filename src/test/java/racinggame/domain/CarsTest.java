package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    @DisplayName("Cars 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateCarNameList")
    void carsInitTest(List<String> carNames, int carsSize) {
        assertThat(Cars.createCars(carNames).size()).isEqualTo(carsSize);
    }

    @DisplayName("Cars 생성 시 자동차 이름이 중복된 경우 IllegalArgumentException이 발생")
    @ParameterizedTest
    @MethodSource("generateDuplicateCarName")
    void carNameDuplicateTest(List<String> carNames) {
        assertThatThrownBy(() -> {
            Cars.from(carNames);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    private static Stream<Arguments> generateDuplicateCarName() {
        return Stream.of(
                Arguments.of(Arrays.asList("abbb", "abbb")),
                Arguments.of(Arrays.asList("차1","차1")),
                Arguments.of(Arrays.asList("차1","차1","차1")),
                Arguments.of(Arrays.asList("차1","차2","차2","차4"))
        );
    }

    private static Stream<Arguments> generateCarNameList() {
        return Stream.of(
                Arguments.of(Arrays.asList("차1"), 1),
                Arguments.of(Arrays.asList("차1","차2"), 2),
                Arguments.of(Arrays.asList("차1","차2","차3"), 3),
                Arguments.of(Arrays.asList("차1","차2","차3","차4"), 4)
        );
    }
}