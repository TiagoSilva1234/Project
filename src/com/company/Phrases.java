package com.company;

import com.company.Player;

public class Phrases {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Player player;

    public Phrases(Player player) {
        this.player = player;
    }

    public void beforeAnswerSentence() {
        int random = (int) (Math.random() * 5);

        switch (random) {
            case 0:
                System.out.println("Get ready newbie\n");
                break;
            case 1:
                System.out.println("I hope u studied\n");
                break;
            case 2:
                System.out.println("I can see you shaking already\n");
                break;
            case 3:
                System.out.println("Its over for you\n");
                break;
            default:
                System.out.println("I hope you liked it\n ");
                break;
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void correctChoosenText() {
        int random = (int) (Math.random() * 5);

        switch (random) {
            case 0:
                System.out.println("REALLY GOOD THATS WHAT I LIKE TO SEE.\nBUT GET READY BECAUSE WE AIN'T OVER YET!");
                break;
            case 1:
                System.out.println("hmmm lucky shot\nBut unfortunately, this battle ain't over!");
                break;
            case 2:
                System.out.println("I see i ain't dealing with an inexperienced fellow here\nHmpf dont get to cocky");
                break;
            case 3:
                System.out.println("*Argh good hit i give u that\nBUT i still have more from where that came from!");
                break;
            default:
                System.out.println("I cant believe u actually got that one right\nVery well get ready for my next challenge!");
                break;
        }
        System.out.println(ANSI_GREEN + "you have DEALT "+ player.getAtk()+ " dmg" + ANSI_RESET);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void wronngChoiceChosen() {
        int random = (int) (Math.random() * 5);

        switch (random) {
            case 0:
                System.out.println("HAHAHAHA pathetic cant even answer such simple questions\nI though higher of you " + player.getName() + " guess i was wrong.\n");
                break;
            case 1:
                System.out.println("I CANT BELIEVE IT SUCH POW... well that is wrong\nWell... '-' \n");
                break;
            case 2:
                System.out.println("Well i guess your condidence is just for show\nReceive my hit wekling");
                break;
            case 3:
                System.out.println("MUAHAHHAHA THAT HIGHLY INCORRECT\nGet ready for your punishment");
                break;
            default:
                System.out.println("*looking down\nIncorrect i thought u were better than this get back home and study\n");
                break;
        }
        System.out.println(ANSI_RED + "you have RECEIVED 1 damage" + ANSI_RESET);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void professorDefeated() {
        int random = (int) (Math.random() * 5);

        switch (random) {
            case 0:
                System.out.println("I can see you have studied well my student\nPass along you have defeated me\n\n");
                break;
            case 1:
                System.out.println("I CANT UNDERSTAND HOW CAN U HAVE SUCH POWER\nREMEMBER WHAT I AM SAYING, I WILL HAVE MY REVENGE!!\n\n");
                break;
            case 2:
                System.out.println("Tch cant believe i lost to such a newbie\nWhat a disgrace\n\n");
                break;
            case 3:
                System.out.println("Very well student u defeated me\nPass along and good luck on your journey\n\n");
                break;
            default:
                System.out.println("YOU MAY HAVE WON BUT BE AWARE\nIM NOT THE ONLY CHALLENGE IN THIS DUNGEON I HOPE YOUR READY WEAKLING!\n\n");
                break;
        }
        System.out.println(ANSI_GREEN + "Congratulations you won against the boss:)" + ANSI_RESET);

    }


    public void profUltimateDefeat() {
        int random = (int) (Math.random() * 4);

        switch (random) {
            case 0:
                System.out.println("Very well student you deserved this win i have no more power to fight.\n\n");
                break;
            case 1:
                System.out.println("*cough *cough Congrats its your win, I have lost all my energy pass forward warrior.\n\n");
                break;
            case 2:
                System.out.println("Hmpf i should have asked about recursion my, mistake.\nVery well you defeated me.\n\n");
                break;
            default:
                System.out.println("..... Just go\n\n");
                break;
        }
        System.out.println(ANSI_GREEN + "Prof life has reached 0\nCongratulations you won :)" + ANSI_RESET);


    }

}
