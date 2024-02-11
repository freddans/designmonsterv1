package exercises.facade.interfaces;

public interface Services {
  public int getAssetAmount(String userId);

  public void buy(String userId, int amount);
}
