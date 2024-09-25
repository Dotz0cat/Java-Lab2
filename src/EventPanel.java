import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    private final Font FONT = new Font("Sans Serif", Font.BOLD, 16);

    EventPanel(Event event) {
        super();

        //set the layout for the eventPanel
        this.setLayout(new GridLayout(0, 1));

        this.setBackground(Color.green);

        //set the event and make a button
        this.setEvent(event);
        this.completeButton = new JButton("Complete Event");

        //set the font for completeButton
        this.completeButton.setFont(this.FONT);

        //add Listener to completeButton
        this.completeButton.addActionListener((ActionEvent) -> {
            if ((event instanceof Completable) &&
                    !((Completable) event).isComplete()) {

                ((Completable) event).complete();
                this.updateDisplay();
            }
        });

        //updates the display
        //adds the text and adds completeButton if Completable
        updateDisplay();
    }

    public Event getEvent() {
        return event;
    }

    private void setEvent(Event event) {
        this.event = event;
    }

    //not implemented
    public void updateUrgency() {
        return;
    }

    private void updateDisplay() {
        //clears the panel so new elements can be added
        this.removeAll();

        //adds the name and type of event
        //ex. Meeting: FirstMeeting
        JLabel nameLabel = new JLabel(this.event.getDisplayName() + ": " + this.event.getName());
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(this.FONT);
        this.add(nameLabel);

        //adds the Strings returned from getDisplayStrings
        for (String s : event.getDisplayStrings()) {
            JLabel label = new JLabel(s);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(this.FONT);
            this.add(label);
        }

        //adds completeButton if the event is Completable
        if (this.event instanceof Completable) {
            this.add(this.completeButton);
        }

        //Graphics magic to make everything display right
        this.repaint();
        this.revalidate();
    }
}

