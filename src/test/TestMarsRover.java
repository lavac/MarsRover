import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMarsRover {

    @Test
    public void leftOfEastShouldBeNorth() {
        MarsRover marsRover = new MarsRover(1, 2, MarsRover.Direction.E);
        MarsRover.Direction expectedDirection = MarsRover.Direction.N;
        MarsRover.Direction.Rotation rotation = MarsRover.Direction.Rotation.L;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction(rotation));
    }

    @Test
    public void rightOfEastShouldBeSouth() {
        MarsRover marsRover = new MarsRover(1, 2, MarsRover.Direction.E);
        MarsRover.Direction expectedDirection = MarsRover.Direction.S;
        MarsRover.Direction.Rotation rotation = MarsRover.Direction.Rotation.R;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction(rotation));
    }


}
