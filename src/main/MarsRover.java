import java.util.HashMap;
import java.util.Map;

public class MarsRover {
    static  Position.Location coOrdinate;
     static Position.Direction facedDirection;
    private Map<Position.Location, Position.Direction> navigationMap = new HashMap<>();

    MarsRover() {}

    MarsRover(int xCoOrdinate, int yCoordinate, Position.Direction facedDirection) {
        if (xCoOrdinate >= 5 || yCoordinate >= 5 || xCoOrdinate < 0 || yCoordinate < 0)
            throw new IndexOutOfBoundsException();
        coOrdinate = new Position.Location(xCoOrdinate, yCoordinate);
        if (facedDirection == null)
            throw new NullPointerException();
        MarsRover.facedDirection = facedDirection;
        initializeMap();
    }

    private void initializeMap() {
        navigationMap.put(new Position.Location(0, 1), Position.Direction.N);
        navigationMap.put(new Position.Location(0, -1), Position.Direction.S);
        navigationMap.put(new Position.Location(1, 0), Position.Direction.E);
        navigationMap.put(new Position.Location(-1, 0), Position.Direction.W);
    }

    private void move() {
        for (Map.Entry<Position.Location, Position.Direction> entry : navigationMap.entrySet()) {
            if (entry.getValue().equals(facedDirection)) {
                coOrdinate.xCordinate += entry.getKey().xCordinate;
                coOrdinate.yCoOrdinate += entry.getKey().yCoOrdinate;
            }
        }
    }

    private Position.Direction rotate(Position.Direction.Rotation rotation) {
        facedDirection = facedDirection.rotate(rotation);
        return facedDirection;
    }

    Position.Direction navigatingAsPerInstruction(String instructions) {
        char[] instructionSet = instructions.toCharArray();
        for (char instruction : instructionSet) {
            if (instruction == 'M') {
                move();
            } else {
                String rotateInstruction = Character.toString(instruction);
                Position.Direction.Rotation rotation = Position.Direction.Rotation.valueOf((rotateInstruction));
                facedDirection = rotate(rotation);
            }
        }
        return facedDirection;
    }

    Position.Location getLocation() {
        return coOrdinate;
    }

    Position.Direction getDirection() {
        return facedDirection;
    }

    public static void main(String args[]) {
        MarsRover marsRoverOne = new MarsRover(1, 2, Position.Direction.N);
        marsRoverOne.navigatingAsPerInstruction("LMLMLMLMM");
        System.out.println(coOrdinate.xCordinate + " " + coOrdinate.yCoOrdinate + " " + facedDirection);
        MarsRover marsRoverTwo = new MarsRover(3, 3, Position.Direction.E);
        marsRoverTwo.navigatingAsPerInstruction("MMRMMRMRRM");
        System.out.println(coOrdinate.xCordinate + " " + coOrdinate.yCoOrdinate + " " + facedDirection);
    }
}


