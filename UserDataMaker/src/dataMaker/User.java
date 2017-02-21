package dataMaker;

/**
 * Created on 2017/01/31
 * @author mikeg
 *
 */
public class User {
	
	private String firstName, lastName, age, gender, profession, email, phoneNum, postcode;
	
	/**
	 * @param First Name
	 * @param Last Name
	 * @param Age
	 * @param Gender
	 * @param Profession
	 * @param Email
	 * @param Phone Number
	 * @param Postcode
	 */
	public User(String[] args) {
		this.setFirstName(args[0]);
		this.setLastName(args[1]);
		this.setAge(args[2]);
		this.setGender(args[3]);
		this.setProfession(args[4]);
		this.setEmail(args[5]);
		this.setPhoneNum(args[6]);
		this.setPostcode(args[7]);
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	

}
