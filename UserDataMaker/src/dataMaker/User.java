package dataMaker;

import java.util.Random;

/**
 * Created on 2017/01/31
 * @author mikeg
 *
 */
public class User {
	
	private String firstName;
	private String lastName;
	private StringBuilder nameTemp = new StringBuilder();
	private int age;
	private String email;
	private StringBuilder emailTemp = new StringBuilder();
	private String phoneNum;
	private StringBuilder phoneTemp = new StringBuilder("07");
	private Random rnd = new Random();
	private int i;
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	public void createFirstName(){
		for(i = 0; i < (rnd.nextInt(4) + 4); i++ ){
			int charNo = nameTemp.length() == 0 ? rnd.nextInt(26) + 1 : rnd.nextInt(26) + 27;
			char base = (charNo < 26) ? 'A' : 'a';
			char input = (char) (base + charNo % 26);
			nameTemp.append(input);
		}
		firstName = nameTemp.toString();
		nameTemp.setLength(0);				//Clears StringBuilder
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	public void createLastName(){
		for(i = 0; i < (rnd.nextInt(6) + 4); i++ ){
			int charNo = nameTemp.length() == 0 ? rnd.nextInt(26) + 1 : rnd.nextInt(26) + 27;
			char base = (charNo < 26) ? 'A' : 'a';
			char input = (char) (base + charNo % 26);
			nameTemp.append(input);
		}
		lastName = nameTemp.toString();
		nameTemp.setLength(0);
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	public void createPhoneNum(){
		for(i=2; i<11; i++){
			int tempBuild = rnd.nextInt(10);					//Generate random number between 0-9
			phoneTemp.append(Integer.toString(tempBuild));		//Parse number as string, append to phone number StringBuilder
		}
		phoneNum = phoneTemp.toString();
	}
	
	/**
	 * Created on 2017/01/31
	 * @author mikeg
	 */
	public void createEmail(){
		emailTemp.append(firstName.substring(0,1));
		emailTemp.append(".");
		emailTemp.append(lastName);
		emailTemp.append("@domain.com");
		email = emailTemp.toString();
	}

}
