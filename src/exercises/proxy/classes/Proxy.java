package exercises.proxy.classes;

import java.util.ArrayList;
import java.util.Date;

public class Proxy {
  // properties
  private FileSystem fileSystem = FileSystem.getInstance();
  private Logger logger = Logger.getInstance();
  private ArrayList<String> badWords;

  public Proxy() {
    this.badWords = new ArrayList<>();
  }

  // Methods
  public void write(String key, String msg) {
    try {
      checkForBadWords(msg);
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

  // profanity filter
  public void addBadWord(String word) {
    badWords.add(word);
  }

  public void removeBadWord(String word) {
    badWords.remove(word);
  }

  public void checkForBadWords(String msg) {
    for (String badWord : badWords) {
      if (msg.contains(badWord)) {
        logActivity("WRITE", "Message contains forbidden word: " + badWord);
        throw new InvalidLanguageException("Message contains forbidden word: " + badWord);
      }
    }
  }
}
