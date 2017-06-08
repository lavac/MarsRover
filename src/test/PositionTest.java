import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PositionTest {
    @Test
    public void instanceOfPositionWithSameValuesAreSame() {
        Location positionOne = new Location(1, 2);
        Location positionTwo = new Location(1, 2);
        assertTrue(positionTwo.equals(positionOne));
    }
}
