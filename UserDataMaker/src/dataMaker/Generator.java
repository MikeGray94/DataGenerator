package dataMaker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 2017/01/31
 * @author mikeg
 * 
 */
public class Generator {
	
	protected ArrayList<User> userList = new ArrayList<User>();
	
	private int i;
	private Random rnd = new Random();
	private StringBuilder nameTemp = new StringBuilder();
	private StringBuilder emailTemp = new StringBuilder();
	private StringBuilder phoneTemp = new StringBuilder("07");
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createFirstName(){
		nameTemp.setLength(0);
		for(i = 0; i < (rnd.nextInt(4) + 4); i++ ){
			char input = (char) (nameTemp.length() == 0 ? (rnd.nextInt(26) + 65) : (rnd.nextInt(26) + 97));
			nameTemp.append(input);
		}
		return (nameTemp.toString());
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createLastName(){
		nameTemp.setLength(0);
		for(i = 0; i < (rnd.nextInt(6) + 4); i++ ){
			char input = (char) (nameTemp.length() == 0 ? (rnd.nextInt(26) + 65) : (rnd.nextInt(26) + 97));
			nameTemp.append(input);
		}
		return (nameTemp.toString());
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createPhoneNum(){
		phoneTemp.setLength(2);
		for(i=2; i<11; i++){
			int tempBuild = rnd.nextInt(10);					//Generate random number between 0-9
			phoneTemp.append(Integer.toString(tempBuild));		//Parse number as string, append to phone number StringBuilder
		}
		return (phoneTemp.toString());
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createEmail(String firstName, String lastName){
		emailTemp.setLength(0);
		emailTemp.append(firstName.substring(0,1));
		emailTemp.append(".");
		emailTemp.append(lastName);
		emailTemp.append("@domain.com");
		return (emailTemp.toString());
	}
	/**
	 * Created on 2017/02/02
	 * @author mikeg
	 */
	public void createUser(){
		String fName = createFirstName();
		String lName = createLastName();
		User tempUser = new User(fName, lName, (rnd.nextInt(47) + 18), createEmail(fName, lName.toLowerCase()), createPhoneNum());
		userList.add(tempUser);
	}
	
	/**
	 * Created on 2017/02/02
	 * @author mikeg
	 * @param fileName
	 */
	public void fileWrite(String fileName){
		try{
			FileWriter fw = new FileWriter(new File(fileName + ".txt"));
			for( User u : userList ){	
				fw.write(u.getFirstName() + "," 
						+ u.getLastName() + "," 
						+ u.getAge() + "," 
						+ u.getEmail() + "," 
						+ u.getPhoneNum());
				fw.write(System.lineSeparator());
			}
			fw.close();
		}
		catch(IOException ex){
			System.out.println("Error writing to file.");
			ex.printStackTrace();				
		}
	}
	
	private Generator() {}
	
	private static class generatorHolder{
		private static final Generator INSTANCE = new Generator();
	}
	
	public static Generator getInstance(){
		return generatorHolder.INSTANCE;
	}
	

}
