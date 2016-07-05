import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WaterHeater implements Appliance {
    private String name;
    private Status status;
    private Integer autoOffTime;
    private List<Event> eventQueue;
    
    public WaterHeater() {
        this.name = "Water Heater";
        this.status = Status.OFF;
        this.autoOffTime = 0;
        this.eventQueue = new ArrayList<Event>();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setAutoOffTime(Integer time) {
        this.autoOffTime = time;
    }
    
    public Integer getAutoOffTime() {
        return this.autoOffTime;
    }
    
    public void addEvent(Event event) {
        eventQueue.add(event);
    }
    
    public void sortEventQueue() {
        // sorts events in the eventQueue by time
        Collections.sort(eventQueue, new Comparator<Event>() {
            public int compare(Event one, Event other) {
                return one.getTime().compareTo(other.getTime());
            }
        });
    }
    
    public List<Event> getEventQueue() {
        return this.eventQueue;
    }
}
