/**
 * Created by lavanya on 6/5/17.
 */
public class MarsRover {
    private int xCordinate;
    private int yCordinate;

    enum Direction {
        E() {
            @Override
            public Direction next(Rotation rotation) {
                return rotation == Rotation.R ? S : N;
            }
        },
        W() {
            @Override
            public Direction next(Rotation rotation) {
                return rotation == Rotation.R ? N : S;
            }
        },
        S() {
            @Override
            public Direction next(Rotation rotation) {
                return rotation == Rotation.R ? W : E;
            }
        },
        N() {
            @Override
            public Direction next(Rotation rotation) {
                System.out.println(rotation);
                return rotation == Rotation.R ? E : W;
            }
        };

        public static Direction direction;

        abstract Direction next(Rotation rotation);

        enum Rotation {
            R, L
        }
    }

    MarsRover(int xCordinate, int yCordinate, Direction direction) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        Direction.direction = direction;
    }

    Direction navigatingAsPerInstruction(Direction.Rotation rotation) {
        return (Direction.direction.next(rotation));
    }

}
