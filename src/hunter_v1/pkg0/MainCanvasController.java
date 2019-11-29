/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private AnchorPane rootPane;
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
    
    int step = 0;
    
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
    //int totalTrials=38;
    public static int trialNum=0;
    Button[] allShips= new Button[7];
    
    public static int dateTime=0;
    public String filePath = "";
    
    public File file = null;    
    FileWriter writer= null;
    PrintWriter move = null;
    String recordLine="";
    
    List<Integer> currentBlock=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    List<Integer> block50=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    List<Integer> block75=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    List<Integer> block100=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
    int trialInBlock = 0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
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
        trialText.setText("Trial: "+String.valueOf(trialNum));
        
        welcomeController.setFileNameFromResultCanvas(welcomeController.fileNameFromResultCanvas());
        filePath = "/Users/zhouxiaoyan/Downloads/"+ "ShadowHunt_"+dateTime+ ".csv";
        file = new File(filePath);
          
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
            
            System.out.println((ShipX+randomMoveX) +","+(ShipY+shipHeight/2+randomMoveY));
            System.out.println((ShipX+randomMoveX) +","+(ShipY-shipHeight/2+randomMoveY));
            System.out.println((ShipX+shipWidth/2+randomMoveX) +","+(ShipY+randomMoveY));
            System.out.println((ShipX-shipWidth/2+randomMoveX) +","+(ShipY+randomMoveY));
            System.out.println(canvas[ShipX+randomMoveX][ShipY+shipHeight/2+randomMoveY]);
            System.out.println(canvas[ShipX+randomMoveX][ShipY-shipHeight/2+randomMoveY]);
            System.out.println(canvas[ShipX+shipWidth/2+randomMoveX][ShipY+randomMoveY]);
            System.out.println(canvas[ShipX-shipWidth/2+randomMoveX][ShipY+randomMoveY]);
            
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
                        case 4:
                        case 6:
                        case 8:
                        case 10:
                        case 12:
                        case 14:
                        case 16:
                        case 18:
                        case 20:
                        case 22:
                        case 24:
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
                                System.out.println("1rightX: "+(X1+shipWidth/2)+ " 1rightY: "+ Y1);
                                System.out.println("1leftX: "+(X1-shipWidth/2)+" 1leftY: "+Y1);
                                System.out.println("1downX: "+X1+" 1downY: "+(Y1+shipHeight/2));
                                System.out.println("1upX: "+X1+" 1upY: "+(Y1-shipHeight/2));
//                                
                            }
                            else{
                                friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);

                            }
                            clearShipsOnCanvas();
                            setAllShipsOnCanvas(friendlyShip2);
                            if(canvas[X2][Y2+shipHeight/2]!=1 && canvas[X2][Y2-shipHeight/2]!=1 && canvas[X2-shipWidth/2][Y2]!=1 && canvas[X2+shipWidth/2][Y2]!=1){
                                friendlyShip2.relocate(X2,Y2);
                                System.out.println("1rightX: "+(X2+shipWidth/2)+ " 2rightY: "+ Y2);
                                System.out.println("2leftX: "+(X2-shipWidth/2)+" 2leftY: "+Y2);
                                System.out.println("2downX: "+X2+" 2downY: "+(Y2+shipHeight/2));
                                System.out.println("2upX: "+X2+" 2upY: "+(Y2-shipHeight/2));
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
                        case 4:
                        case 6:
                        case 8:
                        case 10:
                        case 12:
                        case 14:
                        case 16:
                        case 18:
                        case 20:
                        case 22:
                        case 24:
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
            System.out.println("hunterRright: "+canvas[X+shipWidth/2][Y]);
            System.out.println("hunterLeft: "+canvas[X-shipWidth/2][Y]);
            System.out.println("hunterDown: "+canvas[X][Y-shipHeight/2]);
            System.out.println("hunterUp: "+canvas[X][Y+shipHeight/2]);
            
            
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
                case 4:
                case 6:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
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
            
            
            step+=1;
            System.out.println("step: "+step);
            
            
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
                    
            System.out.println("myrightX: "+((int)btnMyShip.getLayoutX()+shipWidth/2)+"myrightY: "+((int)btnMyShip.getLayoutY()));
            System.out.println("myleftX: "+((int)btnMyShip.getLayoutX()-shipWidth/2)+"myleftY: "+((int)btnMyShip.getLayoutY()));
            System.out.println("mydownX: "+((int)btnMyShip.getLayoutX())+"mydownY: "+((int)btnMyShip.getLayoutY()+shipHeight/2));
            System.out.println("myupXX: "+((int)btnMyShip.getLayoutX())+"myupY: "+((int)btnMyShip.getLayoutY()-shipHeight/2));    
//            clearShipsOnCanvas();
//            setShipOnCanvas(btnMyShip);
//            
//            
//            setShipOnCanvas(btnShip1);
//            setShipOnCanvas(btnShip2);
//            setShipOnCanvas(btnShip4);
//            setShipOnCanvas(btnShip5);
            
            hostileShipChase(btnShip3,100);
            
//            setShipOnCanvas(btnMyShip);
//            setShipOnCanvas(btnShip1);
//            setShipOnCanvas(btnShip2);
//            setShipOnCanvas(btnShip4);
            hostileShipFollow(btnShip5,75);
            //friendlyShipWithTarget(btnShip1, 370, 240,75);
            
//            setShipOnCanvas(btnMyShip);
//            setShipOnCanvas(btnShip1);
//            setShipOnCanvas(btnShip3);
//            setShipOnCanvas(btnShip4);
            friendlyShipWithTarget(btnShip2, 579, 510,50);
            
            
            //friendlyShipWithCirclePath(btnShip4,100,150,300,15,75);
//            setShipOnCanvas(btnMyShip);
//            setShipOnCanvas(btnShip3);
//            setShipOnCanvas(btnShip5);
            friendlyShipsChaseInCircle(btnShip1,btnShip4,150,250,200,30,75);
                
            saveRecord();    
        
                        
                        
//                        try {
//                            writer = new FileWriter(file, true);
//                        } catch (IOException ex) {
//                            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
              
            }
            else{
                timeup.setText("Time's up");
            };
            }
                    
            };
            
            timer.schedule(getKeyEvent,1000);
             
            
     }
    
