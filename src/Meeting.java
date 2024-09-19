import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.setEndDateTime(end);
        this.setLocation(location);
    }

    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Duration getDuration() {
        return Duration.between(this.getDateTime(), this.endDateTime);
    }

    public String getLocation() {
        return location;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

