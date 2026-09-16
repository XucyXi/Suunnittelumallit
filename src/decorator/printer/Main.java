package decorator.printer;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Basic Printer ---");
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        System.out.println("\n--- XML Printer ---");
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        System.out.println("\n--- XML Encrypted Printer (Order Swapped) ---");
        Printer printer3 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer3.print("Hello World!");
    }
}