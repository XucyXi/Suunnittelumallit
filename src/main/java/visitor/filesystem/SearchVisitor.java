package visitor.filesystem;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String searchCriterion;
    private final List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String searchCriterion) {
        this.searchCriterion = searchCriterion;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchCriterion)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Recursively visit all elements to find matches
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}