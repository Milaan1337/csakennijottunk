package csakennijottunk.InGame;

public class BasicVariables {
    static boolean basicrod = true;
    static boolean betterrod = false;
    static boolean bestrod = false;

    static int basicrodLength = 3;
    static int betterrodLength = 4;
    static int bestrodLength = 5;

    static int rodType = 1;
    static int money = 0;
    static int bait = 1;
    static int damil = 1;


    static int basicrodPrice = 50;
    static int betterrodPrice = 100;
    static int bestrodPrice = 200;

    public int getMoney(){
        return money;
    }

    public int getDamil(){
        return damil;
    }

    public void setDamil(int amount){
        damil = damil + amount;
    }

    public int getCsali(){
        return bait;
    }

    public void setCsali(int amount){
        bait = bait + amount;
    }

    public boolean getRodLvl2(){
        return betterrod;
    }

    public boolean getRodLvl3(){
        return bestrod;
    }

    public void setRod(int lvl){
        rodType = lvl;
    }

    public void buyRodLvl2(){
        betterrod = true;
    }

    public void buyRodLvl3(){
        bestrod = true;
    }

    public void setMoney(int coin){
        money = coin;
    }

}
