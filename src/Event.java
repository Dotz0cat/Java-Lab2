import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime dateTime;

    protected final DateTimeFormatter TIMEFORMAT;

    Event(String name, LocalDateTime dateTime) {
        this.setName(name);
        this.setDateTime(dateTime);
        TIMEFORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Event e) {
        return dateTime.compareTo(e.getDateTime());
    }

    public abstract String getDisplayName();
    public abstract String[] getDisplayStrings();
}
