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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void loadMain(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        resultPane.getChildren().setAll(pane);
    }
}
