package exercises.facade.classes.services;

import exercises.facade.interfaces.Services;

import java.util.HashMap;
import java.util.Map;

public class FundService implements Services {
  private Map<String, Integer> fundsList = new HashMap<>();

  @Override
  public int getAssetAmount(String userId) {
    return fundsList.getOrDefault(userId, 0);
  }

  @Override
  public void buy(String userId, int amount) {
    int currentFunds = fundsList.getOrDefault(userId, 0);
    fundsList.put(userId, currentFunds + amount);
  }
}
