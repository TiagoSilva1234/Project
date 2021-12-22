package com.company;
import static com.company.Phrases.*;
public class Player {

    String name;
    int hp = 7;
    int atk = 1;
    int money = 200;

    public Player(String name) {
        this.name = name;


    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void presentStats(){
        System.out.println("Your stats are:");
        System.out.println(ANSI_PURPLE+ "hp: "+ hp + ANSI_RESET);
        System.out.println(ANSI_RED + "atack: "+ atk + ANSI_RESET);
        System.out.println(ANSI_GREEN +"Money: "+ money+ ANSI_RESET );
        System.out.println("----------------------");
    }
}
