package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Label labelText;

    @FXML
    Button buttonYes;

    @FXML
    Button buttonNo;

    private List<Question> questionList;
    private int activeQuestion;

    public Controller() {
        questionList = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questionList.add(new Question("Czy Polska to państwo?", true));
        questionList.add(new Question("Czy pies to ssak?", true));
        questionList.add(new Question("Czy java 8 to flagowa werjsa oprogramowania?", false));
        questionList.add(new Question("Czy notebook i netbook to to samo?", false));
        Collections.shuffle(questionList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonYes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               if(questionList.get(activeQuestion).isYesCorrect()){
                   activeQuestion++;
                   nextQuestion();
               }else{
                   createDialog("Podałeś niepoprawną odpowiedz");
               }
            }
        });
        buttonNo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!questionList.get(activeQuestion).isYesCorrect()){
                    activeQuestion++;
                    nextQuestion();
                }else{
                    createDialog("Podałeś niepoprawną odpowiedz");
                }
            }
        });
        nextQuestion();
    }

    private void nextQuestion() {
        if(activeQuestion > questionList.size()-1){
            createDialog("Koniec gry, brawo!");
            System.exit(0);
        }
        labelText.setText(questionList.get(activeQuestion).getQuestionText());
    }

    private void createDialog(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Milionerzy");
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.showAndWait();
    }

}
