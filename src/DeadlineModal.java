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

        this.setLayout(new GridLayout(0, 2));

        this.nameFieldLabel = new JLabel("Name: ");
        this.nameField = new JTextField();
        this.timeFieldLabel = new JLabel("Deadline Date: ");
        this.timeField = new DateTimePicker();

        this.add(nameFieldLabel);
        this.add(nameField);
        this.add(timeFieldLabel);
        this.add(timeField);
    }

    public Event getEvent() {
        String name;
        LocalDateTime time;
        name = nameField.getText();
        time = timeField.getDateTime();
        return new Deadline(name, time);
    }
}
