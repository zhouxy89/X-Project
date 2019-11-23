/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author zhouxiaoyan
 */
public class Hunter_v10 extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("MainCanvas.fxml"));
        //MainCanvasController controller = new MainCanvasController();
        //Parent root = loader.load();
        Parent root = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
       //loader.setController(controller);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
//        @Override
    
//public void stop() throws Exception {
//        super.stop();
//        System.exit(1);
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
