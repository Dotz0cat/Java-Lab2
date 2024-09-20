import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel controlPanel;
    private JPanel displayPanel;
    private JComboBox<String> sortDropDown;
    private ArrayList<JCheckBox> filterDisplay;
    private JButton addEventButton;

    private final String[] SORT_OPTIONS = {"Name Ascending", "Date Ascending",
        "Name Descending", "Date Descending"};
    private final String[] FILTERS = {"Complete Tasks", "Deadlines", "Meetings"};


    EventListPanel() {
        super();

        this.events = new ArrayList<Event>();
        this.controlPanel = new JPanel();
        this.displayPanel = new JPanel();
        this.sortDropDown = new JComboBox<String>(SORT_OPTIONS);
        this.filterDisplay = new ArrayList<JCheckBox>();
        this.addEventButton = new JButton("Add Event");

        this.add(controlPanel);
        this.add(displayPanel);

        this.controlPanel.add(this.addEventButton);
        this.controlPanel.add(this.sortDropDown);

        //sortDropDown needs to be implemented with a lambda
        this.sortDropDown.addActionListener(actionEvent -> {

        });

        for (String filter : FILTERS) {
            JCheckBox filterBox = new JCheckBox(filter);
            //filterDisplay needs to be implemented with an anonymous class
            filterBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    updateDisplay();
                }
            });
            this.filterDisplay.add(filterBox);
            this.controlPanel.add(filterBox);
        }
    }

    public void addEvent(Event event) {
        this.events.add(event);

        this.updateDisplay();
    }

    private boolean isFiltered(Event event) {
        for (JCheckBox filter : filterDisplay) {
            if (filter.isSelected()) {
                switch (filter.getText()) {
                    case "Complete Tasks":
                        if (event instanceof Completable) {
                            return ((Completable) event).isComplete();
                        }
                        break;
                    case "Deadlines":
                        if (event instanceof Deadline) {
                            return true;
                        }
                        break;
                    case "Meetings":
                        if (event instanceof Meeting) {
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    public void updateDisplay() {
        this.displayPanel.removeAll();
        for (Event e : this.events) {
            if (!this.isFiltered(e)) {
                this.displayPanel.add(new EventPanel(e));
            }
        }
        this.displayPanel.repaint();
        this.displayPanel.revalidate();
    }

    //the implementation for addEventButton was not specified, so I chose to
    //implement with an inner class
    private class addEventButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //needs to start an addEventModal
            //AddEventModal dialog = new AddEventModal();

//            //get data from it
//            Event event = mew deadline();
//
//            //send it to addEvent()
//            addEvent(event);

        }
    }
}

