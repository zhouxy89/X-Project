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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class QuestionCanvas1Controller implements Initializable {
    @FXML
    private AnchorPane question1Pane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void loadQuestion2(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("QuestionCanvas2.fxml"));
        question1Pane.getChildren().setAll(pane);
    }
}
