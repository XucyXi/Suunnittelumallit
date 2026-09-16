package decorator.printer;

public abstract class PrinterDecorator implements Printer {
    protected Printer wrappedPrinter;

    public PrinterDecorator(Printer printer) {
        this.wrappedPrinter = printer;
    }

    @Override
    public void print(String message) {
        wrappedPrinter.print(message);
    }
}