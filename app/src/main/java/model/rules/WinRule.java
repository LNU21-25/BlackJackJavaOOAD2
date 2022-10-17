package model.rules;

import model.Player;

public interface WinRule {
    boolean winRule(Player player, Player dealer);
}
