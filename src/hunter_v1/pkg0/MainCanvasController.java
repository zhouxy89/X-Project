/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import static hunter_v1.pkg0.QuestionCanvas1Controller.pickFirstAnswerTime;
import static hunter_v1.pkg0.QuestionCanvas2Controller.followedShipAnswer;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static jdk.nashorn.internal.objects.NativeRegExp.source;


/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class MainCanvasController implements Initializable {
    
    
    @FXML
    private AnchorPane scene;
    @FXML
    private StackPane MainCanvas;
    
    @FXML
    private BorderPane parameters;
    
    @FXML
    private BorderPane gamePane;
    
    @FXML
    private BorderPane begin;
    
    @FXML
    private WelcomeCanvasController welcomeController;
    
    @FXML
    private Button btnShip1;
    @FXML
    private Button btnShip2;
    @FXML
    private Button btnShip3;
    @FXML
    private Button btnShip4;
    @FXML
    private Button btnShip5;
    @FXML
    private Button btnShip6;
    
    @FXML
    private Button btnMyShip;
    
    @FXML
    private Button btnUp;
    @FXML
    private Button btnDown;
    @FXML
    private Button btnLeft;
    @FXML
    private Button btnRight;
    
    @FXML
    private Text status;
    @FXML
    private Text timeup;
    
    @FXML
    public Text trialText;
    
    @FXML
    private Button endGame;
    
    @FXML
    private Button nextPractice;
    
    @FXML
    private Button btnParameters;
    
    @FXML
    public Text stepCounter;
    
    private Button patrolShip1;
    private Button patrolShip2;
    
    private static final int      KEYBOARD_MOVEMENT_DELTA = 15;
    
    private double randomElement;
    
    
    double MyShipX = 0;
    double MyShipY = 0;
    
    double distance_afterMove;
    double distance_beforeMove;
    
    public int step = 0;
    
    static int lastStep=0;
    
    int[][] canvas;
    int[] randomStop_ship1;
    int[] randomStop_ship2;
    int[] randomStop_ship3;
    int[] randomStop_ship4;
    int canvasWidth= 0;
    int canvasHeight= 0;
    int shipWidth= 0;
    int shipHeight= 0;
    int MyShipWidth=0;
    int MyShipHeight=0;
    int moveX=0;
    int moveY=0;
    int randomMoveX=0;
    int randomMoveY=0;
    int randomNum1=0;
    int randomNum2=0;
    int ShipX= 0;
    int ShipY= 0;
    int targetStartX= 0;
    int targetStartY= 0;
    int hostileShipX=0;
    int hostileShipY=0;
    int moveDirect=0;
    int circleStep=0;
    int currentMyShipX=0;
    int currentMyShipY=0;
    int moveDistancePerStep=15;
    int distanceFromLastPoint_toShip=27+moveDistancePerStep*2;
    int distanceFromCurrentPoint_toShip=0;
    int totalSteps=25;
    int totalDistance=0;
    int totalDistance1=0;
    int totalDistance2=0;
    int sigleLength = 0;
    int sigleWidth = 0;
    int sigleLength1 = 0;
    int sigleWidth1 = 0;
    int sigleLength2 = 0;
    int sigleWidth2 = 0;
    int lengthDistance1 = 0;
    int widthDistance1 = 0;
    int lengthDistance2 = 0;
    int widthDistance2 = 0;
    int eachStepDistance = 0;
    int eachStepDistance1 = 0;
    int eachStepDistance2 = 0;
    int LDistance1_1 = 0;
    int WDistance1_1 = 0;
    int LDistance2_1 = 0;
    int WDistance2_1 = 0;
    int LDistance1_2 = 0;
    int WDistance1_2 = 0;
    int LDistance2_2 = 0;
    int WDistance2_2 = 0;
    int patrolShip1X = 0;
    int patrolShip1Y = 0;
    int patrolShip2X = 0;
    int patrolShip2Y = 0;
    int patrolStartX = 0;
    int patrolStartY = 0;    
    int DiagonaPointX1 = 0;
    int DiagonaPointY1 = 0;
    int DiagonaPointX2 = 0;
    int DiagonaPointY2 = 0;
    int DiagonaPointX3 = 0;
    int DiagonaPointY3 = 0;
    int DiagonaPointX4 = 0;
    int DiagonaPointY4 = 0;
    int DiagonaPointX = 0;
    int DiagonaPointY = 0;
    int dPointX1 = 0;
    int dPointY1 = 0;
    int dPointX2 = 0;
    int dPointY2 = 0;
    List<Integer>DPXList=Arrays.asList(1,2,3,4);
    List<Integer>DPYList=Arrays.asList(1,2,3,4);
    
    public static int noChange=0;
    public static int count=0;
    //int totalTrials=38;
    public static int trialNum=0;
    Button[] allShips= new Button[7];
    
    public static int dateTime=0;
    public static String filepath = "";
    public static String home = "";
    public File file = null;    
    FileWriter writer= null;
    PrintWriter move = null;
    String recordLine="";
    
    List<Integer> currentBlock=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    public static List<Integer> block50=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    public static List<Integer> block75=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    public static List<Integer> block100=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    public static List<List> blockListAfterShuffle = Arrays.asList(block100,block75,block50);
    int trialInBlock = 0;
    //public static int blockListAfterShuffle_number=0;
    
    public boolean beFollowed = false;
    public static Button followShipBtn =null;
    public static int followShip=0;
    List<Button> shipList = null;
    List<Button> newShipList = null;
    
    int X_zone1=28;
    int X_zone2=260;
    int X_zone3=492;
    int X_zone4=724;
    
    int Y_zone1=32;
    int Y_zone2=180;
    int Y_zone3=328;
    int Y_zone4=475;
    
    int XZoneWidth=232;
    int YZoneWidth=148;
    
    int targetX = 0;
    int targetY = 0;
    
    Integer[]zoneX1 = new Integer[232];
    Integer[]zoneX2 = new Integer[232];
    Integer[]zoneX3 = new Integer[232];
    Integer[]zoneY1 = new Integer[148];
    Integer[]zoneY2 = new Integer[148];
    Integer[]zoneY3 = new Integer[148];


    int randomX1 = 0;
    int randomY1 = 0;
    int randomX2 = 0;
    int randomY2 = 0;
    int randomX3 = 0;
    int randomY3 = 0;
    
    List<Integer> X1List = null;
    List<Integer> X2List = null;
    List<Integer> X3List = null;
    List<Integer> Y1List = null;
    List<Integer> Y2List = null;
    List<Integer> Y3List = null;
    
    Random rand = new Random();
    
    int[]setTarget1_100 = null;
    int[]setTarget2_100 = null;
    int[]setTarget3_100 = null;
    int[]setCirclePath1_100 = null;
    int[]setCirclePath2_100 = null;
    int[]setTarget4_100 = null;
    int[]setTarget5_100 = null;
    int[]setTarget6_100 = null;
    int[]setCirclePath3_100 = null;
    int[]setTarget7_100 = null;
    int[]setTarget8_100 = null;
    int[]setTarget9_100 = null;
    int[]setTarget10_100 = null;
    int[]setCirclePath4_100 = null;
    
    
    int[]setTarget1_75 = null;
    int[]setTarget2_75 = null;
    int[]setTarget3_75 = null;
    int[]setCirclePath1_75 = null;
    int[]setCirclePath2_75 = null;
    int[]setTarget4_75 = null;
    int[]setTarget5_75 = null;
    int[]setTarget6_75 = null;
    int[]setCirclePath3_75 = null;
    int[]setTarget7_75 = null;
    int[]setTarget8_75 = null;
    int[]setTarget9_75 = null;
    int[]setTarget10_75 = null;
    int[]setCirclePath4_75 = null;
    int[]setCirclePath5_75 = null;
    int[]setPatrolTarget1 = null;
    int[]setPatrolTarget2 = null;
    
    int[]setTarget1_50 = null;
    int[]setTarget2_50 = null;
    int[]setTarget3_50 = null;
    int[]setCirclePath1_50 = null;
    int[]setCirclePath2_50 = null;
    int[]setTarget4_50 = null;
    int[]setTarget5_50 = null;
    int[]setTarget6_50 = null;
    int[]setCirclePath3_50 = null;
    int[]setTarget7_50 = null;
    int[]setTarget8_50 = null;
    int[]setTarget9_50 = null;
    int[]setTarget10_50 = null;
    int[]setCirclePath4_50 = null;
    
    public static int rightGuess=0;
    
    public static String hunterActive="";
    
    String ship1active = "";
    String ship2active = "";
    String ship3active = "";
    String ship4active = "";
    String ship5active = "";
    String ship6active = "";
    String active = "";
    static String record = "";
    
    public static List<Integer> lastStepX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> lastStepY = Arrays.asList(1,2,3,4,5,6,7);
    
    public static List<Integer> lastStepPracticX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> lastStepPracticY = Arrays.asList(1,2,3,4,5,6,7);
    
    static String keyPressTime = "";
    public static String endTime = "";
    public static String myShipDirection = "";
    public static String startGameTime = "";
    
    int participantID = 0;
    static int PID = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        begin.setVisible(false);
        parameters.setVisible(false);
        endGame.setDisable(true);
        endGame.setFocusTraversable(false);
        nextPractice.setFocusTraversable(false);
        gamePane.setVisible(true);
        
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        welcomeController.setTrialFromResultCanvas(welcomeController.trialFromResult());
        

        trialNum+=1;
        if(trialNum<3){
            trialText.setText("Practice Trial");
            endGame.setVisible(false);
        }
        else{
        endGame.setVisible(true);
        nextPractice.setVisible(false);
        trialText.setText("Trial: "+String.valueOf(trialNum-2));
        System.out.println("Current trial: "+trialNum);
        }
        welcomeController.setFileNameFromResultCanvas(welcomeController.fileNameFromResultCanvas());
        welcomeController.setblockListFromResultCanvas(welcomeController.blockListAfterShuffleFromResultCanvas());
        String home = System.getProperty("user.home");
        filepath = home+"/Downloads/"+ "ShadowHunt_"+dateTime+ ".csv";
        //filepath = "/Users/zhouxiaoyan/Downloads/"+ "ShadowHunt_"+dateTime+ ".csv";
        file = new File(filepath);
        //participantID=(int)((Math.random()*9+1)*1000000000);
        System.out.println("participantID: "+participantID);
        //System.out.println("file: "+file);
        welcomeController.setrightGuessFromResultCanvas(welcomeController.rightGuessFromResult());
        System.out.println("welcomeController.rightGuessFromResult(): "+welcomeController.rightGuessFromResult());
        
        
        assignTrialInBlock();
        //System.out.println("welcomeController.blockListAfterShuffleFromResultCanvas()"+welcomeController.blockListAfterShuffleFromResultCanvas());
 
        randomAssignBlock();

        shipList = randomShipList();
        
        System.out.println("shipList1: "+shipList);
        setStartPosition();
        System.out.println("welcomeController.fileNameFromResultCanvas(): "+welcomeController.fileNameFromResultCanvas());
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        startGameTime = time.format(formatter);
    }
    

    

    @FXML
    private void friendlyShipWithTarget(Button friendlyShip,int towardTargetX, int towardTargetY,int matchPercentage){
            
            clearShipsOnCanvas();
            setAllShipsOnCanvas(friendlyShip);
            if(step==1){
                targetStartX = (int)friendlyShip.getLayoutX();
                targetStartY = (int)friendlyShip.getLayoutY();
            }
            ShipX= (int)friendlyShip.getLayoutX();
            ShipY= (int)friendlyShip.getLayoutY();
            shipWidth = (int)friendlyShip.getPrefWidth();
            shipHeight = (int)friendlyShip.getPrefHeight();
            
            if(step<totalSteps){
            //moveX=Math.round((towardTargetX-ShipX)/(totalSteps-step));
            //moveY=Math.round((towardTargetY-ShipY)/(totalSteps-step));
            moveX=Math.round((towardTargetX-targetStartX)/totalSteps);
            moveY=Math.round((towardTargetY-targetStartY)/totalSteps);
            }
            else{
             moveX = moveX;
             moveY = moveY;
            }
            
            //System.out.println("moveX: " +moveX);
            //System.out.println("moveY: " +moveY);
           
            randomMoveX = (int)givenList_shouldReturnARandomElement()+moveX;
            randomMoveY = (int)givenList_shouldReturnARandomElement()+moveY;
            
            randomNum1 = (int)givenList_shouldReturnARandomElement()+ ShipX;
            randomNum2 = (int)givenList_shouldReturnARandomElement()+ ShipY;
  
            
            if(ShipX-shipWidth/2+randomMoveX<0){
                randomMoveX=0;
            }
            
            if(canvasWidth<ShipX+shipWidth/2+randomMoveX){
                randomMoveX=0;
            }
            
            if(ShipY-shipHeight/2+randomMoveY<0){
                randomMoveY=0;
            }
            
            if(canvasHeight<ShipY+shipHeight+randomMoveY){
                randomMoveY=0;
            }
            
//            System.out.println((ShipX+randomMoveX) +","+(ShipY+shipHeight/2+randomMoveY));
//            System.out.println((ShipX+randomMoveX) +","+(ShipY-shipHeight/2+randomMoveY));
//            System.out.println((ShipX+shipWidth/2+randomMoveX) +","+(ShipY+randomMoveY));
//            System.out.println((ShipX-shipWidth/2+randomMoveX) +","+(ShipY+randomMoveY));
//            System.out.println(canvas[ShipX+randomMoveX][ShipY+shipHeight/2+randomMoveY]);
//            System.out.println(canvas[ShipX+randomMoveX][ShipY-shipHeight/2+randomMoveY]);
//            System.out.println(canvas[ShipX+shipWidth/2+randomMoveX][ShipY+randomMoveY]);
//            System.out.println(canvas[ShipX-shipWidth/2+randomMoveX][ShipY+randomMoveY]);
//            
            if(canvas[ShipX+randomMoveX][ShipY+shipHeight/2+randomMoveY]==1){
                randomMoveX=0;
                randomMoveY=0;
            }
            //if(ShipX-shipWidth/2+randomMoveX >=0 && ShipY-shipHeight/2+randomMoveY>=0){
            if(canvas[ShipX+randomMoveX][ShipY-shipHeight/2+randomMoveY]==1){
                randomMoveX=0;
                randomMoveY=0;
            }
            //}
            //if(ShipY-shipHeight/2+randomMoveY>=0){
            if(canvas[ShipX+shipWidth/2+randomMoveX][ShipY+randomMoveY]==1){
                randomMoveX=0;
                randomMoveY=0;
            }
            //}
            //if(ShipX-shipWidth/2+randomMoveX>=0){
            if(canvas[ShipX-shipWidth/2+randomMoveX][ShipY+randomMoveY]==1){
                randomMoveX=0;
                randomMoveY=0;
            }
            //}
                
           
            
//            for (int i = 0; i < stop.length; i++){
//                if (step == stop[i]){
//                randomMoveX=0;
//                randomMoveY=0;
//                }
//            } 

            if(isMoveToHunter(friendlyShip)==1){
                randomMoveX=0;
                randomMoveY=0;
            }
            
            
            
            switch (matchPercentage) {
            
                case 100:
                    if(canvas[ShipX +randomMoveX][ShipY +randomMoveY+shipHeight/2]!=1 && canvas[ShipX +randomMoveX][ShipY +randomMoveY-shipHeight/2]!=1 && canvas[ShipX +randomMoveX-shipWidth/2][ShipY +randomMoveY]!=1 &&canvas[ShipX +randomMoveX+shipWidth/2][ShipY +randomMoveY]!=1){
                        friendlyShip.relocate(ShipX +randomMoveX, ShipY +randomMoveY);
                    }
                    else{
                        friendlyShip.relocate(ShipX,ShipY);
                    }
                    break;
                
                case 75:
              
                    switch (step) {
                        case 3:
                        case 7:
                        case 10:
                        case 15:
                        case 17:
                        case 22:
                            if(canvas[randomNum1][randomNum2+shipHeight]!=1 && canvas[randomNum1][randomNum2-shipHeight]!=1 && canvas[randomNum1-shipWidth][randomNum2]!=1 &&canvas[randomNum1+shipWidth][randomNum2]!=1){
                                friendlyShip.relocate(randomNum1, randomNum2);
                            }
                            else{
                                friendlyShip.relocate(ShipX,ShipY);
                            }
                            break;
                
                        default:
                            if(canvas[ShipX +randomMoveX][ShipY +randomMoveY+shipHeight]!=1 && canvas[ShipX +randomMoveX][ShipY +randomMoveY-shipHeight]!=1 && canvas[ShipX +randomMoveX-shipWidth][ShipY +randomMoveY]!=1 &&canvas[ShipX +randomMoveX+shipWidth][ShipY +randomMoveY]!=1){
                                friendlyShip.relocate(ShipX+randomMoveX, ShipY+randomMoveY);
                            }
                            else{
                                friendlyShip.relocate(ShipX,ShipY);
                            }
                            break;
                    }
                    break;
                    
                case 50:
              
                    switch (step) {
                        case 2:
                        case 3:
                        case 4:
                        case 8:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                        case 21:
                        case 22:
                        case 23:
                            if(canvas[randomNum1][randomNum2+shipHeight]!=1 && canvas[randomNum1][randomNum2-shipHeight]!=1 && canvas[randomNum1-shipWidth][randomNum2]!=1 &&canvas[randomNum1+shipWidth][randomNum2]!=1){
                                friendlyShip.relocate(randomNum1, randomNum2);
                            }
                            else{
                                friendlyShip.relocate(ShipX,ShipY);
                            }
                            break;
                
                        default:
                            if(canvas[ShipX +randomMoveX][ShipY +randomMoveY+shipHeight]!=1 && canvas[ShipX +randomMoveX][ShipY +randomMoveY-shipHeight]!=1 && canvas[ShipX +randomMoveX-shipWidth][ShipY +randomMoveY]!=1 &&canvas[ShipX +randomMoveX+shipWidth][ShipY +randomMoveY]!=1){
                                friendlyShip.relocate(ShipX +randomMoveX, ShipY +randomMoveY);
                            }
                            else{
                                friendlyShip.relocate(ShipX,ShipY);
                            }
                            break;
                    }
                    break;
                        
                            
            }
            
            
         
    }
    
    @FXML
    
    private void friendlyShipWithPatrolBehavior(Button friendlyShip, int diagonaPointX,int diagonaPointY,int steps, int matchPercentage ){
        clearShipsOnCanvas();
        setAllShipsOnCanvas(friendlyShip);
        int patrolShipX = (int)friendlyShip.getLayoutX();
        int patrolShipY = (int)friendlyShip.getLayoutY();
        int rand1 = 0;
        int rand2 = 0;
        
        rand1 = (int)givenList_shouldReturnARandomElement();
        rand2 = (int)givenList_shouldReturnARandomElement();
               
        
        switch (matchPercentage) {
            
                case 100:
                    patrolAction(friendlyShip, diagonaPointX,diagonaPointY,steps);
                    break;
                
                case 75:
              
                    switch (step) {
                        case 3:
                        case 7:
                        case 10:
                        case 15:
                        case 17:
                        case 22:
                            if(canvas[patrolShipX+rand1][patrolShipY+rand2+shipHeight/2]!=1 && canvas[patrolShipX+rand1][patrolShipY+rand2-shipHeight/2]!=1 && canvas[patrolShipX+rand1-shipWidth/2][patrolShipY+rand2]!=1 &&canvas[patrolShipX+rand1+shipWidth/2][patrolShipY+rand2]!=1){
                                friendlyShip.relocate(patrolShipX +rand1, patrolShipY +rand2);
                            }
                            else{
                                friendlyShip.relocate(patrolShipX,patrolShipY);
                            }
                            break;
                
                        default:
                            patrolAction(friendlyShip, diagonaPointX,diagonaPointY,steps);
                            break;
                    }
                    break;
                    
                case 50:
              
                    switch (step) {
                        case 2:
                        case 3:
                        case 4:
                        case 8:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                        case 21:
                        case 22:
                        case 23:
                            
                            if(canvas[patrolShipX+rand1][patrolShipY+rand2+shipHeight/2]!=1 && canvas[patrolShipX+rand1][patrolShipY+rand2-shipHeight/2]!=1 && canvas[patrolShipX+rand1-shipWidth/2][patrolShipY+rand2]!=1 &&canvas[patrolShipX+rand1+shipWidth/2][patrolShipY+rand2]!=1){
                                friendlyShip.relocate(patrolShipX +rand1, patrolShipY +rand2);
                            }
                            else{
                                friendlyShip.relocate(patrolShipX,patrolShipY);
                            }
                            
                            break;
                
                        default:
                            patrolAction(friendlyShip, diagonaPointX,diagonaPointY,steps);
                            break;
                    }
                    break;
                        
                            
            }
        
    }
    
    @FXML
    
    private void patrolAction(Button friendlyShip, int diagonaPointX,int diagonaPointY,int steps){
        int friendlyShipX = (int)friendlyShip.getLayoutX();
        int friendlyShipY = (int)friendlyShip.getLayoutY();
        
        System.out.println("friendlyShipX: "+friendlyShipX);
        System.out.println("friendlyShipY: "+friendlyShipY);
        
        if((LDistance1_1 ==LDistance2_1&&LDistance2_1!=0&&WDistance1_1==0)||(WDistance1_1==WDistance2_1&&WDistance2_1!=0)){
            LDistance1_1=0 ;
            WDistance1_1=0;
            LDistance2_1=0;
            WDistance2_1=0;
        }
        
        if((LDistance1_2 ==LDistance2_2&&LDistance2_2!=0&&WDistance1_2==0)||(WDistance1_2==WDistance2_2&&WDistance2_2!=0)){
            LDistance1_2=0 ;
            WDistance1_2=0;
            LDistance2_2=0;
            WDistance2_2=0;
        }
        
        
        if(step==1&&eachStepDistance==0){
            patrolShip1=friendlyShip;
            patrolShip1X = (int)patrolShip1.getLayoutX();
            patrolShip1Y = (int)patrolShip1.getLayoutY();
            sigleLength1 = Math.abs(diagonaPointY - friendlyShipY);
            sigleWidth1 = Math.abs(diagonaPointX - friendlyShipX);
            totalDistance1 = sigleLength1*2+sigleWidth1*2;
            eachStepDistance1 = totalDistance1/steps;
            dPointX1 = diagonaPointX;
            dPointY1 = diagonaPointY;
            
        }
        else if(step==1&&eachStepDistance!=0){
            patrolShip2=friendlyShip;
            patrolShip2X = (int)patrolShip2.getLayoutX();
            patrolShip2Y = (int)patrolShip2.getLayoutY();
            sigleLength2 = Math.abs(diagonaPointY - friendlyShipY);
            sigleWidth2 = Math.abs(diagonaPointX - friendlyShipX);
            totalDistance2 = sigleLength2*2+sigleWidth2*2;
            eachStepDistance2 = totalDistance2/steps;
            dPointX2 = diagonaPointX;
            dPointY2 = diagonaPointY;
        }
        
        if(friendlyShip==patrolShip1){
            sigleLength = sigleLength1;
            sigleWidth = sigleWidth1;
            totalDistance = totalDistance1;
            eachStepDistance = eachStepDistance1;
            diagonaPointX = dPointX1;
            diagonaPointY = dPointY1;
            lengthDistance1 = LDistance1_1 ;
            widthDistance1 = WDistance1_1;
            lengthDistance2 = LDistance2_1;
            widthDistance2 = WDistance2_1;
            patrolStartX = patrolShip1X;
            patrolStartY = patrolShip1Y;
        }
        else if(friendlyShip==patrolShip2){
            sigleLength = sigleLength2;
            sigleWidth = sigleWidth2;
            totalDistance = totalDistance2;
            eachStepDistance = eachStepDistance2;
            diagonaPointX = dPointX2;
            diagonaPointY = dPointY2;
            lengthDistance1 = LDistance1_2 ;
            widthDistance1 = WDistance1_2;
            lengthDistance2 = LDistance2_2;
            widthDistance2 = WDistance2_2;
            patrolStartX = patrolShip2X;
            patrolStartY = patrolShip2Y;
        }
        
        System.out.println("totalDistance: "+totalDistance);
        System.out.println("eachStepDistance: "+eachStepDistance);
        System.out.println("sigleLength: "+sigleLength);
        System.out.println("sigleWidth: "+sigleWidth);
        System.out.println("diagonaPointX: "+diagonaPointX);
        System.out.println("diagonaPointY: "+diagonaPointY);
        if(isMoveToHunter(friendlyShip)!=1){
        if(diagonaPointY>patrolStartY&&diagonaPointX>patrolStartX){
            if(friendlyShipY+eachStepDistance<=diagonaPointY&&friendlyShipX+eachStepDistance<=diagonaPointX&&lengthDistance1+eachStepDistance<=sigleLength){
                if(canvas[friendlyShipX][friendlyShipY+eachStepDistance+shipHeight]!=1 && canvas[friendlyShipX][friendlyShipY+eachStepDistance-shipHeight]!=1 && canvas[friendlyShipX-shipWidth][friendlyShipY+eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY+eachStepDistance]!=1){
                    friendlyShip.relocate(friendlyShipX,friendlyShipY+eachStepDistance);
                    lengthDistance1=lengthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance1_1 = lengthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance1_2 = lengthDistance1;
                }
            }
            else if(friendlyShipY+eachStepDistance>diagonaPointY&&friendlyShipX+eachStepDistance<=diagonaPointX&&widthDistance1+eachStepDistance<=sigleWidth){
                if(canvas[friendlyShipX+eachStepDistance][friendlyShipY+shipHeight]!=1 &&canvas[friendlyShipX+eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX+eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX+eachStepDistance+shipWidth][friendlyShipY]!=1){
                    friendlyShip.relocate(friendlyShipX+eachStepDistance,friendlyShipY);
                    widthDistance1=widthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance1_1 = widthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance1_2 = widthDistance1;
                }
            }
            else if(lengthDistance2+eachStepDistance<=lengthDistance1){
                if(canvas[friendlyShipX][friendlyShipY-eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY-eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY-eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY-eachStepDistance]!=1){
                    friendlyShip.relocate(friendlyShipX,friendlyShipY-eachStepDistance);
                    lengthDistance2=lengthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance2_1 = lengthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance2_2 = lengthDistance2;
                }

            }
            else if(widthDistance2+eachStepDistance<=widthDistance1){
                if(canvas[friendlyShipX-eachStepDistance][friendlyShipY+shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX-eachStepDistance+shipWidth][friendlyShipY]!=1){
                    friendlyShip.relocate(friendlyShipX-eachStepDistance,friendlyShipY);
                    widthDistance2=widthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance2_1 = widthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance2_2 = widthDistance2;
                }
            }
        }
        else if(diagonaPointY>patrolStartY&&diagonaPointX<patrolStartX){
            //System.out.println("friendlyShipX-eachStepDistance: "+(friendlyShipX-eachStepDistance));
            //System.out.println("friendlyShipY+eachStepDistance: "+(friendlyShipY+eachStepDistance));
            //System.out.println("diagonaPointX: "+diagonaPointX);
            //System.out.println("diagonaPointY: "+diagonaPointY);
            
            if(friendlyShipY+eachStepDistance<=diagonaPointY&&friendlyShipX-eachStepDistance>=diagonaPointX&&lengthDistance1+eachStepDistance<=sigleLength){
                if(canvas[friendlyShipX][friendlyShipY+eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY+eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY+eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY+eachStepDistance]!=1){
                friendlyShip.relocate(friendlyShipX,friendlyShipY+eachStepDistance);
                lengthDistance1=lengthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance1_1 = lengthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance1_2 = lengthDistance1;
                }
            }
            else if(friendlyShipY+eachStepDistance>diagonaPointY&&friendlyShipX-eachStepDistance>=diagonaPointX&&widthDistance1+eachStepDistance<=sigleWidth){
                if(canvas[friendlyShipX-eachStepDistance][friendlyShipY+shipHeight]!=1&&canvas[friendlyShipX-eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX-eachStepDistance+shipWidth][friendlyShipY]!=1){
                friendlyShip.relocate(friendlyShipX-eachStepDistance,friendlyShipY); 
                widthDistance1=widthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance1_1 = widthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance1_2 = widthDistance1;
                } 
            }
            else if(lengthDistance2+eachStepDistance<=lengthDistance1){
                if(canvas[friendlyShipX][friendlyShipY-eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY-eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY-eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY-eachStepDistance]!=1){
                friendlyShip.relocate(friendlyShipX,friendlyShipY-eachStepDistance);
                lengthDistance2=lengthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                System.out.println("lengthDistance2: "+lengthDistance2);
                if(friendlyShip==patrolShip1){
                    LDistance2_1 = lengthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance2_2 = lengthDistance2;
                }
            

            }
            else if(widthDistance2+eachStepDistance<=widthDistance1){
                if(canvas[friendlyShipX+eachStepDistance][friendlyShipY+shipHeight]!=1&&canvas[friendlyShipX+eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX+eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX+eachStepDistance+shipWidth][friendlyShipY]!=1){
                friendlyShip.relocate(friendlyShipX+eachStepDistance,friendlyShipY);
                widthDistance2=widthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance2_1 = widthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance2_2 = widthDistance2;
                }
            }
        }
        else if(diagonaPointY<patrolStartY&&diagonaPointX>patrolStartX){
            if(friendlyShipY-eachStepDistance>=diagonaPointY&&friendlyShipX+eachStepDistance<=diagonaPointX&&lengthDistance1+eachStepDistance<=sigleLength){
                if(canvas[friendlyShipX][friendlyShipY-eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY-eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY-eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY-eachStepDistance]!=1){
                friendlyShip.relocate(friendlyShipX,friendlyShipY-eachStepDistance);
                lengthDistance1=lengthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance1_1 = lengthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance1_2 = lengthDistance1;
                }
            }
            else if(friendlyShipY-eachStepDistance<diagonaPointY&&friendlyShipX+eachStepDistance<=diagonaPointX&&widthDistance1+eachStepDistance<=sigleWidth){
                if(canvas[friendlyShipX+eachStepDistance][friendlyShipY+shipHeight]!=1&&canvas[friendlyShipX+eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX+eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX+eachStepDistance+shipWidth][friendlyShipY]!=1){
                friendlyShip.relocate(friendlyShipX+eachStepDistance,friendlyShipY);
                widthDistance1=widthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance1_1 = widthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance1_2 = widthDistance1;
                }
            }
            else if(lengthDistance2+eachStepDistance<=lengthDistance1){
                if(canvas[friendlyShipX][friendlyShipY+eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY+eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY+eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY+eachStepDistance]!=1){
                friendlyShip.relocate(friendlyShipX,friendlyShipY+eachStepDistance);
                lengthDistance2=lengthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance2_1 = lengthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance2_2 = lengthDistance2;
                }

            }
            else if(widthDistance2+eachStepDistance<=widthDistance1){
                if(canvas[friendlyShipX-eachStepDistance][friendlyShipY+shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX-eachStepDistance+shipWidth][friendlyShipY]!=1){
                friendlyShip.relocate(friendlyShipX-eachStepDistance,friendlyShipY);
                widthDistance2=widthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance2_1 = widthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance2_2 = widthDistance2;
                }
            }
        }
        else if(diagonaPointY<patrolStartY&&diagonaPointX<patrolStartX){
            if(friendlyShipY-eachStepDistance>=diagonaPointY&&friendlyShipX-eachStepDistance>=diagonaPointX&&lengthDistance1+eachStepDistance<=sigleLength){
                if(canvas[friendlyShipX][friendlyShipY-eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY-eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY-eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY-eachStepDistance]!=1){
                friendlyShip.relocate(friendlyShipX,friendlyShipY-eachStepDistance);
                lengthDistance1=lengthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance1_1 = lengthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance1_2 = lengthDistance1;
                }
            }
            else if(friendlyShipY-eachStepDistance<diagonaPointY&&friendlyShipX-eachStepDistance>=diagonaPointX&&widthDistance1+eachStepDistance<=sigleWidth){
                if(canvas[friendlyShipX-eachStepDistance][friendlyShipY+shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX-eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX-eachStepDistance+shipWidth][friendlyShipY]!=1){
                friendlyShip.relocate(friendlyShipX-eachStepDistance,friendlyShipY); 
                widthDistance1=widthDistance1+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance1_1 = widthDistance1;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance1_2 = widthDistance1;
                }
            }
            else if(lengthDistance2+eachStepDistance<=lengthDistance1){
                if(canvas[friendlyShipX][friendlyShipY+eachStepDistance+shipHeight]!=1 &&canvas[friendlyShipX][friendlyShipY+eachStepDistance-shipHeight]!=1 &&canvas[friendlyShipX-shipWidth][friendlyShipY+eachStepDistance]!=1 &&canvas[friendlyShipX+shipWidth][friendlyShipY+eachStepDistance]!=1){
                friendlyShip.relocate(friendlyShipX,friendlyShipY+eachStepDistance);
                lengthDistance2=lengthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    LDistance2_1 = lengthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    LDistance2_2 = lengthDistance2;
                }

            }
            else if(widthDistance2+eachStepDistance<=widthDistance1){
                if(canvas[friendlyShipX+eachStepDistance][friendlyShipY+shipHeight]!=1&&canvas[friendlyShipX+eachStepDistance][friendlyShipY-shipHeight]!=1 &&canvas[friendlyShipX+eachStepDistance-shipWidth][friendlyShipY]!=1 &&canvas[friendlyShipX+eachStepDistance+shipWidth][friendlyShipY]!=1){
                friendlyShip.relocate(friendlyShipX+eachStepDistance,friendlyShipY);
                widthDistance2=widthDistance2+eachStepDistance;
                }
                else{
                    friendlyShip.relocate(friendlyShipX,friendlyShipY);
                    System.out.println("Stoped because of spot is occupied");
                }
                
                if(friendlyShip==patrolShip1){
                    WDistance2_1 = widthDistance2;
                }
                else if(friendlyShip==patrolShip2){
                    WDistance2_2 = widthDistance2;
                }
            }
        }
        System.out.println("lengthDistance1: "+lengthDistance1);
            System.out.println("widthDistance1: "+widthDistance1);
            System.out.println("lengthDistance2: "+lengthDistance2);
            System.out.println("widthDistance2: "+widthDistance2);
        }
        else{
            friendlyShip.relocate(friendlyShipX,friendlyShipY);
            System.out.println("Stoped because of yellow ship is coming");
        }
    }
    
    @FXML
    
    private void friendlyShipWithCirclePath(Button friendlyShip, int r, int x, int y, int steps,int matchPercentage ){
        clearShipsOnCanvas();
        setAllShipsOnCanvas(friendlyShip);
        
        int friednlyShipX = (int)friendlyShip.getLayoutX();
        int friednlyShipY = (int)friendlyShip.getLayoutY();
        int X = 0;
        int Y = 0;
        double radians = (Math.PI/180) * Math.round(360/steps);
        if(circleStep<steps) {  
        circleStep+=1;
        }
        else{
        circleStep=0;
        circleStep+=1;
        }
        if(isMoveToHunter(friendlyShip)!=1){
            X = (int) (x + r * Math.sin(radians * circleStep));
            Y = (int) (y + r * Math.cos(radians * circleStep));
        }
        else{
            X = friednlyShipX;
            Y = friednlyShipY;
        }
//        System.out.println("ship4: "+canvas[X][Y]);
//        System.out.println("ship4X: "+X);
//        System.out.println("ship4Y: "+Y);
        
        switch (matchPercentage) {
            
                case 100:
                    if(canvas[X][Y+shipHeight/2]!=1 && canvas[X][Y-shipHeight/2]!=1 && canvas[X-shipWidth/2][Y]!=1 && canvas[X+shipWidth/2][Y]!=1){
                        friendlyShip.relocate(X,Y);
                    }
                    else{
                        friendlyShip.relocate(friednlyShipX,friednlyShipY);
                    }
                    break;
                
                case 75:
              
                    switch (step) {
                        case 3:
                        case 7:
                        case 10:
                        case 15:
                        case 17:
                        case 22:
                            if(canvas[X][Y+shipHeight/2]!=1 && canvas[X][Y-shipHeight/2]!=1 && canvas[X-shipWidth/2][Y]!=1 && canvas[X+shipWidth/2][Y]!=1){
                                friendlyShip.relocate(friednlyShipX +givenList_shouldReturnARandomElement(), friednlyShipY +givenList_shouldReturnARandomElement());
                            }
                            else{
                                friendlyShip.relocate(friednlyShipX,friednlyShipY);
                            }
                            break;
                
                        default:
                            if(canvas[X][Y+shipHeight/2]!=1 && canvas[X][Y-shipHeight/2]!=1 && canvas[X-shipWidth/2][Y]!=1 && canvas[X+shipWidth/2][Y]!=1){
                                friendlyShip.relocate(X,Y);
                            }
                            else{
                                friendlyShip.relocate(friednlyShipX,friednlyShipY);
                            }
                            break;
                    }
                    break;
                    
        }
        
      
    }
    
    @FXML
    
    private void friendlyShipsChaseInCircle(Button friendlyShip1, Button friendlyShip2, int r, int x, int y, int steps,int matchPercentage){
        
        
        int friednlyShipX1 = (int)friendlyShip1.getLayoutX();
        int friednlyShipY1 = (int)friendlyShip1.getLayoutY();
        int friednlyShipX2 = (int)friendlyShip2.getLayoutX();
        int friednlyShipY2 = (int)friendlyShip2.getLayoutY();
        
        shipWidth = (int)friendlyShip1.getPrefWidth();
        shipHeight = (int)friendlyShip1.getPrefHeight();
        
        
        
        
        int X1 = 0;
        int Y1 = 0;
        int X2 = 0;
        int Y2 = 0;
        
        double radians = (Math.PI/180) * Math.round(360/steps);
        
//        System.out.println(friendlyShip1.getLayoutX());
//        System.out.println(friendlyShip1.getLayoutY());
//        System.out.println(friendlyShip2.getLayoutX());
//        System.out.println(friendlyShip2.getLayoutY());
        
        if(isMoveToHunter(friendlyShip1)!=1){
            X1 = (int) (x + r * Math.sin(radians * circleStep));
            Y1 = (int) (y + r * Math.cos(radians * circleStep));
        }
        else{
            X1 = friednlyShipX1;
            Y1 = friednlyShipY1;
        }
        
        if(isMoveToHunter(friendlyShip2)!=1){
            X2 = (int) (x + r * (Math.sin(radians * (circleStep+steps/2))));
            Y2 = (int) (y + r * (Math.cos(radians * (circleStep+steps/2))));
        }
        else{
            X2 = friednlyShipX2;
            Y2 = friednlyShipY2;
        }
        
        switch (matchPercentage) {
            
                case 100:
                    clearShipsOnCanvas();
                    setAllShipsOnCanvas(friendlyShip1);
                    if(canvas[X1][Y1+shipHeight/2]!=1 && canvas[X1][Y1-shipHeight/2]!=1 && canvas[X1-shipWidth/2][Y1]!=1 && canvas[X1+shipWidth/2][Y1]!=1){
                        friendlyShip1.relocate(X1,Y1);
                        
                    }
                    else{
                        friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);
                        
                    }
                    clearShipsOnCanvas();
                    setAllShipsOnCanvas(friendlyShip2);
                    if(canvas[X2][Y2+shipHeight/2]!=1 && canvas[X2][Y2-shipHeight/2]!=1 && canvas[X2-shipWidth/2][Y2]!=1 && canvas[X2+shipWidth/2][Y2]!=1){

                        friendlyShip2.relocate(X2,Y2);
                    }
                    else{
                        friendlyShip2.relocate(friednlyShipX2,friednlyShipY2);
                    }
                    break;
                
                case 75:
              
                    switch (step) {
                        case 3:
                        case 7:
                        case 10:
                        case 15:
                        case 17:
                        case 22:
                            clearShipsOnCanvas();
                            setAllShipsOnCanvas(friendlyShip1);
                            if(canvas[X1][Y1+shipHeight/2]!=1 && canvas[X1][Y1-shipHeight/2]!=1 && canvas[X1-shipWidth/2][Y1]!=1 && canvas[X1+shipWidth/2][Y1]!=1){
                                friendlyShip1.relocate(friednlyShipX1 +givenList_shouldReturnARandomElement(), friednlyShipY1 +givenList_shouldReturnARandomElement());
                            }
                            else{
                                friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);
                            }
                            clearShipsOnCanvas();
                            setAllShipsOnCanvas(friendlyShip2);
                            if(canvas[X2][Y2+shipHeight/2]!=1 && canvas[X2][Y2-shipHeight/2]!=1 && canvas[X2-shipWidth/2][Y2]!=1 && canvas[X2+shipWidth/2][Y2]!=1){
                            friendlyShip2.relocate(friednlyShipX2 +givenList_shouldReturnARandomElement(), friednlyShipY2 +givenList_shouldReturnARandomElement());
                            }
                            else{
                                friendlyShip2.relocate(friednlyShipX2,friednlyShipY2);
                            }
                            break;
                
                        default:
                            clearShipsOnCanvas();
                            setAllShipsOnCanvas(friendlyShip1);
                            if(canvas[X1][Y1+shipHeight/2]!=1 && canvas[X1][Y1-shipHeight/2]!=1 && canvas[X1-shipWidth/2][Y1]!=1 && canvas[X1+shipWidth/2][Y1]!=1){
                                friendlyShip1.relocate(X1,Y1);
//                                System.out.println("1rightX: "+(X1+shipWidth/2)+ " 1rightY: "+ Y1);
//                                System.out.println("1leftX: "+(X1-shipWidth/2)+" 1leftY: "+Y1);
//                                System.out.println("1downX: "+X1+" 1downY: "+(Y1+shipHeight/2));
//                                System.out.println("1upX: "+X1+" 1upY: "+(Y1-shipHeight/2));
//                                
                            }
                            else{
                                friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);

                            }
                            clearShipsOnCanvas();
                            setAllShipsOnCanvas(friendlyShip2);
                            if(canvas[X2][Y2+shipHeight/2]!=1 && canvas[X2][Y2-shipHeight/2]!=1 && canvas[X2-shipWidth/2][Y2]!=1 && canvas[X2+shipWidth/2][Y2]!=1){
                                friendlyShip2.relocate(X2,Y2);
//                                System.out.println("1rightX: "+(X2+shipWidth/2)+ " 2rightY: "+ Y2);
//                                System.out.println("2leftX: "+(X2-shipWidth/2)+" 2leftY: "+Y2);
//                                System.out.println("2downX: "+X2+" 2downY: "+(Y2+shipHeight/2));
//                                System.out.println("2upX: "+X2+" 2upY: "+(Y2-shipHeight/2));
                            }
                            else{
                                friendlyShip2.relocate(friednlyShipX2,friednlyShipY2);
                            }
//                            for (int i = X2-shipWidth/2; i <= X2+shipWidth/2; i++) {
//                                for (int j = Y2-shipHeight/2; j <= Y2+shipHeight/2; j++) {
//                                    if(canvas[x][y]==1){
//                                        friendlyShip2.relocate(friednlyShipX2,friednlyShipY2);
//                                    }
//                                    else{
//                                        friendlyShip2.relocate(X2,Y2);
//                                    }
//                                    
//                                }
//                            }
//                             
                            break;
                    }
                    break;
                    
        }
        
        if(circleStep<steps) {  
        circleStep+=1;
        }
        else{
        circleStep=1;
        }
        
        
    }
    
    
    
    @FXML
    
    private void hostileShipFollow(Button hostileShip, int matchPercentage){
        clearShipsOnCanvas();
        setAllShipsOnCanvas(hostileShip);
        
        hostileShipX = (int)hostileShip.getLayoutX();
        hostileShipY = (int)hostileShip.getLayoutY();
        shipWidth = (int)hostileShip.getPrefWidth();
        shipHeight = (int)hostileShip.getPrefHeight();
        
        int X = hostileShipX;
        int Y = hostileShipY;
        
        
        
        switch (moveDirect) {
            
          case 1: 
              if(hostileShipY>14 && isMoveToHunter(hostileShip)==0 && canvas[hostileShipX-shipWidth/2][hostileShipY- KEYBOARD_MOVEMENT_DELTA-shipHeight/2]!=1&& canvas[hostileShipX+shipWidth/2][hostileShipY- KEYBOARD_MOVEMENT_DELTA-shipHeight/2]!=1){
                 Y = hostileShipY- KEYBOARD_MOVEMENT_DELTA;
              }
              else{
                 Y = hostileShipY;
              }
//              System.out.println("UP"+canvas[hostileShipX][hostileShipY- KEYBOARD_MOVEMENT_DELTA]);
              break;
              
          case 2:
              if(hostileShipX<scene.getPrefWidth()- hostileShip.getPrefWidth()&& isMoveToHunter(hostileShip)==0 && canvas[hostileShipX+shipWidth/2+ KEYBOARD_MOVEMENT_DELTA][hostileShipY+shipHeight/2]!=1&& canvas[hostileShipX+shipWidth/2+ KEYBOARD_MOVEMENT_DELTA][hostileShipY-shipHeight/2]!=1){
                 X = hostileShipX+ KEYBOARD_MOVEMENT_DELTA;
              }
              else{
                 X = hostileShipX;
              }
//              System.out.println("Right"+canvas[hostileShipX+ KEYBOARD_MOVEMENT_DELTA][hostileShipY]);
              break;
              
          case 3:
              if(hostileShipY<scene.getPrefHeight()-hostileShip.getPrefHeight()&& isMoveToHunter(hostileShip)==0 && canvas[hostileShipX+shipWidth/2][hostileShipY+ KEYBOARD_MOVEMENT_DELTA+shipHeight/2]!=1&& canvas[hostileShipX-shipWidth/2][hostileShipY+ KEYBOARD_MOVEMENT_DELTA+shipHeight/2]!=1){
                 Y = hostileShipY+ KEYBOARD_MOVEMENT_DELTA;
              }
              else{
                 Y = hostileShipY;
              }
//              System.out.println("Down"+canvas[hostileShipX][hostileShipY+ KEYBOARD_MOVEMENT_DELTA]);
              break;
              
          case 4:
              if(hostileShipX>14&& isMoveToHunter(hostileShip)==0 && canvas[hostileShipX- KEYBOARD_MOVEMENT_DELTA-shipWidth/2][hostileShipY-shipHeight/2]!=1&& canvas[hostileShipX- KEYBOARD_MOVEMENT_DELTA-shipWidth/2][hostileShipY+shipHeight/2]!=1){
                 X = hostileShipX- KEYBOARD_MOVEMENT_DELTA;
              }
              else{
                 X = hostileShipX;
              }
//              System.out.println("Left"+canvas[hostileShipX- KEYBOARD_MOVEMENT_DELTA][hostileShipY]);
              break;
        }
        
        
        switch (matchPercentage) {
            
                case 100:
                    hostileShip.setLayoutX(X);
                    hostileShip.setLayoutY(Y);
                    break;
                    
                case 75:
                    switch (step) {
                        case 3:
                        case 7:
                        case 10:
                        case 15:
                        case 17:
                        case 22:
                            friendlyShipWithTarget(hostileShip, -5, 10,100);
                            break;
                
                        default:
                            hostileShip.setLayoutX(X);
                            hostileShip.setLayoutY(Y);
                            break;
                    }
                    break;
                    
                case 50:
                    switch (step) {
                        case 2:
                        case 3:
                        case 4:
                        case 8:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                        case 21:
                        case 22:
                        case 23:
                            friendlyShipWithTarget(hostileShip, -5, 10,100);
                            break;
                
                        default:
                            hostileShip.setLayoutX(X);
                            hostileShip.setLayoutY(Y);
                            break;    
                    }
                    break;
        }
        
    }
    
    @FXML
    private void hostileShipChase(Button hostileShip,int matchPercentage){
        clearShipsOnCanvas();
        setAllShipsOnCanvas(hostileShip);
        
        hostileShipX = (int)hostileShip.getLayoutX();
        hostileShipY = (int)hostileShip.getLayoutY();
        shipWidth = (int)hostileShip.getPrefWidth();
        shipHeight = (int)hostileShip.getPrefHeight();
        currentMyShipX = (int)btnMyShip.getLayoutX();
        currentMyShipY = (int)btnMyShip.getLayoutY();
        int distanceFromLastPoint=0;
        int distanceFromCurrentPoint=0;
        int X=0;
        int Y=0;
        
        
        switch (matchPercentage) {
            
          case 100:
              
            distanceFromLastPoint=(int)Math.sqrt((hostileShipY-MyShipY)*(hostileShipY-MyShipY)+(hostileShipX-MyShipX)*(hostileShipX-MyShipX));

            distanceFromCurrentPoint=(int)Math.sqrt((hostileShipY-currentMyShipY)*(hostileShipY-currentMyShipY)+(hostileShipX-currentMyShipX)*(hostileShipX-currentMyShipX));

            X =(int)((moveDistancePerStep * (MyShipX-hostileShipX))/distanceFromLastPoint) + hostileShipX;

            Y =(int)((moveDistancePerStep * (MyShipY-hostileShipY))/distanceFromLastPoint) + hostileShipY;
            
//            System.out.println("ship3: "+ canvas[X][Y]);
//            System.out.println("ship3X: "+X);
//            System.out.println("ship3Y: "+Y);
//            System.out.println("hunterRright: "+canvas[X+shipWidth/2][Y]);
//            System.out.println("hunterLeft: "+canvas[X-shipWidth/2][Y]);
//            System.out.println("hunterDown: "+canvas[X][Y-shipHeight/2]);
//            System.out.println("hunterUp: "+canvas[X][Y+shipHeight/2]);
            
            
            if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||canvas[X+shipWidth/2][Y]==1||canvas[X-shipWidth/2][Y]==1||canvas[X][Y-shipHeight/2]==1||canvas[X][Y+shipHeight/2]==1||isMoveToHunter(hostileShip)==1){
                hostileShip.relocate(hostileShipX,hostileShipY);
            }
            else{
                hostileShip.relocate(X,Y);
            }
            break;
            
          case 75:
              
              switch (step) {
                case 3:
                case 7:
                case 10:
                case 15:
                case 17:
                case 22:
                    friendlyShipWithTarget(hostileShip, -5, 10,100);
                    break;
                
                default:

                    distanceFromLastPoint=(int)Math.sqrt((hostileShipY-MyShipY)*(hostileShipY-MyShipY)+(hostileShipX-MyShipX)*(hostileShipX-MyShipX));

                    distanceFromCurrentPoint=(int)Math.sqrt((hostileShipY-currentMyShipY)*(hostileShipY-currentMyShipY)+(hostileShipX-currentMyShipX)*(hostileShipX-currentMyShipX));

                    X =(int)((moveDistancePerStep * (MyShipX-hostileShipX))/distanceFromLastPoint) + hostileShipX;

                    Y =(int)((moveDistancePerStep * (MyShipY-hostileShipY))/distanceFromLastPoint) + hostileShipY;


                    if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||isMoveToHunter(hostileShip)==1){//||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
                        hostileShip.relocate(hostileShipX,hostileShipY);
                    }
                    else{
                        hostileShip.relocate(X,Y);
                    }
                    break;
                }
            break;
            
          case 50:
              
              switch (step) {
                case 2:
                case 3:
                case 4:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                case 21:
                case 22:
                case 23:
                    friendlyShipWithTarget(hostileShip, -5, 10,100);
                    break;

                default:
        
                    distanceFromLastPoint=(int)Math.sqrt((hostileShipY-MyShipY)*(hostileShipY-MyShipY)+(hostileShipX-MyShipX)*(hostileShipX-MyShipX));

                    distanceFromCurrentPoint=(int)Math.sqrt((hostileShipY-currentMyShipY)*(hostileShipY-currentMyShipY)+(hostileShipX-currentMyShipX)*(hostileShipX-currentMyShipX));

                    X =(int)((moveDistancePerStep * (MyShipX-hostileShipX))/distanceFromLastPoint) + hostileShipX;

                    Y =(int)((moveDistancePerStep * (MyShipY-hostileShipY))/distanceFromLastPoint) + hostileShipY;


                    if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||isMoveToHunter(hostileShip)==1){//||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
                        hostileShip.relocate(hostileShipX,hostileShipY);
                    }
                    else{
                        hostileShip.relocate(X,Y);
                    }
                    break;
                }
            break;
            
          
            
        }    
            
            
            
    }
    
    
    @FXML
    private void hostileShipsSwitchChase(Button hostileShip1,Button hostileShip2){
        
        int hostileShipX1 = (int)hostileShip1.getLayoutX();
        int hostileShipY1 = (int)hostileShip1.getLayoutY();
        int hostileShipX1_Current = 0;
        int hostileShipY1_Current = 0;
        int shipWidth1 = (int)hostileShip1.getPrefWidth();
        int shipHeight1 = (int)hostileShip1.getPrefHeight();
        int hostileShipX2 = (int)hostileShip2.getLayoutX();
        int hostileShipY2 = (int)hostileShip2.getLayoutY();
        int shipWidth2 = (int)hostileShip2.getPrefWidth();
        int shipHeight2 = (int)hostileShip2.getPrefHeight();
        
        
        currentMyShipX = (int)btnMyShip.getLayoutX();
        currentMyShipY = (int)btnMyShip.getLayoutY();
        
        while(true){
             if(distanceFromLastPoint_toShip<=shipWidth1/2+shipWidth2/2+moveDistancePerStep){
             distanceFromLastPoint_toShip=shipWidth1/2+shipWidth2/2+moveDistancePerStep;
             break;
             }
             if(distanceFromLastPoint_toShip>shipWidth1/2+shipWidth2/2+moveDistancePerStep){
                distanceFromLastPoint_toShip=(int)Math.sqrt((hostileShipY2-hostileShipY1)*(hostileShipY2-hostileShipY1)+(hostileShipX2-hostileShipX1)*(hostileShipX2-hostileShipX1));
             break;
             }
        }
        
        //System.out.println("5chasing: " + (distanceFromLastPoint_toShip>shipWidth1/2+shipWidth2/2+moveDistancePerStep));
        //System.out.println(distanceFromLastPoint_toShip);
        clearShipsOnCanvas();
        setAllShipsOnCanvas(hostileShip1);
        if(distanceFromLastPoint_toShip>shipWidth1/2+shipWidth2/2+moveDistancePerStep){
            
            int distanceFromLastPoint1=(int)Math.sqrt((hostileShipY1-MyShipY)*(hostileShipY1-MyShipY)+(hostileShipX1-MyShipX)*(hostileShipX1-MyShipX));

            int distanceFromCurrentPoint1=(int)Math.sqrt((hostileShipY1-currentMyShipY)*(hostileShipY1-currentMyShipY)+(hostileShipX1-currentMyShipX)*(hostileShipX1-currentMyShipX));

            int X1 =(int)((moveDistancePerStep * (MyShipX-hostileShipX1))/distanceFromLastPoint1) + hostileShipX1;

            int Y1 =(int)((moveDistancePerStep * (MyShipY-hostileShipY1))/distanceFromLastPoint1) + hostileShipY1;

            //System.out.println("5stay: " + (distanceFromCurrentPoint1<MyShipWidth/2+shipWidth1/2+KEYBOARD_MOVEMENT_DELTA));
            
            if(distanceFromCurrentPoint1<MyShipWidth/2+shipWidth1/2+KEYBOARD_MOVEMENT_DELTA){
                hostileShip1.relocate(hostileShipX1,hostileShipY1);
            }
            else{
                hostileShip1.relocate(X1,Y1);
            }
            
            hostileShipX1_Current = (int)hostileShip1.getLayoutX();
            hostileShipY1_Current = (int)hostileShip1.getLayoutY();
            
        }
        else{
            friendlyShipWithTarget(hostileShip1, -10, 20,100);
        }
        
        
        //System.out.println("6chasing: " + (distanceFromLastPoint_toShip<=shipWidth1/2+shipWidth2/2+moveDistancePerStep));
        //System.out.println(distanceFromLastPoint_toShip);
        clearShipsOnCanvas();
        setAllShipsOnCanvas(hostileShip2);
        if(distanceFromLastPoint_toShip<=shipWidth1/2+shipWidth2/2+moveDistancePerStep){
            
            int distanceFromLastPoint2=(int)Math.sqrt((hostileShipY2-MyShipY)*(hostileShipY2-MyShipY)+(hostileShipX2-MyShipX)*(hostileShipX2-MyShipX));

            int distanceFromCurrentPoint2=(int)Math.sqrt((hostileShipY2-currentMyShipY)*(hostileShipY2-currentMyShipY)+(hostileShipX2-currentMyShipX)*(hostileShipX2-currentMyShipX));

            int X3 =(int)((moveDistancePerStep * (MyShipX-hostileShipX2))/distanceFromLastPoint2) + hostileShipX2;

            int Y3 =(int)((moveDistancePerStep * (MyShipY-hostileShipY2))/distanceFromLastPoint2) + hostileShipY2;

            //System.out.println("6stay: " + (distanceFromCurrentPoint2<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA));
            
            if(distanceFromCurrentPoint2<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA){
                
                hostileShip2.relocate(hostileShipX2,hostileShipY2);
            }
//            else if(canvas[hostileShipX2-shipWidth/2][hostileShipY2+shipHeight/2]==1){
//                hostileShip1.relocate(hostileShipX2,hostileShipY2);
//            }
            
            else{
                hostileShip2.relocate(X3,Y3);
            }
        }
        else{
            
            int X2 =(int)((moveDistancePerStep * (hostileShipX1-hostileShipX2))/distanceFromLastPoint_toShip) + hostileShipX2;

            int Y2 =(int)((moveDistancePerStep * (hostileShipY1-hostileShipY2))/distanceFromLastPoint_toShip) + hostileShipY2;
            

            distanceFromCurrentPoint_toShip=(int)Math.sqrt((hostileShipY2-hostileShipY1_Current)*(hostileShipY2-hostileShipY1_Current)+(hostileShipX2-hostileShipX1_Current)*(hostileShipX2-hostileShipX1_Current));

            //System.out.println("6chasing5,stay: " + (distanceFromCurrentPoint_toShip<shipWidth1/2+shipWidth2/2+KEYBOARD_MOVEMENT_DELTA));
            
            if(distanceFromCurrentPoint_toShip<shipWidth1/2+shipWidth2/2+KEYBOARD_MOVEMENT_DELTA){
                hostileShip2.relocate(hostileShipX2,hostileShipY2);
            }
            else{
                hostileShip2.relocate(X2,Y2);
            }
        }
        
    }
    @FXML
    private void myShipChangeColor(){
        btnMyShip.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
    }
    @FXML
    private void myShipChangeColorBack(){
    btnMyShip.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
    }
    
    @FXML
    private void moveMyshipOnKeyPress(ActionEvent event) throws IOException{
        
//    @FXML
//    private void moveMyshipOnKeyPress(){
        
//            if(step==1){ 
//        try { 
//            sleep(1500);
            
    
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        }
//            else{
//        try { 
//            sleep(1500);
//            Timer timer = new Timer();
//            TimerTask getKeyEvent;
//            getKeyEvent = new TimerTask()
//            {
//                public void run()
//                {
//                    
//                   switch (event.getCode()) {
//                      case UP: 
//                          btnMyShip.setLayoutY(btnMyShip.getLayoutY());
//                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());
//                          break;
//                      case DOWN: 
//                          btnMyShip.setLayoutY(btnMyShip.getLayoutY());
//                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());
//                          break;
//                      case LEFT: 
//                          btnMyShip.setLayoutY(btnMyShip.getLayoutY());
//                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());
//                          break;
//                      case RIGHT: 
//                          btnMyShip.setLayoutY(btnMyShip.getLayoutY());
//                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());
//                          break;
//                   }      
//                }
//            };
//            
//        timer.schedule(getKeyEvent,1500);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        }
    
