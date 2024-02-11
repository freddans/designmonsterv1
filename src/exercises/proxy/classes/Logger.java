package exercises.proxy.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
  private static Logger instance;
  private static final String FILE_NAME = "src/exercises/proxy/files/log.txt";

  public static synchronized Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }

  public void log(Date date, String activity, String msg) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
      writer.write("Logged on: " + date + System.lineSeparator() +  "Activity: " + activity + System.lineSeparator() + "Info: " + msg + System.lineSeparator() + System.lineSeparator());
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Error: Could not log activity.");
    }
  }

}
