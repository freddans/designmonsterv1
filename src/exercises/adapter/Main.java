package exercises.adapter;

import exercises.adapter.classes.CurrentLogger;
import exercises.adapter.classes.LoggerAdapter;
import exercises.adapter.classes.RandomTextGenerator;

public class Main {
  public static void main(String[] args) {
    LoggerAdapter adapter = new LoggerAdapter();
    RandomTextGenerator rtg = new RandomTextGenerator();
    CurrentLogger oldLoggerSystem = new CurrentLogger();

    rtg.createString(1, adapter);

    System.out.println();

    rtg.createString(1, oldLoggerSystem);
  }
}
