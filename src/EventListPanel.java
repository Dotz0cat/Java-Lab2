import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel controlPanel;
    private JPanel displayPanel;
    private JComboBox sortDropDown;
    private JCheckBox filterDisplay;
    private JButton addEventButton;

    EventListPanel() {
        super();

        this.events = new ArrayList<Event>();
        this.controlPanel = new JPanel();
        this.displayPanel = new JPanel();
        this.sortDropDown = new JComboBox();
        this.filterDisplay = new JCheckBox();
        this.addEventButton = new JButton();

        //sortDropDown needs to be implemented with a lambda
        this.sortDropDown.addActionListener(actionEvent -> {

        });

        //filterDisplay needs to be implemented with an anonymous class
        this.filterDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }

    public void addEvent(Event event) {
        this.events.add(event);

        EventPanel newEvent = new EventPanel(event);
        this.displayPanel.add(newEvent);
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

