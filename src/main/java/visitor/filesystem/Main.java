package visitor.filesystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create file system structure
        Directory rootDir = new Directory("Root");
        Directory srcDir = new Directory("src");
        Directory assetsDir = new Directory("assets");

        srcDir.addElement(new File("Main.java", 0.05));
        srcDir.addElement(new File("PlayerController.java", 0.12));

        assetsDir.addElement(new File("hero_sprite.png", 2.5));
        assetsDir.addElement(new File("background.png", 5.8));
        assetsDir.addElement(new File("theme_song.mp3", 4.2));

        rootDir.addElement(srcDir);
        rootDir.addElement(assetsDir);
        rootDir.addElement(new File("README.md", 0.01));

        // Test SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        rootDir.accept(sizeVisitor);
        System.out.println("Total size of the file system: " + sizeVisitor.getTotalSize() + " MB");

        // Test SearchVisitor
        String searchString = ".png";
        SearchVisitor searchVisitor = new SearchVisitor(searchString);
        rootDir.accept(searchVisitor);

        System.out.println("\nSearch results for '" + searchString + "':");
        List<File> foundFiles = searchVisitor.getFoundFiles();
        for (File file : foundFiles) {
            System.out.println("- " + file.getName() + " (" + file.getSize() + " MB)");
        }
    }
}