//Last Updated 11/28/2020 6:47 p.m.
package theHerbalistSystem;
import java.util.*;
public class HerbalistLogin {
	//users logging in needed credientials
			private String username = null; //user login username = null
			private String password = null; //user login password = null
			private String email = null; //user login email = null
			
			//methods //default constructors
			//public Herbalist System
			/**
			 * @param username
			 * @param password
			 * @param email
			 * @return 
			 * */
			HerbalistLogin(){}
			public HerbalistLogin (String username, String password, String email) {
				super();
				this.username = username;
				this.password = password;
				this.email = email;
			}
			
			/*get username & set username
			 * @param username: String
			 * @return String usernmae value
			 */
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			
			/*get password & set password
			 * @param password: String 
			 * @return String password value
			 */
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			
			/*get email & set email
			 * @param email: String 
			 * @return String email value
			 */
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			
			/*
			 * When the user wishes to change user name, they will be prompted to enter their new user name
			 * the user name wil be set in the array
			 */
			public void changeUsername() {

				Scanner input = new Scanner(System.in);
				
				System.out.print("Enter a new username");
				setUsername (input.next());
				
				}
			
			/*
			 * When the user wishes to change their password, they will be prompted to enter their new password
			 * the password will be set in the array
			 */
			public void changePassword() {

				Scanner input = new Scanner(System.in);

	
				System.out.print("Enter a new password");
				setPassword (input.next());
	
			}	
			
			/*
			 * When the user wishes to change their email, they will be prompted to enter their new email
			 * the email will be set in the array
			 */
			public void changeEmail() {

				Scanner input = new Scanner(System.in);
	
				System.out.print("Enter a new email");
				setEmail (input.next());
	
	
			}
			/*
			 * Enter new users password and email
			 */
			public void inputDetails() {
				Scanner input = new Scanner(System.in);
	
				System.out.println("Enter password: "); 
				setPassword(input.next());
	
				System.out.println("Enter email: ");
				setEmail(input.next()); 
			}
			/*
			 * Display the new users: user name, password, and email. 
			 */
			public String printDetails()
			{ 
				return ("Username" + this.username + " Password: " + this.password + " Email: " + this.email);
			}
}	
