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
	
	private ArrayList<User> userList = new ArrayList<User>();
	
	private int i;
	private Random rnd = new Random();
	private StringBuilder nameTemp = new StringBuilder();
	private StringBuilder emailTemp = new StringBuilder();
	private StringBuilder phoneTemp = new StringBuilder("07");
	boolean fNameInc, lNameInc, ageInc, genderInc, profInc, emailInc, phoneNumInc;
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createFirstName(int length){
		if(fNameInc){
			nameTemp.setLength(0);
			for(i = 0; i < (rnd.nextInt(4) + (length - 4)); i++ ){
				char input = (char) (nameTemp.length() == 0 ? (rnd.nextInt(26) + 65) : (rnd.nextInt(26) + 97));
				nameTemp.append(input);
			}
			return (nameTemp.toString());
		}
		return "";
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createLastName(int length){
		if(lNameInc){
			nameTemp.setLength(0);
			for(i = 0; i < (rnd.nextInt(4) + (length - 4)); i++ ){
				char input = (char) (nameTemp.length() == 0 ? (rnd.nextInt(26) + 65) : (rnd.nextInt(26) + 97));
				nameTemp.append(input);
			}
			return (nameTemp.toString());	
		}
		return "";
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createPhoneNum(){
		if(phoneNumInc){
			phoneTemp.setLength(2);
			for(i=2; i<11; i++){
				int tempBuild = rnd.nextInt(10);					//Generate random number between 0-9
				phoneTemp.append(Integer.toString(tempBuild));		//Parse number as string, append to phone number StringBuilder
			}
			return (phoneTemp.toString());
		}
		return "";
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createEmail(String firstName, String lastName){
		if(emailInc){
			emailTemp.setLength(0);
			emailTemp.append(firstName.substring(0,1).toLowerCase() + "." 
					+ lastName.toLowerCase() + "@" 
					+ Domain.getRandomDomain().toString().toLowerCase() + ".com");
			return (emailTemp.toString());
		}
		return "";
	}
	
	/**
	 * Created on 2017/02/12
	 * @author mikeg
	 */
	private String createAge(){
		if(ageInc){
			return Integer.toString(rnd.nextInt(47) + 18);
		}
		return "";
	}
	
	private String createGender(){
		if(genderInc){
			String gender = rnd.nextInt(2) == 0 ? "M" : "F";
			return gender;
		}
		return "";
	}
	
	private String getProfession(){
		if(profInc){
			return Profession.getRandomProf().toString();
		}
		return "";
	}
	
	/**
	 * Created on 2017/02/02
	 * @author mikeg
	 */
	public void createUser(int fNameLength, int lNameLength){
		String[] args = new String[7];
		args[0] = createFirstName(fNameLength);
		args[1] = createLastName(lNameLength);
		args[2] = createAge();
		args[3] = createGender();
		args[4] = getProfession();
		args[5] = createEmail(args[0], args[1]);
		args[6] = createPhoneNum();
		User tempUser = new User(args);
		getUserList().add(tempUser);
	}
	
	/**
	 * Created on 2017/02/02
	 * @author mikeg
	 * @param fileName
	 * @deprecated
	 */
	public void fileWrite(String fileName){
		try{
			FileWriter fw = new FileWriter(new File(fileName + ".txt"));
			for( User u : getUserList() ){	
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

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	

}
