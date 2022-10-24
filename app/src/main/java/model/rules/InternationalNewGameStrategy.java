package model.rules;

import model.Dealer;
import model.Player;

class InternationalNewGameStrategy implements NewGameStrategy {
  
  
  /** defines the implemented method, newGame.

   * @param dealer dealer
   * @param player player
   * @return boolean true
   */
  public boolean newGame(Dealer dealer, Player player) {
    dealer.getShowCard(true, player);
    dealer.getShowCard(true, dealer);
    dealer.getShowCard(true, player);
    return true;
  }
}