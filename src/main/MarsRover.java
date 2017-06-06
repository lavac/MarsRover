import java.util.HashMap;
import java.util.Map;

public class MarsRover {
    private Position.Location coOrdinate;
    private Position.Direction facedDirection;
    private Map<Position.Location, Position.Direction> navigationMap = new HashMap<>();

    MarsRover(int xCoOrdinate, int yCoordinate, Position.Direction facedDirection) {
        coOrdinate = new Position.Location(xCoOrdinate, yCoordinate);
        this.facedDirection = facedDirection;
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
        System.out.println("   " + rotation);
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

    public static void main(String args[]) {
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.N);
        marsRover.navigatingAsPerInstruction("LMLMLMLMM");
    }

     Position.Location getLocation() {
        return coOrdinate;
    }

     Position.Direction getDirection() {
        return facedDirection;
    }
}


