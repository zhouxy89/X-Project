/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
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
    private Button btnMyShip;
    @FXML
    private Text status;
    @FXML
    private Text timeup;
    
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
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }
            
     
    

    @FXML
    private void friendlyShipWithTarget(Button friendlyShip,int towardTargetX, int towardTargetY,int matchPercentage){
        
            ShipX= (int)friendlyShip.getLayoutX();
            ShipY= (int)friendlyShip.getLayoutY();
            shipWidth = (int)friendlyShip.getPrefWidth();
            shipHeight = (int)friendlyShip.getPrefHeight();
            
            moveX=Math.round((towardTargetX-ShipX)/(totalSteps-step));
            moveY=Math.round((towardTargetY-ShipY)/(totalSteps-step));
            
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
            
            if(canvasHeight<ShipY+shipHeight/2+randomMoveY){
                randomMoveY=0;
            }
            
//            System.out.println((ShipX+shipWidth/2+randomMoveX) +","+(ShipY+shipHeight/2+randomMoveY));
//            System.out.println((ShipX-shipWidth/2+randomMoveX) +","+(ShipY-shipHeight/2+randomMoveY));
//            System.out.println((ShipX+shipWidth/2+randomMoveX) +","+(ShipY-shipHeight/2+randomMoveY));
//            System.out.println((ShipX-shipWidth/2+randomMoveX) +","+(ShipY+shipHeight/2+randomMoveY));
//            System.out.println(canvas[ShipX+shipWidth/2+randomMoveX][ShipY+shipHeight/2+randomMoveY]);
//            System.out.println(canvas[ShipX-shipWidth/2+randomMoveX][ShipY-shipHeight/2+randomMoveY]);
//            System.out.println(canvas[ShipX+shipWidth/2+randomMoveX][ShipY-shipHeight/2+randomMoveY]);
//            System.out.println(canvas[ShipX-shipWidth/2+randomMoveX][ShipY+shipHeight/2+randomMoveY]);
            
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
            
            setShipsOnCanvas(friendlyShip);
            
         
    }
    
    @FXML
    
    private void friendlyShipWithCirclePath(Button friendlyShip, int r, int x, int y, int steps,int matchPercentage ){
        int friednlyShipX = (int)friendlyShip.getLayoutX();
        int friednlyShipY = (int)friendlyShip.getLayoutY();
        
        double radians = (Math.PI/180) * Math.round(360/steps);
        if(circleStep<steps) {  
        circleStep+=1;
        }
        else{
        circleStep=0;
        circleStep+=1;
        }
        
        int X = (int) (x + r * Math.sin(radians * circleStep));
        int Y = (int) (y + r * Math.cos(radians * circleStep));
        System.out.println("ship4: "+canvas[X][Y]);
        System.out.println("ship4X: "+X);
        System.out.println("ship4Y: "+Y);
        
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
        setShipsOnCanvas(friendlyShip);    
        //System.out.println(X+","+Y);
      
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
        
   
        X1 = (int) (x + r * Math.sin(radians * circleStep));
        Y1 = (int) (y + r * Math.cos(radians * circleStep));


        X2 = (int) (x + r * (Math.sin(radians * (circleStep+steps/2))));
        Y2 = (int) (y + r * (Math.cos(radians * (circleStep+steps/2))));

        
        switch (matchPercentage) {
            
                case 100:
                    if(canvas[X1][Y1+shipHeight/2]!=1 && canvas[X1][Y1-shipHeight/2]!=1 && canvas[X1-shipWidth/2][Y1]!=1 && canvas[X1+shipWidth/2][Y1]!=1){
                        friendlyShip1.relocate(X1,Y1);
                        
                    }
                    else{
                        friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);
                        
                    }
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
                            if(canvas[X1][Y1+shipHeight/2]!=1 && canvas[X1][Y1-shipHeight/2]!=1 && canvas[X1-shipWidth/2][Y1]!=1 && canvas[X1+shipWidth/2][Y1]!=1){
                                friendlyShip1.relocate(friednlyShipX1 +givenList_shouldReturnARandomElement(), friednlyShipY1 +givenList_shouldReturnARandomElement());
                            }
                            else{
                                friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);
                            }
                            
                            if(canvas[X2][Y2+shipHeight/2]!=1 && canvas[X2][Y2-shipHeight/2]!=1 && canvas[X2-shipWidth/2][Y2]!=1 && canvas[X2+shipWidth/2][Y2]!=1){
                            friendlyShip2.relocate(friednlyShipX2 +givenList_shouldReturnARandomElement(), friednlyShipY2 +givenList_shouldReturnARandomElement());
                            }
                            else{
                                friendlyShip2.relocate(friednlyShipX2,friednlyShipY2);
                            }
                            break;
                
                        default:
                            if(canvas[X1][Y1+shipHeight/2]!=1 && canvas[X1][Y1-shipHeight/2]!=1 && canvas[X1-shipWidth/2][Y1]!=1 && canvas[X1+shipWidth/2][Y1]!=1){
                                friendlyShip1.relocate(X1,Y1);
//                                System.out.println("1up: "+canvas[X1+shipWidth/2][Y1]);
//                                System.out.println("1down: "+canvas[X1-shipWidth/2][Y1]);
//                                System.out.println("1right: "+canvas[X1][Y1+shipHeight/2]);
//                                System.out.println("1left: "+canvas[X1][Y1-shipHeight/2]);
//                                
                            }
                            else{
                                friendlyShip1.relocate(friednlyShipX1,friednlyShipY1);

                            }
                            if(canvas[X2][Y2+shipHeight/2]!=1 && canvas[X2][Y2-shipHeight/2]!=1 && canvas[X2-shipWidth/2][Y2]!=1 && canvas[X2+shipWidth/2][Y2]!=1){
                                friendlyShip2.relocate(X2,Y2);
                                System.out.println("2up: "+canvas[X1+shipWidth/2][Y1]);
                                System.out.println("2down: "+canvas[X1-shipWidth/2][Y1]);
                                System.out.println("2right: "+canvas[X1][Y1+shipHeight/2]);
                                System.out.println("2left: "+canvas[X1][Y1-shipHeight/2]);
                            }
                            else{
                                friendlyShip2.relocate(friednlyShipX2,friednlyShipY2);
                            }
                               
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
        
        setShipsOnCanvas(friendlyShip1);
        setShipsOnCanvas(friendlyShip2);
        
    }
    
    
    
    @FXML
    
    private void hostileShipFollow(Button hostileShip, int matchPercentage){
        
        
        hostileShipX = (int)hostileShip.getLayoutX();
        hostileShipY = (int)hostileShip.getLayoutY();
        shipWidth = (int)hostileShip.getPrefWidth();
        shipHeight = (int)hostileShip.getPrefHeight();
        
        int X = hostileShipX;
        int Y = hostileShipY;
        
        
        setShipsOnCanvas(btnShip1);
        setShipsOnCanvas(btnShip2);
        setShipsOnCanvas(btnShip3);
        setShipsOnCanvas(btnShip5);
        
        
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
        clearShipsOnCanvas();
        setShipsOnCanvas(hostileShip);
    }
    
    @FXML
    private void hostileShipChase(Button hostileShip,int matchPercentage){
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
            
            if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
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


                    if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
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


                    if(distanceFromCurrentPoint<MyShipWidth/2+shipWidth/2+KEYBOARD_MOVEMENT_DELTA||canvas[hostileShipX+shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY+shipHeight/2]==1||canvas[hostileShipX+shipWidth/2][hostileShipY-shipHeight/2]==1||canvas[hostileShipX-shipWidth/2][hostileShipY-shipHeight/2]==1){
                        hostileShip.relocate(hostileShipX,hostileShipY);
                    }
                    else{
                        hostileShip.relocate(X,Y);
                    }
                    break;
                }
            break;
            
          
            
        }    
            setShipsOnCanvas(hostileShip);
            
            
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
        
        setShipsOnCanvas(hostileShip1);
        setShipsOnCanvas(hostileShip2);
    }
    
    @FXML
    private void moveMyshipOnKeyPress(KeyEvent event){
            MyShipY = (int)btnMyShip.getLayoutY();
            MyShipX = (int)btnMyShip.getLayoutX();
            MyShipWidth=(int)btnMyShip.getPrefWidth();
            MyShipHeight=(int)btnMyShip.getPrefHeight();
            
            step+=1;
            System.out.println(step);
            
            canvasWidth= (int)scene.getPrefWidth();
            canvasHeight= (int)scene.getPrefHeight();
            canvas =new int[canvasWidth][canvasHeight];
            clearShipsOnCanvas();
            
            
            setShipsOnCanvas(btnShip1);
            setShipsOnCanvas(btnShip2);
            setShipsOnCanvas(btnShip3);
            setShipsOnCanvas(btnShip4);
            setShipsOnCanvas(btnShip5);
            
            Timer timer = new Timer();
            TimerTask getKeyEvent = new TimerTask()
            {
                public void run()
                {
                    
                    if(step<=totalSteps){
                    switch (event.getCode()) {
                      case UP: 
                          moveDirect=1;
                          if(btnMyShip.getLayoutY()>15){
                              if(canvas[(int)MyShipX][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA-MyShipHeight/2]!=1&&canvas[(int)MyShipX+MyShipWidth/2][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA]!=1&&canvas[(int)MyShipX-MyShipWidth/2][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA]!=1){
                                  
                                System.out.println(canvas[(int)MyShipX][(int)MyShipY- KEYBOARD_MOVEMENT_DELTA-MyShipHeight/2]);
                                System.out.println(MyShipX);
                                System.out.println(MyShipY- KEYBOARD_MOVEMENT_DELTA);
                                btnMyShip.setLayoutY(btnMyShip.getLayoutY() - KEYBOARD_MOVEMENT_DELTA);
                          
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
                                System.out.println(canvas[(int)MyShipX+ KEYBOARD_MOVEMENT_DELTA+MyShipWidth/2][(int)MyShipY]);
                                System.out.println(MyShipX+ KEYBOARD_MOVEMENT_DELTA);
                                System.out.println(MyShipY);
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
                                  System.out.println(canvas[(int)MyShipX][(int)MyShipY+ KEYBOARD_MOVEMENT_DELTA+MyShipHeight/2]);
                                  System.out.println(MyShipX);
                                  System.out.println(MyShipY+ KEYBOARD_MOVEMENT_DELTA);  
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
                                  System.out.println(canvas[(int)MyShipX- KEYBOARD_MOVEMENT_DELTA-MyShipWidth/2][(int)MyShipY]);
                                  System.out.println(MyShipX-KEYBOARD_MOVEMENT_DELTA);
                                  System.out.println(MyShipY);  
                                  btnMyShip.setLayoutX(btnMyShip.getLayoutX() - KEYBOARD_MOVEMENT_DELTA); 
                                }
                          }
                          else{
                          btnMyShip.setLayoutX(btnMyShip.getLayoutX());    
                          }
                          break;
                        }
                    
                                System.out.println("myup: "+canvas[(int)btnMyShip.getLayoutX()+shipWidth/2][(int)btnMyShip.getLayoutY()]);
                                System.out.println("mydown: "+canvas[(int)btnMyShip.getLayoutX()-shipWidth/2][(int)btnMyShip.getLayoutY()]);
                                System.out.println("myright: "+canvas[(int)btnMyShip.getLayoutX()][(int)btnMyShip.getLayoutY()+shipHeight/2]);
                                System.out.println("myleft: "+canvas[(int)btnMyShip.getLayoutX()][(int)btnMyShip.getLayoutY()-shipHeight/2]);    
            setShipsOnCanvas(btnMyShip);
            
           
            hostileShipFollow(btnShip5,75);
            //friendlyShipWithTarget(btnShip1, 370, 240,75);
            friendlyShipWithTarget(btnShip2, 579, 510,50);
            hostileShipChase(btnShip3,100);
            //friendlyShipWithCirclePath(btnShip4,100,150,300,15,75);
            friendlyShipsChaseInCircle(btnShip1,btnShip4,150,250,200,30,75);
            
            }
            else{
                timeup.setText("Time's up");
            };
            }
                    
            };
            
            timer.schedule(getKeyEvent,500);
        
            

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
    
    
    
    public void setShipsOnCanvas(Button Ship){
        ShipX= (int)Ship.getLayoutX();
        ShipY= (int)Ship.getLayoutY();
        shipWidth = (int)Ship.getPrefWidth();
        shipHeight = (int)Ship.getPrefHeight();
        
        for (int x = ShipX-(shipWidth/2); x <= ShipX+(shipWidth/2); x++) {
                for (int y = ShipY-(shipHeight/2); y <= ShipY+(shipHeight/2); y++) {
                    canvas[x][y]=1;
//                    System.out.println(x+","+y);
                }
            }
    }
    
    
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
    private void displayPosition(MouseEvent event) {
        status.setText("X = " + event.getX() + "    Y = "  + event.getY());
    }
    
    @FXML
    private void loadQuestion1(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas1.fxml"));
        rootPane.getChildren().setAll(pane);
    }
 
}


