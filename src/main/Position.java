
class Position {
    private Location location;
    private Direction direction;

    Position(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    static class Location {
        int xCordinate;
        int yCoOrdinate;

        public boolean equals(Object o) {
            Location c = (Location) o;
            return this.xCordinate == c.xCordinate && this.yCoOrdinate == c.yCoOrdinate;
        }

        Location(int x, int y) {
            if (x >= 5 || y >= 5)
                throw new IndexOutOfBoundsException();
            this.xCordinate = x;
            this.yCoOrdinate = y;
        }

    }


    public enum Direction {
        E() {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? S : N;
            }
        },
        W() {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? N : S;
            }
        },
        S() {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? W : E;
            }

        },
        N() {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? E : W;
            }

        };

        public static Direction direction;

        abstract Direction rotate(Direction.Rotation rotation);

        enum Rotation {
            R, L
        }
    }

}
