package builder.computer;

public class OfficeComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i3-12100");
    }

    @Override
    public void buildRAM() {
        computer.setRam(8);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("256GB SATA SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Intel UHD Graphics 730");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}