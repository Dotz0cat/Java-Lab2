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

        //set a grid layout
        this.setLayout(new GridLayout(0, 2));

        //make the entry fields and labels for them
        this.nameField = new JTextField();
        this.nameFieldLabel = new JLabel("Name:");
        this.startTimeField = new DateTimePicker();
        this.startTimeFieldLabel = new JLabel("Start Time:");
        this.endTimeField = new DateTimePicker();
        this.endTimeFieldLabel = new JLabel("End Time:");
        this.locationField = new JTextField();
        this.locationFieldLabel = new JLabel("Location:");

        //add the namefield and it label to the JPanel
        this.add(this.nameFieldLabel);
        this.add(this.nameField);

        //add the startTime field and its label to the JPanel
        this.add(this.startTimeFieldLabel);
        this.add(this.startTimeField);

        //add the endTime field and its label to the JPanel
        this.add(this.endTimeFieldLabel);
        this.add(this.endTimeField);

        //add the location field and its label to the JPanel
        this.add(this.locationFieldLabel);
        this.add(this.locationField);
    }

    @Override
    public Event getEvent() {
        String name;
        LocalDateTime startTime;
        LocalDateTime endTime;
        String location;

        //get the data from the fields in the JPanel
        name = this.nameField.getText();
        startTime = this.startTimeField.getDateTime();
        endTime = this.endTimeField.getDateTime();
        location = this.locationField.getText();

        //make a new meeting with that data
        return new Meeting(name, startTime, endTime, location);
    }
}
