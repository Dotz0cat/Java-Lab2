import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class DeadlineModal extends JPanel implements ModalSelector {
    private JTextField nameField;
    private JLabel nameFieldLabel;
    private DateTimePicker timeField;
    private JLabel timeFieldLabel;

    DeadlineModal() {
        super();

        //set a gridlayout for the JPanel
        this.setLayout(new GridLayout(0, 2));

        //make the fields and their labels
        this.nameFieldLabel = new JLabel("Name: ");
        this.nameField = new JTextField();
        this.timeFieldLabel = new JLabel("Deadline Date: ");
        this.timeField = new DateTimePicker();

        //add the fields and labels to the JPanel
        this.add(nameFieldLabel);
        this.add(nameField);
        this.add(timeFieldLabel);
        this.add(timeField);
    }

    public Event getEvent() {
        String name;
        LocalDateTime time;

        //get the data from the JPanel
        name = nameField.getText();
        time = timeField.getDateTime();

        //use that data to make a new deadline
        return new Deadline(name, time);
    }
}
