package observer.weather;

public class WeatherDisplay implements Observer {
    private final String name;
    private final WeatherStation station;

    public WeatherDisplay(String name, WeatherStation station) {
        this.name = name;
        this.station = station;
    }

    @Override
    public void update() {
        System.out.println(name + " reports: The current temperature is now " + station.getTemperature() + "°C");
    }
}