/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import static hunter_v1.pkg0.QuestionCanvas1Controller.lastX;
import static hunter_v1.pkg0.QuestionCanvas1Controller.lastY;
import static hunter_v1.pkg0.QuestionCanvas1Controller.pickFirstAnswerTime;
import static hunter_v1.pkg0.QuestionCanvas1Controller.practiclastX;
import static hunter_v1.pkg0.QuestionCanvas1Controller.practiclastY;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class QuestionCanvas2Controller implements Initializable {

    @FXML
    private Pane scene3;
    @FXML
    private RadioButton ship1;
    @FXML
    private RadioButton ship2;
    @FXML
    private RadioButton ship3;
    @FXML
    private RadioButton ship4;
    @FXML
    private RadioButton ship5;
    @FXML
    private RadioButton ship6;
    
    @FXML
    private Button Q2Ship1;
    @FXML
    private Button Q2Ship2;
    @FXML
    private Button Q2Ship3;
    @FXML
    private Button Q2Ship4;
    @FXML
    private Button Q2Ship5;
    @FXML
    private Button Q2Ship6;
    @FXML
    private Button Q2MyShip;
    
    
    @FXML
    private AnchorPane question2Pane;
    
    public static int followedShipAnswer;
    
    public static List<Integer> allX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> allY = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> practicAllX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> practicAllY = Arrays.asList(1,2,3,4,5,6,7);
    
    public static String pickSecondAnswerTime = "";
    
    
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

            Q2Ship1.relocate(allX.get(0),allY.get(0));
            Q2Ship2.relocate(allX.get(1),allY.get(1));
            Q2Ship3.relocate(allX.get(2),allY.get(2));
            Q2Ship4.relocate(allX.get(3),allY.get(3));
            Q2Ship5.relocate(allX.get(4),allY.get(4));
            Q2Ship6.relocate(allX.get(5),allY.get(5));
            Q2MyShip.relocate(allX.get(6),allY.get(6));
        }
        else{
            Q2Ship1.relocate(practicAllX.get(0),practicAllY.get(0));
            Q2Ship2.relocate(practicAllX.get(1),practicAllY.get(1));
            Q2Ship3.relocate(practicAllX.get(2),practicAllY.get(2));
            Q2Ship4.relocate(practicAllX.get(3),practicAllY.get(3));
            Q2Ship5.relocate(practicAllX.get(4),practicAllY.get(4));
            Q2Ship6.relocate(practicAllX.get(5),practicAllY.get(5));
            Q2MyShip.relocate(practicAllX.get(6),practicAllY.get(6));
        }
        
    }    

    @FXML
    private void loadResult(ActionEvent event) throws IOException {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        pickSecondAnswerTime = time.format(formatter);
            
            
        if(ship1.isSelected()){
            followedShipAnswer = 1;
        }
        if(ship2.isSelected()){
            followedShipAnswer = 2;
        }
        if(ship3.isSelected()){
            followedShipAnswer = 3;
        }
        if(ship4.isSelected()){
            followedShipAnswer = 4;
        }
        if(ship5.isSelected()){
            followedShipAnswer = 5;
        }
        if(ship6.isSelected()){
            followedShipAnswer = 6;
        }
        //System.out.println("followedShipAnswer: "+followedShipAnswer);
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultCanvas.fxml"));
        question2Pane.getChildren().setAll(pane);
    }
 
}
