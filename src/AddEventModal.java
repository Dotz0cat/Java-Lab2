import javax.swing.*;
import java.awt.*;

public class AddEventModal extends JDialog {
    private JPanel displayArea;
    private JTabbedPane tabbedPane;
    private JPanel buttonPanel;
    private JButton exit;
    private JButton save;
    private Event event;

    AddEventModal() {
        super();

        this.setModalityType(ModalityType.APPLICATION_MODAL);

        this.displayArea = new JPanel();
        this.tabbedPane = new JTabbedPane();
        this.buttonPanel = new JPanel();
        this.exit = new JButton("Exit");
        this.save = new JButton("Save");

        this.displayArea.setLayout(new GridLayout(0, 1));

        this.tabbedPane.addTab("Deadline", new DeadlineModal());
        this.tabbedPane.addTab("Meeting", new MeetingModal());

        this.displayArea.add(this.tabbedPane);

        this.exit.addActionListener(e -> {
            setVisible(false);
        });
        this.save.addActionListener(e -> {
            prepareEvent();
            setVisible(false);
        });

        this.buttonPanel.add(this.exit);
        this.buttonPanel.add(this.save);

        this.displayArea.add(buttonPanel);

        this.add(this.displayArea);
    }
    
    public Event getEvent() {
        return event;
    }

    private void prepareEvent() {
        Component selectedComponet = this.tabbedPane.getSelectedComponent();
        if (selectedComponet instanceof ModalSelector) {
            this.event = ((ModalSelector) selectedComponet).getEvent();
        }
    }
}

