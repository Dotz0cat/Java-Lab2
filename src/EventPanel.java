import javax.swing.*;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    EventPanel(Event event) {
        super();

        this.setEvent(event);
        this.completeButton = new JButton();
    }

    public Event getEvent() {
        return event;
    }

    private void setEvent(Event event) {
        this.event = event;
    }

    public void updateUrgency() {
        return;
    }
}

