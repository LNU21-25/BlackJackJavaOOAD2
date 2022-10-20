package model.rules;

import model.Card;
import model.Player;

public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    int dScore = dealer.calcScore();
    int numAces = 0;
    for (Card c : dealer.getHand()) {
      if (c.getValue() == Card.Value.Ace) {
        numAces += 1;
      }
    }
    if (dScore < hitLimit || (numAces != 0 && dScore == hitLimit)) {
      return true;
    } else {
      return false;
    }
  }
}
