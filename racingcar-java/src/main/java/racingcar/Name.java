package racingcar;

public class Name {

    private String carName;

    public Name(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("이름이 다섯 글자 초과");
        }
        if(carName == null) {
            throw new IllegalArgumentException("이름에 null이 들어옴");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
