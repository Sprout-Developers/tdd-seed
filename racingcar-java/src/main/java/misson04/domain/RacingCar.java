package misson04.domain;

import misson04.utils.RacingCarMovementStrategy;

public class RacingCar {

    private static final int DISTANCE_DEFAULT = 1;
    private static final String TEMPORARY_NAME = "타요타요";

    private final Name name;
    private int movedDistance;

    public RacingCar() {
        this(DISTANCE_DEFAULT);
    }

    public RacingCar(int movedDistance) {
        this(TEMPORARY_NAME, movedDistance);
    }

    public RacingCar(String name) {
        this(name, DISTANCE_DEFAULT);
    }

    public RacingCar(String name, int movedDistance) {
        this.name = new Name(name);
        this.movedDistance = movedDistance;
    }


    public void moveCar(RacingCarMovementStrategy racingCarMovementStrategy) {
        if (racingCarMovementStrategy.makeRandomMovement()) {
            this.movedDistance++;
        }
    }

    public String getCarName() {
        return name.getName();
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}

/*
 디자인 패턴은 최상단까지 올린다.
 필드는 모든 메서드에서 사용되어야 한다. 그렇지 않으면, 외부에서 주입하는 것이 맞다.
 모든 메서드에 필요하지 않으면, 메소드 인자로 받아서 처리해라
*/
