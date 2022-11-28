package com.example.demo;

import java.util.ArrayList;

public class People {
    private String name;
    private int strength;
    private int attack;
    private int defense;
    private int height;
    private int weight;
    private int intelligence;
    private int survivalSkills;
    private int hasWeapon;

    private int hunting;
    private int archery;
    private int swordsmanship;
    private int x;
    private int y;
    private long startTime;
    private boolean alive;
    private int hunger;

    public People(String n, int s, int a, int d, int h, int w, int i, int ss, int hunt, int arch, int sword) {
        name = n;
        strength = s;
        attack = a;
        defense = d;
        height = h;
        weight = w;
        intelligence = i;
        survivalSkills = ss;

        hunting = hunt;
        archery = arch;
        swordsmanship = sword;
        x = 0;
        y = 0;
        alive = true;
        hasWeapon = 0;
        hunger = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHunger() {
        return hunger;
    }

    public void subtractHunger() {
        this.hunger = hunger-1;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getArchery() {
        return archery;
    }

    public int getHunting() {
        return hunting;
    }

    public int getSurvivalSkills() {
        return survivalSkills;
    }

    public int getSwordsmanship() {
        return swordsmanship;
    }

    public void setDead(){alive = false;}

    public int isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(int hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setArchery(int archery) {
        this.archery = archery;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHunting(int hunting) {
        this.hunting = hunting;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSurvivalSkills(int survivalSkills) {
        this.survivalSkills = survivalSkills;
    }

    public void setSwordsmanship(int swordsmanship) {
        this.swordsmanship = swordsmanship;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void subTractDefense(int w){
        defense -=w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addAttack(int a){attack += a;}

    public void addDefense(int d){defense += d;}
    public void addIntelligence(int d) {
        this.intelligence += d;
    }
    public void addArchery(int d) {
        this.archery += d;
    }
    public void addHunting(int d) {
        this.hunting += d;
    }
    public void addSword(int d){swordsmanship+=5;}


    public void changeLoc(int[][] gameGrid, int val) {


        boolean check = false;
        while (!check) {
            int tempx = x;
            int tempy = y;
            if (Math.random() > .5) {
                tempx++;
            } else {
                tempx--;
            }
            if (Math.random() > .5) {
                tempy++;
            } else {
                tempy--;
            }
            if (tempx >= 0 && tempy >= 0 && tempx < 40 - 1 && tempy < 40 - 1) {
                if (gameGrid[tempx][tempy] == 0) {
                    check = true;
                    gameGrid[tempx][tempy] = val;
                    gameGrid[x][y] = 0;
                    x = tempx;
                    y = tempy;
                }
            }
        }
    }
    public String checkNeighborFight(ArrayList<People> tempPeople, int tempGrid[][]){
        boolean notDead = true;

        for (int i = 0;i<tempPeople.size();i++){
//
            if(tempPeople.get(i).getX() >=x-1 && tempPeople.get(i).getX()<=x+1 &&
                    tempPeople.get(i).getY() >=y-1 && tempPeople.get(i).getY()<=y+1 &&
                    (tempPeople.get(i).getX()!=x || tempPeople.get(i).getY()!=y)&&tempPeople.get(i).isAlive()&&alive){
                    System.out.println("in dead space");

                    while (notDead){
                        if(tempPeople.get(i).hasWeapon == 0) {
                            defense = defense - tempPeople.get(i).getStrength();
                        }
                        if(tempPeople.get(i).hasWeapon == 1){
                            defense = defense - tempPeople.get(i).getSwordsmanship();
                        }
                        if(tempPeople.get(i).hasWeapon == 2){
                            defense = defense - tempPeople.get(i).getArchery();
                        }
                        if(hasWeapon==0) {
                            tempPeople.get(i).subTractDefense(strength);
                        }else if(hasWeapon == 1){
                            tempPeople.get(i).subTractDefense(swordsmanship);
                        }else if(hasWeapon == 2){
                            tempPeople.get(i).subTractDefense(archery);
                        }


                        if(defense<0 || tempPeople.get(i).getDefense() < 0){
                            notDead = false;
                        }
                    }
                    if(defense == tempPeople.get(i).getDefense()){
                        int randInt = (int)(Math.random()*2)+1;
                        if(randInt == 1){
                            defense = 1;
                            tempPeople.get(i).setDefense(0);
                            //  System.out.println(tribe + "Won");
                        }else{
                            tempPeople.get(i).setDefense(1);
                            defense = 0;
                            // System.out.println(tempPeople.get(i).getTribe() + "Won");
                        }
                    }else if(defense>tempPeople.get(i).getDefense()){
                        tempPeople.get(i).setDead();
                        tempPeople.get(i).setDefense(0);
                        System.out.println("killed");
                        return name + " has killed " + tempPeople.get(i).getName();
                    }else if(defense<tempPeople.get(i).getDefense()){
                        alive = false;
                        defense = 0;
                        System.out.println("killed");
                        return tempPeople.get(i).getName() + " has killed " + name ;

                    }




            }
        }
        return "";


    }

    public void flee(int[][] gameGrid, int xVal, int yVal){

        int person = gameGrid[x][y];
        int tempx = x;
        int tempy = y;
        if (tempx - xVal > 0) {
            tempx++;
        } else if (tempx - xVal < 0) {
            tempx--;
        }
        if (tempy - yVal > 0) {
            tempy++;
        } else if (tempy - yVal < 0) {
            tempy--;
        }
        if ((tempx > 0 && tempy > 0 && tempx < 40 - 1 && tempy < 40 - 1)) {
            gameGrid[tempx][tempy] = person;
            gameGrid[x][y] = 0;
            x = tempx;
            y = tempy;


        }else{
           changeLoc(gameGrid,gameGrid[x][y]);
           // System.out.println("changingLoc");
        }
    }
    public void findSpecials(int[][] gameGrid, int xVal, int yVal){

        int person = gameGrid[x][y];
        int tempx = x;
        int tempy = y;
        if (tempx - xVal > 0) {
            tempx--;
        } else if (tempx - xVal < 0) {
            tempx++;
        }
        if (tempy - yVal > 0) {
            tempy--;
        } else if (tempy - yVal < 0) {
            tempy++;
        }
        if (tempx >= 0 && tempy >= 0 && tempx < 40 - 1 && tempy < 40 - 1&& gameGrid[tempx][tempy]==0) {
            gameGrid[tempx][tempy] = 1;
            gameGrid[x][y] = 0;
            x = tempx;
            y = tempy;
            //System.out.println("chasing");


        }else{
            //System.out.println("changing loc");
            changeLoc(gameGrid,1);

        }
    }
    public void resetStartTime(){
        startTime = System.nanoTime();
    }
    public long getStartTime(){
        return startTime;
    }


}
