import javax.swing.*;
import java.awt.*;
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

    private final Font FONT = new Font("Sans Serif", Font.BOLD, 16);


    EventListPanel() {
        super();

        //use a gridBagLayout for eventListPanel
        this.setLayout(new GridBagLayout());

        // Make the instance variables
        this.events = new ArrayList<Event>();
        this.controlPanel = new JPanel();
        this.displayPanel = new JPanel();
        this.sortDropDown = new JComboBox<String>(SORT_OPTIONS);
        this.filterDisplay = new ArrayList<JCheckBox>();
        this.addEventButton = new JButton("Add Event");

        //layout constraints for controlPanel
        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.weightx = 1.0;
        controlPanelConstraints.gridy = 0;
        controlPanelConstraints.anchor = GridBagConstraints.PAGE_START;
        controlPanelConstraints.fill = GridBagConstraints.HORIZONTAL;

        // add controlPanel with layout constraints
        this.add(controlPanel, controlPanelConstraints);

        //layout constraints for displayPanel
        GridBagConstraints displayPanelConstraints = new GridBagConstraints();
        displayPanelConstraints.weightx = 1.0;
        displayPanelConstraints.weighty = 1.0;
        displayPanelConstraints.gridy = 1;
        displayPanelConstraints.fill = GridBagConstraints.BOTH;

        // add displayPanel with constraints
        this.add(displayPanel, displayPanelConstraints);

        //set the layout manager for controlPanel
        this.controlPanel.setLayout(new GridBagLayout());

        //set the font of addEventButton and sortDropDown
        this.addEventButton.setFont(this.FONT);
        this.sortDropDown.setFont(this.FONT);

        GridBagConstraints buttonDropDownConstraints = new GridBagConstraints();
        buttonDropDownConstraints.fill = GridBagConstraints.HORIZONTAL;
        buttonDropDownConstraints.anchor = GridBagConstraints.PAGE_START;
        buttonDropDownConstraints.gridy = 0;
        buttonDropDownConstraints.weightx = 1.0;

        //add the addEventButton and sortDropDown to controlPanel
        this.controlPanel.add(this.addEventButton, buttonDropDownConstraints);
        this.controlPanel.add(this.sortDropDown, buttonDropDownConstraints);

        //add the actionListener for addEventButton
        this.addEventButton.addActionListener(new addEventButtonListener());

        //sortDropDown needs to be implemented with a lambda
        this.sortDropDown.addActionListener(actionEvent -> {

        });

        //the layout contraints for the filters
        GridBagConstraints filterConstraints = new GridBagConstraints();
        filterConstraints.gridy = 1;

        //add the checkboxes for filterDisplay
        for (String filter : FILTERS) {
            JCheckBox filterBox = new JCheckBox(filter);
            filterBox.setFont(this.FONT);
            //filterDisplay needs to be implemented with an anonymous class
            filterBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    updateDisplay();
                }
            });
            this.filterDisplay.add(filterBox);
            this.controlPanel.add(filterBox, filterConstraints);
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

