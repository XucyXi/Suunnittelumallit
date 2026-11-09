package builder.computer;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build a Gaming PC
        System.out.println("--- Assembling Gaming PC ---");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.setBuilder(gamingBuilder);
        director.constructComputer();

        Computer gamingPC = gamingBuilder.getComputer();
        System.out.println(gamingPC);

        // Build an Office PC
        System.out.println("--- Assembling Office PC ---");
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.setBuilder(officeBuilder);
        director.constructComputer();

        Computer officePC = officeBuilder.getComputer();
        System.out.println(officePC);
    }
}