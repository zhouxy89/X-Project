/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class ResultCanvasController implements Initializable {

    @FXML
    private AnchorPane resultPane;
    @FXML
    private Pane scene;
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
    private Button btnShip6;
    
    
    public static int trial=0;
    int totalTrial = 38;
    static Date DT = new Date();
    public static int dateNum = (int)(DT.getTime()/1000);
    //public static int dateNum=1;
    /**
     * Initializes the controller class.
     */

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        welcomeController.setTrialFromMainCanvas(welcomeController.trialFromMain());
        
        welcomeController.setFileNameFromMainCanvas(welcomeController.fileNameFromMainCanvas());
    }   
    
    
    @FXML
    private void loadMain(ActionEvent event) throws IOException {
        if(trial<totalTrial){
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        System.out.println("trial2: "+trial);
        resultPane.getChildren().setAll(pane);
        }
        else{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EndCanvas.fxml"));
        resultPane.getChildren().setAll(pane);    
        }
        
    }

}
