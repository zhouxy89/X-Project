/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.Format.Field;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class WelcomeCanvasController implements Initializable {
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
    private AnchorPane welcomeCanvas;
    
    @FXML
    ResultCanvasController resultController;
    
    @FXML
    MainCanvasController mainController;
    
    
    
    @FXML
    private Text welcomeText;
    
    @FXML
    private Button btnContinue;
    /**
     * Initializes the controller class.
     */
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        setFileNameFromResultCanvas(fileNameFromResultCanvas());
//        mainController.file = new File(mainController.filePath);
    } 
    
    @FXML
    private void loadGame(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        welcomeCanvas.getChildren().setAll(pane);
    }
    
    public int trialFromMain(){
        return mainController.trialNum;
    }
    
    public int trialFromResult(){
        return resultController.trial;
    }
    
    public void setTrialFromResultCanvas(int trialNumber) {
        mainController.trialNum = trialNumber;
        
    }
    
    public void setTrialFromMainCanvas(int trialNumber) {
        resultController.trial = trialNumber;
        
    }
    
    public int fileNameFromResultCanvas(){
        return resultController.dateNum;
    }
    
    public int fileNameFromMainCanvas(){
        return mainController.dateTime;
    }
    
   
    public void setFileNameFromMainCanvas(int date) {
        resultController.dateNum = date;
        
    }
    
    public void setFileNameFromResultCanvas(int date) {
        mainController.dateTime = date;
        
    }
}
