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
import javafx.scene.control.CheckBox;
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
    private Pane scene;
    @FXML
    private CheckBox ship1;
    @FXML
    private CheckBox ship2;
    @FXML
    private CheckBox ship3;
    @FXML
    private CheckBox ship4;
    @FXML
    private CheckBox ship5;
    @FXML
    private CheckBox ship6;
    
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
    private AnchorPane question2Pane;
    
    public static int followedShipAnswer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void loadResult(ActionEvent event) throws IOException {
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
        System.out.println("followedShipAnswer: "+followedShipAnswer);
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultCanvas.fxml"));
        question2Pane.getChildren().setAll(pane);
    }

    

    
    
}
