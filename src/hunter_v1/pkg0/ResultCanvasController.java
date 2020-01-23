/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter_v1.pkg0;

import static hunter_v1.pkg0.MainCanvasController.filepath;
import static hunter_v1.pkg0.MainCanvasController.trialNum;
import static hunter_v1.pkg0.QuestionCanvas1Controller.lastX;
import static hunter_v1.pkg0.QuestionCanvas1Controller.lastY;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zhouxiaoyan
 */
public class ResultCanvasController implements Initializable {

    @FXML
    private AnchorPane ResultCanvas;
    @FXML
    private Pane sceneResult;
    @FXML
    private TextField rightAnswer;
    @FXML
    private TextField rightAnswerLabel;
    @FXML
    private TextField yourAnswer;
    @FXML
    private TextField yourAnswerLabel;
    @FXML
    private TextField result;
    @FXML
    private TextField resultLabel;
    @FXML
    private TextField score;
    @FXML
    private TextField totalTrialsLabel;
    @FXML
    private TextField scoreLabel;
//    @FXML
//    MainCanvasController mainController;
//    @FXML
//    QuestionCanvas2Controller question2Controller;
    @FXML
    private Button resultShip1;
    @FXML
    private Button resultShip2;
    @FXML
    private Button resultShip3;
    @FXML
    private Button resultShip4;
    @FXML
    private Button resultShip5;
    @FXML
    private Button resultShip6;
    @FXML
    private Button resultMyShip;
    
    @FXML
    private MainCanvasController mainController;
    
    public static int trial=0;
    int totalTrial = 32;
    public static Date DT = new Date();
    public static int dateNum = (int)(DT.getTime()/1000);
    public static int realFollower= 0;
    public static int followerAnswer= 0;
    public static int rightAnswerNum= 0;
    
    public String showRightAnswer = "";
    public String showYourAnswer = "";
    
    public static List<Integer> block50_result=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    public static List<Integer> block75_result=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    public static List<Integer> block100_result=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    public static List<Integer> positionX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> positionY = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> practicPositionX = Arrays.asList(1,2,3,4,5,6,7);
    public static List<Integer> practicPositionY = Arrays.asList(1,2,3,4,5,6,7);
    
    public static String endGameTime = "";
    
    public static String firstAnswer = "";
    
    public static String firstAnswerPickTime = "";
    
    public static String secondAnswerPickTime = "";
    
    public static String gameStartTime = "";
    /**
     *
     */
    @FXML public static List<List> blockListAfterShuffle_result = Arrays.asList(block50_result,block75_result,block100_result);
    
    //public List<Integer> blockListAfterShuffle_result = Arrays.asList(1,2,3);
    //public static int blockListAfterShuffle_num = 123;
    
    FileWriter resultWriter= null;
    PrintWriter resultPrint = null;
    String resultRecord="";
   
    //public static int dateNum=1;
    /**
     * Initializes the controller class.
     */

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println("dateNum: "+dateNum);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        welcomeController.setTrialFromMainCanvas(welcomeController.trialFromMain());
        
        welcomeController.setFileNameFromMainCanvas(welcomeController.fileNameFromMainCanvas());
        
        welcomeController.setrealFollowerFromMainCanvas(welcomeController.realFollowerFromMainCanvas());
        
        welcomeController.setfollowerAnswerFromQuestion2Canvas(welcomeController.followerAnswerFromQuestion2Canvas());
        if(welcomeController.trialFromMain()==1&&mainController.noChange==0){
        Collections.shuffle(block50_result);
        Collections.shuffle(block75_result);
        Collections.shuffle(block100_result);
        
        Collections.shuffle(blockListAfterShuffle_result);
        }
        showRightAnswer = "1";
        showYourAnswer = "2";
        if(realFollower==0){
            showRightAnswer = "None";
            }
        if(realFollower==1){
            showRightAnswer = "Ship1";
            }
        if(realFollower==2){
            showRightAnswer = "Ship2";
        }
        if(realFollower==3){
            showRightAnswer = "Ship3";
        }
        if(realFollower==4){
            showRightAnswer = "Ship4";
        }
        if(realFollower==5){
            showRightAnswer = "Ship5";
        }
        if(realFollower==6){
            showRightAnswer = "Ship6";
        }
        
        if(followerAnswer==0){
            showYourAnswer = "None";
            }
        if(followerAnswer==1){
            showYourAnswer = "Ship1";
            }
        if(followerAnswer==2){
            showYourAnswer = "Ship2";
        }
        if(followerAnswer==3){
            showYourAnswer = "Ship3";
        }
        if(followerAnswer==4){
            showYourAnswer = "Ship4";
        }
        if(followerAnswer==5){
            showYourAnswer = "Ship5";
        }
        if(followerAnswer==6){
            showYourAnswer = "Ship6";
        }
        