//    
    //scene.setOnKeyPressed(new EventHandler<KeyEvent>() { 
        
       //@Override 
       //public void handle(KeyEvent event) { 
           
           
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            keyPressTime = time.format(formatter);
            
           
            MyShipY = (int)btnMyShip.getLayoutY();
            MyShipX = (int)btnMyShip.getLayoutX();
            MyShipWidth=(int)btnMyShip.getPrefWidth();
            MyShipHeight=(int)btnMyShip.getPrefHeight();
            
            
            
            canvasWidth= (int)scene.getPrefWidth();
            canvasHeight= (int)scene.getPrefHeight();
            canvas =new int[canvasWidth][canvasHeight];
            
            
            
            //clearShipsOnCanvas();
            
            
//            setShipOnCanvas(btnShip1);
//            setShipOnCanvas(btnShip2);
//            setShipOnCanvas(btnShip3);
//            setShipOnCanvas(btnShip4);
//            setShipOnCanvas(btnShip5);
            if(trialNum==3){
                PID = dateTime;
                count+=1;
            }
            noChange+=1;
            step+=1;
            System.out.println("step: "+step);
            if(step<=5){
                endGame.setDisable(true);
            }
            else{
                endGame.setDisable(false);
            }
            if(step<=25){
            try {
               buttonClick();
           } catch (IOException ex) {
               Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
//            Timer timer = new Timer();
//            TimerTask getKeyEvent = new TimerTask()
//            {
//                public void run()
//                {
                    
                    if(step<=totalSteps){
                    
                    clearShipsOnCanvas();
                    setAllShipsOnCanvas(btnMyShip);    
                    //switch (event.getCode()) {
                    Button btn =(Button)event.getSource(); 
                    String id = btn.getId();
                    switch (id) {
                      case "btnUp": 
                          myShipDirection = "UP";
                          moveDirect=1;
                          if(btnMyShip.getLayoutY()>15){
                              if(canvas[(int)MyShipX][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA-MyShipHeight/2]!=1&&canvas[(int)MyShipX+MyShipWidth/2][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA]!=1&&canvas[(int)MyShipX-MyShipWidth/2][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA]!=1){
                                  
//                                System.out.println(canvas[(int)MyShipX][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA-MyShipHeight/2]);
//                                System.out.println(MyShipX);
//                                System.out.println(MyShipY- KEYBOARD_MOVEMENT_DELTA);
                                btnMyShip.setLayoutY(btnMyShip.getLayoutY() - KEYBOARD_MOVEMENT_DELTA);
//                          
                              }
                          }
                          else{
                          btnMyShip.setLayoutY(btnMyShip.getLayoutY());
                          }
                          break;
                      case "btnRight":
                          myShipDirection = "RIGHT";
                          moveDirect=2;
                          if(btnMyShip.getLayoutX()<scene.getPrefWidth()- btnMyShip.getPrefWidth()){
                              if(canvas[(int)MyShipX+ KEYBOARD_MOVEMENT_DELTA+MyShipWidth/2][(int)MyShipY]!=1&&canvas[(int)MyShipX+ KEYBOARD_MOVEMENT_DELTA][(int)MyShipY+MyShipHeight/2]!=1&&canvas[(int)MyShipX+ KEYBOARD_MOVEMENT_DELTA][(int)MyShipY-MyShipHeight/2]!=1){
//                                System.out.println(canvas[(int)MyShipX+ KEYBOARD_MOVEMENT_DELTA+MyShipWidth/2][(int)MyShipY]);
//                                System.out.println(MyShipX+ KEYBOARD_MOVEMENT_DELTA);
//                                System.out.println(MyShipY);
                                btnMyShip.setLayoutX(btnMyShip.getLayoutX() + KEYBOARD_MOVEMENT_DELTA); 
                              }
                          }
                          else{
                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());    
                          }
                          break;
                      case "btnDown":
                          myShipDirection = "DOWN";
                          moveDirect=3;
                          if(btnMyShip.getLayoutY()<scene.getPrefHeight()-btnMyShip.getPrefHeight()){
                              if(canvas[(int)MyShipX][(int)MyShipY+ KEYBOARD_MOVEMENT_DELTA+MyShipHeight/2]!=1&&canvas[(int)MyShipX+MyShipWidth/2][(int)MyShipY+ KEYBOARD_MOVEMENT_DELTA]!=1&&canvas[(int)MyShipX-MyShipWidth/2][(int)MyShipY+ KEYBOARD_MOVEMENT_DELTA]!=1){
//                                  System.out.println(canvas[(int)MyShipX][(int)MyShipY+ KEYBOARD_MOVEMENT_DELTA+MyShipHeight/2]);
//                                  System.out.println(MyShipX);
//                                  System.out.println(MyShipY+ KEYBOARD_MOVEMENT_DELTA);  
                                  btnMyShip.setLayoutY(btnMyShip.getLayoutY() + KEYBOARD_MOVEMENT_DELTA);
                                }
                          }
                          else{
                          btnMyShip.setLayoutY(btnMyShip.getLayoutY());   
                          }
                          break;
                      case "btnLeft": 
                          myShipDirection = "LEFT";
                          moveDirect=4;
                          if(btnMyShip.getLayoutX()>15){
                              if(canvas[(int)MyShipX- KEYBOARD_MOVEMENT_DELTA-MyShipWidth/2][(int)MyShipY]!=1&&canvas[(int)MyShipX- KEYBOARD_MOVEMENT_DELTA][(int)MyShipY+MyShipHeight/2]!=1&&canvas[(int)MyShipX- KEYBOARD_MOVEMENT_DELTA][(int)MyShipY-MyShipHeight/2]!=1){
//                                  System.out.println(canvas[(int)MyShipX- KEYBOARD_MOVEMENT_DELTA-MyShipWidth/2][(int)MyShipY]);
//                                  System.out.println(MyShipX-KEYBOARD_MOVEMENT_DELTA);
//                                  System.out.println(MyShipY);  
                                  btnMyShip.setLayoutX(btnMyShip.getLayoutX() - KEYBOARD_MOVEMENT_DELTA); 
                                }
                          }
                          else{
                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());    
                          }
                          break;
                        }
                    
//            System.out.println("myrightX: "+((int)btnMyShip.getLayoutX()+shipWidth/2)+"myrightY: "+((int)btnMyShip.getLayoutY()));
//            System.out.println("myleftX: "+((int)btnMyShip.getLayoutX()-shipWidth/2)+"myleftY: "+((int)btnMyShip.getLayoutY()));
//            System.out.println("mydownX: "+((int)btnMyShip.getLayoutX())+"mydownY: "+((int)btnMyShip.getLayoutY()+shipHeight/2));
//            System.out.println("myupXX: "+((int)btnMyShip.getLayoutX())+"myupY: "+((int)btnMyShip.getLayoutY()-shipHeight/2));    
//            System.out.println("followShip1: "+followShipBtn);
//            System.out.println("shipList1: "+shipList);
         
            if(trialNum<3){
                System.out.println("Practic shipList: "+shipList);
                
            
            
            practicTrials();
            
            if(btnShip1==newShipList.get(0)){
                            //btnShip1.setText("1S");
                btnShip1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
            }
            else if(btnShip2==newShipList.get(0)){
                //btnShip2.setText("2S");
                btnShip2.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
            }
            else if(btnShip3==newShipList.get(0)){
                //btnShip3.setText("3S");
                btnShip3.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
            }
            else if(btnShip4==newShipList.get(0)){
                //btnShip4.setText("4S");
                btnShip4.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
            }
            else if(btnShip5==newShipList.get(0)){
                //btnShip5.setText("5S");
                btnShip5.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
            }
            else if(btnShip6==newShipList.get(0)){
                //btnShip6.setText("6S");
                btnShip6.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
            }
            
            lastStepPracticX=new ArrayList<Integer>(7);
            lastStepPracticY=new ArrayList<Integer>(7);
            
            lastStepPracticX.add((int)btnShip1.getLayoutX());
            lastStepPracticX.add((int)btnShip2.getLayoutX());
            lastStepPracticX.add((int)btnShip3.getLayoutX());
            lastStepPracticX.add((int)btnShip4.getLayoutX());
            lastStepPracticX.add((int)btnShip5.getLayoutX());
            lastStepPracticX.add((int)btnShip6.getLayoutX());
            lastStepPracticX.add((int)btnMyShip.getLayoutX());
            
            lastStepPracticY.add((int)btnShip1.getLayoutY());
            lastStepPracticY.add((int)btnShip2.getLayoutY());
            lastStepPracticY.add((int)btnShip3.getLayoutY());
            lastStepPracticY.add((int)btnShip4.getLayoutY());
            lastStepPracticY.add((int)btnShip5.getLayoutY());
            lastStepPracticY.add((int)btnShip6.getLayoutY());
            lastStepPracticY.add((int)btnMyShip.getLayoutY());
               
            }
            else{
                
            randomAssignShips();
               
            }
            System.out.println("followShip: "+followShipBtn);
            System.out.println("shipList2: "+shipList);
            if(followShipBtn == btnShip1){
                followShip = 1;
            }
            if(followShipBtn == btnShip2){
                followShip = 2;
            }
            if(followShipBtn == btnShip3){
                followShip = 3;
            }
            if(followShipBtn == btnShip4){
                followShip = 4;
            }
            if(followShipBtn == btnShip5){
                followShip = 5;
            }
            if(followShipBtn == btnShip6){
                followShip = 6;
            }
            if(followShipBtn == null){
                followShip = 0;
            }
            
            if(trialNum>2){
            saveRecord();    
            }
            }
            else{
                timeup.setText("Time's up");
            };
           
