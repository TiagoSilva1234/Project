package com.company.professors;

public class Questions {
    String question;
    String[] answears;
    int correta;


    public Questions(String question, String[] answers, int correta) {
        this.question = question;
        this.answears = answers;
        this.correta = correta;

    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswears() {
        return answears;
    }

    public int getCorreta() {
        return correta;
    }
}
