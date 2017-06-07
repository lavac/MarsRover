import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class PositionTest {
    @Test
    public void instanceOfPositionWithSameValuesAreSame() {
        Position.Location positionOne=new Position.Location(1, 2);
        Position.Location positionTwo=new Position.Location(1, 2);
        assertTrue(positionTwo.equals(positionOne));
    }


}