//                           }
//
//            };
//            
//            timer.schedule(getKeyEvent,1000);
//        }
            
//          Timer timer = new Timer();
//            TimerTask getKeyEvent;
//            getKeyEvent = new TimerTask()
//            {
//                public void run()
//                {
//                    scene.setOnKeyPressed(e -> {
//                if (e.getCode().equals("UP")&&e.getCode().equals("DOWN")&&e.getCode().equals("LEFT")&&e.getCode().equals("RIGHT")) {
//                    //e.consume();
//                    switch (event.getCode()) {
//                      case UP: 
//                          scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyHandler);
//                          break;
//                      case DOWN: 
//                          scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyHandler);
//                          break;
//                      case LEFT: 
//                          scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyHandler);
//                          break;
//                      case RIGHT: 
//                          scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyHandler);
//                          break;
//                   }      
//                }
//            });
//                     }
//            };   
                  
//            timer.schedule(getKeyEvent,1000);   

            
               
         //} 
        
        //});   
            btnMyShip.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
            if(step>25){
                step=25;
            }
            stepCounter.setText(step + "/25");
            
            if(step<25){
            btnUp.setDisable(true);
            btnDown.setDisable(true);
            btnLeft.setDisable(true);
            btnRight.setDisable(true);
            
            Timer timer = new Timer();
            TimerTask getKeyEvent;
            
            getKeyEvent = new TimerTask()
            {
                public void run()
                {
                    btnUp.setDisable(false);
                    btnDown.setDisable(false);
                    btnLeft.setDisable(false);
                    btnRight.setDisable(false);
                }
            };
            
            timer.schedule(getKeyEvent,1000);
            }
            else{
                btnUp.setDisable(true);
                btnDown.setDisable(true);
                btnLeft.setDisable(true);
                btnRight.setDisable(true);
            }
            
            

     }
    

    
    public int isMoveToHunter(Button Ship){
        int isClose = 1;
        distance_afterMove=Math.sqrt((Ship.getLayoutY()-btnMyShip.getLayoutY())*(Ship.getLayoutY()-btnMyShip.getLayoutY())+(Ship.getLayoutX()-btnMyShip.getLayoutX())*(Ship.getLayoutX()-btnMyShip.getLayoutX()));
        distance_beforeMove=Math.sqrt((Ship.getLayoutY()-MyShipY)*(Ship.getLayoutY()-MyShipY)+(Ship.getLayoutX()-MyShipX)*(Ship.getLayoutX()-MyShipX));
        if(distance_beforeMove>distance_afterMove){
            isClose = 1;
        }
        else{
            isClose = 0;
        }
        
        return isClose;
    }
    
    
    @FXML
    public void setShipOnCanvas(Button Ship){
        ShipX= (int)Ship.getLayoutX();
        ShipY= (int)Ship.getLayoutY();
        shipWidth = (int)Ship.getPrefWidth();
        shipHeight = (int)Ship.getPrefHeight();
        
        for (int x = ShipX-(shipWidth/2); x <= ShipX+(shipWidth/2); x++) {
                for (int y = ShipY-(shipHeight/2); y <= ShipY+(shipHeight/2); y++) {
                    canvas[x][y]=1;
                    //System.out.println(x+","+y);
                }
            }
    }
    
    
    @FXML
    public void setAllShipsOnCanvas(Button Ship){
        allShips[0]= btnShip1;
        allShips[1]= btnShip2;
        allShips[2]= btnShip3;
        allShips[3]= btnShip4;
        allShips[4]= btnShip5;
        allShips[5]= btnShip6;
        allShips[6]= btnMyShip;;
        
        for (int s=0; s<allShips.length; s++){
//            System.out.println(allShips[0]);
//            System.out.println(allShips[1]);
//            System.out.println(allShips[2]);
//            System.out.println(allShips[3]);
//            System.out.println(allShips[4]);
//            System.out.println(allShips[5]);
//            System.out.println(allShips[s]);
//            System.out.println(allShips.length);
            if(allShips[s]!= Ship){
                
                    setShipOnCanvas(allShips[s]);
                
                }
        }
    }
