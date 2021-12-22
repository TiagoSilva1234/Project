package com.company.events;

import static com.company.Phrases.*;

import com.company.Player;

import java.util.Scanner;

public class Bar implements Events {
    Scanner sc = new Scanner(System.in);

    @Override
    public void startEvent(Player player) {
        System.out.print("You found a Bar");
        sc.nextLine();
        String choice = "";
        System.out.println("do yo wish to enter?");
        while (true) {
            System.out.println("yes/no");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                break;
            }
            if (choice.equalsIgnoreCase("no")) {
                return;
            }
        }
        double random = Math.random();
        System.out.println("You sit on the corner table and hear 2 guys talking in your back");sc.nextLine();
        if (random > 0.75) {
            System.out.println(ANSI_GREEN + "I have heard that the '.' defines a class" + ANSI_RESET);
            sc.nextLine();
        }
        if (random < 0.25) {
            System.out.println(ANSI_GREEN + "I've heard that twitch uses UDP" + ANSI_RESET);
            sc.nextLine();
        }
        if (random > 0.25 && random < 0.50) {
            System.out.println(ANSI_GREEN + "I better start using my ipv6 as my computer password" + ANSI_RESET);
            sc.nextLine();
        }
        if (random > 0.50 && random < 0.75) {
            System.out.println(ANSI_GREEN + "Never forget to check your commits log" + ANSI_RESET);
            sc.nextLine();
        }
        System.out.println(ANSI_PURPLE+ "You also bought a beer and regenerated 1 HP" +ANSI_RESET);sc.nextLine();
    }

}

