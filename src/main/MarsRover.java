import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MarsRover {
    private static Position.Location coOrdinate;
    private static Position.Direction facedDirection;
    static Plateau plateau;
    private Map<Position.Location, Position.Direction> navigationMap = new HashMap<>();

    private MarsRover(int xCoOrdinate, int yCoordinate, Position.Direction facedDirection) {
        if (xCoOrdinate > plateau.getUpperXCordinate() || yCoordinate > plateau.getUpperYCordinate() || xCoOrdinate < 0 || yCoordinate < 0)
            throw new IndexOutOfBoundsException();
        coOrdinate = new Position.Location(xCoOrdinate, yCoordinate);
        if (facedDirection == null)
            throw new NullPointerException();
        MarsRover.facedDirection = facedDirection;
        initializeMap();
    }

    MarsRover(int xCoOrdinate, int yCoordinate, Position.Direction facedDirection, Plateau plateau) {
        if (xCoOrdinate > plateau.getUpperXCordinate() || yCoordinate > plateau.getUpperYCordinate() || xCoOrdinate < 0 || yCoordinate < 0)
            throw new IndexOutOfBoundsException();
        coOrdinate = new Position.Location(xCoOrdinate, yCoordinate);
        if (facedDirection == null)
            throw new NullPointerException();
        MarsRover.facedDirection = facedDirection;
        this.plateau = plateau;
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
                if (((coOrdinate.xCordinate += entry.getKey().xCordinate) > plateau.getUpperXCordinate()))
                    throw new IndexOutOfBoundsException();
                if (((coOrdinate.yCordinate += entry.getKey().yCordinate) > plateau.getUpperYCordinate()))
                    throw new IndexOutOfBoundsException();
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
        Scanner in = new Scanner(System.in);
        int xCordinate = in.nextInt();
        int yCordinate = in.nextInt();
        plateau = new Plateau(xCordinate, yCordinate);
        for(int rover = 1; rover <= 2; rover++) {
            int initialXCordinate = in.nextInt();
            int initialYCordinate = in.nextInt();
            String direction = in.next();
            Position.Direction intialDirection = Position.Direction.valueOf(direction);
            MarsRover marsRover = new MarsRover(initialXCordinate, initialYCordinate, intialDirection);
            String instruction = in.next();
            marsRover.navigatingAsPerInstruction(instruction);
            System.out.println(coOrdinate.xCordinate + " " + coOrdinate.yCordinate + " " + facedDirection);
        }
    }
}


