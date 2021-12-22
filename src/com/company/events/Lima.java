package com.company.events;

import static com.company.Phrases.*;

import com.company.Phrases;
import com.company.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lima implements Events {
    LinkedHashMap<String, Integer> shop = new LinkedHashMap<>();
    Scanner sc = new Scanner(System.in);


    public void printShopOptions(Player player) {
        System.out.println(ANSI_GREEN + "You have: " + player.getMoney() + ANSI_RESET);
        System.out.printf("%-25s| %-7s |%n", "item:", "price:");
        for (Map.Entry<String, Integer> it : shop.entrySet())
            System.out.printf("%-25s| %-7d |%n", it.getKey(), it.getValue());
    }

    public Lima() {
        shop.put("Recursion sword", 10000);
        shop.put("instant heal s", 200);
        shop.put("instant heal m", 500);
        shop.put("instant heal l", 1000);
        shop.put("Sout sword", 200);
        shop.put("Thread sword", 700);
        shop.put("Method sword", 3000);

    }


    @Override
    public void startEvent(Player player) {
        System.out.println("Welcome to my shop my name is Nuno lima and i may have something for you");
        System.out.print("If of course you have the money :) (type the item name to purchase)");
        sc.nextLine();
        System.out.print("Type " + ANSI_RED + "´quit´" + ANSI_RESET + " to leave\n");
        sc.nextLine();
        String choice = "";
        printShopOptions(player);
        while (true) {
                choice = sc.nextLine();
            if (choice.equalsIgnoreCase("quit")) {
                break;
            }
            if (!shop.containsKey(choice)) {
                System.out.println("You only have one job yet you failed at it ...");
                continue;
            }

            if (shop.get(choice) > player.getMoney()) {
                System.out.println(ANSI_RED + "Well you kinda pobre :)" + ANSI_RESET);
                continue;
            }
            player.setMoney(player.getMoney() - shop.get(choice));
            purchase(choice, player);
            sc.nextLine();
            System.out.println("Thank you for your purchase :)");
            System.out.print("You now have: " + ANSI_GREEN + player.getMoney() + ANSI_RESET);
            sc.nextLine();
            shop.remove(choice);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printShopOptions(player);
        }
        System.out.println("Thank you for your time.\nCome back later >:)");
        sc.nextLine();
    }


    public void purchase(String choice, Player player) {

        switch (choice) {
            case "instant heal l":
                System.out.println(ANSI_GREEN + "You regenerated 7 HP" + ANSI_RESET);
                player.setHp(player.getHp() + 7);
                break;
            case "instant heal m":
                System.out.println(ANSI_GREEN + "You regenerated 4 HP" + ANSI_RESET);
                player.setHp(player.getHp() + 4);
                break;
            case "instant heal s":
                System.out.println(ANSI_GREEN + "You regenerated 2 HP" + ANSI_RESET);
                player.setHp(player.getHp() + 2);
                break;
            case "Recursion sword":
                System.out.println(ANSI_GREEN + "You brought the Recursion" + ANSI_RESET);
                player.setAtk(5000);
                break;
            case "Method sword":
                System.out.println(ANSI_GREEN + "You brought the Method sword" + ANSI_RESET);
                player.setAtk(2);
                break;
            case "Thread sword":
                System.out.println(ANSI_GREEN + "You brought the Thread sword" + ANSI_RESET);
                player.setAtk(4);
                break;
            case "Sout sword":
                System.out.println(ANSI_GREEN + "You brought the Sout sword" + ANSI_RESET);
                player.setAtk(3);
                break;
        }
        sc.nextLine();
        player.presentStats();
    }
}
