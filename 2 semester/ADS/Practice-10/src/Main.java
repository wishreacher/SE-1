/*
    Написати графічну програму, що використовуючи JFileChooser дозволяє обрати файл і виводить його зміст.

    Федорич Володимир
 */

import javax.swing.*;

public class Main extends JFrame{
    Main(){
        super();
        setTitle("Hello World");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JButton button = new JButton("Select a file");
        add(button);

        JTextArea textArea = new JTextArea();
        add(textArea);

        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a file");
            fileChooser.showOpenDialog(this);

            try {
                textArea.setText("");
                java.io.File file = fileChooser.getSelectedFile();
                java.io.FileReader fileReader = new java.io.FileReader(file);
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception ex) {
                textArea.setText("Can't read the file");
            }
        });
    }

    public static void main(String[] args) {
        JFrame ui = new Main();
        ui.setVisible(true);
    }

}
