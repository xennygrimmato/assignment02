import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WaterHeaterTest {
    @Test
    public void testWaterHeaterConstructor() {
        WaterHeater waterHeater = new WaterHeater();
        assertEquals(waterHeater.name, "Water Heater");
    }
}
