package exercises.adapter.classes;

import exercises.adapter.interfaces.Logger;
import exercises.adapter.interfaces.TextGenerator;

public class RandomTextGenerator implements TextGenerator {
  @Override
  public void createString(int length, Logger logger) {
    logger.log("FROM: RandomTextGenerator -> " + logger.getClass().getName());
  }
}
