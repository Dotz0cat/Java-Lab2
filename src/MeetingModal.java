import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class MeetingModal extends JPanel implements ModalSelector {
    private JTextField nameField;
    private JLabel nameFieldLabel;
    private DateTimePicker startTimeField;
    private JLabel startTimeFieldLabel;
    private DateTimePicker endTimeField;
    private JLabel endTimeFieldLabel;
    private JTextField locationField;
    private JLabel locationFieldLabel;

    MeetingModal() {
        super();

        this.setLayout(new GridLayout(0, 2));

        this.nameField = new JTextField();
        this.nameFieldLabel = new JLabel("Name:");
        this.startTimeField = new DateTimePicker();
        this.startTimeFieldLabel = new JLabel("Start Time:");
        this.endTimeField = new DateTimePicker();
        this.endTimeFieldLabel = new JLabel("End Time:");
        this.locationField = new JTextField();
        this.locationFieldLabel = new JLabel("Location:");

        this.add(nameFieldLabel);
        this.add(nameField);

        this.add(startTimeFieldLabel);
        this.add(startTimeField);

        this.add(endTimeFieldLabel);
        this.add(endTimeField);

        this.add(locationFieldLabel);
        this.add(locationField);
    }

    @Override
    public Event getEvent() {
        String name;
        LocalDateTime startTime;
        LocalDateTime endTime;
        String location;

        name = this.nameField.getText();
        startTime = this.startTimeField.getDateTime();
        endTime = this.endTimeField.getDateTime();
        location = this.locationField.getText();
        return new Meeting(name, startTime, endTime, location);
    }
}
