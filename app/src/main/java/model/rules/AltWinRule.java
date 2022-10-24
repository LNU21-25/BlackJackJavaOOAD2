package model.rules;

import model.Player;

/**
   * uses the win rule interface to define a win rule 
   * where the player wins on a tie with the dealer.
  */
public class AltWinRule implements WinRule {

  private static final int blackJack = 21;

  /**
   * implements the winRule interface.

  * @param player player
  * @param dealer dealer
  * @return boolean if player won
  */
  @Override
  public boolean winRule(Player player, Player dealer) {
    if (player.calcScore() > blackJack) {
      return true;
    } else if (dealer.calcScore() > blackJack) {
      return false;
    }
    return dealer.calcScore() > player.calcScore();
  }

}
