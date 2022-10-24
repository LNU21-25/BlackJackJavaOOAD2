package model.rules;

import model.Player;

/**
 * defines a standard/basic winRule.
 */
public class BasicWinRule implements WinRule {

  private static final int blackJack = 21;

  /** defines the winRule.

   * @param player player
   * @param dealer dealer
   * @return boolean
   */
  @Override
  public boolean winRule(Player player, Player dealer) {
    if (player.calcScore() > blackJack) {
      return true;
    } else if (dealer.calcScore() > blackJack) {
      return false;
    }
    return dealer.calcScore() >= player.calcScore();
  }

}
