import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime dateTime;

    Event(String name, LocalDateTime dateTime) {
        this.setName(name);
        this.setDateTime(dateTime);
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
