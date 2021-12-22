package com.company.events;

import com.company.Player;

import java.util.Scanner;

public class Tripped implements Events {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void startEvent(Player player) {
        System.out.println("well u are quite unlucky arent u :)\n" + ANSI_RED + "You just tripped and lost 1 hp\n" + ANSI_RESET);
        player.setHp(player.getHp() - 1);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
