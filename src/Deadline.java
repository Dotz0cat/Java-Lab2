import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    boolean complete;

    Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
    }

    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }

    @Override
    public String getDisplayName() {
        return "Deadline";
    }

    @Override
    public String[] getDisplayStrings() {
        String[] strings = new String[3];
        strings[0] = this.getName();
        strings[1] = this.getDateTime().toString();
        strings[2] = this.isComplete() ? "Complete" : "Not Complete";
        return strings;
    }
}

