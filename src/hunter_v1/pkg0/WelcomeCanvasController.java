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
    private AnchorPane WelcomeCanvas;
    
    @FXML
    private ResultCanvasController resultController;
    
    @FXML
    private MainCanvasController mainController;
    
    @FXML
    private QuestionCanvas2Controller question2Controller;
    
    
    
    @FXML
    private Text welcomeText;
    
    @FXML
    private Button btnContinue;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void init(){
        mainController.init(this);
            resultController.init(this);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        setFileNameFromResultCanvas(fileNameFromResultCanvas());
//        mainController.file = new File(mainController.filePath);

    //FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultCanvas.fxml"));
//        try {
//            Parent root = (Parent)loader.load();
//        } catch (IOException ex) {
//            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ResultCanvasController resultController = loader.getController();
//        
//        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("MainCanvas.fxml"));
//        try {
//            Parent root = (Parent)loader1.load();
//        } catch (IOException ex) {
//            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        MainCanvasController mainController = loader1.getController();
            
          
    } 
    
    @FXML
    private void loadGame(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        WelcomeCanvas.getChildren().setAll(pane);
    }
    
    public void injectMainController(MainCanvasController mainController){
        this.mainController = mainController;
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
    
    public int realFollowerFromMainCanvas(){
        return mainController.followShip;
    }
    
    public void setrealFollowerFromMainCanvas(int SP) {
        resultController.realFollower = SP;
        
    }
    
    public int followerAnswerFromQuestion2Canvas(){
        return question2Controller.followedShipAnswer;
    }
    
    public void setfollowerAnswerFromQuestion2Canvas(int SP) {
        resultController.followerAnswer = SP;
        question2Controller.followedShipAnswer = 0;
    }
    
    
    public List blockListAfterShuffleFromMainCanvas(){
        
        
        return mainController.blockListAfterShuffle;
    }
    
 
    public void setblockListFromMainCanvas(List BLFromMain) {
        resultController.block50_result = mainController.block50;
        resultController.block75_result = mainController.block75;
        resultController.block100_result = mainController.block100;
        resultController.blockListAfterShuffle_result = BLFromMain;
        
    }
    @FXML
    public List blockListAfterShuffleFromResultCanvas(){
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("ResultCanvas.fxml"));
       
        try {
            Pane Pane2 = (Pane)loader1.load();
        } catch (IOException ex) {
            Logger.getLogger(WelcomeCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultCanvasController resultController = loader1.getController();

        
        return resultController.blockListAfterShuffle_result;
    }

    
    public void setblockListFromResultCanvas(List BLFromResult){
 
            mainController.block50 = resultController.block50_result;
            mainController.block75 = resultController.block75_result;
            mainController.block100 = resultController.block100_result;
          mainController.blockListAfterShuffle = BLFromResult;
        
    }
}
