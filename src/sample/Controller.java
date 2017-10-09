package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
               }
            }
        });
        buttonNo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!questionList.get(activeQuestion).isYesCorrect()){
                    activeQuestion++;
                    nextQuestion();
                }
            }
        });
        nextQuestion();
    }

    private void nextQuestion() {
        labelText.setText(questionList.get(activeQuestion).getQuestionText());
    }

}
