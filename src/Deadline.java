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
}