//    
//    public void setAllShipsOnCanvas(Button Ship1){
//        setAllShipsOnCanvas(Ship1,ship);
//    }
    
    @FXML
    public void clearShipsOnCanvas(){
        canvasWidth= (int)scene.getPrefWidth();
        canvasHeight= (int)scene.getPrefHeight();
        
        for (int x = 0; x < canvasWidth; x++) {
                for (int y = 0; y < canvasHeight; y++) {
                    canvas[x][y]=0;
                }
            }
    }
    
    
    public double givenList_shouldReturnARandomElement() {
    List<Integer> givenList = Arrays.asList(0,20,-20);
    Random rand = new Random();
    return randomElement = givenList.get(rand.nextInt(givenList.size()));
    }
    
    
    @FXML
    public void recordData() throws IOException{
        int X = 0;
        int Y = 0;     
        String coordinate = "";
        record = "";
        lastStepX=new ArrayList<Integer>(7);
        lastStepY=new ArrayList<Integer>(7);
        
        for (int s=0; s<allShips.length; s++){
            if(allShips[s]==newShipList.get(0)){
                active = ship1active;
            }
            else if(allShips[s]==newShipList.get(1)){
                active = ship2active;
            }
            else if(allShips[s]==newShipList.get(2)){
                active = ship3active;
            }
            else if(allShips[s]==newShipList.get(3)){
                active = ship4active;
            }
            else if(allShips[s]==newShipList.get(4)){
                active = ship5active;
            }
            else if(allShips[s]==newShipList.get(5)){
                active = ship6active;
            }
            else{
                active = myShipDirection;
            }
            X = (int)allShips[s].getLayoutX();
            Y = (int)allShips[s].getLayoutY();
            
            lastStepX.add(X);
            lastStepY.add(Y);
            
            System.out.println("lastStepX: "+lastStepX);
            System.out.println("lastStepY: "+lastStepY);
            
            
            coordinate = active+","+ X + "," + Y;
            
            record+=","+coordinate;
            
        }
        //return record;
    }
    
    @FXML
    private void saveRecord(){
        try {
            if(file.createNewFile()){
                writer = new FileWriter(file, true);
            }else{

                writer = new FileWriter(filepath, true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(step==1){
            if(trialNum==3){
//            System.out.println(step);
//            System.out.println(trialNum);
                try {
                    writer.write("ParticipantID"+","+"DataType"+","+"Trial"+","+"Step"+","+"keyPressTime"+","+"Ship1Action"+","+"Ship1X"+","+"Ship1Y"+","+"Ship2Action"+","+"Ship2X"+","+"Ship2Y"+","+"Ship3Action"+","+"Ship3X"+","+"Ship3Y"+","+"Ship4Action"+","+"Ship4X"+","+"Ship4Y"+","+"Ship5Action"+","+"Ship5X"+","+"Ship5Y"+","+"Ship6Action"+","+"Ship6X"+","+"Ship6Y"+","+"MyShipAction"+","+"MyShipX"+","+"MyShipY"+","+"StartGameTime"+","+"EndGameTime"+","+"Hunted or Shadowed"+","+"FirstAnswerPickTime"+","+"ParticipantAnswer"+","+"SecondAnswerPickTime"+","+"RightAnswer_Action"+","+"RightAnswer_ShipNumber"+","+"Result"+'\n');
                } catch (IOException ex) {
                    Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
        
        
        
        BufferedWriter data = new BufferedWriter(writer);
        move = new PrintWriter(data);
        
        try {
            recordData();
            recordLine = PID+","+"D"+","+(trialNum-2) +","+step+","+keyPressTime+record;
            lastStep = step;
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        move.println(recordLine);
        move.flush();
        move.close();
        
                
    }
    @FXML
    public List randomBlocks(){
        Collections.shuffle(block100);
        Collections.shuffle(block75);
        Collections.shuffle(block50);
        System.out.println("blockListBeforeShuffle: "+blockListAfterShuffle);
        Collections.shuffle(blockListAfterShuffle);
        System.out.println("blockListAfterShuffle: "+blockListAfterShuffle);
        return blockListAfterShuffle;
        
       
    }
    
    @FXML
    private void assignTrialInBlock(){
        switch(trialNum){
//            case 1:
//            case 2:
            case 3:
            case 4:
            case 5:    
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
//            case 13:
//            case 14:
//            case 15:  
                trialInBlock=trialNum-2;
                break;
                
            
            case 13:
            case 14:
            case 15:   
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
//            case 23:
//            case 24:
//            case 25:
//            case 26:
//            case 27:
                trialInBlock=trialNum-12;
                break;
            
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:    
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
//            case 33:
//            case 34:
//            case 35:
//            case 36:
//            case 37:
//            case 38:
//            case 39:
                trialInBlock=trialNum-22;
                break;
        }
    }
    
    @FXML
    private void randomAssignBlock(){
        //List<List> blockList = randomBlocks();
        List<List> blockList =blockListAfterShuffle;
        System.out.println("blockList: "+blockList);
        switch(trialNum){
//            case 1:
//            case 2:
            case 3:
            case 4:
            case 5:    
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
//            case 13:
//            case 14:
//            case 15:
                currentBlock=blockList.get(0);
                break;
                
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
//            case 23:
//            case 24:
//            case 25:
//            case 26:
//            case 27:    
                currentBlock=blockList.get(1);
                break;
                
            case 23:
            case 24:
            case 25:
            case 26:
            case 27: 
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
//            case 33:
//            case 34:
//            case 35:
//            case 36:
//            case 37:
//            case 38:
//            case 39:
                currentBlock=blockList.get(2);
                break;
        }
        
        
    }
    
    
    @FXML
    private List randomShipList() {
    List<Button> givenShipList = Arrays.asList(btnShip1,btnShip2,btnShip3,btnShip4,btnShip5,btnShip6);
    
    Collections.shuffle(givenShipList);
    
    return givenShipList;
    }
    
    @FXML
    private void practicTrials(){
        
        if(trialNum==1){
                      timeup.setText("Shadowing Scene");  
                      if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        System.out.println("new shipList: "+shipList);
                        setTarget1_75 = setTarget(newShipList.get(1));
                        setTarget2_75 = setTarget(newShipList.get(2));
                        setTarget3_75 = setTarget(newShipList.get(3));
                        //setCirclePath1_75 = setCirclePath();
                        //setCirclePath2_75 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                      }
//                        if(btnShip1==shipList.get(0)){
//                            //btnShip1.setText("1S");
//                            btnShip1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip2==shipList.get(0)){
//                            //btnShip2.setText("2S");
//                            btnShip2.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip3==shipList.get(0)){
//                            //btnShip3.setText("3S");
//                            btnShip3.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip4==shipList.get(0)){
//                            //btnShip4.setText("4S");
//                            btnShip4.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip5==shipList.get(0)){
//                            //btnShip5.setText("5S");
//                            btnShip5.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip6==shipList.get(0)){
//                            //btnShip6.setText("6S");
//                            btnShip6.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
                        
                        hostileShipFollow(shipList.get(0),75);
                        friendlyShipWithTarget(newShipList.get(1), setTarget1_75[0], setTarget1_75[1],100);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget2_75[0], setTarget2_75[1],75);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget3_75[0], setTarget3_75[1],50);
                        
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,75);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,100);
                        //friendlyShipWithPatrolBehavior(shipList.get(5),300,100,25,100);
                        //friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_75[0],setCirclePath1_75[1],setCirclePath1_75[2],totalSteps,75);
                        
                        
                        //friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_75[0],setCirclePath2_75[1],setCirclePath2_75[2],totalSteps,75);
                        
                 beFollowed = true;
                 followShipBtn = newShipList.get(0);
        }
        
        if(trialNum==2){
                timeup.setText("Hunting Scene");
                if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget4_75 = setTarget(newShipList.get(1));
                        setTarget5_75 = setTarget(newShipList.get(2));
                        setTarget6_75 = setTarget(newShipList.get(3));
                        //setCirclePath3_75 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                
//                        if(btnShip1==shipList.get(0)){
//                            //btnShip1.setText("1(H)");
//                            btnShip1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip2==shipList.get(0)){
//                            //btnShip2.setText("2(H)");
//                            btnShip2.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip3==shipList.get(0)){
//                            //btnShip3.setText("3(H)");
//                            btnShip3.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip4==shipList.get(0)){
//                            //btnShip4.setText("4(H)");
//                            btnShip4.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip5==shipList.get(0)){
//                            //btnShip5.setText("5(H)");
//                            btnShip5.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                        else if(btnShip6==shipList.get(0)){
//                            //btnShip6.setText("6(H)");
//                            btnShip6.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
//                        }
//                
                        hostileShipChase(newShipList.get(0),75);
                        
                        friendlyShipWithTarget(newShipList.get(1), setTarget4_75[0], setTarget4_75[1],100);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget5_75[0], setTarget5_75[1],75);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget6_75[0], setTarget6_75[1],50);
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,75);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,100);
                        //friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_75[0],setCirclePath3_75[1],setCirclePath3_75[2],totalSteps,75);

                 beFollowed = true;
                 followShipBtn = newShipList.get(0);
        }
        
