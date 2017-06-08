import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MarsRoverTest {

    @Test
    public void leftOfEastShouldBeNorth() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        MarsRover marsRover = new MarsRover(location, Position.Direction.East, plateau);
        Position.Direction expectedDirection = Position.Direction.North;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction("L"));
    }

    @Test
    public void rightOfEastShouldBeSouth() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        MarsRover marsRover = new MarsRover(location, Position.Direction.East, plateau);
        Position.Direction expectedDirection = Position.Direction.South;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction("R"));
    }


    @Test
    public void locationOnPlateauShouldNotChangeWhenRoverRotates() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        MarsRover marsRover = new MarsRover(location, Position.Direction.East, plateau);
        marsRover.navigatingAsPerInstruction("RL");
        Location expectedLocation = new Location(1, 2);
        assertEquals(expectedLocation, marsRover.getLocation());
    }

    @Test
    public void directionOfRoverShouldNotChangeWhenHeMove() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(5, 5);
        MarsRover marsRover = new MarsRover(location, Position.Direction.East, plateau);
        marsRover.navigatingAsPerInstruction("MMM");
        Position.Direction expectedDirection = Position.Direction.East;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @Test
    public void shouldBeAbleToNavigate() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        MarsRover marsRoverOne = new MarsRover(location, Position.Direction.North, plateau);
        marsRoverOne.navigatingAsPerInstruction("LMLRM");
        Location expectedLocation = new Location(0, 2);
        Position.Direction expectedDirection = Position.Direction.West;
        assertEquals(expectedDirection, marsRoverOne.getDirection());
        assertEquals(expectedLocation, marsRoverOne.getLocation());
    }

    @Test
    public void shouldNeglectCommandWhichLeadsToOutOfBoundary() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(4, 4);
        MarsRover marsRover = new MarsRover(location, Position.Direction.East, plateau);
        marsRover.navigatingAsPerInstruction("MMM");
        Position.Direction expectedDirection = Position.Direction.East;
        Location expectedLocation = new Location(5, 4);
        assertTrue(expectedDirection.equals(marsRover.getDirection()));
        assertEquals(expectedLocation, marsRover.getLocation());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void initialPositionShouldNotBeOutsideOfPlateau() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(5, 6);
        MarsRover marsRover = new MarsRover(location, Position.Direction.East, plateau);
        marsRover.navigatingAsPerInstruction("MRL");
        Position.Direction expectedDirection = Position.Direction.East;
        assertEquals(expectedDirection, marsRover.getDirection());

    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAcceptNull() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        MarsRover marsRover = new MarsRover(location, null, plateau);
        marsRover.navigatingAsPerInstruction("MRL");
        Position.Direction expectedDirection = Position.Direction.East;
        assertEquals(expectedDirection, marsRover.getDirection());

    }

}
