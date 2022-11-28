package com.example.demo;

import java.util.ArrayList;

public class Specials {
    private int x;
    private int y;
    private long startTime;
    private String type;
    public Specials(int xLoc, int yLoc, String t) {
        x = xLoc;
        y = yLoc;
        type = t;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }



    public String loot(ArrayList<People> tempPeople, int tempGrid[][]){
        for (int i = 0;i<tempPeople.size();i++){
//                System.out.println(tempAnt.get(i).getX());
            if(tempPeople.get(i).getX() >=x-1 && tempPeople.get(i).getX()<=x+1 &&
                    tempPeople.get(i).getY() >=y-1 && tempPeople.get(i).getY()<=y+1 &&
                    (tempPeople.get(i).getX()!=x || tempPeople.get(i).getY()!=y)&&tempPeople.get(i).isAlive() ){

                if(type.equals("chest")&&tempPeople.get(i).isHasWeapon()==0) {


                    tempPeople.get(i).setHasWeapon((int) (Math.random() * 2) + 1);
                    if(tempPeople.get(i).isHasWeapon() == 1){
                        System.out.println("has sword");
                        return tempPeople.get(i).getName() + " has obtained a sword from a chest!";

                    }
                    if(tempPeople.get(i).isHasWeapon() == 2){
                        System.out.println("has sword");
                        return tempPeople.get(i).getName() + " has obtained a bow, and arrows from a chest!";
                    }

                }else if(type.equals("bush")){
                   int rand = (int)Math.floor(Math.random() * 100);
                   if(tempPeople.get(i).getSurvivalSkills()>rand){
                       if(tempPeople.get(i).isAlive()&&tempPeople.get(i).getHunger()<50) {
                           tempPeople.get(i).setHunger(tempPeople.get(i).getWeight());
                           tempPeople.get(i).addDefense(100);
                           System.out.println(tempPeople.get(i).isAlive());
                           return tempPeople.get(i).getName() + " has eaten some berries and regenerated some health";
                       }
                   }else{

                       if(tempPeople.get(i).isAlive()&&tempPeople.get(i).getDefense()>0){
                           System.out.println(tempPeople.get(i).isAlive());
                           tempPeople.get(i).setDefense(0);
                           return tempPeople.get(i).getName() + " has died after eating some poison berries";
                       }
                   }
                }



            }




        }
        return "";


    }



    public void resetStartTime(){
        startTime = System.nanoTime();
    }
    public long getStartTime(){
        return startTime;
    }


}

