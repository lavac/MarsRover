import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MarsRoverTest {

    @Test
    public void leftOfEastShouldBeNorth() {
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E);
        Position.Direction expectedDirection = Position.Direction.N;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction("L"));
    }

    @Test
    public void rightOfEastShouldBeSouth() {
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E);
        Position.Direction expectedDirection = Position.Direction.S;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction("R"));
    }


    @Test
    public void locationOnPlateauShouldNotChangeWhenRoverRotates() {
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E);
        marsRover.navigatingAsPerInstruction("RL");
        Position.Location expectedLocation = new Position.Location(1,2);
        assertEquals(expectedLocation, marsRover.getLocation());
    }

    @Test
    public void directionOfRoverShouldNotChangeWhenHeMove() {
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E);
        marsRover.navigatingAsPerInstruction("MMM");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

}
