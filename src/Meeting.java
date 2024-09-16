public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    public int getDuration() {
        return 0;
    }

    public String getLocation() {
        return location;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endDateTime = endTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

