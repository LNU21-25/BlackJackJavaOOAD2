package model.rules;

import model.Player;

public class BasicWinRule implements WinRule {
  private static final int blackJack = 21;

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
