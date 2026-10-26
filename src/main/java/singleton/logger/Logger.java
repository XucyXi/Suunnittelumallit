package singleton.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;

    private PrintWriter writer;
    private String fileName;

    private Logger() {
        this.fileName = "default_log.txt";
        openFile(this.fileName);
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void openFile(String file) {
        try {
            writer = new PrintWriter(new FileWriter(file, true), true);
            System.out.println("[System] Log file opened: " + file);
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
        }
    }

    public void setFileName(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile(this.fileName);
    }

    public void write(String message) {
        if (writer != null) {
            writer.println(message);
        } else {
            System.err.println("Logger is not open. Cannot write: " + message);
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
            System.out.println("[System] Log file closed.");
        }
    }
}