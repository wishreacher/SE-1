import java.util.*;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

class MyComboModel implements ComboBoxModel {
	
	private List data = new ArrayList();
	private int selected = 0;
	
	public MyComboModel(List list){
		data = list;
	}
	
	public void setSelectedItem(Object o){
		selected = data.indexOf(o);
	}

	public Object getSelectedItem(){
		return data.get(selected);
	}

	public int getSize(){
		return data.size();
	}

	public Object getElementAt(int i){
		return data.get(i);
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
	}

}

public class ModelTest extends JFrame{

	private ArrayList alphaList;
	private JComboBox myComboBox;
	public ModelTest(ArrayList list)
	   {
	      super();
	     this.setSize(300, 200);
	     this.getContentPane().setLayout(null);
	     this.add(getJComboBox(list), null);
	     this.setTitle("My Model");
	   }
	
	private JComboBox getJComboBox(ArrayList list) {
		alphaList = list;
		
		MyComboModel model = new MyComboModel(alphaList);
		myComboBox = new javax.swing.JComboBox();
		myComboBox.setBounds(50, 50, 71, 27);
		myComboBox.setModel(model);
		return myComboBox;
	}

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		//list1.add("1");
		//list1.add("2");
		//list1.add("3");
		ModelTest w = new ModelTest(list1);
	     w.setVisible(true);
		
	}

}