        System.out.println("rightAnswerNum: "+rightAnswerNum);
        if(trial<3){ 
            resultLabel.setVisible(false); 
            score.setVisible(false); 
            totalTrialsLabel.setVisible(false); 
            scoreLabel.setVisible(false); 
            setText();
        }
        else{
           rightAnswer.setVisible(false); 
           rightAnswerLabel.setVisible(false); 
           yourAnswer.setVisible(false); 
           yourAnswerLabel.setVisible(false); 
           
           if(welcomeController.trialFromMain()==3&&mainController.count==0){ 
               showRightAnswer = "Ship5";
               showYourAnswer = "Ship6";
           }
           
           // System.out.println("mainController.noChange: "+mainController.noChange);
           //System.out.println("rightAnswer: "+showRightAnswer);
           //System.out.println("yourAnswer: "+showYourAnswer);
           //System.out.println("rightGuessFromMain: "+welcomeController.rightGuessFromMain());
          // welcomeController.setrightGuessFromMainCanvas(welcomeController.rightGuessFromMain());
           if(showRightAnswer==showYourAnswer){
               result.setText("Right");
               
               rightAnswerNum+=1;
               score.setText(Integer.toString(rightAnswerNum));
           
               //System.out.println("rightAnswerNum: "+rightAnswerNum);
           }
           else{
               result.setText("Wrong");
               score.setText(Integer.toString(rightAnswerNum));
           }
           
        }
        
        
        System.out.println("block100_result: "+block100_result);
        System.out.println("block75_result: "+block75_result);
        System.out.println("block50_result: "+block50_result);
        System.out.println("blockListAfterShuffle_result: "+blockListAfterShuffle_result);
        
        System.out.println("filePath: "+mainController.filepath);
        
        if(welcomeController.trialFromMain()>=3){
            
            resultShip1.relocate(positionX.get(0),positionY.get(0));
            resultShip2.relocate(positionX.get(1),positionY.get(1));
            resultShip3.relocate(positionX.get(2),positionY.get(2));
            resultShip4.relocate(positionX.get(3),positionY.get(3));
            resultShip5.relocate(positionX.get(4),positionY.get(4));
            resultShip6.relocate(positionX.get(5),positionY.get(5));
            resultMyShip.relocate(positionX.get(6),positionY.get(6));
        }
        else{
            resultShip1.relocate(practicPositionX.get(0),practicPositionY.get(0));
            resultShip2.relocate(practicPositionX.get(1),practicPositionY.get(1));
            resultShip3.relocate(practicPositionX.get(2),practicPositionY.get(2));
            resultShip4.relocate(practicPositionX.get(3),practicPositionY.get(3));
            resultShip5.relocate(practicPositionX.get(4),practicPositionY.get(4));
            resultShip6.relocate(practicPositionX.get(5),practicPositionY.get(5));
            resultMyShip.relocate(practicPositionX.get(6),practicPositionY.get(6));
        }
    }   
    @FXML
    private void setText(){
 
        System.out.println("real followShip: "+realFollower);
        System.out.println("real followedShipAnswer: "+followerAnswer);
        
        rightAnswer.setText(showRightAnswer);
        
        

        
        yourAnswer.setText(showYourAnswer);
        
        
    }
    
    @FXML
    public void randomBlock(){

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ResultCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        WelcomeCanvasController welcomeController = loader.getController();
       
        welcomeController.setblockListFromMainCanvas(welcomeController.blockListAfterShuffleFromMainCanvas());
        
        //blockListAfterShuffle_result=welcomeController.blockListAfterShuffleFromMainCanvas();
//        
    }
    
    @FXML
    public void recordResults(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        if(welcomeController.trialFromMain()>=3&&mainController.count>5){
        try {
            resultWriter = new FileWriter(mainController.filepath, true);
        } catch (IOException ex) {
            Logger.getLogger(ResultCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedWriter data = new BufferedWriter(resultWriter);
        resultPrint = new PrintWriter(data);
        
        if(showYourAnswer=="None"){
           secondAnswerPickTime = " "; 
        }
        resultRecord = MainCanvasController.PID+","+(trial-2) +" "+","+" "+","+ " "+","+" "+","+" "+","+ " "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+ " "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+" "+","+gameStartTime+","+endGameTime+","+firstAnswer+","+firstAnswerPickTime+","+showYourAnswer+","+secondAnswerPickTime+","+showRightAnswer;
        
        
        resultPrint.println(resultRecord);
        resultPrint.flush();
        resultPrint.close();
        }
    }
//    
    @FXML
    private void loadMain(ActionEvent event) throws IOException {
        randomBlock();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCanvas.fxml"));
        try {
            Parent root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainCanvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WelcomeCanvasController welcomeController = loader.getController();
        
        welcomeController.setEndGameTimeFromMainCanvas();
        recordResults();
        if(trial<totalTrial){
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainCanvas.fxml"));
        //System.out.println("trial2: "+trial);
        ResultCanvas.getChildren().setAll(pane);
        }
        else{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EndCanvas.fxml"));
        ResultCanvas.getChildren().setAll(pane);    
        }
        
    }

//    void init(WelcomeCanvasController welcomeController) {
//        welcomeController=welcomeController; //To change body of generated methods, choose Tools | Templates.
//    }

}