//    public void setTrialText(int trialNumber) throws IOException {
//        trialNum=trialNumber;
//    }
    
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
            X = (int)allShips[s].getLayoutX();
            Y = (int)allShips[s].getLayoutY();
            coordinate = "("+ X + " " + Y+")";
            
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

                writer = new FileWriter(filePath, true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(step==1){
            if(trialNum==1){
            System.out.println(step);
            System.out.println(trialNum);
                try {
                    writer.write("Trial"+","+"Step"+","+"Ship1"+","+"Ship2"+","+"Ship3"+","+"Ship4"+","+"Ship5"+","+"Ship6"+","+"MyShip"+'\n');
                } catch (IOException ex) {
                    Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        BufferedWriter data = new BufferedWriter(writer);
        move = new PrintWriter(data);
        
        try {
            recordLine = trialNum+","+step+recordData();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        move.println(recordLine);
        move.flush();
        move.close();
        
                
    }
    @FXML
    private List randomBlocks(){
        List<List> givenShipList = Arrays.asList(block100,block75,block50);
        Collections.shuffle(givenShipList);
        return givenShipList;
       
    }
    
    @FXML
    private void randomAssignTrials(){
        List<List> blockList = randomBlocks();
        
        switch(trialNum){
            case 1:
            case 2:
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
            case 23:
            case 24:
                currentBlock=blockList.get(1);
                break;
                
            case 25:
            case 26:
            case 27:    
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
                currentBlock=blockList.get(2);
                break;
        }
        
        
    }
    
    
    @FXML
    private List randomShipList() {
    List<Button> givenShipList = Arrays.asList(btnShip1,btnShip2,btnShip3,btnShip4,btnShip5);
    
    Collections.shuffle(givenShipList);
    
    return givenShipList;
    }
    
    @FXML
    private void randomAssignShips(){
     List<Button> givenShipList = randomShipList();
     
     if(currentBlock==block100){
         //random trial number first
         if(trialInBlock==block100.get(0)||trialInBlock==block100.get(1)||trialInBlock==block100.get(2)||trialInBlock==block100.get(3)||trialInBlock==block100.get(4)){
                 for(int s=0; s<givenShipList.size(); s++){
                        //hostileShipChase(givenShipList.get(1),100);

                        hostileShipFollow(givenShipList.get(0),100);

                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        friendlyShipWithCirclePath(givenShipList.get(4),100,150,300,15,75);
                        friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);
                        //friendlyShipsChaseInCircle(givenShipList.get(1),givenShipList.get(1),150,250,200,30,75);

                 }
                 
         if(trialInBlock==block100.get(5)||trialInBlock==block100.get(6)||trialInBlock==block100.get(7)||trialInBlock==block100.get(8)||trialInBlock==block100.get(9)){
                 for(int s=0; s<givenShipList.size(); s++){
                        hostileShipChase(givenShipList.get(0),100);

                        //hostileShipFollow(givenShipList.get(1),100);

                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        //friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);

                        friendlyShipsChaseInCircle(givenShipList.get(4),givenShipList.get(5),150,250,200,30,75);

                 }
        }
         
            if(trialInBlock==block100.get(10)||trialInBlock==block100.get(11)){
            
                for(int s=0; s<givenShipList.size(); s++){
                        friendlyShipWithTarget(givenShipList.get(0), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        //friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);

                        friendlyShipsChaseInCircle(givenShipList.get(4),givenShipList.get(5),150,250,200,30,75);

                 }
            }
        }
     }
     if(currentBlock==block75){
         if(trialInBlock==block75.get(0)||trialInBlock==block75.get(1)||trialInBlock==block75.get(2)||trialInBlock==block75.get(3)||trialInBlock==block75.get(4)){
                 for(int s=0; s<givenShipList.size(); s++){
                        //hostileShipChase(givenShipList.get(1),100);

                        hostileShipFollow(givenShipList.get(0),75);

                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        friendlyShipWithCirclePath(givenShipList.get(4),100,150,300,15,75);
                        friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);
                        //friendlyShipsChaseInCircle(givenShipList.get(1),givenShipList.get(1),150,250,200,30,75);

                 }
                 
         if(trialInBlock==block75.get(5)||trialInBlock==block75.get(6)||trialInBlock==block75.get(7)||trialInBlock==block75.get(8)||trialInBlock==block75.get(9)){
                 for(int s=0; s<givenShipList.size(); s++){
                        hostileShipChase(givenShipList.get(0),75);

                        //hostileShipFollow(givenShipList.get(1),100);

                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        //friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);

                        friendlyShipsChaseInCircle(givenShipList.get(4),givenShipList.get(5),150,250,200,30,75);

                 }
        }
         
         if(trialInBlock==block75.get(10)||trialInBlock==block75.get(11)){
            
                for(int s=0; s<givenShipList.size(); s++){
                        friendlyShipWithTarget(givenShipList.get(0), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        friendlyShipWithCirclePath(givenShipList.get(4),100,150,300,15,75);
                        friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);

                        //friendlyShipsChaseInCircle(givenShipList.get(4),givenShipList.get(5),150,250,200,30,75);

                 }
            }
        }
     }
     if(currentBlock==block50){
         if(trialInBlock==block50.get(0)||trialInBlock==block50.get(1)||trialInBlock==block50.get(2)||trialInBlock==block50.get(3)||trialInBlock==block50.get(4)){
                 for(int s=0; s<givenShipList.size(); s++){
                        //hostileShipChase(givenShipList.get(1),100);

                        hostileShipFollow(givenShipList.get(0),50);

                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        friendlyShipWithCirclePath(givenShipList.get(4),100,150,300,15,75);
                        friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);
                        //friendlyShipsChaseInCircle(givenShipList.get(1),givenShipList.get(1),150,250,200,30,75);

                 }
                 
         if(trialInBlock==block50.get(5)||trialInBlock==block50.get(6)||trialInBlock==block50.get(7)||trialInBlock==block50.get(8)||trialInBlock==block50.get(9)){
                 for(int s=0; s<givenShipList.size(); s++){
                        hostileShipChase(givenShipList.get(0),50);

                        //hostileShipFollow(givenShipList.get(1),100);

                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
                        //friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);

                        friendlyShipsChaseInCircle(givenShipList.get(4),givenShipList.get(5),150,250,200,30,75);

                 }
        }
         if(trialInBlock==block50.get(10)||trialInBlock==block50.get(11)){
            
                for(int s=0; s<givenShipList.size(); s++){
                        friendlyShipWithTarget(givenShipList.get(0), 579, 510,100);
                        friendlyShipWithTarget(givenShipList.get(1), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(2), 579, 510,75);
                        friendlyShipWithTarget(givenShipList.get(3), 579, 510,50);
//                        friendlyShipWithCirclePath(givenShipList.get(4),100,150,300,15,75);
//                        friendlyShipWithCirclePath(givenShipList.get(5),100,150,300,15,75);

                        friendlyShipsChaseInCircle(givenShipList.get(4),givenShipList.get(5),150,250,200,30,75);

                 }
            }
        }
    }
    }

    @FXML
    private void displayPosition(MouseEvent event) {
        status.setText("X = " + event.getX() + "    Y = "  + event.getY());
    }
    
    @FXML
    private void loadQuestion1(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas1.fxml"));
        rootPane.getChildren().setAll(pane);
    }


 
}


