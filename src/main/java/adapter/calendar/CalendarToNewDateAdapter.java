package adapter.calendar;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    // The "Adaptee" - the legacy class we are hiding
    private final Calendar calendar;

    public CalendarToNewDateAdapter() {
        this.calendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Calendar months are 0-indexed (Jan = 0, Dec = 11).
        // We subtract 1 so the client can use standard 1-12.
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Add 1 to convert it back to standard 1-12 for the client
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        // The old Calendar class uses the 'add' method to jump forward in time
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}