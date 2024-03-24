/*
    Створити форму для зчитування логіна і пароля, в разі вірно введених даних виводити секретну інформацію,
    в іншому випадку видавати помилку (і те, і те - в нових вікнах-повідомленнях).
 */

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame{
    public LoginScreen(){
        this.setTitle("PES PATRON");
        this.setSize(600, 400);
        this.getContentPane().setLayout(new BorderLayout());


        JLabel label = new JLabel("Введіть логін та пароль", SwingConstants.CENTER);
        this.add(label, BorderLayout.NORTH);
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        label.setFont(new Font("Verdana", Font.PLAIN, 20));

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.Y_AXIS));

        JTextField loginField = new JTextField("Введіть логін");
        Dimension size = new Dimension(200, 30);
        loginField.setPreferredSize(size);
        loginField.setMinimumSize(size);
        loginField.setMaximumSize(size);

        JTextField passwordField = new JTextField("Ведіть пароль");
        passwordField.setPreferredSize(size);
        passwordField.setMinimumSize(size);
        passwordField.setMaximumSize(size);

        gridPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        gridPanel.add(loginField);
        gridPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gridPanel.add(passwordField);

        JButton submitButton = new JButton("Увійти");
        submitButton.setPreferredSize(new Dimension(100, 40));
        submitButton.setMinimumSize(new Dimension(100, 40));
        submitButton.setMaximumSize(new Dimension(100, 40));

        ImageIcon icon = new ImageIcon("patron.jpg");
        //JOptionPane.showMessageDialog(this, "patron.jpg", "Title", JOptionPane.INFORMATION_MESSAGE, icon);

        submitButton.addActionListener(e -> {
            if (loginField.getText().equals("admin") && passwordField.getText().equals("admin")){
                JOptionPane.showMessageDialog(this, "аааа ууу", "", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(this, "Помилка: Невірний логін або пароль");
            }
        });


        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Set alignment to center

        gridPanel.add(Box.createVerticalGlue()); // Add filler
        gridPanel.add(submitButton);
        gridPanel.add(Box.createVerticalGlue());

        this.add(gridPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        LoginScreen ui = new LoginScreen();
        ui.setVisible(true);
    }
}
