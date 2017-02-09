package dataMaker;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GenGUI implements ActionListener, ItemListener {

	final int width = 640;
	final int height = 480;
	
	public GenGUI(){
		
		JFrame menu = new JFrame("Data Generation");
		JLabel jlblTop = new JLabel("Select which parameters you require:");
		JCheckBox jchbFName = new JCheckBox("First Name");
		JCheckBox jchbLName = new JCheckBox("Last Name");
		JCheckBox jchbAge = new JCheckBox("Age");
		JCheckBox jchbGender = new JCheckBox("Gender");
		JCheckBox jchbProf = new JCheckBox("Profession");
		JCheckBox jchbEmail = new JCheckBox("Email Address");
		JCheckBox jchbPhone = new JCheckBox("Phone Number");
		JTextField jtfQuantity = new JTextField("Quantity");
		JButton jbtnGen = new JButton("Generate");
		
		JPanel checkBoxPane = new JPanel();
		//checkBoxPane.setLayout(new BoxLayout(checkBoxPane, BoxLayout.Y_AXIS));
		JPanel submitPane = new JPanel();
		JPanel outputPane = new JPanel();
		
		jbtnGen.addActionListener(this);
		
		jchbFName.addItemListener(this);
		jchbLName.addItemListener(this);
		jchbAge.addItemListener(this);
		jchbGender.addItemListener(this);
		jchbProf.addItemListener(this);
		jchbEmail.addItemListener(this);
		jchbPhone.addItemListener(this);
		
		menu.setSize(width, height);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLayout(new BorderLayout());
		
		menu.add(checkBoxPane);
		checkBoxPane.add(jlblTop);
		checkBoxPane.add(jchbFName);
		checkBoxPane.add(jchbLName);
		checkBoxPane.add(jchbAge);
		checkBoxPane.add(jchbGender);
		checkBoxPane.add(jchbProf);
		checkBoxPane.add(jchbEmail);
		checkBoxPane.add(jchbPhone);
		menu.add(submitPane);
		submitPane.add(jtfQuantity);
		submitPane.add(jbtnGen);
		menu.add(outputPane);
		
		menu.pack();
		menu.setVisible(true);
		
	}
	/*
	private static class genGUIHolder{
		private static final GenGUI INSTANCE = new GenGUI();
	}
	
	public static GenGUI getInstance(){
		return genGUIHolder.INSTANCE;
	}
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GenGUI();
			}
		});
	}

	
}
