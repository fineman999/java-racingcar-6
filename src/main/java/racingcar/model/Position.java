package racingcar.model;

import java.util.Objects;

public final class Position {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position startFromZero() {
        return new Position(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
