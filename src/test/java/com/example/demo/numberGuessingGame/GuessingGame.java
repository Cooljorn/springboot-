package com.example.demo.numberGuessingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        System.out.println("############### Guessing Game Start ###################");
        Scanner sc = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>(5);
        for(int i=1;i<6;i++) {
            Player player = new Player("player"+i);
            System.out.println("Please enter player"+i+" name：");
            player.name = sc.nextLine();
            playerList.add(player);
        }
        System.out.println("##################################");
        for(int i=1;i<6;i++) {

            System.out.println("Round  "+i);

        }
        System.out.println();
    }

}
