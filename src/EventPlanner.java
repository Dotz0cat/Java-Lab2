import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] argv) {
        JFrame frame = new JFrame("Event Planner");
        EventListPanel eventList = new EventListPanel();
        addDefaultEvents(eventList);
        frame.getContentPane().add(eventList);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void addDefaultEvents(EventListPanel events) {
        LocalDateTime start = LocalDateTime.of(2024, 9, 20, 15, 20);
        LocalDateTime end = LocalDateTime.of(2024, 9, 20, 15, 50);
        LocalDateTime dueDate = LocalDateTime.of(2024, 9, 25, 15, 0);
        Meeting meeting = new Meeting("FirstMeeting", start, end, "MSC 339");
        Deadline deadline = new Deadline("Lab due", dueDate);
        events.addEvent(meeting);
        events.addEvent(deadline);
    }
}

