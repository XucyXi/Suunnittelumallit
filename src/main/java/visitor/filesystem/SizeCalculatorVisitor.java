package visitor.filesystem;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // Recursively visit all elements inside the directory
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public double getTotalSize() {
        return totalSize;
    }
}