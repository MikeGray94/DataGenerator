package dataMaker;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GenGUI implements ActionListener {

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
			String[] parameters = new String[7];
			StringBuilder userInfo = new StringBuilder();
			String[] output = new String[Generator.getInstance().getUserList().size()];
			int j = 0;
			for(User u : Generator.getInstance().getUserList()){
				userInfo.setLength(0);
				parameters[0] = u.getFirstName();
				parameters[1] = u.getLastName();
				parameters[2] = u.getAge();
				parameters[3] = u.getGender();
				parameters[4] = u.getProfession();
				parameters[5] = u.getEmail();
				parameters[6] = u.getPhoneNum();
				for(int k = 0; k < 7; k++){
					if(parameters[k]!=""){
						userInfo.append(parameters[k] + " | ");
					}
				}
				output[j] = userInfo.toString();
				System.out.println(output[j]);
				j++;
			}
			JList<String> dataList = new JList<String>(output);
			JScrollPane scrollPane = new JScrollPane(dataList);
			scrollPane.setPreferredSize(new Dimension((width/2)-10,(height/2)-10));
			outputPane.add(scrollPane);
			break;
			
		case "First Name":
			if(jchbFName.isSelected()){
				Generator.getInstance().fNameInc = true;
			}
			else{
				Generator.getInstance().fNameInc = false;
			}
			break;
		
		case "Last Name":
			if(jchbLName.isSelected()){
				Generator.getInstance().lNameInc = true;
			}
			else{
				Generator.getInstance().lNameInc = false;
			}
			break;
			
		case "Age":
			if(jchbAge.isSelected()){
				Generator.getInstance().ageInc = true;
			}
			else{
				Generator.getInstance().ageInc = false;
			}
			break;
			
		case "Gender":
			if(jchbGender.isSelected()){
				Generator.getInstance().genderInc = true;
			}
			else{
				Generator.getInstance().genderInc = false;
			}
			break;
			
		case "Profession":
			if(jchbProf.isSelected()){
				Generator.getInstance().profInc = true;
			}
			else{
				Generator.getInstance().profInc = false;
			}
			break;
			
		case "Email Address":
			if(jchbEmail.isSelected()){
				Generator.getInstance().emailInc = true;
			}
			else{
				Generator.getInstance().emailInc = false;
			}
			break;
			
		case "Phone Number":
			if(jchbPhone.isSelected()){
				Generator.getInstance().phoneNumInc = true;
			}
			else{
				Generator.getInstance().phoneNumInc = false;
			}
			break;
		}	
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GenGUI();
			}
		});
	}

	
}
