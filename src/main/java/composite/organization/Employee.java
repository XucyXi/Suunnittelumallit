package composite.organization;

public class Employee extends OrganizationComponent {
    private final double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toXML(String indent) {
        return indent + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />\n";
    }
}