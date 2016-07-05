public class Event {
    private Status status;
    private Integer time;
    
    public Event(Status status, Integer time) {
        this.status = status;
        this.time = time;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Integer getTime() {
        return this.time;
    }
    
    public void setTime(Integer time) {
        this.time = time;
    }
    
}
