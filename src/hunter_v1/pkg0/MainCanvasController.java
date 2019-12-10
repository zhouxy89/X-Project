/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.NativeRegExp.source;


/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class MainCanvasController implements Initializable {
    
    
    @FXML
    private Pane scene;
    @FXML
    private AnchorPane MainCanvas;
    
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
    private Text status;
    @FXML
    private Text timeup;
    
    @FXML
    public Text trialText;
    
    @FXML
    private Button endGame;
    
    private Button ship;
    
    private static final int      KEYBOARD_MOVEMENT_DELTA = 15;
    
    private double randomElement;
    
    
    double MyShipX = 0;
    double MyShipY = 0;
    
    double distance_afterMove;
    double distance_beforeMove;
    
    public int step = 0;
    
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
    int ShipX= 0;
    int ShipY= 0;
    int hostileShipX=0;
    int hostileShipY=0;
    int moveDirect=0;
    int circleStep=0;
    int currentMyShipX=0;
    int currentMyShipY=0;
    int moveDistancePerStep=10;
    int distanceFromLastPoint_toShip=27+moveDistancePerStep*2;
    int distanceFromCurrentPoint_toShip=0;
    int totalSteps=25;
    
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
    
    List<Integer> currentBlock=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    public static List<Integer> block50=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    public static List<Integer> block75=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    public static List<Integer> block100=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    public static List<List> blockListAfterShuffle = Arrays.asList(block100,block75,block50);
    int trialInBlock = 0;
    public static int blockListAfterShuffle_number=0;
    
    public boolean beFollowed = false;
    public static Button followShipBtn =null;
    public static int followShip=0;
    List<Button> shipList = null;
    
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
    
    String ship1active = "";
    String ship2active = "";
    String ship3active = "";
    String ship4active = "";
    String ship5active = "";
    String ship6active = "";
    String active = "";
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        endGame.setDisable(true);
        endGame.setFocusTraversable(false);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        welcomeController.setTrialFromResultCanvas(welcomeController.trialFromResult());
        

        trialNum+=1;
        if(trialNum<=3){
            trialText.setText("Practic Trial");
        }
        else{
        trialText.setText("Trial: "+String.valueOf(trialNum-3));
        System.out.println("Current trial: "+trialNum);
        }
        welcomeController.setFileNameFromResultCanvas(welcomeController.fileNameFromResultCanvas());
        welcomeController.setblockListFromResultCanvas(welcomeController.blockListAfterShuffleFromResultCanvas());
        String home = System.getProperty("user.home");
        filepath = home+"/Downloads/"+ "ShadowHunt_"+dateTime+ ".csv";
        //filepath = "/Users/zhouxiaoyan/Downloads/"+ "ShadowHunt_"+dateTime+ ".csv";
        file = new File(filepath);
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
        
        
    }
    

    

    @FXML
    private void friendlyShipWithTarget(Button friendlyShip,int towardTargetX, int towardTargetY,int matchPercentage){
            
            clearShipsOnCanvas();
            setAllShipsOnCanvas(friendlyShip);
            
            ShipX= (int)friendlyShip.getLayoutX();
            ShipY= (int)friendlyShip.getLayoutY();
            shipWidth = (int)friendlyShip.getPrefWidth();
            shipHeight = (int)friendlyShip.getPrefHeight();
            
            if(step<totalSteps){
            moveX=Math.round((towardTargetX-ShipX)/(totalSteps-step));
            moveY=Math.round((towardTargetY-ShipY)/(totalSteps-step));
            }
            else{
             moveX = moveX;
             moveY = moveY;
            }
            
            //System.out.println("moveX: " +moveX);
            //System.out.println("moveY: " +moveY);
           
            randomMoveX = (int)givenList_shouldReturnARandomElement()+moveX;
            randomMoveY = (int)givenList_shouldReturnARandomElement()+moveY;
            
  
            
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
                friendlyShip.relocate(ShipX +randomMoveX, ShipY +randomMoveY);
                    break;
                
                case 75:
              
                    switch (step) {
                        case 3:
                        case 7:
                        case 10:
                        case 15:
                        case 17:
                        case 22:
                            friendlyShip.relocate(ShipX +givenList_shouldReturnARandomElement(), ShipY +givenList_shouldReturnARandomElement());
                            break;
                
                        default:
                            friendlyShip.relocate(ShipX +randomMoveX, ShipY +randomMoveY);
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
                            friendlyShip.relocate(ShipX + givenList_shouldReturnARandomElement(), ShipY + givenList_shouldReturnARandomElement());
                            
                            break;
                
                        default:
                            friendlyShip.relocate(ShipX +randomMoveX, ShipY +randomMoveY);
                            break;
                    }
                    break;
                        
                            
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
            
            
            if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||canvas[X+shipWidth/2][Y]==1||canvas[X-shipWidth/2][Y]==1||canvas[X][Y-shipHeight/2]==1||canvas[X][Y+shipHeight/2]==1){
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


                    if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA){//||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
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


                    if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA){//||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
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
    private void moveMyshipOnKeyPress(KeyEvent event) throws IOException{
            if(step==1){ 
        try { 
            sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            else{
        try { 
            sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
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
            if(trialNum==4){
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
            Timer timer = new Timer();
            TimerTask getKeyEvent = new TimerTask()
            {
                public void run()
                {
                    
                    if(step<=totalSteps){
                    clearShipsOnCanvas();
                    setAllShipsOnCanvas(btnMyShip);    
                    switch (event.getCode()) {
                      case UP: 
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
                      case RIGHT:
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
                      case DOWN:
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
                      case LEFT:  
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
         
            if(trialNum<=3){
                System.out.println("Practic shipList: "+shipList);
            practicTrials();
               
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
            
            if(trialNum>3){
            saveRecord();    
            }
            }
            else{
                timeup.setText("Time's up");
            };
            }
                    
            };
            
            timer.schedule(getKeyEvent,1000);
             
            
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
        allShips[6]= btnMyShip;
        
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
    List<Integer> givenList = Arrays.asList(0,10,-10);
    Random rand = new Random();
    return randomElement = givenList.get(rand.nextInt(givenList.size()));
    }
    
    
    @FXML
    public String recordData() throws IOException{
        int X = 0;
        int Y = 0;     
        String coordinate = "";
        String record = "";
        
        for (int s=0; s<allShips.length; s++){
            if(allShips[s]==shipList.get(0)){
                active = ship1active;
            }
            else if(allShips[s]==shipList.get(1)){
                active = ship2active;
            }
            else if(allShips[s]==shipList.get(2)){
                active = ship3active;
            }
            else if(allShips[s]==shipList.get(3)){
                active = ship4active;
            }
            else if(allShips[s]==shipList.get(4)){
                active = ship5active;
            }
            else if(allShips[s]==shipList.get(5)){
                active = ship6active;
            }
            X = (int)allShips[s].getLayoutX();
            Y = (int)allShips[s].getLayoutY();
            
            coordinate = "("+ X + " " + Y+")"+" "+active;
            
            record+=","+coordinate;
            
        }
        
        return record;
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
            if(trialNum==4){
//            System.out.println(step);
//            System.out.println(trialNum);
                try {
                    writer.write("Trial"+","+"Step"+","+"Ship1"+","+"Ship2"+","+"Ship3"+","+"Ship4"+","+"Ship5"+","+"Ship6"+","+"MyShip"+","+"ParticipantAnswer"+","+"RightAnswer"+'\n');
                } catch (IOException ex) {
                    Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
        
        
        
        BufferedWriter data = new BufferedWriter(writer);
        move = new PrintWriter(data);
        
        try {
            recordLine = trialNum-3 +","+step+recordData();
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
//            case 3:
            case 4:
            case 5:    
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:  
                trialInBlock=trialNum-3;
                break;
                
            
              
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                trialInBlock=trialNum-15;
                break;
            
                
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                trialInBlock=trialNum-27;
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
//            case 3:
            case 4:
            case 5:    
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                currentBlock=blockList.get(0);
                break;
                
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:    
                currentBlock=blockList.get(1);
                break;
                
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
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
                      if(step==1){
                        setTarget1_75 = setTarget(shipList.get(1));
                        setTarget2_75 = setTarget(shipList.get(2));
                        setTarget3_75 = setTarget(shipList.get(3));
                        setCirclePath1_75 = setCirclePath();
                        setCirclePath2_75 = setCirclePath();
                      }
                        
                        hostileShipFollow(shipList.get(0),75);
                        friendlyShipWithTarget(shipList.get(1), setTarget1_75[0], setTarget1_75[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget2_75[0], setTarget2_75[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget3_75[0], setTarget3_75[1],50);
                        
                        
                        
                        friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_75[0],setCirclePath1_75[1],setCirclePath1_75[2],totalSteps,75);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_75[0],setCirclePath2_75[1],setCirclePath2_75[2],totalSteps,75);
                        
                 beFollowed = true;
                 followShipBtn = shipList.get(0);
        }
        
        if(trialNum==2){
                if(step==1){
                        setTarget4_75 = setTarget(shipList.get(1));
                        setTarget5_75 = setTarget(shipList.get(2));
                        setTarget6_75 = setTarget(shipList.get(3));
                        setCirclePath3_75 = setCirclePath();
                        }
                        hostileShipChase(shipList.get(0),75);
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget4_75[0], setTarget4_75[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget5_75[0], setTarget5_75[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget6_75[0], setTarget6_75[1],50);
                        
                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_75[0],setCirclePath3_75[1],setCirclePath3_75[2],totalSteps,75);

                 beFollowed = true;
                 followShipBtn = shipList.get(0);
        }
        
        if(trialNum==3){
                    if(step==1){
                        setTarget7_100 = setTarget(shipList.get(0));
                        setTarget8_100 = setTarget(shipList.get(1));
                        setTarget9_100 = setTarget(shipList.get(2));
                        setTarget10_100 = setTarget(shipList.get(3));
                        setCirclePath4_100 = setCirclePath();
                        }
                        friendlyShipWithTarget(shipList.get(0), setTarget7_100[0], setTarget7_100[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget8_100[0], setTarget8_100[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget9_100[0], setTarget9_100[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget10_100[0], setTarget10_100[1],50);
                        
                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath4_100[0],setCirclePath4_100[1],setCirclePath4_100[2],totalSteps,75);
                      
                beFollowed = false;
                followShipBtn = null;
                
           
        }
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
                        setTarget1_100 = setTarget(shipList.get(1));
                        setTarget2_100 = setTarget(shipList.get(2));
                        setTarget3_100 = setTarget(shipList.get(3));
                        setCirclePath1_100 = setCirclePath();
                        setCirclePath2_100 = setCirclePath();
                        }
                        
                        hostileShipFollow(shipList.get(0),100);
                        System.out.println("shipList.get(1): "+shipList.get(1));
                        friendlyShipWithTarget(shipList.get(1), setTarget1_100[0], setTarget1_100[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget2_100[0], setTarget2_100[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget3_100[0], setTarget3_100[1],50);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_100[0],setCirclePath1_100[1],setCirclePath1_100[2],totalSteps,75);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_100[0],setCirclePath2_100[1],setCirclePath2_100[2],totalSteps,75);
                      
                 beFollowed = true;
                 followShipBtn = shipList.get(0);
                 ship1active = "100Shadowing";
                 ship2active = "100Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling Alone";
                 ship6active = "75Circling Alone";
                 
         }        
         if(trialInBlock==block100.get(5)||trialInBlock==block100.get(6)||trialInBlock==block100.get(7)||trialInBlock==block100.get(8)||trialInBlock==block100.get(9)){
                
                        
                        if(step==1){
                        setTarget4_100 = setTarget(shipList.get(1));
                        setTarget5_100 = setTarget(shipList.get(2));
                        setTarget6_100 = setTarget(shipList.get(3));
                        setCirclePath3_100 = setCirclePath();
                        }
                        
                        hostileShipChase(shipList.get(0),100);
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget4_100[0], setTarget4_100[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget5_100[0], setTarget5_100[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget6_100[0], setTarget6_100[1],50);
                        
                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_100[0],setCirclePath3_100[1],setCirclePath3_100[2],totalSteps,75);
                        
                 beFollowed = true;
                 followShipBtn = shipList.get(0);
                 ship1active = "100Hunting";
                 ship2active = "100Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling and Chasing";
                 ship6active = "75Circling and Chasing";
            }
         
            if(trialInBlock==block100.get(10)||trialInBlock==block100.get(11)){
                        if(step==1){
                        setTarget7_100 = setTarget(shipList.get(0));
                        setTarget8_100 = setTarget(shipList.get(1));
                        setTarget9_100 = setTarget(shipList.get(2));
                        setTarget10_100 = setTarget(shipList.get(3));
                        setCirclePath4_100 = setCirclePath();
                        }
                        friendlyShipWithTarget(shipList.get(0), setTarget7_100[0], setTarget7_100[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget8_100[0], setTarget8_100[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget9_100[0], setTarget9_100[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget10_100[0], setTarget10_100[1],50);
                        
                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath4_100[0],setCirclePath4_100[1],setCirclePath4_100[2],totalSteps,75);
                      
                beFollowed = false;
                followShipBtn = null;
                 ship1active = "100Targeting";
                 ship2active = "75Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling and Chasing";
                 ship6active = "75Circling and Chasing";
            }
        
     }
     if(currentBlock==block75){
         if(trialInBlock==block75.get(0)||trialInBlock==block75.get(1)||trialInBlock==block75.get(2)||trialInBlock==block75.get(3)||trialInBlock==block75.get(4)){
                 
                        
                        if(step==1){
                        setTarget1_75 = setTarget(shipList.get(1));
                        setTarget2_75 = setTarget(shipList.get(2));
                        setTarget3_75 = setTarget(shipList.get(3));
                        setCirclePath1_75 = setCirclePath();
                        setCirclePath2_75 = setCirclePath();
                        }
                        
                        hostileShipFollow(shipList.get(0),75);
                        friendlyShipWithTarget(shipList.get(1), setTarget1_75[0], setTarget1_75[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget2_75[0], setTarget2_75[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget3_75[0], setTarget3_75[1],50);
                        
                        
                        
                        friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_75[0],setCirclePath1_75[1],setCirclePath1_75[2],totalSteps,75);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_75[0],setCirclePath2_75[1],setCirclePath2_75[2],totalSteps,75);
                        
                 beFollowed = true;
                 followShipBtn = shipList.get(0);
                 ship1active = "75Shadowing";
                 ship2active = "100Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling Alone";
                 ship6active = "75Circling Alone";
         }     
         if(trialInBlock==block75.get(5)||trialInBlock==block75.get(6)||trialInBlock==block75.get(7)||trialInBlock==block75.get(8)||trialInBlock==block75.get(9)){
                 
                        
                        if(step==1){
                        setTarget4_75 = setTarget(shipList.get(1));
                        setTarget5_75 = setTarget(shipList.get(2));
                        setTarget6_75 = setTarget(shipList.get(3));
                        setCirclePath3_75 = setCirclePath();
                        }
                        hostileShipChase(shipList.get(0),75);
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget4_75[0], setTarget4_75[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget5_75[0], setTarget5_75[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget6_75[0], setTarget6_75[1],50);
                        
                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_75[0],setCirclePath3_75[1],setCirclePath3_75[2],totalSteps,75);

                 beFollowed = true;
                 followShipBtn = shipList.get(0);
                 ship1active = "75Hunting";
                 ship2active = "100Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling and Chasing";
                 ship6active = "75Circling and Chasing";
        }
         
         if(trialInBlock==block75.get(10)||trialInBlock==block75.get(11)){
                        if(step==1){
                        setTarget7_75 = setTarget(shipList.get(0));
                        setTarget8_75 = setTarget(shipList.get(1));
                        setTarget9_75 = setTarget(shipList.get(2));
                        setTarget10_75 = setTarget(shipList.get(3));
                        setCirclePath4_75 = setCirclePath();
                        setCirclePath5_75 = setCirclePath();
                        }
                        friendlyShipWithTarget(shipList.get(0), setTarget7_75[0], setTarget7_75[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget8_75[0], setTarget8_75[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget9_75[0], setTarget9_75[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget10_75[0], setTarget10_75[1],50);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(4),setCirclePath4_75[0],setCirclePath4_75[1],setCirclePath4_75[2],totalSteps,75);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(5),setCirclePath5_75[0],setCirclePath5_75[1],setCirclePath5_75[2],totalSteps,75);

                      
                beFollowed = false;
                followShipBtn = null;
                ship1active = "100Targeting";
                 ship2active = "75Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling Alone";
                 ship6active = "75Circling Alone";
        }
        
     }
     if(currentBlock==block50){
         if(trialInBlock==block50.get(0)||trialInBlock==block50.get(1)||trialInBlock==block50.get(2)||trialInBlock==block50.get(3)||trialInBlock==block50.get(4)){
                        
                        
                        if(step==1){
                        setTarget1_50 = setTarget(shipList.get(1));
                        setTarget2_50 = setTarget(shipList.get(2));
                        setTarget3_50 = setTarget(shipList.get(3));
                        setCirclePath1_50 = setCirclePath();
                        setCirclePath2_50 = setCirclePath();
                        }
                        hostileShipFollow(shipList.get(0),50);
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget1_50[0], setTarget1_50[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget2_50[0], setTarget2_50[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget3_50[0], setTarget3_50[1],50);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(4),setCirclePath1_50[0],setCirclePath1_50[1],setCirclePath1_50[2],totalSteps,75);
                        
                        
                        friendlyShipWithCirclePath(shipList.get(5),setCirclePath2_50[0],setCirclePath2_50[1],setCirclePath2_50[2],totalSteps,75);
                        
                 
                 beFollowed = true;
                 followShipBtn = shipList.get(0);
                 ship1active = "50Shadowing";
                 ship2active = "100Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling Alone";
                 ship6active = "75Circling Alone";
         }        
         if(trialInBlock==block50.get(5)||trialInBlock==block50.get(6)||trialInBlock==block50.get(7)||trialInBlock==block50.get(8)||trialInBlock==block50.get(9)){
                 
                        
                        if(step==1){
                        setTarget4_50 = setTarget(shipList.get(1));
                        setTarget5_50 = setTarget(shipList.get(2));
                        setTarget6_50 = setTarget(shipList.get(3));
                        setCirclePath3_50 = setCirclePath();
                        }
                        hostileShipChase(shipList.get(0),50);
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget4_50[0], setTarget4_50[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget5_50[0], setTarget5_50[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget6_50[0], setTarget6_50[1],50);

                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath3_50[0],setCirclePath3_50[1],setCirclePath3_50[2],totalSteps,75);

                 
                 beFollowed = true;
                 followShipBtn = shipList.get(0);
                 ship1active = "50Hunting";
                 ship2active = "100Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling and Chasing";
                 ship6active = "75Circling and Chasing";
        }
         if(trialInBlock==block50.get(10)||trialInBlock==block50.get(11)){
                        if(step==1){
                        setTarget7_50 = setTarget(shipList.get(0));
                        setTarget8_50 = setTarget(shipList.get(1));
                        setTarget9_50 = setTarget(shipList.get(2));
                        setTarget10_50 = setTarget(shipList.get(3));
                        setCirclePath4_50 = setCirclePath();
                        }
                        friendlyShipWithTarget(shipList.get(0), setTarget7_50[0], setTarget7_50[1],100);
                        
                        
                        friendlyShipWithTarget(shipList.get(1), setTarget8_50[0], setTarget8_50[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(2), setTarget9_50[0], setTarget9_50[1],75);
                        
                        
                        friendlyShipWithTarget(shipList.get(3), setTarget10_50[0], setTarget10_50[1],50);

                        
                        friendlyShipsChaseInCircle(shipList.get(4),shipList.get(5),setCirclePath4_50[0],setCirclePath4_50[1],setCirclePath4_50[2],totalSteps,75);

                
                beFollowed = false;
                followShipBtn = null;
                ship1active = "100Targeting";
                 ship2active = "75Targeting";
                 ship3active = "75Targeting";
                 ship4active = "50Targeting";
                 ship5active = "75Circling and Chasing";
                 ship6active = "75Circling and Chasing";
            }
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
        
        if(X_zone1 <= shipX && shipX <= X_zone2 && Y_zone2 < shipY && shipY <= Y_zone3){
            
            targetX = X3List.get(rand.nextInt(X3List.size()));
            targetY = Y2List.get(rand.nextInt(Y2List.size()));
        }
        
        if(X_zone3 < shipX && shipX <= X_zone4 && Y_zone2 < shipY && shipY <= Y_zone3){
            
            targetX = X1List.get(rand.nextInt(X1List.size()));
            targetY = Y2List.get(rand.nextInt(Y2List.size()));
        }
        
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
    }
    
    @FXML
    private void loadQuestion1(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas1.fxml"));
        MainCanvas.getChildren().setAll(pane);
        
    }

    public void init(WelcomeCanvasController welcomeController) {
        welcomeController=welcomeController; //To change body of generated methods, choose Tools | Templates.
    }


 
}


