package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("새로 생성한 위치 객체가 1인지 확인")
    void positionCreateTest() {
        Position position = new Position();
        assertThat(position.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("새로 생성한 위치 객체 문자열 확인")
    void positionStringTest() {
        Position position = new Position();
        assertThat(position.positionString()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 객체 생성 후 위치 확인")
    void carCreateTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 객체 생성 후 위치 출력")
    void carStringTest() {
        Car car = new Car();
        assertThat(car.carString()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 객체 생성 후 1칸 움직임")
    void carMoveTest() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
        assertThat(car.carString()).isEqualTo("--");
    }

    @Test
    @DisplayName("자동차들 여러 대 생성 테스트")
    void carsCreateTest() {
        Cars cars2 = new Cars(2);
        assertThat(cars2.getCar(0).getPosition()).isEqualTo(1);
        assertThat(cars2.getCar(1).getPosition()).isEqualTo(1);
        assertThat(cars2.getCarList()).hasSize(2);

        cars2.getCar(0).move();
        List<String> carsStatus = cars2.getCarsStatus();
        assertThat(carsStatus.get(0)).isEqualTo("--");
        assertThat(carsStatus.get(1)).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차들 0대 생성 테스트")
    void carsNotCreateTest() {
        Cars cars = new Cars(0);
        assertThat(cars.getCar(0).getPosition()).isEqualTo(1);
    }

//    @Test
//    @DisplayName("자동차들 null 테스트")
//    void carsNullTest() {
//        Cars cars = new Cars(0);
//        cars.carList.add(null);
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            cars.getCar(0);
//        });
//    }

    @Test
    @DisplayName("사용자 생성 및 랜덤 테스트")
    void userCreateTest() {
        User user = new User();
        assertThat(user.random()).isBetween(0, 9);
    }

    @Test
    @DisplayName("사용자들 여러 명 생성 테스트")
    void usersCreateTest() {
        Users users = new Users(3);
        assertThat(users.getUserList()).hasSize(3);
    }

    @Test
    @DisplayName("이름 생성")
    void nameCreateTest() {
        Name name1 = new Name("name1");
        Name name2 = new Name("다섯글자닉");
        assertThat(name1.getCarName()).isEqualTo("name1");
        assertThat(name2.getCarName()).isEqualTo("다섯글자닉");
    }

    @Test
    @DisplayName("이름 생성 실패")
    void nameCreateFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Name name = new Name("여섯글자닉넴");
        });
    }

    @Test
    @DisplayName("이름들 ,로 분리")
    void namesSplitTest() {
        String string = "pobi,crong,honux";
        List<Name> names = NameSpliter.nameSplit(string);
        assertThat(names).hasSize(3);
        assertThat(names.get(0).getCarName()).
                isEqualTo("pobi");
        assertThat(names.get(1).getCarName()).
                isEqualTo("crong");
        assertThat(names.get(2).getCarName()).
                isEqualTo("honux");
    }

    @Test
    @DisplayName("이름들 분리 실패")
    void namesSplitFailTest() {
        String string = "1234,12345,123456,1234567";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Name> names = NameSpliter.nameSplit(string);
        });
    }
}
