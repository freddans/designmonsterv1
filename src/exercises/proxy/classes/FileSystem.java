package exercises.proxy.classes;

import java.io.*;
import java.util.Properties;

public class FileSystem {
  // var
  private static FileSystem instance;
  private Properties properties = new Properties();
  private final String CONFIG_FILE = "src/exercises/proxy/files/file.cfg";

  // Constructor
  public FileSystem() {
    loadFile();
  }

  // Methods
  // Singleton
  public static synchronized FileSystem getInstance() {
    if (instance == null) {
      instance = new FileSystem();
    }
    return instance;
  }

  // Load File
  private void loadFile() {
    try (InputStream input = new FileInputStream(CONFIG_FILE)) {
      properties.load(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Read File
  public String read(String key) {
    return properties.getProperty(key);
  }

  // Save
  public void save(String key, String value) {
    properties.setProperty(key, value);
    try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
      properties.store(output, null);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
