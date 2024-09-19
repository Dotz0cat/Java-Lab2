import javax.swing.*;

public class EventPlanner {
    public static void main(String[] argv) {
        System.out.printf("I am supposed to be graphical\n");

        JFrame frame = new JFrame("Event Planner");
        EventListPanel eventList = new EventListPanel();
        frame.getContentPane().add(eventList);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void addDefaultEvents(EventPanel events) {
        return;   
    }
}

