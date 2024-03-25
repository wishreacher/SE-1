import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class NumberGame extends JFrame {
    JTextField amountField = new JTextField();
    JPanel questionPanelContainer = new JPanel();
    NumberGame() {
        init();
    }

    public static void main(String[] args) {
        JFrame ui = new NumberGame();
        ui.setVisible(true);
    }

    public void init(){
        setTitle("Number Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        JLabel label = new JLabel("Stupidity test!", SwingConstants.CENTER);
        label.setFont(new Font("SF Pro", Font.PLAIN, 30));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        this.add(label, BorderLayout.NORTH);

        JPanel shit = new JPanel();
        shit.setLayout(new BoxLayout(shit, BoxLayout.Y_AXIS));

        JPanel params = new JPanel();
        params.setLayout(new FlowLayout());

        JLabel limitLabel = new JLabel("Limit:");
        params.add(limitLabel);

        JTextField limitField = new JTextField();
        limitField.setPreferredSize(new Dimension(150, 30));
        params.add(limitField);

        JLabel amountLabel = new JLabel("Amount:");
        params.add(amountLabel);

        amountField.setPreferredSize(new Dimension(150, 30));
        params.add(amountField);
        JButton generateButton = new JButton("Згенерувати");
        generateButton.setPreferredSize(new Dimension(150, 30));
        generateButton.addActionListener(e -> generateButtonClicked(e, amountField.getText(), limitField.getText()));
        params.add(generateButton);

        questionPanelContainer.setLayout(new BoxLayout(questionPanelContainer, BoxLayout.Y_AXIS));

        // Create a JScrollPane and pass the container to its constructor
        JScrollPane dataScroll = new JScrollPane(questionPanelContainer);
        dataScroll.setBorder(new EmptyBorder(0, 70, 0, 70));
        dataScroll.getViewport().setBackground(Color.GRAY);
        dataScroll.setPreferredSize(new Dimension(600, 400));
        shit.add(params);
        shit.add(dataScroll);

        JButton checkButton = new JButton("Результат");
        checkButton.setPreferredSize(new Dimension(150, 30));
        checkButton.setMaximumSize(new Dimension(150, 30));
        checkButton.setMinimumSize(new Dimension(150, 30));
        checkButton.addActionListener(e -> resultButtonClicked(e));

        // Create a JPanel with FlowLayout and add the checkButton to it
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(checkButton);

        // Add the buttonPanel to the SOUTH region instead of the checkButton
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(shit, BorderLayout.CENTER);
        //this.add(dataScroll, BorderLayout.CENTER);
    }

    public void generateButtonClicked(ActionEvent e, String amount, String limit){
        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть ціле число");
            return;
        }

        Component[] components = questionPanelContainer.getComponents();
        if(components.length != 0){
            questionPanelContainer.removeAll();
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(amount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введіть ціле число");
            return;
        }

        try {
            b = Integer.parseInt(limit);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введіть ціле число");
            return;
        }

        for(int i = 0; i < a; i++){
            Random random = new Random();

            int numOperations = random.nextInt(2) + 1; // 2 or 3 operations
            StringBuilder problem = new StringBuilder();

            // Generate the first number
            int number = random.nextInt(b) + 1;
            problem.append(number);
            int result = number;

            // Generate the operations and the next numbers
            for (int j = 0; j < numOperations; j++) {
                String operation = random.nextBoolean() ? "+" : "-";
                number = random.nextInt(b) + 1;

                // Check if the operation results in a negative value
                if (operation.equals("-") && result - number < 0) {
                    operation = "+"; // Swap the operation
                } else if (operation.equals("+") && result + number < 0) {
                    operation = "-"; // Swap the operation
                }

                // Apply the operation
                if (operation.equals("+")) {
                    result += number;
                } else {
                    result -= number;
                }

                problem.append(" ").append(operation).append(" ").append(number);
            }
            problem.append(" =");

            // Create a QuestionPanel with the problem and add it to the container
            QuestionPanel questionPanel = new QuestionPanel(problem.toString(), result);
            questionPanelContainer.add(questionPanel);
        }

        questionPanelContainer.revalidate();
        questionPanelContainer.repaint();
    }

    public void resultButtonClicked(ActionEvent e){
        Component[] components = questionPanelContainer.getComponents();
        int correct = 0;
        for(Component component : components){
            QuestionPanel questionPanel = (QuestionPanel) component;
            if(questionPanel.isCorrect()){
                correct++;
                questionPanel.answerField.setBackground(Color.GREEN);
            } else{
                questionPanel.answerField.setBackground(Color.RED);
            }
        }

        JOptionPane.showMessageDialog(this, "Кількість правильних відповідей: " + correct);
    }
}
