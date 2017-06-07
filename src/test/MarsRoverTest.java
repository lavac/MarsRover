import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MarsRoverTest {

    @Test
    public void leftOfEastShouldBeNorth() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E, plateau);
        Position.Direction expectedDirection = Position.Direction.N;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction("L"));
    }

    @Test
    public void rightOfEastShouldBeSouth() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E, plateau);
        Position.Direction expectedDirection = Position.Direction.S;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction("R"));
    }

    @Test
    public void shouldMoveOneGridPerMove() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E, plateau);
        marsRover.navigatingAsPerInstruction("M");
        Position.Location expectedLocation = new Position.Location(2,2);
        assertEquals(expectedLocation, marsRover.getLocation());
    }

    @Test
    public void locationOnPlateauShouldNotChangeWhenRoverRotates() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(1, 2, Position.Direction.E,plateau);
        marsRover.navigatingAsPerInstruction("RL");
        Position.Location expectedLocation = new Position.Location(1,2);
        assertEquals(expectedLocation, marsRover.getLocation());
    }

    @Test
    public void directionOfRoverShouldNotChangeWhenHeMove() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(1,2 , Position.Direction.E, plateau);
        marsRover.navigatingAsPerInstruction("MMM");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @Test
    public void shouldBeAbleToNavigate() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRoverOne = new MarsRover(1,2 , Position.Direction.N, plateau);
        marsRoverOne.navigatingAsPerInstruction("LMLMLMLMM");
        Position.Location expectedLocation = new Position.Location(1,3);
        Position.Direction expectedDirection = Position.Direction.N;
        assertEquals(expectedLocation, marsRoverOne.getLocation());
        assertEquals(expectedDirection, marsRoverOne.getDirection());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldNotBeAbleToNavigateOutOf() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(2, 2, Position.Direction.E,plateau);
        marsRover.navigatingAsPerInstruction("MMMMMMMMM");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void initialPositionShouldNotBeOutsideOfPlateau() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(5, 6, Position.Direction.E,plateau);
        marsRover.navigatingAsPerInstruction("MRL");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAcceptNull() {
        Plateau plateau = new Plateau(5,5);
        MarsRover marsRover = new MarsRover(1, 2, null,plateau);
        marsRover.navigatingAsPerInstruction("MRL");
        Position.Direction expectedDirection = Position.Direction.E;
        assertEquals(expectedDirection, marsRover.getDirection());

    }

}
