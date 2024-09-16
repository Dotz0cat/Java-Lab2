public class Deadline extends Event implements Completable {
    boolean complete;

    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }
}

