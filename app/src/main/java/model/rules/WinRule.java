package model.rules;

import model.Player;

public interface WinRule {

    /** implemented method for defining a win rule.

   * @param dealer
   * @param player 
   * @return boolean
   */
    boolean winRule(Player player, Player dealer);
}
