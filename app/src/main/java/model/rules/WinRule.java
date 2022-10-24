package model.rules;

import model.Player;

/**
 * interface for defining a winrule.
 */
public interface WinRule {

  /** 
   * implemented method for defining a win rule.

   * @param dealer dealer
   * @param player player
   * @return boolean has won
   */
  boolean winRule(Player player, Player dealer);
}
