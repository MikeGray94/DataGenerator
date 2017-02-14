package dataMaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
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
	JLabel jlblTop = new JLabel("Select required parameters:");
	JCheckBox jchbFName = new JCheckBox("First Name");
	JCheckBox jchbLName = new JCheckBox("Last Name");
	JCheckBox jchbAge = new JCheckBox("Age");
	JCheckBox jchbGender = new JCheckBox("Gender");
	JCheckBox jchbProf = new JCheckBox("Profession");
	JCheckBox jchbEmail = new JCheckBox("Email Address");
	JCheckBox jchbPhone = new JCheckBox("Phone Number");
	JTextField jtfQuantity = new JTextField("Quantity");
	JTextField jtfFileName = new JTextField("File Name");
	JButton jbtnGen = new JButton("Generate");
	JButton jbtnFile = new JButton("Save As");
	JPanel inputPane = new JPanel();
	JPanel viewPane = new JPanel();
	
	private GenGUI(){
				
		inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.PAGE_AXIS));
		inputPane.setPreferredSize(new Dimension((width/3), (height)));	
		inputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		viewPane.setLayout(new FlowLayout());
		viewPane.setPreferredSize(new Dimension(((2*width)/3), (height)));
		viewPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jlblTop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jbtnGen.addActionListener(this);
		jbtnFile.addActionListener(this);
		
		jtfQuantity.setPreferredSize(new Dimension((width/2)-10, 25));
		jtfQuantity.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfFileName.getPreferredSize().height));
		
		jtfFileName.setPreferredSize(new Dimension((width/2)-10, 25));
		jtfFileName.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfFileName.getPreferredSize().height));
		
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
		inputPane.add(jtfFileName);
		inputPane.add(jbtnFile);
		menu.add(viewPane);
	
		menu.pack();
		menu.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent aE) {
		switch(aE.getActionCommand()){
		case "Generate":
			int quantity = 0;
			try{
				quantity = Integer.parseInt(jtfQuantity.getText());
			}
			catch(NumberFormatException nFE){
				System.out.println("Invalid input");
				nFE.printStackTrace();
			}
			for(int i = 0; i < quantity; i++){
				Generator.getInstance().createUser();
			}
			JList<String> dataList = new JList<String>(userToString());
			JScrollPane scrollPane = new JScrollPane(dataList);
			scrollPane.setPreferredSize(new Dimension((width/2)-20,(height/2)-20));
			viewPane.add(scrollPane);
			viewPane.revalidate();
			break;
			
		case "Save As":
			try{
				FileWriter fw = new FileWriter(
						new File(jtfFileName.getText().isEmpty() 
								? "userList.txt" : jtfFileName.getText() 
										+ ".txt"));
				for(String s : userToString()){
					fw.write(s);
					fw.write(System.lineSeparator());
				}
				fw.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
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
	
	public String[] userToString(){
		String[] parameters = new String[7];
		StringBuilder sb = new StringBuilder();
		String[] output = new String[Generator.getInstance().getUserList().size()];
		int j = 0;
		for(User u : Generator.getInstance().getUserList()){
			sb.setLength(0);
			parameters[0] = u.getFirstName();
			parameters[1] = u.getLastName();
			parameters[2] = u.getAge();
			parameters[3] = u.getGender();
			parameters[4] = u.getProfession();
			parameters[5] = u.getEmail();
			parameters[6] = u.getPhoneNum();
			for(int k = 0; k < 7; k++){
				if(parameters[k]!=""){
					sb.append(parameters[k] + " | ");
				}
			}
			output[j] = sb.toString();
			j++;
		}
		return output;
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GenGUI();
			}
		});
	}

	
}
