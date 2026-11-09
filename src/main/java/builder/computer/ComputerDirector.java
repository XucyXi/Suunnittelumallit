package builder.computer;

public class ComputerDirector {
    private ComputerBuilder builder;

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    // Executes the assembly sequence
    public void constructComputer() {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
    }
}