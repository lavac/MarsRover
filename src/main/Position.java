
class Position {
    private Location location;
    private Direction direction;
    Position(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    static class Location {
        int xCordinate;
        int yCordinate;

        public boolean equals(Object obj) {
            Location location = (Location) obj;
            if(!(location != null))
                throw new IllegalArgumentException();
            return this.xCordinate == location.xCordinate && this.yCordinate == location.yCordinate;
        }

        Location(int x, int y) {
            if (x >= 5 || y >= 5)
                throw new IndexOutOfBoundsException();
            this.xCordinate = x;
            this.yCordinate = y;
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

        abstract Direction rotate(Direction.Rotation rotation);

        enum Rotation {
            R, L
        }
    }

}
