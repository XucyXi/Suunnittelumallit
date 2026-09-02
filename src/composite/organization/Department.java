package composite.organization;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private final List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        // Loop through everything in this department and ask for its salary
        for (OrganizationComponent component : components) {
            totalSalary += component.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String toXML(String indent) {
        StringBuilder xml = new StringBuilder();

        xml.append(indent).append("<Department name=\"").append(name).append("\">\n");

        // Ask every child component to print its own XML, adding extra indentation
        for (OrganizationComponent component : components) {
            xml.append(component.toXML(indent + "    "));
        }

        xml.append(indent).append("</Department>\n");

        return xml.toString();
    }
}