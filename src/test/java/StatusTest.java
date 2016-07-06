import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class StatusTest {
    @Test
    public void testStatus() {
        assertNotNull(Status.valueOf("ON"));
        assertNotNull(Status.valueOf("OFF"));
    }
}
