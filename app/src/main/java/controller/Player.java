package controller;

import model.Game;
import view.EnglishView;
import view.View.Selection;

/**
 * Scenario controller for playing the game.
 */
public class Player implements model.CardDeltObserver {

  public Game game;
  // public View view;
  public EnglishView view;

  public Player(Game g, EnglishView v/* View v */) {
    game = g;
    view = v;

    game.dealer.addSub(this);
  }

  /**
   * Runs the play use case.
   * 
   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play() {

    deal();

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    Selection input = view.getInput();

    switch (input) {
      case startGame:
        game.newGame();
        break;
      case hit:
        game.hit();
        break;
      case stand:
        game.stand();
        break;
      default:
    }
    return input != Selection.quit;
  }

  /**
   * Shows delt cards.
  */
  public void cardDelt() {
    deal();
    view.delay();
  }

  /**
   * calls the prints from the view.
  */
  public void deal() {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
  }

}