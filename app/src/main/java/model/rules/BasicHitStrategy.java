package model.rules;

import model.Player;

/**
 * defines the doHit method from hitStrategy.
 */
class BasicHitStrategy implements HitStrategy {

  private static final int hitLimit = 17;
  
  /** fulfills implemented method.

   * @param dealer of type player
   * @return boolean hit is done
   */
  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }
}
