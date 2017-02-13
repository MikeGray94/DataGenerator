package dataMaker;

import java.util.Scanner;

/**
 * Created on 2017/02/02
 * @author mikeg
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		run(s);
	}
	
	private static void run(Scanner s){
		
		boolean done = false;
		while(!done){
			System.out.println("Generate | View | Output | Exit");
			String action = s.next().toUpperCase();
			
			switch(action){
			
			case "GENERATE":
				System.out.println("How many users would you like to generate?");
				int quantity = s.nextInt();
				for(int i =0; i < quantity; i++){
					Generator.getInstance().createUser();
				}
				break;
				
			case "VIEW":
				System.out.println("How many users would you like to view?");
				quantity = s.nextInt();
				for(int i = 0; i < quantity; i++){
					System.out.println("First Name: " + Generator.getInstance().getUserList().get(i).getFirstName()
							+ " Last Name: " + Generator.getInstance().getUserList().get(i).getLastName()
							+ " Age: " + Generator.getInstance().getUserList().get(i).getAge()
							+ " Email: " + Generator.getInstance().getUserList().get(i).getEmail()
							+ " Phone Number: " + Generator.getInstance().getUserList().get(i).getPhoneNum());
				}
				break;
				
			case "OUTPUT":
				System.out.println("Please enter the name of the file to write to:");
				String fileName = s.next();
				Generator.getInstance().fileWrite(fileName);
				break;
				
			case "EXIT":
				done = true;
				break;
				
			default:
				System.out.println("Invalid option, please try again.");
				break;
			}
		}
	}
}
