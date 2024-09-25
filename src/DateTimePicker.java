import javax.swing.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

public class DateTimePicker extends JPanel {
    private final static String[] MONTHS = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"};

    private JSpinner monthPicker;
    private JSpinner day;
    private JSpinner year;
    private JSpinner hour;
    private JSpinner minute;

    DateTimePicker() {
        super();

        this.monthPicker = new JSpinner(new SpinnerListModel(MONTHS));
        this.day = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        this.year = new JSpinner(new SpinnerNumberModel(2000, 2000, 9999, 1));
        this.hour = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        this.minute = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1));

        this.add(monthPicker);
        this.add(day);
        this.add(year);
        this.add(hour);
        this.add(minute);
    }

    public LocalDateTime getDateTime() {
        LocalDateTime dateTime;

        String selectedMonth = ((String) this.monthPicker.getValue()).toUpperCase();
        int selectedDay = (int) this.day.getValue();
        int selectedYear = (int)this.year.getValue();
        int selectedHour = (int) this.hour.getValue();
        int selectedMinute = (int) this.minute.getValue();

        dateTime = LocalDateTime.of(selectedYear, Month.valueOf(selectedMonth), selectedDay, selectedHour, selectedMinute);
        return dateTime;
    }
}
