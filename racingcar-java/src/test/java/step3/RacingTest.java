package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("레이싱 테스트")
class RacingTest {
    Racing racing = new Racing();

    @Test
    @DisplayName("입력값 넣기 테스트")
    void testRacing() {
        String input = "pobi,crong,honux\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        racing.raceStart();
    }

    @Test
    @DisplayName("자동차 이름 비어있을 때 오류 발생 테스트")
    void carNameIsNullTest() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤 값 테스트")
    void carRandomDistance(){
        Car car = new Car("pobi",1, bound -> 5);
        car.move();
        car.move();
        car.move();
        assertThat(car.getDistance()).isEqualTo(4);
    }

    @Test
    @DisplayName("Car 이름 가져오기")
    void getCarName() {
        String carNames = "pobi,crong,honux";

        Cars cars = new Cars(carNames);

        assertAll(
                () -> assertThat(cars.getCars().get(0).getCarName()).isEqualTo("pobi"),
                () -> assertThat(cars.getCars().get(1).getCarName()).isEqualTo("crong")
        );
    }
}