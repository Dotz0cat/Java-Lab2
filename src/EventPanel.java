import javax.swing.*;
import java.awt.event.ActionEvent;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    EventPanel(Event event) {
        super();

        this.setEvent(event);
        this.completeButton = new JButton("Complete Event");

        JLabel nameLabel = new JLabel(this.event.getDisplayName() + ": " + this.event.getName());
        this.add(nameLabel);

        for (String s : event.getDisplayStrings()) {
            JLabel label = new JLabel(s);
            this.add(label);
        }

        if (this.event instanceof Completable) {
            this.add(completeButton);
            this.completeButton.addActionListener((ActionEvent) -> {
                if (!((Completable) event).isComplete()) {
                    ((Completable) event).complete();
                    //graphical stuff
                    repaint();
                    revalidate();
                }
            });
        }
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

