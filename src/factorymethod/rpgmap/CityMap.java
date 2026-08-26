package factorymethod.rpgmap;
import java.util.Random;

public class CityMap extends Map {
    final private static Random rand = new Random();

    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);

        if (choice == 0) {
            return new RoadTile();
        } else if (choice == 1) {
            return new ForestTile();
        } else {
            return new BuildingTile();
        }
    }
}