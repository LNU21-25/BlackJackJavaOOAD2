package model;

/**
 * observer interfave for when a card is delt.
 */
public interface CardDeltObserver {

  /**
   * for the implementor to define an action for when this is called.
   */
  void cardDelt();
}
