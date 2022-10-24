package model.rules;

import model.Dealer;
import model.Player;

/**
   * defines american game strategy.
  */
class AmericanNewGameStrategy implements NewGameStrategy {

  /**
   * fullfills the implemented method with a new game strategy.

  * @param dealer dealer
  * @param player player
  */
  public boolean newGame(Dealer dealer, Player player) {
    dealer.getShowCard(true, player);
    dealer.getShowCard(true, dealer);
    dealer.getShowCard(true, player);
    dealer.getShowCard(false, dealer);
    return true;
  }
}