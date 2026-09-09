package observer.weather;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Weather Simulator ---");

        WeatherStation station = new WeatherStation();

        Observer newsChannel = new WeatherDisplay("Channel 4 News", station);
        Observer mobileApp = new WeatherDisplay("Metropolia Weather App", station);
        Observer aviationControl = new WeatherDisplay("Airport Traffic Control", station);

        station.addObserver(newsChannel);
        station.addObserver(mobileApp);
        station.addObserver(aviationControl);

        station.start();

        try {
            Thread.sleep(12000);

            System.out.println("\n--- ACTION: User uninstalled the Mobile Weather App ---");
            station.removeObserver(mobileApp);

            Thread.sleep(12000);

            station.stopStation();
            System.out.println("\n--- Simulation Ended ---");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}