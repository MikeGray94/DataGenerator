package dataMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GenGUI implements ActionListener {

	final int width = 640;
	final int height = 480;
	
	private GenGUI(){
		
		JFrame menu = new JFrame("Data Generation");
		
	}
	
	private static class genGUIHolder{
		private static final GenGUI INSTANCE = new GenGUI();
	}
	
	public static GenGUI getInstance(){
		return genGUIHolder.INSTANCE;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
