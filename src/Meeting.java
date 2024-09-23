import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;

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

    @Override
    public String getDisplayName() {
        return "Meeting";
    }

    @Override
    public String[] getDisplayStrings() {
        String[] strings = new String[5];
        strings[0] = this.getDateTime().format(TIMEFORMAT);
        strings[1] = this.getEndDateTime().format(TIMEFORMAT);
        strings[2] = this.getLocation();
        strings[3] = this.getDuration().toMinutes() + " Minutes";
        strings[4] = this.isComplete() ? "Complete" : "Not Complete";
        return strings;
    }
}

