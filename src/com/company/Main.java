package com.company;
import static com.company.Phrases.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";

        while(name.length()<1 || name.length()>10){
            System.out.println("Tell me your name human "+ ANSI_RED + "(bigger than 0 smaller than 10)" + ANSI_RESET);
             name = sc.nextLine();
        }
       Game game = new Game(new Player(name));
          game.start();
        System.out.println("thank you for playing :* ");sc.nextLine();

    }


}