package racingcar.model;

import racingcar.utils.RandomGenerator;

import java.util.Objects;

public class RacingGame {
    private final Cars cars;
    private final TryNumber tryNumber;

    private final Count count;

    private RacingGame(Cars cars, TryNumber tryNumber, Count count) {
        this.cars = cars;
        this.tryNumber = tryNumber;
        this.count = count;
    }

    public static RacingGame of(String names, int tryNo) {
        Cars newCars = Cars.of(names);
        TryNumber newTryNumber = TryNumber.of(tryNo);
        Count newCount = Count.of(0);
        return new RacingGame(newCars, newTryNumber, newCount);
    }

    public static RacingGame ofWithCount(String names, int tryNo, int count) {
        Cars newCars = Cars.of(names);
        TryNumber newTryNumber = TryNumber.of(tryNo);
        Count newCount = Count.of(count);
        return new RacingGame(newCars, newTryNumber, newCount);
    }

    public RacingGame race(RandomGenerator randomNumber) {
        cars.moves(randomNumber);
        return new RacingGame(cars, tryNumber, count.countUp());
    }

    public boolean isEnd() {
        return count.isEnd(tryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(tryNumber, that.tryNumber) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryNumber, count);
    }

}