package com.company.professors;

import com.company.Player;
import com.company.events.Fight;

public class Maria extends Fight implements Professors {
    private final String NAME = "Maria";
    public Questions[] perguntas = new Questions[6];
    private int hp = 5;

    @Override
    public void implementPerguntas() {
        String[] respostas = new String[]{"println", "System.out.println", "printf", "Scanner.writeline"};
        perguntas[0] = new Questions("How do you write something in the console (java)?", respostas, 2);

        String[] respostas2 = new String[]{"Yes", "No", "Maybe"};
        perguntas[1] = new Questions("Is it possible to create methods with the same name?", respostas2, 1);

        String[] respostas3 = new String[]{"java", "C++", "html", "Python"};
        perguntas[2] = new Questions("Which one of these is not considered a programming language?", respostas3, 3);

        String[] respostas4 = new String[]{"Divides html in 2 pieces ", "Defines a variable ", "Creates a division in html", "Divides to pieces of code"};
        perguntas[3] = new Questions("What does the tag <div> do in html?", respostas4, 3);

        String[] respostas5 = new String[]{".selector", "*selector", "#selector", "./selector"};
        perguntas[4] = new Questions("how do you define a class in CSS?", respostas5, 1);

        String[] ultimate = new String[]{"An iframe is used to display a web page within a web page", "An iframe is used to crete a frame around an image or video", "both", "none"};
        perguntas[5] = new Questions("What is the use of an iframe tag?", ultimate, 1);
    }

    public Maria() {
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
        return NAME;
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
