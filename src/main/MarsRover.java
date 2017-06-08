import java.util.HashMap;
import java.util.Map;


public class MarsRover {
    Location coOrdinate;
    Position.Direction facedDirection;
    Plateau plateau;
    private static final Map<Location, Position.Direction> navigationMap = new HashMap<>();
    private static final Map<Character, String> map =  new HashMap<>();
    //final static String MOVE = "M";


    public MarsRover(Location location, Position.Direction initialDirection, Plateau plateau) {
        this.plateau = plateau;
        if (!(location.checkLocationWithTheBoundaryValues(plateau)))
            throw new IndexOutOfBoundsException();
        coOrdinate = location;
        if (initialDirection == null)
            throw new NullPointerException();
        facedDirection = initialDirection;
        initializeMap();
    }

    private void initializeMap() {
        navigationMap.put(new Location(0, 1), Position.Direction.North);
        navigationMap.put(new Location(0, -1), Position.Direction.South);
        navigationMap.put(new Location(1, 0), Position.Direction.East);
        navigationMap.put(new Location(-1, 0), Position.Direction.West);
    }

    private void move() {
        for (Map.Entry<Location, Position.Direction> entry : navigationMap.entrySet()) {
            if (entry.getValue().equals(facedDirection)) {
                Location nextCoOrdinate = new Location((coOrdinate.xCordinate + entry.getKey().xCordinate), (coOrdinate.yCordinate + entry.getKey().yCordinate));
                if (nextCoOrdinate.checkLocationWithTheBoundaryValues(plateau))
                    coOrdinate = nextCoOrdinate;
                break;
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



    Location getLocation() {
                return coOrdinate;
            }

            Position.Direction getDirection () {
                return facedDirection;
            }

        }

