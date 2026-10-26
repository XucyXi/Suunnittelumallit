package composite.organization;

public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component.");
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component.");
    }

    public abstract double getSalary();
    public abstract String toXML(String indent);
}