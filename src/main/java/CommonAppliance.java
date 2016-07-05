import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CommonAppliance implements Appliance {
    protected String name;
    protected Status status;
    protected Integer autoOffTime;
    protected List<Event> eventQueue;

    CommonAppliance() {
        this.status = Status.OFF;
        this.eventQueue = new ArrayList<Event>();
        this.autoOffTime = 0;
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
