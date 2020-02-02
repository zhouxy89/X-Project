/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;


import static hunter_v1.pkg0.MainCanvasController.lastStepPracticX;
import static hunter_v1.pkg0.QuestionCanvas1Controller.pickFirstAnswerTime;
import static hunter_v1.pkg0.QuestionCanvas2Controller.practicAllY;
import static hunter_v1.pkg0.ResultCanvasController.practicPositionX;
import static hunter_v1.pkg0.ResultCanvasController.rightAnswerNum;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.Format.Field;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    private BorderPane pane;
    @FXML
    private BorderPane scrollCanvas;
    @FXML
    private AnchorPane scrollAnchor;
    @FXML
    private ScrollPane scroll;
    @FXML
    private CheckBox consent;
    @FXML
    private Text secondScreen1;
    @FXML
    private Text secondScreen2;
    @FXML
    private Text secondScreen3;
    @FXML
    private Text secondScreen4;
    @FXML
    private ImageView secondScreen5;
    @FXML
    private Text secondScreen6;
    @FXML
    private Text secondScreen7;
    
    
    
    
    @FXML
    private StackPane WelcomeCanvas;
    
    @FXML
    private ResultCanvasController resultController;
    
    @FXML
    private MainCanvasController mainController;
    
    @FXML
    private QuestionCanvas2Controller question2Controller;
    
    @FXML
    private QuestionCanvas1Controller question1Controller;
    
    @FXML
    private Text firstScreen;
    @FXML
    private Text welcomeText;
    
    @FXML
    private Button btnContinue;
    
    
    /**
     * Initializes the controller class.
     */
    
//    @FXML
//    public void init(){
//        mainController.init(this);
//            resultController.init(this);
//    }
    
    
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

        
              consent.setDisable(true);
              scrollCanvas.setVisible(false);
              scrollAnchor.setVisible(false);
              secondScreen1.setVisible(false);
              secondScreen2.setVisible(false);
              secondScreen3.setVisible(false);
              secondScreen4.setVisible(false);
              secondScreen5.setVisible(false);
              secondScreen6.setVisible(false);
              secondScreen7.setVisible(false);
              btnContinue.setVisible(false);
              
              
            Timer timer = new Timer();
            TimerTask showConsent;
            
            showConsent = new TimerTask()
            {
                public void run()
                {
                    consent.setDisable(false);
                }
            };
            
            timer.schedule(showConsent,45000);
              



    } 
    
    @FXML
    private void loadSecondScreen(ActionEvent event) throws IOException {
        if(consent.isSelected()){
              
              scrollCanvas.setVisible(true);
              scrollAnchor.setVisible(true);
              
              secondScreen1.setVisible(true);
              secondScreen2.setVisible(true);
              secondScreen3.setVisible(true);
              secondScreen4.setVisible(true);
              secondScreen5.setVisible(true);
              secondScreen6.setVisible(true);
              secondScreen7.setVisible(true);
              btnContinue.setVisible(true);
              scene.applyCss();
              scene.layout();
              scroll.setVvalue(0);
              firstScreen.setVisible(false);
              welcomeText.setVisible(false);
              consent.setVisible(false);
              
          }
    }
    
    @FXML
    private void loadGame(ActionEvent event) throws IOException {
        StackPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
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
    
    public String realFollowerActionFromMainCanvas(){
        return mainController.hunterActive;
    }
    
    public void setrealFollowerActionFromMainCanvas(String SP) {
        resultController.huntingActive = SP;
        
    }
    
    public int followerAnswerFromQuestion2Canvas(){
        return question2Controller.followedShipAnswer;
    }
    
    public void setfollowerAnswerFromQuestion2Canvas(int SP) {
        resultController.followerAnswer = SP;
        question2Controller.followedShipAnswer = 0;
        resultController.firstAnswer = question1Controller.answer1;
    }
    
//    public int lastPositionXFromMainCanvas(){
//        return mainController.lastStepX;
//    }
    
    public void setlastPositionFromMainCanvas() {
        question1Controller.practiclastX = mainController.lastStepPracticX;
        question1Controller.practiclastY = mainController.lastStepPracticY;
        question2Controller.practicAllX = mainController.lastStepPracticX;
        question2Controller.practicAllY = mainController.lastStepPracticY;
        resultController.practicPositionX = mainController.lastStepPracticX;
        resultController.practicPositionY = mainController.lastStepPracticY;
        
        question1Controller.lastX = mainController.lastStepX;
        question1Controller.lastY = mainController.lastStepY;
        question2Controller.allX = mainController.lastStepX;
        question2Controller.allY = mainController.lastStepY;
        resultController.positionX = mainController.lastStepX;
        resultController.positionY = mainController.lastStepY;
        
    }
    
    public void setEndGameTimeFromMainCanvas(){
        resultController.endGameTime = mainController.endTime;
        resultController.firstAnswer = question1Controller.answer1;
        resultController.firstAnswerPickTime = question1Controller.pickFirstAnswerTime;
        resultController.secondAnswerPickTime = question2Controller.pickSecondAnswerTime;
        resultController.gameStartTime = mainController.startGameTime;
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
    
    
    public int rightGuessFromResult(){
     
        return resultController.rightAnswerNum;
    }
    
    public void setrightGuessFromResultCanvas(int Number) {
        mainController.rightGuess = Number;
        
    }
    
    
}
