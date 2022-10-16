package model.rules;

import model.Card;
import model.Player;

public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    if (dealer.calcScore() > hitLimit) {
      return false;
    } else {
      int numAces = 0;
      for (Card c : dealer.getHand()) {
        if (c.getValue() == Card.Value.Ace) {
          numAces += 1;
        }
      }
      if (dealer.calcScore() < hitLimit || (numAces != 0 && dealer.calcScore() == hitLimit)) {
        return true;
      } else {
        return false;
      }
    }
  }
}
