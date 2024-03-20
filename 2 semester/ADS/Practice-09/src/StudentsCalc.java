import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentsCalc extends JFrame{

	private int count = 0;
	private JLabel countLabel;
	private JButton addStudent;
	private JButton removeStudent;
	
	public StudentsCalc(){
		super("Калькулятор студентів");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		countLabel = new JLabel("Студентів: "+count);
		addStudent = new JButton("Додати студента");
		removeStudent = new JButton("Прибрати студента");
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		add(countLabel, BorderLayout.NORTH);
		buttonsPanel.add(addStudent);
		buttonsPanel.add(removeStudent);
		add(buttonsPanel, BorderLayout.SOUTH);
		addStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count++;
				updateStudentsCounter();
			}


		});
		removeStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count>0){
					count--;
					updateStudentsCounter();
				}
				
			}
		});
	}
	private void updateStudentsCounter() {
		countLabel.setText("Студентів: "+count);
		
	}
	public static void main(String[] args) {
		StudentsCalc app = new StudentsCalc();
		app.setVisible(true);
		app.pack();

	}

}
