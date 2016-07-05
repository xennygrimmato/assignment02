import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

public class SmartHomeTest {
    @Test
    public void testApplianceListInitialSize() {
        SmartHome testSmartHome = new SmartHome();
        assertEquals(testSmartHome.getApplianceList().size(), 0);
    }
    
    @Test
    public void testInitialTimer() {
        SmartHome testSmartHome = new SmartHome();
        assertEquals(testSmartHome.getTimer(), new Integer(0));
    }
    
    @Test
    public void testAddAppliance() {
        SmartHome testSmartHome = new SmartHome();
        AirConditioner ac = new AirConditioner();
        testSmartHome.addAppliance(ac);
        Appliance expected = testSmartHome.getApplianceList().get(0);
        assertEquals(ac, expected);
    }
    
    @Test
    public void testRemoveAppliance() {
        SmartHome testSmartHome = new SmartHome();
        AirConditioner ac = new AirConditioner();
        testSmartHome.addAppliance(ac);
        testSmartHome.getApplianceList().remove(0);
        assertEquals(testSmartHome.getApplianceList(), new ArrayList<Appliance>(0));
    }
    
    @Test
    public void testPrintStatus() {
        SmartHome testSmartHome = new SmartHome();
        AirConditioner ac = new AirConditioner();
        testSmartHome.addAppliance(ac);
        String applianceName = testSmartHome.getApplianceList().get(0).getName();
        Status applianceStatus = testSmartHome.getApplianceList().get(0).getStatus();
        assertEquals(applianceName, new String("Air Conditioner"));
        assertEquals(applianceStatus, Status.OFF);
    }
    
    @Test
    public void testTimer() {
        SmartHome testSmartHome = new SmartHome();
        testSmartHome.incrementTimer();
        Integer expectedTimer = testSmartHome.getTimer();
        assertEquals(expectedTimer, new Integer(1));
    }
    
    @Test
    public void testGetTimer() {
        SmartHome testSmartHome = new SmartHome();
        assertEquals(testSmartHome.getTimer().getClass(), Integer.class);
    }
    
    @Test
    public void testEventChange() {
        SmartHome testSmartHome = new SmartHome();
        assertEquals(false, testSmartHome.eventChange());
    }
}