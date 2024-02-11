package exercises.facade;

import exercises.facade.classes.investment.InvestmentFacade;

public class Main {
  public static void main(String[] args) {
    InvestmentFacade facade = new InvestmentFacade();

    // testanrop
    facade.invest("111", "Funds", 10);
    facade.invest("111", "Options", 20);
    facade.invest("111", "Stocks", 30);

    facade.invest("222", "Funds", 110);
    facade.invest("222", "Options", 120);
    facade.invest("222", "Stocks", 130);

    facade.invest("333", "Options", 220);

    System.out.println(facade.getAssets("111"));
    System.out.println(facade.getAssets("222"));
    System.out.println(facade.getAssets("333"));


  }
}