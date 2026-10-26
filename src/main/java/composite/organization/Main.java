package composite.organization;

public class Main {
    public static void main(String[] args) {
        Department headOffice = new Department("Head Office");
        Department engineering = new Department("Engineering");
        Department hr = new Department("Human Resources");

        headOffice.add(engineering);
        headOffice.add(hr);

        engineering.add(new Employee("Alice (Lead Dev)", 90000));
        engineering.add(new Employee("Bob (Dev)", 75000));

        hr.add(new Employee("Charlie (Recruiter)", 60000));

        headOffice.add(new Employee("Diana (CEO)", 150000));

        System.out.println("--- TOTAL ORGANIZATION SALARY ---");
        System.out.println("$" + headOffice.getSalary());

        System.out.println("\n--- ORGANIZATION XML STRUCTURE ---");
        System.out.println(headOffice.toXML(""));
    }
}