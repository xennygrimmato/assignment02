import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTest {
    @Test
    public void testMain() {
        String[] args = {""};
        Main.main(args);
    }
    
    @Test
    public void testFilePath() {
        Main.setFilePath("/projects/assignment02/src/main/inputx.txt");
        assertEquals(Main.getFilePath(), "/projects/assignment02/src/main/inputx.txt");
    }
    
    @Test
    public void testGetSmartHome() {
        Main.setMySmartHome(new SmartHome());
        assertEquals(Main.getSmartHome().getTimer(), new Integer(0));
    }
    
    @Test
    public void testIOException() {
        Main.setFilePath("/projects/assignment02/src/main/inputx.txt");
        String[] args = {""};
        Main.main(args);
    }
}
