import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
    public void shouldMoveOneGridPerMove() {
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E);
        marsRover.navigatingAsPerInstruction("M");
        Position.Location expectedLocation = new Position.Location(2,2);
        assertEquals(expectedLocation, marsRover.getLocation());
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
        MarsRover marsRover = new MarsRover(1,2 , Position.Direction.E);
        marsRover.navigatingAsPerInstruction("MMM");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @Test
    public void shouldBeAbleToNavigate() {
        MarsRover marsRoverOne = new MarsRover(1,2 , Position.Direction.N);
        marsRoverOne.navigatingAsPerInstruction("LMLMLMLMM");
        Position.Location expectedLocation = new Position.Location(1,3);
        Position.Direction expectedDirection = Position.Direction.N;
        assertEquals(expectedLocation, marsRoverOne.getLocation());
        assertEquals(expectedDirection, marsRoverOne.getDirection());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldNotBeAbleToNavigateOutOf() {
        MarsRover marsRover = new MarsRover(5, 6, Position.Direction.E);
        marsRover.navigatingAsPerInstruction("MRL");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAcceptNull() {
        MarsRover marsRover = new MarsRover(1, 2, null);
        marsRover.navigatingAsPerInstruction("MRL");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());

    }

}