//        if(trialNum==3){
//                    if(step==1){
//                        setTarget7_100 = setTarget(shipList.get(0));
//                        setTarget8_100 = setTarget(shipList.get(1));
//                        setTarget9_100 = setTarget(shipList.get(2));
//                        setTarget10_100 = setTarget(shipList.get(3));
//                        setCirclePath4_100 = setCirclePath();
//                        }
//                        friendlyShipWithTarget(shipList.get(0), setTarget7_100[0], setTarget7_100[1],100);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(1), setTarget8_100[0], setTarget8_100[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(2), setTarget9_100[0], setTarget9_100[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(3), setTarget10_100[0], setTarget10_100[1],50);
//                        
//                        
//                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath4_100[0],setCirclePath4_100[1],setCirclePath4_100[2],totalSteps,75);
//                      
//                beFollowed = false;
//                followShipBtn = null;
                
           
//        }
    }
    @FXML
    private void randomAssignShips(){
     System.out.println("block100: "+block100);
     System.out.println("block75: "+block75);
     System.out.println("block50: "+block50);
     System.out.println("currentBlock: "+currentBlock);
     System.out.println("trialInBlock: "+trialInBlock);
     if(currentBlock==block100){
         //random trial number first
         if(trialInBlock==block100.get(0)||trialInBlock==block100.get(1)||trialInBlock==block100.get(2)||trialInBlock==block100.get(3)||trialInBlock==block100.get(4)){
                 
                        
                        if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget1_100 = setTarget(newShipList.get(1));
                        setTarget2_100 = setTarget(newShipList.get(2));
                        setTarget3_100 = setTarget(newShipList.get(3));
                        //setCirclePath1_100 = setCirclePath();
                        //setCirclePath2_100 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                        
                        hostileShipFollow(shipList.get(0),100);
                        System.out.println("shipList.get(1): "+shipList.get(1));
                        friendlyShipWithTarget(newShipList.get(1), setTarget1_100[0], setTarget1_100[1],100);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget2_100[0], setTarget2_100[1],100);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget3_100[0], setTarget3_100[1],100);
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,100);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,100);
                        //friendlyShipWithCirclePath(newShipList.get(4),setCirclePath1_100[0],setCirclePath1_100[1],setCirclePath1_100[2],totalSteps,75);
                        
                        
                        //friendlyShipWithCirclePath(newShipList.get(5),setCirclePath2_100[0],setCirclePath2_100[1],setCirclePath2_100[2],totalSteps,75);
                      
                 beFollowed = true;
                 hunterActive="shadowed";
                 followShipBtn = newShipList.get(0);
                 ship1active = "100Shadowing";
                 ship2active = "100Targeting";
                 ship3active = "100Targeting";
                 ship4active = "100Targeting";
                 ship5active = "100Patroling";
                 ship6active = "100Patroling";
                 
         }        
         if(trialInBlock==block100.get(5)||trialInBlock==block100.get(6)||trialInBlock==block100.get(7)||trialInBlock==block100.get(8)||trialInBlock==block100.get(9)){
                
                        
                        if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget4_100 = setTarget(newShipList.get(1));
                        setTarget5_100 = setTarget(newShipList.get(2));
                        setTarget6_100 = setTarget(newShipList.get(3));
                        //setCirclePath3_100 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                        
                        hostileShipChase(newShipList.get(0),100);
                        
                        friendlyShipWithTarget(newShipList.get(1), setTarget4_100[0], setTarget4_100[1],100);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget5_100[0], setTarget5_100[1],100);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget6_100[0], setTarget6_100[1],100);
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,100);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,100);
                        //friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_100[0],setCirclePath3_100[1],setCirclePath3_100[2],totalSteps,75);
                        
                 beFollowed = true;
                 hunterActive="hunted";
                 followShipBtn = newShipList.get(0);
                 ship1active = "100Hunting";
                 ship2active = "100Targeting";
                 ship3active = "100Targeting";
                 ship4active = "100Targeting";
                 ship5active = "100Patroling";
                 ship6active = "100Patroling";
            }
         
