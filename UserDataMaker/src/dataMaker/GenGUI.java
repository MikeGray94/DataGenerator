package dataMaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GenGUI implements ActionListener {

	final int width = 800;
	final int height = 600;
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
	JTextField jtfFNameLength = new JTextField("First Name Length");
	JTextField jtfLNameLength = new JTextField("Last Name Length");
	JTextField jtfFileName = new JTextField("File Name");
	JButton jbtnGen = new JButton("Generate");
	JButton jbtnFile = new JButton("Save As");
	JPanel inputPane = new JPanel();
	JPanel viewPane = new JPanel();
	JPanel titlePane = new JPanel();
	JPanel selectionPane = new JPanel();
	JPanel generatePane = new JPanel();
	JPanel savePane = new JPanel();
	JPanel warningPane = new JPanel();
	JLabel formatWarning = new JLabel("Input is not valid, please try again!");
	JLabel fileNameWarning = new JLabel("Only alphanumeric characters and spaces are allowed!");
	JPanel[][] panelHolder;
	
	private GenGUI(){
		
		DocumentListener textListener = new MyDocListener();
				
		inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.PAGE_AXIS));
		inputPane.setPreferredSize(new Dimension((width/3), (height)));	
		inputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		viewPane.setLayout(new FlowLayout());
		viewPane.setPreferredSize(new Dimension(((2*width)/3), (height)));
		viewPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jbtnGen.setEnabled(false);
		jbtnGen.addActionListener(this);
		jbtnFile.addActionListener(this);
		
		jtfQuantity.setPreferredSize(new Dimension((width/3)-20, 25));
		jtfQuantity.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfFileName.getPreferredSize().height));
		jtfQuantity.getDocument().addDocumentListener(textListener);
		
		jtfFileName.setPreferredSize(new Dimension((width/3)-20, 25));
		jtfFileName.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfFileName.getPreferredSize().height));
		jtfFileName.getDocument().addDocumentListener(textListener);
		
		jtfFNameLength.setPreferredSize(new Dimension((width/6)-20, 25));
		jtfFNameLength.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfFNameLength.getPreferredSize().height));
		jtfFNameLength.getDocument().addDocumentListener(textListener);
		
		jtfLNameLength.setPreferredSize(new Dimension((width/6)-20, 25));
		jtfLNameLength.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfLNameLength.getPreferredSize().height));
		jtfLNameLength.getDocument().addDocumentListener(textListener);
		
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
		inputPane.add(titlePane);
		titlePane.setMaximumSize(new Dimension((width/3), 50));
		titlePane.add(jlblTop, BorderLayout.CENTER);
		
		inputPane.add(selectionPane);
		selectionPane.setLayout(new GridLayout(0,2,0,1));
		int rows = 8;
		int columns = 2;
		panelHolder = new JPanel[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				panelHolder[i][j] = new JPanel(new FlowLayout(FlowLayout.LEFT));
				selectionPane.add(panelHolder[i][j]);
			}
		}
		panelHolder[0][0].add(jchbFName);
		panelHolder[0][1].add(jtfFNameLength);
		panelHolder[1][0].add(jchbLName);
		panelHolder[1][1].add(jtfLNameLength);
		panelHolder[2][0].add(jchbAge);
		panelHolder[3][0].add(jchbGender);
		panelHolder[4][0].add(jchbProf);
		panelHolder[5][0].add(jchbEmail);
		panelHolder[6][0].add(jchbPhone);
		panelHolder[7][0].add(jtfQuantity);
		
		inputPane.add(generatePane);
		generatePane.add(jtfQuantity, BorderLayout.LINE_START);
		generatePane.add(jbtnGen, BorderLayout.LINE_END);
		
		inputPane.add(savePane);
		savePane.add(jtfFileName, BorderLayout.LINE_START);
		savePane.add(jbtnFile, BorderLayout.LINE_END);
		
		inputPane.add(warningPane);

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
				warningPane.removeAll();
				warningPane.add(formatWarning);
				nFE.printStackTrace();
			}
			for(int i = 0; i < quantity; i++){
				int fNameLength = Generator.getInstance().fNameInc 
						? Integer.parseInt(jtfFNameLength.getText()) : 0;
				int lNameLength = Generator.getInstance().lNameInc 
						? Integer.parseInt(jtfLNameLength.getText()) : 0;
				Generator.getInstance().createUser(fNameLength, lNameLength);
			}
			JList<String> dataList = new JList<String>(userToString());
			JScrollPane scrollPane = new JScrollPane(dataList);
			scrollPane.setPreferredSize(new Dimension((2*width/3)-15,(height)-15));
			viewPane.removeAll();
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
				warningPane.removeAll();
				warningPane.add(fileNameWarning);
				ex.printStackTrace();
			}
			break;
			
		case "First Name":
			Generator.getInstance().fNameInc = jchbFName.isSelected();
			break;
		
		case "Last Name":
			Generator.getInstance().lNameInc = jchbLName.isSelected();
			break;
			
		case "Age":
			Generator.getInstance().ageInc = jchbAge.isSelected();
			break;
			
		case "Gender":
			Generator.getInstance().genderInc = jchbGender.isSelected();
			break;
			
		case "Profession":
			Generator.getInstance().profInc = jchbProf.isSelected();
			break;
			
		case "Email Address":
			Generator.getInstance().emailInc = jchbEmail.isSelected();
			break;
			
		case "Phone Number":
			Generator.getInstance().phoneNumInc = jchbPhone.isSelected();
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
	
	private class MyDocListener implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			checkInputValid();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			checkInputValid();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			checkInputValid();
		}
	}
	
	private void checkInputValid(){
		if(Pattern.matches("^[0-9]+$", jtfQuantity.getText().trim())
				& (Pattern.matches("^[0-9]+$", jtfFNameLength.getText().trim()) | !(Generator.getInstance().fNameInc))
				& (Pattern.matches("^[0-9]+$",  jtfLNameLength.getText().trim()) | !(Generator.getInstance().lNameInc))
				){
			jbtnGen.setEnabled(true);
		}
		else{
			jbtnGen.setEnabled(false);
		}
		
		if(Pattern.matches("[a-zA-Z0-9\\s]+", jtfFileName.getText().trim())){
			jbtnFile.setEnabled(true);
		}
		else{
			jbtnFile.setEnabled(false);
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
