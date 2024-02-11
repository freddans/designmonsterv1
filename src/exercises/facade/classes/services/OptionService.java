package exercises.facade.classes.services;

import exercises.facade.interfaces.Services;

import java.util.HashMap;
import java.util.Map;

public class OptionService implements Services {
  private Map<String, Integer> optionsList = new HashMap<>();

  @Override
  public int getAssetAmount(String userId) {
    return optionsList.getOrDefault(userId, 0);
  }

  @Override
  public void buy(String userId, int amount) {
    int currentOptions = optionsList.getOrDefault(userId, 0);
    optionsList.put(userId, currentOptions + amount);
  }
}
