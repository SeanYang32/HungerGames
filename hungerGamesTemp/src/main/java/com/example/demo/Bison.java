package com.example.demo;

import java.util.ArrayList;

public class Bison {
    private int x;
    private int y;
    private long startTime;
    public Bison(int xVal, int yVal){
        x = xVal;
        y = yVal;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public void resetStartTime(){
        startTime = System.nanoTime();
    }
    public long getStartTime(){
        return startTime;
    }
    public String hunt(ArrayList<People> tempPeople, int tempGrid[][]){
        for (int i = 0;i<tempPeople.size();i++){
//                System.out.println(tempAnt.get(i).getX());
            if(tempPeople.get(i).getX() >=x-1 && tempPeople.get(i).getX()<=x+1 &&
                    tempPeople.get(i).getY() >=y-1 && tempPeople.get(i).getY()<=y+1 && tempPeople.get(i).isAlive()){
                int rand = (int)Math.floor(Math.random() * 100);
                if(rand < tempPeople.get(i).getHunting()&&tempPeople.get(i).getHunger()<50){
                    tempPeople.get(i).setHunger(tempPeople.get(i).getWeight());
                    tempPeople.get(i).addDefense(50);
                    return tempPeople.get(i).getName() + " has killed a bison and used it for food!";
                }else{
                    tempPeople.get(i).setDead();
                    tempPeople.get(i).setDefense(0);
                    return tempPeople.get(i).getName() + " could not kill the bison and the bison killed them";
                }

            }



        }



        return "";
    }

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

}
