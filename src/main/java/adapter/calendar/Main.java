package adapter.calendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Calendar Adapter Test ---");

        // We only interact with our clean interface
        NewDateInterface date = new CalendarToNewDateAdapter();

        // Set the date to February 28, 2024 (Leap Year)
        date.setYear(2024);
        date.setMonth(2); // Client uses standard 2 for February
        date.setDay(28);

        System.out.println("Initial Date: " + formatDate(date));

        // Advance by 2 days. Because 2024 is a leap year, this should perfectly roll over to March 1st.
        int daysToAdvance = 2;
        System.out.println("Advancing by " + daysToAdvance + " days...");
        date.advanceDays(daysToAdvance);

        System.out.println("New Date:     " + formatDate(date));
    }

    // A small helper method just to print the date cleanly
    private static String formatDate(NewDateInterface date) {
        // Format: DD-MM-YYYY
        return String.format("%02d-%02d-%04d", date.getDay(), date.getMonth(), date.getYear());
    }
}