import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lavanya on 6/5/17.
 */
public class TestMarsRover {
    @Test
    public void leftOfEastShouldBeNorth() {
        MarsRover marsRover = new MarsRover(1, 2, MarsRover.Direction.E);
        MarsRover.Direction expectedDirection = MarsRover.Direction.N;
        MarsRover.Direction.Rotation rotation = MarsRover.Direction.Rotation.L;
        assertEquals(expectedDirection, marsRover.navigatingAsPerInstruction(rotation));
    }
}
