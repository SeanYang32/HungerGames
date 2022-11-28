package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;



import java.awt.Transparency;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class HelloController {
    @FXML ListView<String> archView,aliveView, informationView, archStats, myStats, simMyStats, view1, view2, view3, view4, view5,view6,view7, view8, view9, view10, view11,view12,distStats,myBattleView,opponentBattleView,attackView, eventLog;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField nameField, heightField, weightField, archetypeField;
    @FXML
    private Label attackLabel, resultLabel, trainingLabel, finalLabel;
    @FXML
    private ImageView bison0, bison1, bison2;
    @FXML
    private Button leftButton, middleButton, rightButton, readyButton;


    ArrayList<People> archetypes= new ArrayList<>();
    ArrayList<People> tributes = new ArrayList<>();
    ArrayList<String> directions = new ArrayList<>();
    ArrayList<String> userInput = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<Integer> archInput = new ArrayList<>();
    ArrayList<Specials> chests = new ArrayList<>();
    ArrayList<Specials> bushes = new ArrayList<>();
    ArrayList<Bison> bisons = new ArrayList<>();

    People myPerson = new People("",0,0,0,0,0,0,0,0,0,0);
    People myOpponent;
    int attackDefenseClickNum = 0;
    int archGameNum = 0;
    int opponentHealth;
    int myHealth;



    @FXML
    private void begin(){
        archetypes.add(new People("Offense",75,75,50,0,0, 50,50,50,50,75));
        archetypes.add(new People("Defense",75,50,75,0,0,50,50,50,75,50));
        archetypes.add(new People("Survival Expert",50,50,50,0,0,75,75,75,50,50));

        for(int i =0; i<3;i++){
            archView.getItems().add(archetypes.get(i).getName());
        }
        tabPane.getSelectionModel().selectNext();
        informationView.getItems().add("Dummy Attack");
        informationView.getItems().add("Training Battle");
        informationView.getItems().add("Archery Game");
        bison0.setVisible(false);
        bison1.setVisible(false);
        bison2.setVisible(false);
        leftButton.setDisable(true);
        middleButton.setDisable(true);
        rightButton.setDisable(true);

    }

    public void showArchStats(MouseEvent x){
        archStats.getItems().clear();
        int i = archView.getSelectionModel().getSelectedIndex();
        archStats.getItems().add("Strength: " + archetypes.get(i).getStrength());
        archStats.getItems().add("Attack: " + archetypes.get(i).getAttack());
        archStats.getItems().add("Defense: " + archetypes.get(i).getDefense());
        archStats.getItems().add("Intelligence: " + archetypes.get(i).getIntelligence());
        archStats.getItems().add("Survival Skills: " + archetypes.get(i).getSurvivalSkills());
        archStats.getItems().add("Hunting: " + archetypes.get(i).getHunting());
        archStats.getItems().add("Archery: " + archetypes.get(i).getArchery());
        archStats.getItems().add("Swordsmanship: " + archetypes.get(i).getSwordsmanship());


    }

    @FXML
    private void nameButton(){
        myPerson.setName(nameField.getText());
    }
    @FXML
    private void heightButton(){
        myPerson.setHeight(Integer.parseInt(heightField.getText()));
    }
    @FXML
    private void weightButton(){
        myPerson.setWeight(Integer.parseInt(weightField.getText()));
    }
    @FXML
    private void archetypeButton(){
        if(archetypeField.getText().equals("Offense")){
            myPerson.setStrength(archetypes.get(0).getStrength());
            myPerson.setAttack(archetypes.get(0).getAttack());
            myPerson.setDefense(archetypes.get(0).getDefense());
            myPerson.setIntelligence(archetypes.get(0).getIntelligence());
            myPerson.setSurvivalSkills(archetypes.get(0).getSurvivalSkills());
            myPerson.setHunting(archetypes.get(0).getHunting());
            myPerson.setArchery(archetypes.get(0).getArchery());
            myPerson.setSwordsmanship(archetypes.get(0).getSwordsmanship());
        } else if(archetypeField.getText().equals("Defense")){
            myPerson.setStrength(archetypes.get(1).getStrength());
            myPerson.setAttack(archetypes.get(1).getAttack());
            myPerson.setDefense(archetypes.get(1).getDefense());
            myPerson.setIntelligence(archetypes.get(1).getIntelligence());
            myPerson.setSurvivalSkills(archetypes.get(1).getSurvivalSkills());
            myPerson.setHunting(archetypes.get(1).getHunting());
            myPerson.setArchery(archetypes.get(1).getArchery());
            myPerson.setSwordsmanship(archetypes.get(1).getSwordsmanship());
        }else if(archetypeField.getText().equals("Survival Expert")){
            myPerson.setStrength(archetypes.get(2).getStrength());
            myPerson.setAttack(archetypes.get(2).getAttack());
            myPerson.setDefense(archetypes.get(2).getDefense());
            myPerson.setIntelligence(archetypes.get(2).getIntelligence());
            myPerson.setSurvivalSkills(archetypes.get(2).getSurvivalSkills());
            myPerson.setHunting(archetypes.get(2).getHunting());
            myPerson.setArchery(archetypes.get(2).getArchery());
            myPerson.setSwordsmanship(archetypes.get(2).getSwordsmanship());
        }else{
            System.out.println("Choose a presented archetype");
        }
        /*myStats.getItems().add("Name: " + myPerson.getName());
        myStats.getItems().add("Height: " + myPerson.getHeight());
        myStats.getItems().add("Weight: " + myPerson.getWeight());
        myStats.getItems().add("Strength: " + myPerson.getStrength());
        myStats.getItems().add("Attack: " + myPerson.getAttack());
        myStats.getItems().add("Defense: " + myPerson.getDefense());
        myStats.getItems().add("Intelligence: " + myPerson.getIntelligence());
        myStats.getItems().add("Survival Skills: " + myPerson.getSurvivalSkills());
        myStats.getItems().add("Hunting: " + myPerson.getHunting());
        myStats.getItems().add("Archery: " + myPerson.getArchery());
        myStats.getItems().add("Swordsmanship: " + myPerson.getSwordsmanship());*/
        String[] names = {"Marvel",  "Cato", "Beetee", "Sia",  "Sol", "Jason","Elias","Bonnie","Mazie","Tanner","Rue"};
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        chests.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"chest"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bushes.add(new Specials((int)(Math.random() * 40),(int)(Math.random() * 40),"bush"));
        bisons.add(new Bison((int)(Math.random() * 40),(int)(Math.random() * 40)));
        bisons.add(new Bison((int)(Math.random() * 40),(int)(Math.random() * 40)));
        bisons.add(new Bison((int)(Math.random() * 40),(int)(Math.random() * 40)));
        bisons.add(new Bison((int)(Math.random() * 40),(int)(Math.random() * 40)));
        bisons.add(new Bison((int)(Math.random() * 40),(int)(Math.random() * 40)));

        for(int i = 0; i<11;i++){
            tributes.add(new People(names[i],(int)(Math.random() * 31) + 50,(int)(Math.random() * 31) + 50,(int)(Math.random() * 31) + 50,(int)(Math.random() * 25) + 60,(int)(Math.random() * 200) + 100,(int)(Math.random() * 31) + 50,(int)(Math.random() * 31) + 50,(int)(Math.random() * 31) + 50,(int)(Math.random() * 31) + 50,(int)(Math.random() * 31) + 50));
            tributes.get(i).setX((int)(Math.random() * 40));
            tributes.get(i).setY((int)(Math.random() * 40));
        }
        tributes.add(myPerson);
        tributes.get(11).setX((int)(Math.random() * 40));
        tributes.get(11).setY((int)(Math.random() * 40));
        for(People i : tributes) {
            aliveView.getItems().add(i.getName());
        }
        /*for(int i = 0; i<3; i++){
            tributes.get(i).setX(15);
            tributes.get(i).setY(15+4*i);
        }
        for(int i = 3; i<6; i++){
            tributes.get(i).setX(15+4*(i-3));
            tributes.get(i).setY(25);
        }
        for(int i = 6; i<9; i++){
            tributes.get(i).setX(15+4*(i-6));
            tributes.get(i).setY(15);
        }
        for(int i = 9; i<12; i++){
            tributes.get(i).setX(25);
            tributes.get(i).setY(15+4*(i-9));
        }*/


        view1.getItems().add(tributes.get(0).getName());
        view2.getItems().add(tributes.get(1).getName());
        view3.getItems().add(tributes.get(2).getName());
        view4.getItems().add(tributes.get(3).getName());
        view5.getItems().add(tributes.get(4).getName());
        view6.getItems().add(tributes.get(5).getName());
        view7.getItems().add(tributes.get(6).getName());
        view8.getItems().add(tributes.get(7).getName());
        view9.getItems().add(tributes.get(8).getName());
        view10.getItems().add(tributes.get(9).getName());
        view11.getItems().add(tributes.get(10).getName());
        view12.getItems().add(tributes.get(11).getName() + "(You)");

        tabPane.getSelectionModel().selectNext();




    }

    public void showDistStats(int i){
        distStats.getItems().clear();
        distStats.getItems().add("Name: " + tributes.get(i).getName());
        distStats.getItems().add("Height: " + tributes.get(i).getHeight());
        distStats.getItems().add("Weight: " + tributes.get(i).getWeight());
        distStats.getItems().add("Strength: " + tributes.get(i).getStrength());
        distStats.getItems().add("Attack: " + tributes.get(i).getAttack());
        distStats.getItems().add("Defense: " + tributes.get(i).getDefense());
        distStats.getItems().add("Intelligence: " + tributes.get(i).getIntelligence());
        distStats.getItems().add("Survival Skills: " + tributes.get(i).getSurvivalSkills());
        distStats.getItems().add("Hunting: " + tributes.get(i).getHunting());
        distStats.getItems().add("Archery: " + tributes.get(i).getArchery());
        distStats.getItems().add("Swordsmanship: " + tributes.get(i).getSwordsmanship());


    }
    public void viewClick1(MouseEvent x){
        showDistStats(0);
    }
    public void viewClick2(MouseEvent x){
        showDistStats(1);
    }
    public void viewClick3(MouseEvent x){
        showDistStats(2);
    }
    public void viewClick4(MouseEvent x){
        showDistStats(3);
    }
    public void viewClick5(MouseEvent x){
        showDistStats(4);
    }
    public void viewClick6(MouseEvent x){
        showDistStats(5);
    }
    public void viewClick7(MouseEvent x){
        showDistStats(6);
    }
    public void viewClick8(MouseEvent x){
        showDistStats(7);
    }
    public void viewClick9(MouseEvent x){
        showDistStats(8);
    }
    public void viewClick10(MouseEvent x){
        showDistStats(9);
    }
    public void viewClick11(MouseEvent x){
        showDistStats(10);
    }
    public void viewClick12(MouseEvent x){
        showDistStats(11);
    }
    public void readInformation(MouseEvent x){
        int ind = informationView.getSelectionModel().getSelectedIndex();
        directions.clear();
        userInput.clear();

        for(int i = 0; i<5; i++){
            int random = (int)(Math.random() * ((4 - 1) + 1)) + 1;
            if(random==1){
                directions.add("up");
            }
            else if(random==2){
                directions.add("down");
            }
            else if(random==3){
                directions.add("right");
            }
            else if(random==4){
                directions.add("left");
            }
        }
        if(ind == 0){
            trainingLabel.setText("Remember the following directions " + directions.get(0) + ", " + directions.get(1) + ", " + directions.get(2) + ", " + directions.get(3)+", and " + directions.get(4) + ". When you enter the arena, you will have to click the corresponding directions to attack the dummy. You will get +1 to your attack and intelligence attributes for every correct click");
        }
        if(ind == 1){
            trainingLabel.setText("You will be matched up against a random opponent, you can select 3 attacks: swing, jab, and block. Swing beats block, jab beats swing, and block counterattacks against jab");
        }
        if(ind == 2){
            trainingLabel.setText("Choose where you think the bison will be, you will earn +1 to your hunting and archery stat");
        }
    }
    @FXML
    private void trainAttackDefense(){
        tabPane.getSelectionModel().select(4);

    }

    @FXML
    public void clickUp(){
        userInput.add("up");
        attackDefenseClickNum++;
        if(attackDefenseClickNum>4){
            System.out.println(checkCorrect());
            myPerson.addAttack(checkCorrect());
            myPerson.addIntelligence(checkCorrect());
            tabPane.getSelectionModel().select(7);
            resultLabel.setText("You got " + checkCorrect() + " attribute points added to your attack and intelligence.");
        }
    }
    @FXML
    public void clickDown(){
        userInput.add("down");
        attackDefenseClickNum++;
        if(attackDefenseClickNum>4){
            System.out.println(checkCorrect());
            myPerson.addAttack(checkCorrect());
            myPerson.addIntelligence(checkCorrect());
            tabPane.getSelectionModel().select(7);
            resultLabel.setText("You got " + checkCorrect() + " attribute points added to your attack and intelligence.");
        }
    }
    @FXML
    public void clickLeft(){
        userInput.add("left");
        attackDefenseClickNum++;
        if(attackDefenseClickNum>4){
            System.out.println(checkCorrect());
            myPerson.addAttack(checkCorrect());
            myPerson.addIntelligence(checkCorrect());
            tabPane.getSelectionModel().select(7);
            resultLabel.setText("You got " + checkCorrect() + " attribute points added to your attack and intelligence.");
        }
    }
    @FXML
    public void clickRight(){
        userInput.add("right");
        attackDefenseClickNum++;
        if(attackDefenseClickNum>4){
            System.out.println(checkCorrect());
            myPerson.addAttack(checkCorrect());
            myPerson.addIntelligence(checkCorrect());
            tabPane.getSelectionModel().select(7);
            resultLabel.setText("You got " + checkCorrect() + " attribute points added to your attack and intelligence.");
        }
    }

    public int checkCorrect(){
        int points = 0;
        for(int i = 0; i<userInput.size();i++){
            if(userInput.get(i) == directions.get(i)){
                points++;
            }
        }
        return points;
    }

    public int selectRandomOpponent(){
        return (int) Math.floor(Math.random() * 11);
    }

    public void swordBattle(){
        tabPane.getSelectionModel().select(5);
        myOpponent = tributes.get(selectRandomOpponent());
        myHealth = myPerson.getDefense()*10;
        opponentHealth = myOpponent.getDefense()*10;
        attackLabel.setText("");
        myBattleView.getItems().clear();
        opponentBattleView.getItems().clear();
        attackView.getItems().clear();
        myBattleView.getItems().add("Name: " + myPerson.getName());
        opponentBattleView.getItems().add("Name: " + myOpponent.getName());
        myBattleView.getItems().add("Health: " + myHealth);
        myBattleView.getItems().add("Swordsmanship: " + myPerson.getSwordsmanship());
        opponentBattleView.getItems().add("Health: " + opponentHealth);
        opponentBattleView.getItems().add("Swordsmanship: " + myOpponent.getDefense());
        attackView.getItems().add("Jab");
        attackView.getItems().add("Swing");
        attackView.getItems().add("Block");

    }

    public void setTrainingListViews(){
        myBattleView.getItems().clear();
        opponentBattleView.getItems().clear();
        myBattleView.getItems().add("Name: " + myPerson.getName());
        opponentBattleView.getItems().add("Name: " + myOpponent.getName());
        myBattleView.getItems().add("Health: " + myHealth);
        myBattleView.getItems().add("Swordsmanship: " + myPerson.getSwordsmanship());
        opponentBattleView.getItems().add("Health: " + opponentHealth);
        opponentBattleView.getItems().add("Swordsmanship: " + myOpponent.getDefense());
    }

    public void chooseAttack(MouseEvent x){
        int attackChosen = attackView.getSelectionModel().getSelectedIndex();
        int opponentAttackChosen = ((int)(Math.random() * 3));
        if(attackChosen == 0){
            if(opponentAttackChosen==0){
                attackLabel.setText("Both fighters chose jab, nothing happened");

            }
            else if(opponentAttackChosen == 1){
                attackLabel.setText("Opponent chose swing, you did " + myPerson.getAttack()/2 + " damage");
                opponentHealth= opponentHealth - myPerson.getAttack()/2;
                setTrainingListViews();
            }
            else if(opponentAttackChosen == 2){
                attackLabel.setText("Opponent blocked your attack! They counterattacked for " + myOpponent.getAttack());
                myHealth = myHealth-myOpponent.getAttack()/2;
                setTrainingListViews();
            }
        }else if(attackChosen == 1){
            if(opponentAttackChosen==0){
                attackLabel.setText("Opponent chose jab, they beat your attack and did " + myOpponent.getAttack()/2 + " damage");
                myHealth= myHealth - myOpponent.getAttack()/2;
                setTrainingListViews();
            }
            else if(opponentAttackChosen == 1){
                attackLabel.setText("Opponent chose swing, both attacks cancel out");

                setTrainingListViews();
            }
            else if(opponentAttackChosen == 2){
                attackLabel.setText("Opponent block was too weak for your attack, you did " + myPerson.getAttack() + " damage");
                opponentHealth = opponentHealth-myPerson.getAttack();
                setTrainingListViews();
            }
        }else if(attackChosen == 2){
            if(opponentAttackChosen==0){
                attackLabel.setText("Opponent chose jab, you blocked their attack ");
                setTrainingListViews();
            }
            else if(opponentAttackChosen == 1){
                attackLabel.setText("Opponent chose swing, your block was too weak and they did " + myPerson.getAttack());
                myHealth = myHealth-myOpponent.getAttack();
                setTrainingListViews();
        }
            else if(opponentAttackChosen == 2){
                attackLabel.setText("Both fighters blocked, nothing happened");
                setTrainingListViews();
            }
        }
        checkAttackGameHealth();
    }

    public void checkAttackGameHealth(){
        if(myHealth<0){
            resultLabel.setText("You lost your training, you will not get any upgrades");
            tabPane.getSelectionModel().select(7);
        }else if(opponentHealth<0){
            resultLabel.setText("Congrats! You won your battle, you have earned +5 to your swordsmanship and defense");
            tabPane.getSelectionModel().select(7);

            myPerson.addSword(5);
            myPerson.addDefense(5);
        }
    }
    public void archeryGame(){
        path.clear();
        archInput.clear();
        bison1.setVisible(false);
        bison2.setVisible(false);
        bison0.setVisible(false);
        for(int i = 0; i<5;i++) {
            int rand = ((int) (Math.random() * 3));
            path.add(rand);
        }
        tabPane.getSelectionModel().select(6);
    }
    public void archMiddle(){
        archInput.add(1);
        showBison(path.get(archGameNum));
        archGameNum++;
        checkArch();
    }

    public void archLeft(){
        archInput.add(0);
        showBison(path.get(archGameNum));
        archGameNum++;
        checkArch();

    }

    public void archRight(){
        archInput.add(2);
        showBison(path.get(archGameNum));
        archGameNum++;
        checkArch();
    }

    public void showBison(int i){
        if(i == 0){
            bison0.setVisible(true);
            bison1.setVisible(false);
            bison2.setVisible(false);
            leftButton.setDisable(true);
            rightButton.setDisable(true);
            middleButton.setDisable(true);
        }
        if(i == 1){
            bison0.setVisible(false);
            bison1.setVisible(true);
            bison2.setVisible(false);
            leftButton.setDisable(true);
            rightButton.setDisable(true);
            middleButton.setDisable(true);
        }
        if(i == 2){
            bison0.setVisible(false);
            bison1.setVisible(false);
            bison2.setVisible(true);
            leftButton.setDisable(true);
            rightButton.setDisable(true);
            middleButton.setDisable(true);
        }

    }
    public void clickReady(){
        leftButton.setDisable(false);
        rightButton.setDisable(false);
        middleButton.setDisable(false);
        bison0.setVisible(false);
        bison1.setVisible(false);
        bison2.setVisible(false);

    }    public void checkArch(){
        if(archGameNum == 5) {
            int x = 0;
            for (int i = 0; i < archInput.size(); i++) {
                System.out.println("Archery: " +archInput.get(i));
                System.out.println("Path: " +path.get(i));
                if (Objects.equals(archInput.get(i), path.get(i))) {
                    x++;
                }
            }
            tabPane.getSelectionModel().select(7);
            resultLabel.setText("You got " + x + " points for  your archery and hunting ability");
            myPerson.addArchery(x);
            myPerson.addHunting(x);
            archGameNum=0;

        }
    }

    public void back(){
        tabPane.getSelectionModel().select(3);
    }






















    int x = 40;
    int y = 40;
    Button[][] btn = new Button[x][y];
    int[][] gameGrid = new int[x][y];

    //GridPane gPane = new GridPane();
//    Image k = new Image("resources/Koala.jpg");
    @FXML
    private AnchorPane aPane;

    @FXML
    private GridPane gPane;




    @FXML
    private void handleStart(ActionEvent event) {
        tabPane.getSelectionModel().select(8);

        //after adding the grdipane in scenebuilder, modify the fxml manually to eliminate
        // rows and columns


//        gPane.setMinSize(0,0);
        //gPane.setPadding(new Insets(btn[i][j]));
        //gPane.setHgap(10);
        //gPane.setVgap(10);
        //gPane.setGridLinesVisible(true);
        //gPane.setAlignment(Pos.CENTER);

        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){

                //Initializing 2D buttons with values i,j
                btn[i][j] = new Button();
                btn[i][j].setStyle("-fx-background-color:#d3d3d3");

                btn[i][j].setPrefWidth(25);

//                btn[i][j].setPrefSize(25, 5);
                //Paramters:  object, columns, rows
                gPane.add(btn[i][j], j, i);
                gameGrid[i][j]=0;


            }
        }

        gPane.setGridLinesVisible(true);

        gPane.setVisible(true);

        EventHandler z = new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent t)
            {
                //ObservableList<Node> children = gPane.getChildren();
                //used to get a list of all children in gridpane
//                System.out.println("hello");
//                ((ImageView) t.getSource()).setImage(new Image("resources/Penguins.jpg"));
//
//                System.out.println("Row:    " + GridPane.getRowIndex(((ImageView) t.getSource())));
//                System.out.println("Column: " + GridPane.getColumnIndex(((ImageView) t.getSource())));
            }

        };
        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){
                btn[i][j].setOnMouseClicked(z);

            }
        }
        start();
    }



    public void updateScreen(){
        for(int i = 0; i<chests.size(); i++){
            gameGrid[chests.get(i).getX()][chests.get(i).getY()] = 13;
        }
        for(int i = 0; i<bushes.size(); i++){
            gameGrid[bushes.get(i).getX()][bushes.get(i).getY()] = 14;
        }
        for(int i = 0; i<bisons.size(); i++){
            gameGrid[bisons.get(i).getX()][bisons.get(i).getY()] = 15;
        }
        for(int i = 0; i<12;i++){
            if(tributes.get(i).isAlive()){
                gameGrid[tributes.get(i).getX()][tributes.get(i).getY()] = 1;
            }
            else{
                gameGrid[tributes.get(i).getX()][tributes.get(i).getY()] = 0;
            }
        }
        simMyStats.getItems().clear();
        simMyStats.getItems().add("Name: " + tributes.get(11).getName());
        simMyStats.getItems().add("X: " + tributes.get(11).getX());
        simMyStats.getItems().add("Y: " + tributes.get(11).getY());
        simMyStats.getItems().add("Alive?: " + tributes.get(11).isAlive());




        for(int i=0; i<btn.length; i++) {
            for (int j = 0; j < btn[0].length; j++) {
                if (gameGrid[i][j]==0){
                    btn[i][j].setStyle("-fx-background-color:#d3d3d3");
                }
                else if (gameGrid[i][j]==1){
                    btn[i][j].setStyle("-fx-background-color:#ff0000");
                }
                else if(gameGrid[i][j]==13){
                    btn[i][j].setStyle("-fx-background-color:#C8711F");
                }
                else if(gameGrid[i][j]==14){
                    btn[i][j].setStyle("-fx-background-color:#3BA30E");
                }
                else if(gameGrid[i][j]==15){
                    btn[i][j].setStyle("-fx-background-color:#6D3B00");
                }
            }
        }
    }

    public void start() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {



                if(tributes.size()>0) {
                    for (int i = 0; i < tributes.size(); i++) {


                        if (now - tributes.get(i).getStartTime() > 1000000000.0) {
                            path(gameGrid, i, 1, chests.get(nearestChest(i)).getX(), chests.get(nearestChest(i)).getY(), bushes.get(nearestBush(i)).getX(), bushes.get(nearestBush(i)).getY(), tributes.get(checkNearestEnemy(i)).getX(), tributes.get(checkNearestEnemy(i)).getY(), tributes.get(nearestBison(i)).getX(), tributes.get(nearestBison(i)).getY());
                            //tributes.get(i).findSpecials(gameGrid,tributes.get(checkNearestEnemy(i)).getX(),tributes.get(checkNearestEnemy(i)).getY());
                            tributes.get(i).subtractHunger();
                            updateAlive();
                            //checkNearestEnemy(i);
                            String temp1 = tributes.get(i).checkNeighborFight(tributes, gameGrid);
                            checkHealth();
                            if (!Objects.equals(temp1, "")) {
                                eventLog.getItems().add(temp1);
                            }


                            tributes.get(i).resetStartTime();
                        }
                    }

                    if (now - chests.get(0).getStartTime() > 1000000000.0) {
                        for (Specials c : chests) {
                            String temp = c.loot(tributes, gameGrid);
                            if (!temp.equals("")) {
                                eventLog.getItems().add(temp);
                            }

                            //eventLog.getItems().add(c.loot(tributes,gameGrid));
                        }
                        for (Specials b : bushes) {
                            String temp = b.loot(tributes, gameGrid);
                            if (!temp.equals("")) {
                                eventLog.getItems().add(temp);
                                checkHealth();
                            }
                        }


                    }
                    for (Bison b : bisons) {
                        if (now - b.getStartTime() > 1000000000.0) {
                            String temp = b.hunt(tributes, gameGrid);
                            b.changeLoc(gameGrid, 15);
                            if (!temp.equals("")) {
                                eventLog.getItems().add(temp);
                                checkHealth();
                            }
                            b.resetStartTime();
                        }

                    }
                }
                updateScreen();

//                System.out.println("test");
            }
        }.start();
    }

    public void checkHealth(){
        boolean oneDead = false;
        int index = 0;
        int alive = 0;
        String nameTemp ="";
        if(tributes.size()>0) {
            while(index <tributes.size()) {
                if (tributes.get(index).getDefense() <= 0) {
                    gameGrid[tributes.get(index).getX()][tributes.get(index).getY()] = 0;
                    updateScreen();
                    oneDead = true;
                    if(tributes.get(index).isAlive()) {
                        tributes.get(index).setDead();


                    }
                    //System.out.println(tributes.get(index).getName() + " is dead" + tributes.get(index).isAlive());
                    //System.out.println(people.get(1).getTribe());

                }
                index++;
            }
            if(oneDead){
                updateAlive();
            }

            for(People i: tributes){
                if(i.isAlive()){
                    alive+=1;
                    nameTemp = i.getName();
                }
            }
            if(alive == 1){
                tabPane.getSelectionModel().selectNext();
                finalLabel.setText(nameTemp+" has won the hunger games!");
            }
            /*if(tempI.size()>0){
                for(int i = 0; i<tempI.size();i++){
                    gameGrid[people.get(i).getX()][people.get(i).getY()] = 0;
                    updateScreen();
                    people.remove(tempI.get(i));
                    System.out.println(people.get(1).getTribe());
                }
            }
        }
        tempI.clear();*/
        }
    }
    public void updateAlive(){
        aliveView.getItems().clear();
        for(People i: tributes){
            if(i.isAlive()){
                aliveView.getItems().add(i.getName());
            }
        }
    }

    public int checkNearestEnemy(int i){
        int minDistance = 2500;
        int place = i;
        if(tributes.size()>0) {
            for (int j = 0; j < tributes.size(); j++) {

                int temp = distance(tributes.get(j).getX(), tributes.get(i).getX(), tributes.get(j).getY(), tributes.get(i).getY());
                if (temp < minDistance && i != j && tributes.get(j).isAlive()) {
                    minDistance = temp;

                    place = j;
                }

            }
        }


        return place;
    }

    public int nearestChest(int i){
        int minDistance = 2500;
        int place = i;
        for(int j = 0; j<chests.size();j++){
            int temp = distance(chests.get(j).getX(),tributes.get(i).getX(),chests.get(j).getY(),tributes.get(i).getY());
            if(temp<minDistance){
                minDistance = temp;
                place = j;
            }
        }
        return place;
    }
    public int nearestBush(int i){
        int minDistance = 2500;
        int place = i;
        for(int j = 0; j<bushes.size();j++){
            int temp = distance(bushes.get(j).getX(),tributes.get(i).getX(),bushes.get(j).getY(),tributes.get(i).getY());
            if(temp<minDistance){
                minDistance = temp;
                place = j;
            }
        }
        return place;
    }

    public int nearestBison(int i){
        int minDistance = 2500;
        int place = i;
        for(int j = 0; j<bisons.size();j++){
            int temp = distance(bisons.get(j).getX(),tributes.get(i).getX(),bisons.get(j).getY(),tributes.get(i).getY());
            if(temp<minDistance){
                minDistance = temp;
                place = j;
            }
        }
        return place;
    }
    public int distance(int x1, int x2, int y1, int y2){

        double d;
        d = sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        int temp = (int)d;
        return temp;
    }

    public void path(int [][] gameGrid, int i, int val, int chestX, int chestY,int bushX, int bushY,int enemyX,int enemyY, int bisonX, int bisonY) {
        if (tributes.get(i).isAlive()) {
            if(tributes.get(i).getHunger()==50){
                eventLog.getItems().add(tributes.get(i).getName() + " is hungry so they have to look for food");
            }

            if (tributes.get(i).getHunger() < 50 && tributes.get(i).getHunting()<70) {
                tributes.get(i).findSpecials(gameGrid, bushX, bushY);
                //System.out.println("hungry");

            }else if(tributes.get(i).getHunger()<50){
                tributes.get(i).findSpecials(gameGrid,bisonX,bisonY);
            }

            else if (tributes.get(i).isHasWeapon() == 0) {
                tributes.get(i).findSpecials(gameGrid, chestX, chestY);
                //System.out.println("looking for loot");
            } else /*if(tributes.get(i).getDefense()>=30||tributes.size()<5)*/{
                tributes.get(i).findSpecials(gameGrid,enemyX,enemyY);


            }/*else if(tributes.get(i).getDefense()<30){
                tributes.get(i).flee(gameGrid,enemyX,enemyY);
            }else{
                tributes.get(i).changeLoc(gameGrid,val);
            }*/
            /*else {
                tributes.get(i).changeLoc(gameGrid, val);
            }*/




        }
    }










}