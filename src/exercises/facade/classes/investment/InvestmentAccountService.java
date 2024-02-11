package exercises.facade.classes.investment;

public class InvestmentAccountService {
  // var
  private static InvestmentAccountService instance;
  private int availableFunds = 10_000;

  // Constructor
  public InvestmentAccountService() {
  }

  // Threadsafe singleton
  public static synchronized InvestmentAccountService getInstance() {
    if (instance == null) {
      instance = new InvestmentAccountService();
    }
    return instance;
  }

  // Methods
  public void useAmount(int amount) {
      this.availableFunds -= amount;
  }

  // Getters and Setters
  public int getAvailableFunds(String userId) {
    return availableFunds;
  }

}
