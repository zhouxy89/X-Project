/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class EndCanvasController implements Initializable {
    @FXML
    private AnchorPane EndCanvas;
    @FXML
    private Button Close;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void restartApp(){
        /* try{
                Runtime.getRuntime().exec("shuntdown -r -t 0");
            }catch (IOException e){
                e.printStackTrace();
        } */

        System.exit(0);
    }
    
}
