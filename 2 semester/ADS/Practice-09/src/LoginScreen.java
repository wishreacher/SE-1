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

        gridPanel.add(loginField);
        gridPanel.add(passwordField);

        this.add(gridPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        LoginScreen ui = new LoginScreen();
        ui.setVisible(true);
    }
}
