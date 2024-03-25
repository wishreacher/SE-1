import javax.swing.*;
public class QuestionPanel extends JPanel{
    String expression;
    JLabel expressionField;
    JTextField answerField;
    int result;
    QuestionPanel(String problem, int result){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        expression = problem;
        this.result = result;

        expressionField = new JLabel(problem);
        answerField = new JTextField();

        this.add(expressionField);
        this.add(answerField);
    }

    private void generateExpression(){

    }

    public boolean isCorrect() {
        int userAnswer = Integer.parseInt(answerField.getText());
        return userAnswer == result;
    }
}
