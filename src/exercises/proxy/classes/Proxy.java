package exercises.proxy.classes;

import java.util.Date;

public class Proxy {
  // properties
  private FileSystem fileSystem = FileSystem.getInstance();
  private Logger logger = Logger.getInstance();

  // Methods
  public void write(String key, String msg) {
    try {
      fileSystem.save(key, msg);
      System.out.println("Added key: " + key + " with: " + msg);

      // add to logger
      logActivity("WRITE", key + " = " + msg);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void displayInfo(String key) {
    try {
      String info = fileSystem.read(key);
      System.out.println(info);

      // add to logger
      logActivity("READ", key + ": " + info);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void logActivity(String activity, String msg) {
    try {
      logger.log(new Date(), activity, msg);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
