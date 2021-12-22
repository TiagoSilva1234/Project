package com.company.events;

import static com.company.Phrases.*;

import com.company.Player;
import com.company.professors.Questions;

import java.util.Scanner;

public class Suprise implements Events {


    public Questions[] perguntas = new Questions[5];
    Scanner sc = new Scanner(System.in);

    @Override
    public void startEvent(Player player) {
        System.out.print(":O whats that written in the wall??");
        sc.nextLine();
        System.out.print("'For those who seek knowledge, first u shall know the basics'\n'A random question about primitive data types shall be presented to you'");
        sc.nextLine();
        System.out.print("'Its your job to answer such question correctly if of course you wish to be graced, otherwise you shall be punished by your mistakes'");
        sc.nextLine();
        System.out.print("'Here i present you t2he so awaited question'");
        sc.nextLine();
        int random = (int) (Math.random() * 5);
        System.out.print(perguntas[random].getQuestion()+"\n");
        int i = 1;
        for (String respostas : perguntas[random].getAnswears()) {
            System.out.println(i++ + ": " + respostas);
        }
        int answer = 0;
        while (answer <= 0 || answer > perguntas[random].getAnswears().length) {
            answer = sc.nextInt();
        }
        if (answer == perguntas[random].getCorreta()) {
            System.out.println("Very good seeker of knowledge that is indeed correct here take this \n" + ANSI_GREEN + "You regenerated 1 hp" + ANSI_RESET);
            sc.nextLine();
            sc.nextLine();
            System.out.println("You can now proceed with you adventure");
            return;
        }
        System.out.println("That is the wrong answer as a punishment u shall receive my strike\n" + ANSI_RED + "you took 1 damage" + ANSI_RESET);
        sc.nextLine();
        sc.nextLine();
    }

    private void implementPerguntas() {
        String[] respostas = new String[]{"Long", "Short", "int", "Boolean"};
        perguntas[0] = new Questions("Which primitive data type is the lightest of them all?", respostas, 4);

        String[] respostas2 = new String[]{"long", "double", "int", "double e long", "long e int"};
        perguntas[1] = new Questions("Which primitive data type is the heaviest of them all?", respostas2, 4);

        String[] respostas3 = new String[]{"Sim", "Nao"};
        perguntas[2] = new Questions("Is string a primitive data type?", respostas3, 2);

        String[] respostas4 = new String[]{"double", "int", "short", "byte"};
        perguntas[3] = new Questions("Wich one of the following data types is not a Integer Type?", respostas4, 1);

        String[] respostas5 = new String[]{"true", "false", "null"};
        perguntas[4] = new Questions("You are lucky this is the easiest one, wich is the default value for boolean? ", respostas5, 2);


    }


    public Suprise() {
        implementPerguntas();
    }
}
