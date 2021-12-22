package com.company.events;

import static com.company.Phrases.*;

import com.company.Phrases;
import com.company.Player;
import com.company.professors.*;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedMap;

public class Fight implements Events {
    Scanner sc = new Scanner(System.in);
    Phrases phrases;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    LinkedList<Professors> professores = new LinkedList<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Fight(Player player) {
        this.phrases = new Phrases(player);
        professores.add(new Maria());
        professores.add(new Rui());
        professores.add(new Rafael());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Fight() {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void startEvent(Player player) {
        Professors prof = professores.get(0);
        Questions[] perguntas = professores.get(0).getQuestions();

        if(prof instanceof Rafael){
            System.out.print(ANSI_RED+ "WELCOME "+ player.getName() + " TO YOUR LAST CHALLENGE MY NAME IS "+prof.getName()+"!!");sc.nextLine();
            System.out.print("You did well coming all this way.");sc.nextLine();
            System.out.print("I hope you bought some instant heals because this wont get any easier.");sc.nextLine();
        }else{
        System.out.println("WELCOME " + player.getName() + " to your death my name is " + prof.getName() + " i have " + perguntas.length + " questions for u i hope you are ready >:)!!\n");}

        int answer = 0;
        int i = 0;
        while (prof.gethp() != 0) {
            if (player.getHp() <= 0) {
                return;
            }
            if (i == 5) {
                ultimateMove(prof, perguntas, player);
                return;
            }
            printbattleState(prof, player);
            System.out.println(i + 1 + ": Questio!");
            System.out.println("--------------------------------------------------");
            System.out.println(perguntas[i].getQuestion());
            System.out.println("--------------------------------------------------");
            //   beforeAnswerSentence();
            sc.nextLine();
            System.out.println("Answers:");
            for (int j = 0; j < perguntas[i].getAnswears().length; j++) {

                System.out.println(j + 1 + ": " + perguntas[i].getAnswears()[j] + "?");
            }
            while (answer <= 0 || answer > perguntas[i].getAnswears().length) {
                try {
                    answer = sc.nextInt();
                }catch (Exception e){
                    System.out.println("not an option");
                    sc.next();
                }
            }
            if (answer == perguntas[i].getCorreta()) {
                prof.sethp(prof.gethp() - player.getAtk());
                if (prof.gethp() == 0) {
                    break;
                }

                phrases.correctChoosenText();
                sc.nextLine();
                sc.nextLine();

                answer = 0;
                i++;
                continue;
            }
            phrases.wronngChoiceChosen();
            player.setHp(player.getHp() - 1);
            answer = 0;
            i++;
            sc.nextLine();
            sc.nextLine();
        }
        System.out.println(ANSI_PURPLE + prof.getName() + " hp is " + prof.gethp() + "!!!!\n" + ANSI_RESET);
        phrases.professorDefeated();
        professores.removeFirst();
        sc.nextLine();
        sc.nextLine();
        player.setMoney(player.getMoney() + 500);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void printbattleState(Professors prof, Player player) {
        System.out.println("Battle State----------------------------------------------");
        System.out.println(ANSI_BLUE + player.getName() + " currently have " + player.getHp() + " hp!" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + prof.getName() + " has " + prof.gethp() + " hp!" + ANSI_RESET);
        System.out.println("----------------------------------------------------------\n");
    }


    private void ultimateMove(Professors prof, Questions[] questions, Player player) {
        System.out.print("ENOUGH");
        sc.nextLine();
        System.out.println("Its time for my final question be prepared " + player.getName() + " i will use everything i have left!");
        sc.nextLine();
        System.out.println("/ / / / / / / / / / / / / / / / / / / / / /");
        System.out.println(questions[questions.length - 1].getQuestion());
        System.out.println("/ / / / / / / / / / / / / / / / / / / / / /");
        int answer = 0;
        sc.nextLine();
        for (int i = 0; i < questions[questions.length - 1].getAnswears().length; i++) {
            System.out.println(i + 1 + ": " + prof.getQuestions()[prof.getQuestions().length - 1].getAnswears()[i] + "?");
        }
        while (true) {
            try {
                answer = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("not an option");
                sc.next();
            }
        }
        if (answer == questions[questions.length - 1].getCorreta()) {
            phrases.profUltimateDefeat();
            professores.removeFirst();
            player.setMoney(player.getMoney()+500);
            return;
        }
        if (prof.getName().equals("Rafael")) {
            player.setHp(0);
            professores.removeFirst();
            return;
        }
        player.setHp(player.getHp() - 3);
        professores.removeFirst();
        if (player.getHp() <= 0) {
            System.out.println("Wrong!!! You are going down with me!!!!");
            sc.nextLine();
            sc.nextLine();
            return;
        }
        System.out.println(ANSI_RED + "You took 3 dmg" + ANSI_RESET);
        System.out.print("Hmmm even tho you were wrong, I couldn't bring you down\n");
        sc.nextLine();
        System.out.println("Very well pass forward");
        player.setMoney(player.getMoney()+500);
        sc.nextLine();


    }
}
