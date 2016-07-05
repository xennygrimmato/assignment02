import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

public class CommonApplianceTest {
    @Test
    public void testCommonApplianceConstructor() {
        CommonAppliance another = new CommonAppliance();
        assertEquals(another.status, Status.OFF);
        assertEquals(another.autoOffTime, new Integer(0));
    }
    
    @Test
    public void testGetName() {
        CommonAppliance another = new CommonAppliance();
        assertEquals(another.getName(), "");
    }
    
    @Test
    public void testSetName() {
        CommonAppliance another = new CommonAppliance();
        another.setName("another");
        String expected = another.getName();
        assertEquals(expected, "another");
    }
    
    @Test
    public void testAddEvent() {
        CommonAppliance another = new CommonAppliance();
        another.addEvent(new Event(Status.ON, 10));
        Event expected = another.getEventQueue().get(0);
        assertEquals(expected.getClass(), (new Event(Status.ON, 10).getClass()));
        assertEquals(expected.getStatus(), (new Event(Status.ON, 10)).getStatus());
        assertEquals(expected.getTime(), (new Event(Status.ON, 10)).getTime());
    }
    
    @Test
    public void testSortEventQueue() {
        CommonAppliance another = new CommonAppliance();
        another.addEvent(new Event(Status.ON, 10));
        another.addEvent(new Event(Status.OFF, 2));
        another.addEvent(new Event(Status.ON, 1));
        another.addEvent(new Event(Status.ON, 19));
        another.sortEventQueue();
        List<Event> eventQueue = another.getEventQueue();
        for(int i = 0 ; i < eventQueue.size() - 1 ; i++) {
            assertTrue(eventQueue.get(i + 1).getTime() > eventQueue.get(i).getTime());
        }
    }
}
