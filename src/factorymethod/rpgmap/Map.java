package factorymethod.rpgmap;

public abstract class Map {
    protected Tile[][] grid;
    protected int size = 10;

    public Map() {
        grid = new Tile[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = createTile();
            }
        }
    }

    public abstract Tile createTile();

    public void display() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
