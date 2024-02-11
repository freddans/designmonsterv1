package exercises.facade.classes.investment;

import exercises.facade.classes.services.FundService;
import exercises.facade.classes.services.OptionService;
import exercises.facade.classes.services.StockService;

import java.util.HashMap;
import java.util.Map;

public class InvestmentFacade {
  private FundService fundService;
  private OptionService optionService;
  private StockService stockService;
  private InvestmentAccountService accountService;

  // Constructor


  public InvestmentFacade() {
    this.fundService = new FundService();
    this.optionService = new OptionService();
    this.stockService = new StockService();
    this.accountService = InvestmentAccountService.getInstance();
  }

  public Map<String, Integer> getAssets(String userId) {
    Map<String, Integer> assets = new HashMap<>();
    assets.put("Funds", fundService.getAssetAmount(userId));
    assets.put("Options", optionService.getAssetAmount(userId));
    assets.put("Stocks", stockService.getAssetAmount(userId));
    return assets;
  }

  public void invest(String userId, String type, int amount) {
    int availableFunds = accountService.getAvailableFunds(userId);

    if (amount <= availableFunds) {
      if (type.contains("Funds")) {
        fundService.buy(userId, amount);
        accountService.useAmount(amount);
//        return true;

      } else if (type.contains("Options")) {
        optionService.buy(userId, amount);
        accountService.useAmount(amount);
//        return true;

      } else if (type.contains("Stocks")) {
        stockService.buy(userId, amount);
        accountService.useAmount(amount);
//        return true;

      } else {
        System.out.println("Write 1 of three types: Fund, Option or Stock");
//        return false;

      }
    } else {
      System.out.println("Error: Maximum amount is: $" + availableFunds);
      System.out.println("You tried to invest: $" + amount);
      System.out.println("You are $" + ((amount-availableFunds * -1)) + " short.");
//      return false;

    }

  }
}
