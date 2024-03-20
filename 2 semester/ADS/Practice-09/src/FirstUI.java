import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstUI extends JFrame{

	private JLabel label;
	private JTextField text;
	private JButton button;
	
	public FirstUI(String name){
		super();
		this.setTitle(name);
		this.setSize(300,200);
		this.getContentPane().setLayout(new GridLayout(1,2));
		init();
		this.add(label);
		this.add(text);
		this.add(button);
		
		
	}
	
	private void init(){
		if (label==null){
			label = new JLabel();
			label.setText("Hello");
		}
		if (text==null){
			text = new JTextField();
			text.setBounds(10, 10, 150, 15);
			text.setSize(150, 15);
			
		}
		if (button == null){
			button = new JButton();
			button.setText("Ok");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstUI ui = new FirstUI("Перша SWING програма");
		ui.setVisible(true);

	}

}
