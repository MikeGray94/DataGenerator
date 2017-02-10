package dataMaker;

/**
 * Created on 2017/01/31
 * @author mikeg
 *
 */
public class User {
	
	private String firstName;
	private String lastName;
	private String age;
	private String email;
	private String phoneNum;

	public User(String firstName, String lastName, String age, String email,
			String phoneNum) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setEmail(email);
		this.setPhoneNum(phoneNum);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	

}
