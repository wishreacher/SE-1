import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

class Student{
	String name;
	
	Student(String s){
		name = s;
	}
	
	public String toString(){
		return name;
	}
}

public class SecondUI extends JFrame{

	private JPanel panel;
	private Border border;
	private JComboBox combo;
	private ButtonGroup bg1 = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private JCheckBox cb1;
	private JCheckBox cb2;
	private JRadioButton rb1;
	private JRadioButton rb2;
	
	
	public SecondUI() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout(0, 1));
		border = BorderFactory.createTitledBorder("Examples");
		panel.setBorder(border);
		combo = new JComboBox();
		combo.addItem("1");
		combo.addItem("2");
		combo.addItem("3");
		combo.addItem(new Student("Петро"));
		combo.addItem(new Student("Іван"));
		panel.add(combo);
		
		cb1 = new JCheckBox();
		cb2 = new JCheckBox();
		cb1.setText("Юнак");
		cb2.setText("Дівчина");
		panel.add(cb1);
		bg1.add(cb1);
		panel.add(cb2);
		bg1.add(cb2);
		rb1 = new JRadioButton();
		rb2 = new JRadioButton();
		
		rb1.setText("Smth1");
		rb2.setText("Smth2");
		bg2.add(rb1);
		bg2.add(rb2);
		panel.add(rb1);
		panel.add(rb2);
		this.getContentPane().setLayout(new FlowLayout());
		this.setSize(300, 200);
		
		this.add(panel);
		
	}
	
	public static void main(String[] args) {
		SecondUI sui = new SecondUI();
		sui.setVisible(true);

	}

}

