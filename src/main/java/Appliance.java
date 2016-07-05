import java.util.List;

public interface Appliance {
    public void setName(String name);
    public String getName();
    public void setStatus(Status status);
    public Status getStatus();
    public void setAutoOffTime(Integer time);
    public Integer getAutoOffTime();
    public List<Event> getEventQueue();
}
