package com.example.demo.numberGuessingGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String playerNumber;
    public String name;
    public List<GameRound> guessNumber = new ArrayList<>();

    public Player(String playerNumber) {
        this.playerNumber = playerNumber;
    }
}
