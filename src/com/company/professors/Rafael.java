package com.company.professors;

import com.company.events.Fight;

public class Rafael extends Fight implements Professors {

    private final String NAME = "Rafael";
    public Questions[] perguntas = new Questions[6];
    private int hp = 5;

    public Rafael() {
        super();
        implementPerguntas();
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
    public void implementPerguntas() {
        String[] respostas = new String[]{"Java", "Python", "Pascal", "C"};
        perguntas[0] = new Questions("What language is used in Git", respostas, 4);

        String[] respostas2 = new String[]{"Clones your Git repository", "Allows you to create a local copy of the remote GitHub repository", "Clones commits from your GitHub repository"};
        perguntas[1] = new Questions("What does git clone do?", respostas2, 2);

        String[] respostas3 = new String[]{"staged", "Committed", "Modified"};
        perguntas[2] = new Questions("which one is the first stage of the Tracked state in git", respostas3, 1);

        String[] respostas4 = new String[]{"git add 'file_name' ", "git add -A", "git commit -m 'file_name'", "git checkout 'file_name'"};
        perguntas[3] = new Questions("Which git command stages a single file?", respostas4, 1);

        String[] respostas5 = new String[]{"git help", "git status", "git log", "git timeline"};
        perguntas[4] = new Questions("How do you check your commit history?", respostas5, 3);

        String[] ultimate = new String[]{"yes", "no", "both"};
        perguntas[5] = new Questions("Was this a decent project?", ultimate, 1);
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
