/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

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
    private RadioButton rdBtnNo;
    
    public boolean beFollowedAnswer = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void loadQuestion2(ActionEvent event) throws IOException {
        
            beFollowedAnswer = true;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas2.fxml"));
            question1Pane.getChildren().setAll(pane);
        
       
    }
    
    @FXML
    private void loadResult(ActionEvent event) throws IOException {
        
            beFollowedAnswer = false;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultCanvas.fxml"));
            question1Pane.getChildren().setAll(pane);
        
    }
}
