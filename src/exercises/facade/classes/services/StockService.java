package exercises.facade.classes.services;

import exercises.facade.interfaces.Services;

import java.util.HashMap;
import java.util.Map;

public class StockService implements Services {
  private Map<String, Integer> stocksList = new HashMap<>();

  @Override
  public int getAssetAmount(String userId) {
    return stocksList.getOrDefault(userId, 0);
  }

  @Override
  public void buy(String userId, int amount) {
    int currentStocks = stocksList.getOrDefault(userId, 0);
    stocksList.put(userId, currentStocks + amount);
  }
}
