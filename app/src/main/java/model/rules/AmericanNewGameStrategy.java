package model.rules;

//import model.Card;
import model.Dealer;
//import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  

  public boolean newGame(Dealer dealer, Player player) {

    dealer.getShowCard(true, player);
    dealer.getShowCard(true, dealer);
    dealer.getShowCard(true, player);
    dealer.getShowCard(false, dealer);
    return true;
    
  }
}