import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AirConditioner implements Appliance {
    private String name;
    private Status status;
    private Integer autoOffTime;
    private List<Event> eventQueue;
    
    AirConditioner() {
        this.name = "Air Conditioner";
        this.status = Status.OFF;
        this.eventQueue = new ArrayList<Event>();
        this.autoOffTime = 2;
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
