import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CookingOvenTest {
    @Test
    public void testCookingOvenConstructor() {
        CookingOven cookingOven = new CookingOven();
        assertEquals(cookingOven.name, "Cooking Oven");
    }
    
    @Test
    public void testAutoOffTime() {
        CookingOven cookingOven = new CookingOven();
        cookingOven.setAutoOffTime(1);
        assertEquals(cookingOven.getAutoOffTime(), new Integer(1));
    }
}
