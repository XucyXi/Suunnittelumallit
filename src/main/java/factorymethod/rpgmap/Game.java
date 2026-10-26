package factorymethod.rpgmap;
import java.util.Random;

public class Game {
    public static Map createMap() {
        Random rand = new Random();

        if (rand.nextBoolean()) {
            System.out.println("Generating a City Map...");
            return new CityMap();
        } else {
            System.out.println("Generating a Wilderness Map...");
            return new WildernessMap();
        }
    }

    public static void main(String[] args) {
        Map myMap = createMap();

        myMap.display();
    }
}
