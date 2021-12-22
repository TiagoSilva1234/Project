package com.company.professors;

import com.company.Player;
import com.company.events.Fight;

public class Rui extends Fight implements Professors {

    private final String NAME = "Rui";
    public Questions[] perguntas = new Questions[6];
    private int hp = 5;


    public Rui() {
        super();
        implementPerguntas();
    }

    @Override
    public void startEvent(Player player) {
        super.startEvent(player);
    }

    @Override
    public Questions[] getQuestions() {
        return perguntas;
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public void implementPerguntas() {
        String[] respostas = new String[]{"TCP", "UDP", "FASP"};
        perguntas[0] = new Questions("Which one of this is the fastest protocol?", respostas, 3);

        String[] respostas2 = new String[]{"TCP", "UDP"};
        perguntas[1] = new Questions("Which Protocol is generally used for multicast?", respostas2, 2);

        String[] respostas3 = new String[]{"3999", "1000", "10000", "4999"};
        perguntas[2] = new Questions("Wich number is the max possible number using roman numerals?", respostas3, 1);

        String[] respostas4 = new String[]{"makes that two or more threads can access that data at the same time", "limits the usage of that data to one thread at a time", "makes all objects/methods wih that keyword capable of being worked with at the same time"};
        perguntas[3] = new Questions("What does Synchronized do when applied to an object or method in java?", respostas4, 2);

        String[] respostas5 = new String[]{"ipv4", "ipv6", "both"};
        perguntas[4] = new Questions("wich one is safer ipv4 or ipv6", respostas5, 2);

        String[] ultimate = new String[]{"Warns the other thread that this thread is now ended with his tasks", "Notifies a random thread that was waiting that he can now use this data", "Notifies the next thread waiting that he can now use this data", "Notifies all threads that they can now use this data"};
        perguntas[5] = new Questions("What does .notify() method do in Threads?", ultimate, 2);

    }

    @Override
    public int gethp() {
        return hp;
    }

    @Override
    public void sethp(int value) {
        this.hp = value;
    }
}
