package dataMaker;

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
	private StringBuilder postcodeTemp = new StringBuilder();
	boolean fNameInc, lNameInc, ageInc, genderInc, 
		profInc, emailInc, phoneNumInc, postcodeInc;
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	private String createFirstName(int length){
		if(fNameInc){
			nameTemp.setLength(0);
			for(i = 0; i < (rnd.nextInt(4) + (length - 3)); i++ ){
				nameTemp.append((char) (nameTemp.length() == 0 
						? (rnd.nextInt(26) + 65) : (rnd.nextInt(26) + 97)));
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
			for(i = 0; i < (rnd.nextInt(4) + (length - 3)); i++ ){
				nameTemp.append((char) (nameTemp.length() == 0 
						? (rnd.nextInt(26) + 65) : (rnd.nextInt(26) + 97)));
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
				phoneTemp.append(Integer.toString(rnd.nextInt(10)));		//Parse number as string, append to phone number StringBuilder
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
	private String createAge(int lower, int upper){
		if(ageInc){
			return Integer.toString(rnd.nextInt(upper-lower+1) + lower);
		}
		return "";
	}
	
	private String createGender(){
		if(genderInc){
			return (rnd.nextInt(2) == 0 ? "M" : "F");
		}
		return "";
	}
	
	private String getProfession(){
		if(profInc){
			return Profession.getRandomProf().toString();
		}
		return "";
	}
	
	private String createPostcode(){
		if(postcodeInc){
			postcodeTemp.setLength(0);
			
			for(i=0; i < (rnd.nextInt(2) + 1); i++){
				postcodeTemp.append((char) (rnd.nextInt(26) + 65));
			}
			
			postcodeTemp.append(Integer.toString(rnd.nextInt(99) + 1) 
					+ " " + Integer.toString(rnd.nextInt(10)));
			
			for(i=0; i < 2; i++){
				postcodeTemp.append((char) (rnd.nextInt(26) + 65));
			}
			return postcodeTemp.toString();
		}
		return "";
	}
	
	/**
	 * Created on 2017/02/02
	 * @author mikeg
	 */
	public void createUser(int fNameLength, int lNameLength, int lower, int upper){
		String[] args = new String[8];
		args[0] = createFirstName(fNameLength);
		args[1] = createLastName(lNameLength);
		args[2] = createAge(lower, upper);
		args[3] = createGender();
		args[4] = getProfession();
		args[5] = createEmail(args[0], args[1]);
		args[6] = createPhoneNum();
		args[7] = createPostcode();
		User tempUser = new User(args);
		getUserList().add(tempUser);
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