//            if(trialInBlock==block100.get(10)||trialInBlock==block100.get(11)){
//                        if(step==1){
//                        setTarget7_100 = setTarget(shipList.get(0));
//                        setTarget8_100 = setTarget(shipList.get(1));
//                        setTarget9_100 = setTarget(shipList.get(2));
//                        setTarget10_100 = setTarget(shipList.get(3));
//                        setCirclePath4_100 = setCirclePath();
//                        }
//                        friendlyShipWithTarget(shipList.get(0), setTarget7_100[0], setTarget7_100[1],100);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(1), setTarget8_100[0], setTarget8_100[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(2), setTarget9_100[0], setTarget9_100[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(3), setTarget10_100[0], setTarget10_100[1],50);
//                        
//                        
//                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath4_100[0],setCirclePath4_100[1],setCirclePath4_100[2],totalSteps,75);
//                      
//                beFollowed = false;
//                followShipBtn = null;
//                 ship1active = "100Targeting";
//                 ship2active = "75Targeting";
//                 ship3active = "75Targeting";
//                 ship4active = "50Targeting";
//                 ship5active = "75Circling and Chasing";
//                 ship6active = "75Circling and Chasing";
//            }
        
     }
     if(currentBlock==block75){
         if(trialInBlock==block75.get(0)||trialInBlock==block75.get(1)||trialInBlock==block75.get(2)||trialInBlock==block75.get(3)||trialInBlock==block75.get(4)){
                 
                        
                        if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget1_75 = setTarget(newShipList.get(1));
                        setTarget2_75 = setTarget(newShipList.get(2));
                        setTarget3_75 = setTarget(newShipList.get(3));
                        //setCirclePath1_75 = setCirclePath();
                        //setCirclePath2_75 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                        
                        hostileShipFollow(newShipList.get(0),75);
                        friendlyShipWithTarget(newShipList.get(1), setTarget1_75[0], setTarget1_75[1],75);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget2_75[0], setTarget2_75[1],75);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget3_75[0], setTarget3_75[1],75);
                        
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,75);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,75);
                        //friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_75[0],setCirclePath1_75[1],setCirclePath1_75[2],totalSteps,75);
                        
                        
                        //friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_75[0],setCirclePath2_75[1],setCirclePath2_75[2],totalSteps,75);
                        
                 beFollowed = true;
                 hunterActive="shadowed";
                 followShipBtn = newShipList.get(0);
                 ship1active = "75Shadowing";
                 ship2active = "75Targeting";
                 ship3active = "75Targeting";
                 ship4active = "75Targeting";
                 ship5active = "75Patroling";
                 ship6active = "75Patroling";
         }     
         if(trialInBlock==block75.get(5)||trialInBlock==block75.get(6)||trialInBlock==block75.get(7)||trialInBlock==block75.get(8)||trialInBlock==block75.get(9)){
                 
                        
                        if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget4_75 = setTarget(newShipList.get(1));
                        setTarget5_75 = setTarget(newShipList.get(2));
                        setTarget6_75 = setTarget(newShipList.get(3));
                        //setCirclePath3_75 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                        hostileShipChase(newShipList.get(0),75);
                        
                        friendlyShipWithTarget(newShipList.get(1), setTarget4_75[0], setTarget4_75[1],75);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget5_75[0], setTarget5_75[1],75);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget6_75[0], setTarget6_75[1],75);
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,75);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,75);
                        //friendlyShipsChaseInCircle(newShipList.get(4),shipList.get(5),setCirclePath3_75[0],setCirclePath3_75[1],setCirclePath3_75[2],totalSteps,75);

                 beFollowed = true;
                 hunterActive="hunted";
                 followShipBtn = newShipList.get(0);
                 ship1active = "75Hunting";
                 ship2active = "75Targeting";
                 ship3active = "75Targeting";
                 ship4active = "75Targeting";
                 ship5active = "75Patroling";
                 ship6active = "75Patroling";
        }
         
