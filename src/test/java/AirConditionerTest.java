import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AirConditionerTest {
    @Test
    public void testAirConditionerConstructor() {
        AirConditioner airConditioner = new AirConditioner();
        assertEquals(airConditioner.name, "Air Conditioner");
    }
}
