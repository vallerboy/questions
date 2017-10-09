package sample;

public class Question {
    private String questionText;
    private boolean isYesCorrect;

    public Question(String questionText, boolean isYesCorrect) {
        this.questionText = questionText;
        this.isYesCorrect = isYesCorrect;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isYesCorrect() {
        return isYesCorrect;
    }

    public void setYesCorrect(boolean yesCorrect) {
        isYesCorrect = yesCorrect;
    }
}
