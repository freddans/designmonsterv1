package exercises.singleton.classes;

import java.io.*;
import java.util.Properties;

public class Singleton {
  // var
  private static Singleton instance;
  private static final String CONFIG_FILE = "src/exercises/singleton/files/file.cfg";
  private static Properties properties = new Properties();

  // Constructor
  public Singleton() {
    loadCfgFile();
  }

  // Singleton
  // Synchronized for "treadsafe"(trådfri)
  public static synchronized Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  // Methods

  // Load CFG-file
  private void loadCfgFile() {
    try (InputStream input = new FileInputStream(CONFIG_FILE)) {
      properties.load(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Get CFG-info (read)
  public String read(String key) {
    return properties.getProperty(key);
  }

  // save info to CFG-file
  public void save(String key, String value) {
    properties.setProperty(key, value);
    try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
      properties.store(output, null);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
