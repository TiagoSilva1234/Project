package com.company;

import com.company.events.*;
import com.company.professors.Rafael;

import static com.company.Phrases.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Game {
    int moves;
    Player player;
    LinkedList<Events> eventos = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    String[][] mapa;
    private int mapx = 0;
    private int mapy = 0;

    public void start() {
        int x = 0;
        int y = 0;
        apresentation();
        mapx = pickX();
        mapy = picky();
        int random = 0;
        System.out.println("Thank you for playing and good luck \n");
        sc.nextLine();
        player.presentStats();
        String choice = "";
        int floor = 1;

        do {

            System.out.println(ANSI_RED +"Welcome to floor: " + floor + ANSI_RESET );sc.nextLine();
            sc.nextLine();
            mapa = createMapa(mapx, mapy);
            x = 0;
            y = 0;
            moves = 0;
            while (true) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                printMapa(mapa);
                System.out.println("tas em: \nX: " + (x + 1) + "\nY: " + (y + 1) + "\n");
                random = (int) (Math.random() * eventos.size());
                System.out.println("Where do u wanna go? :)\n\n Q:Stats   W:front\n A:left               D:right\n           S:Back");
                choice = sc.next();
                sc.nextLine();
                choice = choice.toUpperCase();

                String nextPosition = "";
                try {
                    switch (choice) {
                        case "W":
                            nextPosition = mapa[y - 1][x];
                            mapa = moving(mapa, x, y - 1);
                            mapa[y][x] = "O";
                            y--;
                            break;
                        case "S":
                            nextPosition = mapa[y + 1][x];
                            mapa = moving(mapa, x, y + 1);
                            mapa[y][x] = "O";
                            y++;
                            break;
                        case "A":
                            nextPosition = mapa[y][x - 1];
                            mapa = moving(mapa, x - 1, y);
                            mapa[y][x] = "O";
                            x--;
                            break;
                        case "D":
                            nextPosition = mapa[y][x + 1];
                            mapa = moving(mapa, x + 1, y);
                            mapa[y][x] = "O";
                            x++;
                            break;
                        case "Q":
                            player.presentStats();
                            sc.nextLine();
                            continue;
                        case "Quit":
                            return;
                        default:
                            System.out.println("wrong choice");
                            break;
                    }

                } catch (Exception e) {
                    System.out.print("Bateste com as trombas na parede o morcao");
                    sc.nextLine();
                    continue;
                }
                if (checkNextMapPosition(nextPosition)) {
                    moves++;
                    if (moves < 10) {
                        eventos.get(random).startEvent(player);
                    }
                    if (moves == 10) {
                        eventos.get(1).startEvent(player);
                    }

                    if (player.getHp() <= 0) {
                        System.out.println(ANSI_RED + "GAME OVER!" + ANSI_RESET);
                        sc.nextLine();
                        return;
                    }
                    if (eventos.get(random) instanceof Fight && floor != 3) {
                        System.out.print(ANSI_GREEN + "congrats you have finished the floor: " + floor + ANSI_RESET + "\n");
                        sc.nextLine();
                        System.out.print("Time for floor: " + (floor + 1) + " >:)! ");
                        sc.nextLine();
                        System.out.print("By the way you won 500 lines");sc.nextLine();
                        break;
                    }
                    if (eventos.get(random) instanceof Fight) {
                        break;
                    }


                }
            }
            floor++;

        }while(floor < 4);
        System.out.println(ANSI_GREEN +"You won the game :)" +ANSI_RESET);sc.nextLine();
    }


    public boolean checkNextMapPosition(String nextposition) {
        if (nextposition.equals("O")) {
            return false;
        }
        return true;
    }

    public static String[][] createMapa(int x, int y) {
        String[][] mapa = new String[y][x];
        for (String[] fill : mapa) {
            Arrays.fill(fill, "I");
        }
        mapa[0][0] = "*O/";

        return mapa;
    }


    public static void printMapa(String[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < mapa[i].length; j++) {
                if(mapa[i][j].equalsIgnoreCase("I")){System.out.print(ANSI_RED + mapa[i][j] + ANSI_RESET+ " | "); continue;}
                if(mapa[i][j].equalsIgnoreCase("O")){System.out.print(ANSI_GREEN + mapa[i][j] + ANSI_RESET+ " | "); continue;}
                System.out.print(ANSI_PURPLE + mapa[i][j] + ANSI_RESET+ " | ");

            }
            System.out.println();
        }

    }

    public static String[][] moving(String[][] mapa, int x, int y) throws Exception {
        if (x < 0 || x > mapa[y].length || y < 0 || y > mapa.length) {
            throw new Exception();
        }
        mapa[y][x] = "*O/";
        return mapa;
    }


    public Game(Player player) {
        this.player = player;
        this.eventos.add(new Tripped());
        this.eventos.add(new Fight(player));
        this.eventos.add(new Suprise());
        this.eventos.add(new Lima());
        this.eventos.add(new Bar());

    }


    public void apresentation() {
        System.out.print("Welcome " + player.getName() + " to your worst nightmare.");
        sc.nextLine();
        System.out.print("Forward from this place you will see all types of challenges from the easiest ones to the most challenging of them all.");
        sc.nextLine();
        System.out.print("I wish you the best of the lucks and don't loose yourself in this adventure.");
        sc.nextLine();
        System.out.print("OOOH almost forgot");
        sc.nextLine();

    }

    public int pickX() {
        System.out.println("Pick a width for your dungeon floors"+ ANSI_RED + " (min 4 /max 10 and must be numeric)" + ANSI_RESET);
        int x = 0;
        while (true) {
            try {
                x = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("not a number");
                sc.next();
            }
        }
        if (x > 3 && x < 11) {
            return x;
        }
        return pickX();
    }

    public int picky() {
        System.out.println("Pick a height for your dungeon floors" + ANSI_RED +"(min 4 /max 10 and must be numeric)" + ANSI_RESET);
        int y = 0;
        while (true) {
            try {
                y = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("not a number");
                sc.next();
            }
        }
        if (y > 3 && y < 11) {
            return y;
        }
        return picky();
    }

}
