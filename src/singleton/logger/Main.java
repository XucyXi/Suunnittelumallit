package singleton.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setFileName("new_log.txt");

        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        logger.close();

        System.out.println("Main method finished. Check your project folder for 'new_log.txt'!");
    }
}