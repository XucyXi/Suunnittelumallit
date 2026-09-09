package observer.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private int temperature;
    private final Random random = new Random();

    private final int MIN_TEMP = -30;
    private final int MAX_TEMP = 40;

    private volatile boolean running = true;

    public WeatherStation() {
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        System.out.println("Weather Station initialized at " + temperature + "°C");
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void stopStation() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                int sleepTime = random.nextInt(4000) + 1000;
                Thread.sleep(sleepTime);

                int change = random.nextInt(3) - 1;
                temperature += change;

                if (temperature < MIN_TEMP) temperature = MIN_TEMP;
                if (temperature > MAX_TEMP) temperature = MAX_TEMP;

                System.out.println("\n[WeatherStation] Temperature updated to " + temperature + "°C");

                notifyObservers();

            } catch (InterruptedException e) {
                System.out.println("Weather station thread interrupted.");
                running = false;
            }
        }
    }
}