//         if(trialInBlock==block75.get(10)||trialInBlock==block75.get(11)){
//                        if(step==1){
//                        setTarget7_75 = setTarget(shipList.get(0));
//                        setTarget8_75 = setTarget(shipList.get(1));
//                        setTarget9_75 = setTarget(shipList.get(2));
//                        setTarget10_75 = setTarget(shipList.get(3));
//                        setCirclePath4_75 = setCirclePath();
//                        setCirclePath5_75 = setCirclePath();
//                        }
//                        friendlyShipWithTarget(shipList.get(0), setTarget7_75[0], setTarget7_75[1],100);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(1), setTarget8_75[0], setTarget8_75[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(2), setTarget9_75[0], setTarget9_75[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(3), setTarget10_75[0], setTarget10_75[1],50);
//                        
//                        
//                        friendlyShipWithCirclePath(shipList.get(4),setCirclePath4_75[0],setCirclePath4_75[1],setCirclePath4_75[2],totalSteps,75);
//                        
//                        
//                        friendlyShipWithCirclePath(shipList.get(5),setCirclePath5_75[0],setCirclePath5_75[1],setCirclePath5_75[2],totalSteps,75);
//
//                      
//                beFollowed = false;
//                followShipBtn = null;
//                ship1active = "100Targeting";
//                 ship2active = "75Targeting";
//                 ship3active = "75Targeting";
//                 ship4active = "50Targeting";
//                 ship5active = "75Circling Alone";
//                 ship6active = "75Circling Alone";
//        }
        
     }
     if(currentBlock==block50){
         if(trialInBlock==block50.get(0)||trialInBlock==block50.get(1)||trialInBlock==block50.get(2)||trialInBlock==block50.get(3)||trialInBlock==block50.get(4)){
                        
                        
                        if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget1_50 = setTarget(newShipList.get(1));
                        setTarget2_50 = setTarget(newShipList.get(2));
                        setTarget3_50 = setTarget(newShipList.get(3));
                        //setCirclePath1_50 = setCirclePath();
                        //setCirclePath2_50 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                        hostileShipFollow(newShipList.get(0),50);
                        
                        friendlyShipWithTarget(newShipList.get(1), setTarget1_50[0], setTarget1_50[1],50);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget2_50[0], setTarget2_50[1],50);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget3_50[0], setTarget3_50[1],50);
                        
                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,50);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,50);
                        //friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_50[0],setCirclePath1_50[1],setCirclePath1_50[2],totalSteps,75);
                        
                        
                        //friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_50[0],setCirclePath2_50[1],setCirclePath2_50[2],totalSteps,75);
                        
                 
                 beFollowed = true;
                 hunterActive="shadowed";
                 followShipBtn = newShipList.get(0);
                 ship1active = "50Shadowing";
                 ship2active = "50Targeting";
                 ship3active = "50Targeting";
                 ship4active = "50Targeting";
                 ship5active = "50Patroling";
                 ship6active = "50Patroling";
         }        
         if(trialInBlock==block50.get(5)||trialInBlock==block50.get(6)||trialInBlock==block50.get(7)||trialInBlock==block50.get(8)||trialInBlock==block50.get(9)){
                 
                        
                        if(step==1){
                        Collections.shuffle(shipList);
                        newShipList = shipList;
                        setTarget4_50 = setTarget(newShipList.get(1));
                        setTarget5_50 = setTarget(newShipList.get(2));
                        setTarget6_50 = setTarget(newShipList.get(3));
                        //setCirclePath3_50 = setCirclePath();
                        setPatrolTarget1 = setDiagonaPoint(newShipList.get(4));
                        setPatrolTarget2 = setDiagonaPoint(newShipList.get(5));
                        }
                        hostileShipChase(newShipList.get(0),50);
                        
                        friendlyShipWithTarget(newShipList.get(1), setTarget4_50[0], setTarget4_50[1],50);
                        
                        
                        friendlyShipWithTarget(newShipList.get(2), setTarget5_50[0], setTarget5_50[1],50);
                        
                        
                        friendlyShipWithTarget(newShipList.get(3), setTarget6_50[0], setTarget6_50[1],50);

                        friendlyShipWithPatrolBehavior(newShipList.get(4),setPatrolTarget1[0],setPatrolTarget1[1],20,50);
                        friendlyShipWithPatrolBehavior(newShipList.get(5),setPatrolTarget2[0],setPatrolTarget2[1],20,50);
                        //friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_50[0],setCirclePath3_50[1],setCirclePath3_50[2],totalSteps,75);

                 
                 beFollowed = true;
                 hunterActive="hunted";
                 followShipBtn = newShipList.get(0);
                 ship1active = "50Hunting";
                 ship2active = "50Targeting";
                 ship3active = "50Targeting";
                 ship4active = "50Targeting";
                 ship5active = "50Patroling";
                 ship6active = "50Patroling";
        }
//         if(trialInBlock==block50.get(10)||trialInBlock==block50.get(11)){
//                        if(step==1){
//                        setTarget7_50 = setTarget(shipList.get(0));
//                        setTarget8_50 = setTarget(shipList.get(1));
//                        setTarget9_50 = setTarget(shipList.get(2));
//                        setTarget10_50 = setTarget(shipList.get(3));
//                        setCirclePath4_50 = setCirclePath();
//                        }
//                        friendlyShipWithTarget(shipList.get(0), setTarget7_50[0], setTarget7_50[1],100);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(1), setTarget8_50[0], setTarget8_50[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(2), setTarget9_50[0], setTarget9_50[1],75);
//                        
//                        
//                        friendlyShipWithTarget(shipList.get(3), setTarget10_50[0], setTarget10_50[1],50);
//
//                        
//                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath4_50[0],setCirclePath4_50[1],setCirclePath4_50[2],totalSteps,75);
//
//                
//                beFollowed = false;
//                followShipBtn = null;
//                ship1active = "100Targeting";
//                 ship2active = "75Targeting";
//                 ship3active = "75Targeting";
//                 ship4active = "50Targeting";
//                 ship5active = "75Circling and Chasing";
//                 ship6active = "75Circling and Chasing";
//            }
        }
