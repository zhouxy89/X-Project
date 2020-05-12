/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import static hunter_v1.pkg0.MainCanvasController.endTime;
import static hunter_v1.pkg0.MainCanvasController.lastStepX;
import static hunter_v1.pkg0.MainCanvasController.lastStepY;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class QuestionCanvas1Controller implements Initializable {
    @FXML
    private AnchorPane question1Pane;
    @FXML
    private RadioButton rdBtnYes;
    @FXML
    private RadioButton rdBtnNo;
    
    @FXML
    private Pane scene2;
    
    @FXML
    private Button Q1Ship1;
    @FXML
    private Button Q1Ship2;
    @FXML
    private Button Q1Ship3;
    @FXML
    private Button Q1Ship4;
    @FXML
    private Button Q1Ship5;
    @FXML
    private Button Q1Ship6;
    @FXML
    private Button Q1MyShip;
    
    @FXML
    private RadioButton shadowed;
    
    @FXML
    private RadioButton hunted;
    
    @FXML
    private RadioButton neither;
    
    
    
    @FXML
    private AnchorPane MainCanvas;
    
    public boolean beFollowedAnswer = false;
    
    
    
    public static List<Integer> lastX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> lastY = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> practiclastX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> practiclastY = Arrays.asList(1,2,3,4,5,6,7);
    
    public static String answer1 = "";
    public static String pickFirstAnswerTime = "";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        welcomeController.setlastPositionFromMainCanvas();
        
        //show the last position of each ship
        if(welcomeController.trialFromMain()>=3){

            Q1Ship1.relocate(lastX.get(0),lastY.get(0));
            Q1Ship2.relocate(lastX.get(1),lastY.get(1));
            Q1Ship3.relocate(lastX.get(2),lastY.get(2));
            Q1Ship4.relocate(lastX.get(3),lastY.get(3));
            Q1Ship5.relocate(lastX.get(4),lastY.get(4));
            Q1Ship6.relocate(lastX.get(5),lastY.get(5));
            Q1MyShip.relocate(lastX.get(6),lastY.get(6));
            
        }
        else{
            
            Q1Ship1.relocate(practiclastX.get(0),practiclastY.get(0));
            Q1Ship2.relocate(practiclastX.get(1),practiclastY.get(1));
            Q1Ship3.relocate(practiclastX.get(2),practiclastY.get(2));
            Q1Ship4.relocate(practiclastX.get(3),practiclastY.get(3));
            Q1Ship5.relocate(practiclastX.get(4),practiclastY.get(4));
            Q1Ship6.relocate(practiclastX.get(5),practiclastY.get(5));
            Q1MyShip.relocate(practiclastX.get(6),practiclastY.get(6));
            
        }
        
    }    
    
    
    @FXML
    private void loadQuestion2(ActionEvent event) throws IOException {
        
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            pickFirstAnswerTime = time.format(formatter);
        
            if(shadowed.isSelected()){
                answer1 = "shadowed";
            }
            else if(hunted.isSelected()){
                answer1 = "hunted";
            }
        
            beFollowedAnswer = true;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas2.fxml"));
            question1Pane.getChildren().setAll(pane);
        
       
    }
    
    @FXML
    private void loadResult(ActionEvent event) throws IOException {
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            pickFirstAnswerTime = time.format(formatter);
            
            if(neither.isSelected()){
                answer1 = "neither";
            }
            
            beFollowedAnswer = false;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultCanvas.fxml"));
            question1Pane.getChildren().setAll(pane);
        
    }
    
}
