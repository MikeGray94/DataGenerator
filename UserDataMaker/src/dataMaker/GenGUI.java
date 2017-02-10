package dataMaker;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GenGUI implements ActionListener, ItemListener {

	final int width = 640;
	final int height = 480;
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
	JPanel inputPane = new JPanel();
	JPanel outputPane = new JPanel();
	
	private GenGUI(){
				

		inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.Y_AXIS));
		inputPane.setPreferredSize(new Dimension((width/2)-5, (height/2)-5));		
		outputPane.setLayout(new FlowLayout());
		outputPane.setPreferredSize(new Dimension((width/2)-5, (height/2)-5));
		
		jbtnGen.addActionListener(this);
		
		jchbFName.addActionListener(this);
		jchbLName.addActionListener(this);
		jchbAge.addActionListener(this);
		jchbGender.addActionListener(this);
		jchbProf.addActionListener(this);
		jchbEmail.addActionListener(this);
		jchbPhone.addActionListener(this);
		
		menu.setSize(width, height);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLayout(new FlowLayout());
		
		menu.add(inputPane);
		inputPane.add(jlblTop);
		inputPane.add(jchbFName);
		inputPane.add(jchbLName);
		inputPane.add(jchbAge);
		inputPane.add(jchbGender);
		inputPane.add(jchbProf);
		inputPane.add(jchbEmail);
		inputPane.add(jchbPhone);
		inputPane.add(jtfQuantity);
		inputPane.add(jbtnGen);
		menu.add(outputPane);
	
		menu.pack();
		menu.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent aE) {
		switch(aE.getActionCommand()){
		case "Generate":
			int quantity = Integer.parseInt(jtfQuantity.getText());
			for(int i = 0; i < quantity; i++){
				Generator.getInstance().createUser();
			}
			String[] output = new String[Generator.getInstance().getUserList().size()];
			int j = 0;
			for(User u : Generator.getInstance().getUserList()){
				output[j] = u.getFirstName() + " | "
						+ u.getLastName() + " | "
						+ u.getAge() + " | "
						+ u.getEmail() + " | "
						+ u.getPhoneNum();
				System.out.println(output[j]);
				j++;
			}
			JList<String> dataList = new JList<String>(output);
			JScrollPane scrollPane = new JScrollPane(dataList);
			scrollPane.setPreferredSize(new Dimension((width/2)-10,(height/2)-10));
			outputPane.add(scrollPane);
			break;
			
		case "Age":
			if(jchbAge.isSelected())
				System.out.println("Age selected");
			else
				System.out.println("Age deselected");
		}	
	}

	@Override
	public void itemStateChanged(ItemEvent iE) {
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GenGUI();
			}
		});
	}

	
}