//    System.out.println("followShip: "+followShipBtn);
//    System.out.println("shipList: "+shipList);
    }
    
    @FXML
    private void setStartPosition(){
        
        //int p1 = 0;
        int x1 = X_zone1;
        int x2 = X_zone2+1;
        int x3 = X_zone3+1;
        int y1 = Y_zone1;
        int y2 = Y_zone2+1;
        int y3 = Y_zone3+1;
        
        
        
        for (int p1 = 0; p1 < XZoneWidth; p1++) {
                x1++;
                zoneX1[p1]=x1;
                
        }

        for (int p2 = 0; p2 < XZoneWidth; p2++) {
                x2++;
                zoneX2[p2]=x2;
                    
        }

        for (int p3 = 0; p3 < XZoneWidth; p3++) {
                x3++;
                zoneX3[p3]=x3;
                
        }

        for (int p4 = 0; p4 < YZoneWidth; p4++) {
               y1++;
               zoneY1[p4]=y1;
                
        }
    
        for (int p5 = 0; p5 < YZoneWidth; p5++) {
                y2++;
                zoneY2[p5]=y2;
                    
        }

        for (int p6 = 0; p6 < YZoneWidth; p6++) {
                y3++;
                zoneY3[p6]=y3;
                    
        }
        
        X1List = Arrays.asList(zoneX1);
        X2List = Arrays.asList(zoneX2);
        X3List = Arrays.asList(zoneX3);
        Y1List = Arrays.asList(zoneY1);
        Y2List = Arrays.asList(zoneY2);
        Y3List = Arrays.asList(zoneY3);
        
//        System.out.println("X1List: "+X1List);
        
    
        randomX1= X1List.get(rand.nextInt(X1List.size()));
        randomY1= Y1List.get(rand.nextInt(Y1List.size()));
        shipList.get(0).relocate(randomX1,randomY1);
        
        randomX1= X1List.get(rand.nextInt(X1List.size()));
        randomY3= Y3List.get(rand.nextInt(Y3List.size()));
        shipList.get(1).relocate(randomX1,randomY3);
        
        randomX2= X2List.get(rand.nextInt(X2List.size()));
        randomY1= Y1List.get(rand.nextInt(Y1List.size()));
        shipList.get(2).relocate(randomX2,randomY1);
        
        randomX2= X2List.get(rand.nextInt(X2List.size()));
        randomY3= Y3List.get(rand.nextInt(Y3List.size()));
        shipList.get(3).relocate(randomX2,randomY3);
        
        randomX3= X3List.get(rand.nextInt(X3List.size()));
        randomY1= Y1List.get(rand.nextInt(Y1List.size()));
        shipList.get(4).relocate(randomX3,randomY1);
        
        randomX3= X3List.get(rand.nextInt(X3List.size()));
        randomY3= Y3List.get(rand.nextInt(Y3List.size()));
        shipList.get(5).relocate(randomX3,randomY3);
    }
    
    @FXML
    private int[] setTarget(Button ship){
        int shipX = (int)ship.getLayoutX();
        int shipY = (int)ship.getLayoutY();
        
        
        
        if(shipX <= X_zone2 && shipY <= Y_zone2){
            
            targetX = X3List.get(rand.nextInt(X3List.size()));
            targetY = Y3List.get(rand.nextInt(Y3List.size()));
        }
        
        if(X_zone2 < shipX && shipX <= X_zone3 && shipY <= Y_zone2){
            
            targetX = X2List.get(rand.nextInt(X2List.size()));
            targetY = Y3List.get(rand.nextInt(Y3List.size()));
        }
        
        if(X_zone3 < shipX && shipY <= Y_zone2){
            
            targetX = X1List.get(rand.nextInt(X1List.size()));
            targetY = Y3List.get(rand.nextInt(Y3List.size()));
        }
        
//        if(X_zone1 <= shipX && shipX <= X_zone2 && Y_zone2 < shipY && shipY <= Y_zone3){
//            
//            targetX = X3List.get(rand.nextInt(X3List.size()));
//            targetY = Y2List.get(rand.nextInt(Y2List.size()));
//        }
//        
//        if(X_zone3 < shipX && shipX <= X_zone4 && Y_zone2 < shipY && shipY <= Y_zone3){
//            
//            targetX = X1List.get(rand.nextInt(X1List.size()));
//            targetY = Y2List.get(rand.nextInt(Y2List.size()));
//        }
//        
        if(shipX <= X_zone2 && shipY > Y_zone3){
            
            targetX = X3List.get(rand.nextInt(X3List.size()));
            targetY = Y1List.get(rand.nextInt(Y1List.size()));
        }
        
        if(X_zone2 < shipX && shipX <= X_zone3 && shipY > Y_zone3){
            
            targetX = X2List.get(rand.nextInt(X2List.size()));
            targetY = Y1List.get(rand.nextInt(Y1List.size()));
        }
        
        if(X_zone3 < shipX && shipY > Y_zone3){
            
            targetX = X1List.get(rand.nextInt(X1List.size()));
            targetY = Y1List.get(rand.nextInt(Y1List.size()));
        }
        
        
        return new int[]{targetX, targetY};
        
    }
    
    @FXML
    private int[] setDiagonaPoint(Button ship){
        int shipX = (int)ship.getLayoutX();
        int shipY = (int)ship.getLayoutY();
        
        
        
        if(shipX <= X_zone2 && shipY <= Y_zone2){
            
            DiagonaPointX1 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX2 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY2 = Y2List.get(rand.nextInt(Y2List.size()));
            DiagonaPointX3 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY3 = Y3List.get(rand.nextInt(Y3List.size()));
            DiagonaPointX4 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY4 = Y3List.get(rand.nextInt(Y3List.size()));
            
            DPXList=Arrays.asList(DiagonaPointX1,DiagonaPointX2,DiagonaPointX3,DiagonaPointX4);
            DPYList=Arrays.asList(DiagonaPointY1,DiagonaPointY2,DiagonaPointY3,DiagonaPointY4);
            
            
            do{
            DiagonaPointX = DPXList.get(rand.nextInt(DPXList.size()));
            
            if(DiagonaPointX==DiagonaPointX1){
                DiagonaPointY = DiagonaPointY1;
            }
            else if(DiagonaPointX==DiagonaPointX2){
                DiagonaPointY = DiagonaPointY2;
            }
            else if(DiagonaPointX==DiagonaPointX3){
                DiagonaPointY = DiagonaPointY3;
            }
            else if(DiagonaPointX==DiagonaPointX4){
                DiagonaPointY = DiagonaPointY4;
            }
            }while(DiagonaPointX==0 || DiagonaPointY==0||Math.abs(DiagonaPointX-shipX)<50 || Math.abs(DiagonaPointY-shipY)<50);
        }
        
        if(X_zone2 < shipX && shipX <= X_zone3 && shipY <= Y_zone2){
            
            DiagonaPointX1 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY1 = Y3List.get(rand.nextInt(Y3List.size()));
            DiagonaPointX2 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY2 = Y3List.get(rand.nextInt(Y3List.size()));
            DiagonaPointX3 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY3 = Y3List.get(rand.nextInt(Y3List.size()));
            DiagonaPointX4 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY4 = Y3List.get(rand.nextInt(Y3List.size()));

            DPXList=Arrays.asList(DiagonaPointX1,DiagonaPointX2,DiagonaPointX3,DiagonaPointX4);
            DPYList=Arrays.asList(DiagonaPointY1,DiagonaPointY2,DiagonaPointY3,DiagonaPointY4);

            do{
            DiagonaPointX = DPXList.get(rand.nextInt(DPXList.size()));
            //DiagonaPointY = DPYList.get(rand.nextInt(DPYList.size()));
            if(DiagonaPointX==DiagonaPointX1){
                DiagonaPointY = DiagonaPointY1;
            }
            else if(DiagonaPointX==DiagonaPointX2){
                DiagonaPointY = DiagonaPointY2;
            }
            else if(DiagonaPointX==DiagonaPointX3){
                DiagonaPointY = DiagonaPointY3;
            }
            else if(DiagonaPointX==DiagonaPointX4){
                DiagonaPointY = DiagonaPointY4;
            }
            }while(DiagonaPointX==0 || DiagonaPointY==0||Math.abs(DiagonaPointX-shipX)<50 || Math.abs(DiagonaPointY-shipY)<50);
        }
        
        if(X_zone3 < shipX && shipY <= Y_zone2){
            
            DiagonaPointX1 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX2 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY2 = Y2List.get(rand.nextInt(Y2List.size()));
            DiagonaPointX3 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY3 = Y3List.get(rand.nextInt(Y3List.size()));
            DiagonaPointX4 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY4 = Y3List.get(rand.nextInt(Y3List.size()));

            DPXList=Arrays.asList(DiagonaPointX1,DiagonaPointX2,DiagonaPointX3,DiagonaPointX4);
            DPYList=Arrays.asList(DiagonaPointY1,DiagonaPointY2,DiagonaPointY3,DiagonaPointY4);

            do{
            DiagonaPointX = DPXList.get(rand.nextInt(DPXList.size()));
            //DiagonaPointY = DPYList.get(rand.nextInt(DPYList.size()));
            if(DiagonaPointX==DiagonaPointX1){
                DiagonaPointY = DiagonaPointY1;
            }
            else if(DiagonaPointX==DiagonaPointX2){
                DiagonaPointY = DiagonaPointY2;
            }
            else if(DiagonaPointX==DiagonaPointX3){
                DiagonaPointY = DiagonaPointY3;
            }
            else if(DiagonaPointX==DiagonaPointX4){
                DiagonaPointY = DiagonaPointY4;
            }
            }while(DiagonaPointX==0 || DiagonaPointY==0||Math.abs(DiagonaPointX-shipX)<50 || Math.abs(DiagonaPointY-shipY)<50);
        }
        
        
        if(shipX <= X_zone2 && shipY > Y_zone3){
            
            DiagonaPointX1 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX2 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY2 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX3 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY3 = Y2List.get(rand.nextInt(Y2List.size()));
            DiagonaPointX4 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY4 = Y3List.get(rand.nextInt(Y3List.size()));

            DPXList=Arrays.asList(DiagonaPointX1,DiagonaPointX2,DiagonaPointX3,DiagonaPointX4);
            DPYList=Arrays.asList(DiagonaPointY1,DiagonaPointY2,DiagonaPointY3,DiagonaPointY4);

            do{
            DiagonaPointX = DPXList.get(rand.nextInt(DPXList.size()));
            //DiagonaPointY = DPYList.get(rand.nextInt(DPYList.size()));
            if(DiagonaPointX==DiagonaPointX1){
                DiagonaPointY = DiagonaPointY1;
            }
            else if(DiagonaPointX==DiagonaPointX2){
                DiagonaPointY = DiagonaPointY2;
            }
            else if(DiagonaPointX==DiagonaPointX3){
                DiagonaPointY = DiagonaPointY3;
            }
            else if(DiagonaPointX==DiagonaPointX4){
                DiagonaPointY = DiagonaPointY4;
            }
            }while(DiagonaPointX==0 || DiagonaPointY==0||Math.abs(DiagonaPointX-shipX)<50 || Math.abs(DiagonaPointY-shipY)<50);
        }
        
        if(X_zone2 < shipX && shipX <= X_zone3 && shipY > Y_zone3){
            
            DiagonaPointX2 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX2 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX3 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY3 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX4 = X3List.get(rand.nextInt(X3List.size()));
            DiagonaPointY4 = Y1List.get(rand.nextInt(Y1List.size()));

            DPXList=Arrays.asList(DiagonaPointX1,DiagonaPointX2,DiagonaPointX3,DiagonaPointX4);
            DPYList=Arrays.asList(DiagonaPointY1,DiagonaPointY2,DiagonaPointY3,DiagonaPointY4);

            do{
            DiagonaPointX = DPXList.get(rand.nextInt(DPXList.size()));
            //DiagonaPointY = DPYList.get(rand.nextInt(DPYList.size()));
            if(DiagonaPointX==DiagonaPointX1){
                DiagonaPointY = DiagonaPointY1;
            }
            else if(DiagonaPointX==DiagonaPointX2){
                DiagonaPointY = DiagonaPointY2;
            }
            else if(DiagonaPointX==DiagonaPointX3){
                DiagonaPointY = DiagonaPointY3;
            }
            else if(DiagonaPointX==DiagonaPointX4){
                DiagonaPointY = DiagonaPointY4;
            }
            }while(DiagonaPointX==0 || DiagonaPointY==0||Math.abs(DiagonaPointX-shipX)<50 || Math.abs(DiagonaPointY-shipY)<50);
        }
        
        if(X_zone3 < shipX && shipY > Y_zone3){
            
            DiagonaPointX2 = X2List.get(rand.nextInt(X2List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX3 = X2List.get(rand.nextInt(X3List.size()));
            DiagonaPointY1 = Y1List.get(rand.nextInt(Y1List.size()));
            DiagonaPointX3 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY3 = Y2List.get(rand.nextInt(Y2List.size()));
            DiagonaPointX4 = X1List.get(rand.nextInt(X1List.size()));
            DiagonaPointY4 = Y3List.get(rand.nextInt(Y3List.size()));

            DPXList=Arrays.asList(DiagonaPointX1,DiagonaPointX2,DiagonaPointX3,DiagonaPointX4);
            DPYList=Arrays.asList(DiagonaPointY1,DiagonaPointY2,DiagonaPointY3,DiagonaPointY4);

            do{
            DiagonaPointX = DPXList.get(rand.nextInt(DPXList.size()));
            //DiagonaPointY = DPYList.get(rand.nextInt(DPYList.size()));
            if(DiagonaPointX==DiagonaPointX1){
                DiagonaPointY = DiagonaPointY1;
            }
            else if(DiagonaPointX==DiagonaPointX2){
                DiagonaPointY = DiagonaPointY2;
            }
            else if(DiagonaPointX==DiagonaPointX3){
                DiagonaPointY = DiagonaPointY3;
            }
            else if(DiagonaPointX==DiagonaPointX4){
                DiagonaPointY = DiagonaPointY4;
            }
            }while(DiagonaPointX==0 || DiagonaPointY==0||Math.abs(DiagonaPointX-shipX)<50 || Math.abs(DiagonaPointY-shipY)<50);
        }
        
        
        return new int[]{DiagonaPointX, DiagonaPointY};
        
    }
    
    @FXML
    private int[] setCirclePath(){
        
        int randomCircleX = 0;
        int randomCircleY = 0;
        int randomCircleR = 0;
        
        Integer[]circleX = new Integer[406];
        Integer[]circleY = new Integer[161];
        Integer[]circleR = new Integer[50];
        
        //int a = 177;
        //int b = 177;
        int a = 200;
        int b = 200;
        int c = 100;
        for (int CX = 0; CX < 406; CX++) {
                a++;
                circleX[CX]=a;
                    
        }
        
        for (int CY = 0; CY < 161; CY++) {
                b++;
                circleY[CY]=b;
                
        }
        
        for (int CR = 0; CR <50; CR++) {
                c++;
                circleR[CR]=c;
                
        }
        List<Integer> circleXList = Arrays.asList(circleX);
        List<Integer> circleYList = Arrays.asList(circleY);
        List<Integer> circleRList = Arrays.asList(circleR);
        
        randomCircleX= circleXList.get(rand.nextInt(circleXList.size()));
        randomCircleY= circleYList.get(rand.nextInt(circleYList.size()));
        randomCircleR= circleRList.get(rand.nextInt(circleRList.size()));
        
        return new int[]{randomCircleR, randomCircleX, randomCircleY};
    }
    
    @FXML
    private void displayPosition(MouseEvent event) {
        status.setText("X = " + event.getX() + "    Y = "  + event.getY());
        status.setVisible(false);
    }
    
    @FXML
    private void loadQuestion1(ActionEvent event) throws IOException {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        endTime = time.format(formatter);
            
        AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas1.fxml"));
        MainCanvas.getChildren().setAll(pane);
        
    }
    
    @FXML
    private void loadMainPractice(ActionEvent event) throws IOException {
        if(trialNum==2){  
            parameters.setVisible(true);
            gamePane.setVisible(false);
        }
        else{
        StackPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        MainCanvas.getChildren().setAll(pane);
        }
    }
    
    @FXML
    private void loadBegin(ActionEvent event) throws IOException {
            parameters.setVisible(false);
            gamePane.setVisible(false);
            begin.setVisible(true);
        
    }
    
    @FXML
    private void loadRealGame(ActionEvent event) throws IOException {
        
        StackPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        MainCanvas.getChildren().setAll(pane);
        
    }
    
    

    public void init(WelcomeCanvasController welcomeController) {
        welcomeController=welcomeController; //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void buttonClick() throws IOException {
        URL soundName = this.getClass().getResource("Click.wav");
        //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName.getFile()));
        //Clip clip = AudioSystem.getClip();
        //clip.open(audioInputStream);
        //clip.start();
        AudioClip note = new AudioClip(soundName.toString());
        note.play();
    }
 
}


