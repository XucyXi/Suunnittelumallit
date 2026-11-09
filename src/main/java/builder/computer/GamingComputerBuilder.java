package builder.computer;

public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i7-12700");
    }

    @Override
    public void buildRAM() {
        computer.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("2TB Samsung 990 Pro M.2 NVMe SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Asus GeForce RTX 5070 Ti OC");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}