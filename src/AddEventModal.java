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

        //make this a modal dialog
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        //make the components of the dialog
        this.displayArea = new JPanel();
        this.tabbedPane = new JTabbedPane();
        this.buttonPanel = new JPanel();
        this.exit = new JButton("Exit");
        this.save = new JButton("Save");

        //use a quick gridlayout for the JPanel that is added to the dialog
        //JDialog behaves like a JFrame so it needs a JPanel to have more than 1 component
        this.displayArea.setLayout(new GridLayout(0, 1));

        //add both a meeting and deadline tab
        this.tabbedPane.addTab("Deadline", new DeadlineModal());
        this.tabbedPane.addTab("Meeting", new MeetingModal());

        //add the tabbed pane to the display area
        this.displayArea.add(this.tabbedPane);

        //handler for the exit button
        //it exits without saving the event
        this.exit.addActionListener(e -> {
            setVisible(false);
        });

        //handler for the save button
        //it saves the event by calling prepareEvent()
        this.save.addActionListener(e -> {
            prepareEvent();
            setVisible(false);
        });

        //add the buttons to their own panel
        this.buttonPanel.add(this.exit);
        this.buttonPanel.add(this.save);

        //add that panel to the display area
        this.displayArea.add(buttonPanel);

        //add the display area panel to the dialog itself
        this.add(this.displayArea);
    }
    
    public Event getEvent() {
        //gets the event that was made when the save button was pressed
        //returns null if exit was pressed
        //EventListPanel handles nulls
        return event;
    }

    private void prepareEvent() {
        //get the selected component of the tabbed pane
        Component selectedComponent = this.tabbedPane.getSelectedComponent();

        //if that component is an ModalSelector then get the event from it
        //it must be as that is all that is added to the tabbed pane
        if (selectedComponent instanceof ModalSelector) {
            this.event = ((ModalSelector) selectedComponent).getEvent();
        }
    }
}

