import java.util.List;
import java.util.ArrayList;


public class SmartHome {
    private List<Appliance> applianceList;
    private Integer timer = 0;
    
    public SmartHome() {
        applianceList = new ArrayList<Appliance>();
        this.timer = 0;
    }
    
    public void addAppliance(Appliance appliance) {
        applianceList.add(appliance);
    }
    
    public void removeAppliance(Appliance appliance) {
        applianceList.remove(appliance);
    }
    
    public void printStatus() {
        // Prints status of each appliance in applianceList
        System.out.println("Time = " + this.timer);
        for(Appliance appliance : applianceList) {
            System.out.println(appliance.getName() + ": " + appliance.getStatus());
        }
        System.out.println("--------------------------");
    }
    
    public void incrementTimer() {
        this.timer ++;
    }
    
    public Integer getTimer() {
        return this.timer;
    }
    
    public boolean eventChange() {
        // check first event in each queue
        // if timestamp matches with timer, we have an event change: return true
        // if timestamp of no appliance matches with timer, return false
        boolean changeStatus = false;
        List<Event> eventList;
        for(Appliance appliance : applianceList) {
            eventList = appliance.getEventQueue();
            Event event;
            if(eventList.size() > 0) {
                event = eventList.get(0);
            } else {
                continue;
            }
            if(event.getTime() == this.timer) {
                changeStatus = true;
                appliance.setStatus(event.getStatus());
                appliance.getEventQueue().remove(0);
            }
        }
        return changeStatus;
    }
}
