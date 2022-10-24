package model;

import java.util.ArrayList;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinRule;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinRule winRule;
  public ArrayList<CardDeltObserver> subscribers;

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {

    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winRule = rulesFactory.getWinRule();
    subscribers = new ArrayList<CardDeltObserver>();

  }

  /**
   * Starts a new game if the game is not currently under way.

   * @param player The player to play agains.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(/*deck, */ this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.

   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver() && hitRule.doHit(player)) {
      
      getShowCard(true, player);

      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.

   * @param player The player to check agains.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winRule.winRule(player, this);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.

   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /**
   * The player has choosen to take no more cards, it is the dealers turn.
   */
  public boolean stand() {
    if (deck != null) {
      showHand();
      while (hitRule.doHit(this) == true) {
        Card.Mutable c = deck.getCard();
        c.show(true);
        dealCard(c);  
      } 
      return true;
    } else {
      return false;
    }
  }

  /**
   * deals a card and notifys subscribers.

   *@param shown whether ther card is shown or not
   *@param player the player to recieve the card
   */
  public void getShowCard(boolean shown, Player player) { 
    Card.Mutable c = this.deck.getCard();
    c.show(shown);
    notifySubs();
    player.dealCard(c);
  }

  /**
   * tells the subscribed player controller that a card has been delt.
   */
  public void notifySubs() {
    for (CardDeltObserver cdo : subscribers) {
      cdo.cardDelt();
    }
  }

  /**
   * adds a card delt subscriber.
   */
  public void addSub(CardDeltObserver cdo) {
    subscribers.add(cdo);
  }

  /**
   * removes a card delt subscriber.
   */
  public void removeSub(CardDeltObserver cdo) {
    subscribers.remove(cdo);
  }

}