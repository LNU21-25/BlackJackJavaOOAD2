package model.rules;

import model.Player;

/**
 * defines a hit strategy for the dealer.
 */
public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;
  
  /** 
   * defines implemented method "doHit".

   * @param dealer dealer
   * @return boolean
   */
  public boolean doHit(Player dealer) {
    int deTopScore = dealer.calcScoreHigh();
    int deScore = dealer.calcScore();
    int scoreDif = deTopScore - deScore;
    int numAces = dealer.numAces();
    if (deScore < hitLimit) {
      return true;
    } else if (scoreDif == 0 && numAces > 0 && deScore == hitLimit) {
      return true;
    } else {
      return false;
    }
  }
}
