package theHerbalistSystem;
import java.util.*;
public class SystemLogin {

	
	//main method that will prompt the users to enter what type of user they are
	public static void main(String[] args) {//main method
		// TODO Auto-generated method stub
		HerbalistLogin [][] login = new HerbalistLogin[3][20]; //array to hold the users info (user name, password, email)
		
		
		//initialize the pre registered users as a test 
		//row 0 = normal users
		//row 1 = herbalist users
		//row 2  = admin users

		//regular users #1
		String usernameN1 = "normaluser1";
		String passwordN1 = "3000";
		String emailN1 = "normaluser1@gmail.com";

		//create variable for user that holds all the data 
		HerbalistLogin normalUser1 = new HerbalistLogin(usernameN1, passwordN1, emailN1);

		login[0][0] = normalUser1;//place user and data in array 

		//regular user #2
		String usernameN2 = "normaluser2";
		String passwordN2 = "3001";
		String emailN2 = "normaluser2@gmail.com";

		//create variable for user that holds all the data 
		HerbalistLogin normalUser2 = new HerbalistLogin(usernameN2, passwordN2, emailN2);

		
		login[0][1] = normalUser2;//place user and data in array 

		//regular user #3
		String usernameN3 = "normaluser3";
        String passwordN3 = "3002";
        String emailN3 = "normaluser3@gmail.com";

        //create variable for user that holds all the data
        HerbalistLogin normalUser3 = new HerbalistLogin(usernameN3,  passwordN3, emailN3);

        login[0][2] = normalUser3;//place user and data in array

        //herb users #1
        String usernameH1 = "herbuser1";
        String passwordH1 = "2000";
        String emailH1 = "herbuser1@gmail.com";

        //create variable for user that holds all the data
        HerbalistLogin herbUser1 = new HerbalistLogin(usernameH1, passwordH1, emailH1);

   
        login[1][0] = herbUser1;//place user and data in array

        //herb user #2
        String usernameH2 = "herbuser2";
        String passwordH2 = "2001";
        String emailH2 = "herbuser2@gmail.com";

        //create variable for user that holds all the data
        HerbalistLogin herbUser2 = new HerbalistLogin(usernameH2, passwordH2, emailH2);

  
        login[1][1] = herbUser2;//place user and data in array

        //herb user #3
        String usernameH3 = "herbuser3";
        String passwordH3 = "2002";
        String emailH3 = "herbuser3@gmail.com";

        //create variable for user that holds all the data
        HerbalistLogin herbUser3 = new HerbalistLogin(usernameH3, passwordH3, emailH3);

    
        login[1][2] = herbUser3;//place user and data in array

        //admin user #1
        String usernameA1 = "adminuser1";
        String passwordA1 = "1000";
        String emailA1 = "adminuser1@gmail.com";

        //create variable for user that holds all the data
        HerbalistLogin adminUser1 = new HerbalistLogin(usernameA1, passwordA1, emailA1);

  
        login[2][0] = adminUser1;//place user and data in array

        //admin user #2
        String usernameA2 = "adminuser2";
        String passwordA2 = "1001";
        String emailA2 = "adminuser2@gmail.com";

        //create variable for user that holds all the data
        HerbalistLogin adminUser2 = new HerbalistLogin(usernameA2, passwordA2, emailA2);

       
        login[2][1] = adminUser2;//place user and data in array

        
	    //menu screen for logging in
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Herbalist System.");
		System.out.println("Please login first to further use the system to browse our Herbs.");
		System.out.println("-----------------------------------------------------------------------");
	
		// do while loop to repeat the question if an input is incorrect
		int usertype; //usertype will be used for input, and find users info in array
		do {
		System.out.println("What type of user is loging into the system?");//prompt user to type what kind of user they are
		System.out.println("Enter '0' for normal user");
		System.out.println("Enter '1' for herbalist user");
		System.out.println("Enter '2' for admin user");
		System.out.println("Enter '3' for Registering new User");
		System.out.print("Enter a number: ");
		usertype = input.nextInt(); 

		//switch will send the user to their respective method 
		switch(usertype) {
		case 0: normalUser(login, usertype); //if entered 0, send to normalUser method 
		break; 
		case 1: herbalistUser(login, usertype); //if entered 1, send to herbalistUser method 
		break; 
		case 2: adminUser(login, usertype); //if entered 2, send to adminUser method 
		break; 
		case 3 : addUser(login); //if entered 3, send to addUser method
		break;
		default : System.out.println("Not a choice"); //if improper input, provide error message
		break; 
		}
		}while(usertype > 3 || usertype < 0); //if improper input, repeat login

	}//end of main

	
	/*normal user method that will be prompted with login and options they can access 
	 * the options that the user has are: search a herb, modify their profile, and log out
	 * the method will also check if the users credentials are valid
	 * if their are any invalid credentials the user will be prompted to enter their information again 
	 * if the user fails 3 input they will be forced to log out
	 */
	public static void normalUser(HerbalistLogin[][] login, int usertype) {//normalUser method

		boolean Uexists;//initialize boolean variable that will notify if the username exist
		boolean Pexists;//initialize boolean variable that will notify if the password exists
		boolean Eexists; //initialize boolean variable that will notify if the email exist
		
		//count the amount of error logins for security purposes
		int error = 0;
		
		
		 //do while loop if the user has inputed an improper choice
		do{
			Scanner input = new Scanner(System.in);
			//reset all the variables if there was an error in at least one of the login credentials
			Uexists = false;
			Pexists = false;
			Eexists = false; 
			
			//Prompt the user to enter their user name 
			
			System.out.println();
			System.out.print("Enter your username: ");
			String username = input.next();
			
		//for loop to check every spot in the array if the entered user name has a match 
		for(int j = 0; j < login.length; j++) {
			if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {
				Uexists = true; 
				continue;
				}
			}

			//prompt the user to enter their password
			System.out.print("Enter your password: "); 
			String password = input.next();
			//for loop to check every spot in the array if the entered password has a match
			for(int j = 0; j < login.length; j++) {
				if (login[usertype][j] != null && password.equals(login[usertype][j].getPassword())) {
					Pexists = true; 
					continue;
				}
			}
		
		//prompt the user to enter their email 
		System.out.print("Enter your email: "); 
		String email = input.next();
		//for loop to check every spot in the array if the entered email has a match
		for(int j = 0; j < login.length; j++) {
			if (login[usertype][j] != null && email.equals(login[usertype][j].getEmail())) {
				Eexists = true; 
				continue;
			}
		
			}
		
		//display an error message for all the conditions where there is an error in the credentials entered.
		if(Uexists == true && Pexists == true && Eexists== false){
			//email is incorrect
			System.out.println("Email incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		}
		else if(Uexists == true && Pexists == false && Eexists== true) {
			//password is incorect
			System.out.println("Password incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		} 
		else if(Uexists == true && Pexists == false && Eexists== false) {
			//password and email incorrect
			System.out.println("Password & Email incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		} 
		else if(Uexists == false && Pexists == true && Eexists== true) {
			//username incorrect
			System.out.println("Username incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		}
		else if(Uexists == false && Pexists == true && Eexists== false) {
			//username and email incorrect
			System.out.println("Username & Email incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		}
		else if(Uexists == false && Pexists == false && Eexists== true) {
			//username and password incorrect
			System.out.println("Username and Password incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		} 
		else if(Uexists == false && Pexists == false && Eexists== false)
		{
			//username, password, email all incorrect
			System.out.println("All login credentials are incorrect please enter all credentials again correctly.");
			System.out.println("Or please refresh and register in our system.");
			//add to error counter
			error++;
		}
		
		
		

		//only display the menu if the user has entered all their credentials correctly
		
		if(Uexists==true && Pexists == true && Eexists == true) 
		{
				System.out.println("==========================");
				System.out.println("MENU");
				System.out.println("1: Search");
				System.out.println("2: Modify Profile");
				System.out.println("3: Log out");

				System.out.print("Enter the number of your choice: ");
				int menu = input.nextInt(); 

				do {//provide user with choices, do while loop for any improper input 
					switch(menu)
					{
					case 1: search(); //if input is 1 send to search method
					break; 
					case 2: modifyProfile(login, usertype); //if input is 2 send to modifyProfile method
					break; 
					case 3: System.out.println("Loging out of the system now. Goodbye."); //if input is 3 log out of system
							System.exit(menu); //close the system
					break;
					default: System.out.println("Not an option, try again"); //if the input is not a choice, display error message and provide menu again
					break; 
					}
					//menu choices again if they is an improper input.
					System.out.println("==========================");
					System.out.println("MENU");
					System.out.println("1: Search");
					System.out.println("2: Modify Profile");
					System.out.println("3: Log out");

					System.out.print("Enter the number of your choice: ");
					menu = input.nextInt(); 
					
					if(menu == 3)
					{
						System.out.println("Loging out of the system now. Goodbye."); 
						System.exit(menu);
					}
				}while (menu !=3);
		}//closing if

	} while ((Uexists == true && Pexists == true && Eexists== false) || (Uexists == true && Pexists == false && Eexists== true) || (Uexists == true && Pexists == false && Eexists== false) || (Uexists == false && Pexists == true && Eexists== true) || (Uexists == false && Pexists == true && Eexists== false) || (Uexists == false && Pexists == false && Eexists== true) || (Uexists == false && Pexists == false && Eexists== false) && (error < 5));//if the login credentials do not exist then prompt the user to login again	
	
		//display when error = 3
		System.out.println("------------------------------");
		System.out.println("Closing System for security purposes, too many error logins. Try again in a couple minutes");
		
	}//end of normalUser method
				
	
	
	/*
	 * herbalistUser method that will prompt the user to login and provide options they can access
	 * the options that the user has are: search a herb, modify their profile, add a herb and its info, delete a herb and its info, modify a herbs info, and log out 
	 * the method will also check if the users credentials are valid
	 * if their are any invalid credentials the user will be prompted to enter their information again 
	 * if the user fails 3 inputs they will be forced to log out
	 */
	public static void herbalistUser(HerbalistLogin[][] login, int usertype) {//herablistUser method
	boolean Uexists;//initialize boolean variable that will notify if the user name exist
	boolean Pexists;//initialize boolean variable that will notify if the password exists
	boolean Eexists; //initialize boolean variable that will notify if the email exist
	
	//count the amount of error logins for security purposes
	int error = 0;
	
	//for loop to check every spot in the array if the user enter has a match 
	 
	do{
		//reset all the variables if there was an error in at least one of the login credentials
		Uexists = false;
		Pexists = false;
		Eexists = false; 
		
		Scanner input = new Scanner(System.in);
		
		//prompt user to enter their username 
		System.out.println();
		System.out.print("Enter your username: ");
		String username = input.next();
		//for loop to check every spot in the array if the entered user name has a match 
	for(int j = 0; j < login.length; j++) {
		if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {
			Uexists = true; 
			continue;
		}
	}
	
	//prompt the user to enter their password
	System.out.print("Enter your password: "); 
	String password = input.next();
	//for loop to check every spot in the array if the entered user name has a match 
	for(int j = 0; j < login.length; j++) {
		if (login[usertype][j] != null && password.equals(login[usertype][j].getPassword())) {
			Pexists = true; 
			continue;
		}
	}
	
	//Prompt the user to enter the email 
	System.out.print("Enter your email: "); 
	String email = input.next();
	//for loop to check every spot in the array if the entered user name has a match 
	for(int j = 0; j < login.length; j++) {
		if (login[usertype][j] != null && email.equals(login[usertype][j].getEmail())) {
			Eexists = true; 
			continue;
		}
	}
	
	//display an error message for all the conditions where there is an error in the credentials entered.
	if(Uexists == true && Pexists == true && Eexists== false){
		//email is incorrect
		System.out.println("Email incorrect please enter all credentials again correctly.");
		
		//add to error counter
		error++;
	}
	else if(Uexists == true && Pexists == false && Eexists== true) {
		//password is incorrect
		System.out.println("Password incorrect please enter all credentials again correctly.");
		
		//add to error counter
		error++;
	} 
	else if(Uexists == true && Pexists == false && Eexists== false) {
		//password and email incorrect
		System.out.println("Password & Email incorrect please enter all credentials again correctly.");
		
		//add to error counter
		error++;
	} 
	else if(Uexists == false && Pexists == true && Eexists== true) {
		//username incorrect
		System.out.println("Username incorrect please enter all credentials again correctly.");
		
		//add to error counter
		error++;
	}
	else if(Uexists == false && Pexists == true && Eexists== false) {
		//username and email incorrect
		System.out.println("Username & Email incorrect please enter all credentials again correctly.");
		
		//add to error counter
		error++;
	}
	else if(Uexists == false && Pexists == false && Eexists== true) {
		//username and password incorrect
		System.out.println("Username and Password incorrect please enter all credentials again correctly.");
		
		//add to error counter
		error++;
	} 
	else if(Uexists == false && Pexists == false && Eexists== false)
	{
		//username, password, email all incorrect
		System.out.println("All login credentials are incorrect please enter all credentials again correctly.");
		System.out.println("Or please refresh and register in our system.");
		//add to error counter
		error++;
	}
		
	//only display the menu if the user has entered all their credentials correctly
		if(Uexists==true && Pexists == true && Eexists == true) {
			System.out.println("=========================");
			System.out.println("MENU");
			System.out.println("1: Search Herb");
			System.out.println("2: Add Herb, Delete Herb, or Modify Herb");
			System.out.println("3: Modify Profile"); 
			System.out.println("4: Logout");

			System.out.print("Enter the number of your choice: ");
			int menu = input.nextInt(); 

			do {//provide user with choices, do while loop for any improper input 
				switch(menu)
				{
				case 1: search(); //if input is 1 send to search method
				break; 
				case 2: adjustHerb();  //if input is 2 send to adjustHerb
				break; 
				case 3: modifyProfile(login, usertype); //if input is 3 send to modifyProfile method
				break;
				case 4: System.out.println("Loging out of the system now. Goodbye."); 
				System.exit(menu); //close the system
				break;
				default: System.out.println("Not an option, try again");//if the input is not a choice, display error message and provide menu again
				break; 
				}

				
				System.out.println("MENU");
				System.out.println("1: Search Herb");
				System.out.println("2: Add Herb, Delete Herb, or Modify Herb");
				System.out.println("3: Modify Profile"); 
				System.out.println("4: Logout");

				System.out.print("Enter the number of your choice: ");
				menu = input.nextInt();
				
				if(menu == 4)
				{
					System.out.println("Loging out of the system now. Goodbye."); 
					System.exit(menu);
				}
			}while(menu != 4);//menu choices again if they is an improper input.
		}
} while ((Uexists == true && Pexists == true && Eexists== false) || (Uexists == true && Pexists == false && Eexists== true) || (Uexists == true && Pexists == false && Eexists== false) || (Uexists == false && Pexists == true && Eexists== true) || (Uexists == false && Pexists == true && Eexists== false) || (Uexists == false && Pexists == false && Eexists== true) || (Uexists == false && Pexists == false && Eexists== false) && (error < 5));//if the login credentials do not exist then prompt the user to login again	

	//display message if the user fails login attempt 3 times
System.out.println("------------------------------");
System.out.println("Closing System for security purposes, too many error logins. Try again in a couple minutes");

	}//end of herbalistUser method

	
	/*
	 * adminUser method that will prompt the suer to login and provide options they can access
	 * the options that the user has are: modify an users profile, delete an users profile, add an user profile, add a herb and its info, delete a herb adn its info, modify a herbs info, search a herb, log out
	 * the method will also check if the users credentials are valid 
	 * if their are any invalid credentials the user will be prompted to enter their information again
	 * if the user fails 3 input they will be forced to log out
	 */
	public static void adminUser(HerbalistLogin[][] login, int usertype) {//adminUser method
	
		boolean Uexists;//initialize boolean variable that will notify if the username exist
		boolean Pexists;//initialize boolean variable that will notify if the password exists
		boolean Eexists; //initialize boolean variable that will notify if the email exist
		
		//count the amount of error logins for security purposes
		int error = 0;
		
		//for loop to check every spot in the array if the user enter has a match 
		 
		do{
			//reset all the variables if there was an error in at least one of the login credentials
			Uexists = false;
			Pexists = false;
			Eexists = false; 
			
			//prompt user to enter username 
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter your username: ");
			String username = input.next();

			//for loop to check every spot in the array if the entered user name has a match 
		for(int j = 0; j < login.length; j++) {
			if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {
				Uexists = true; 
				continue;
			}
		}
		
		//Prompt the user to enter their password
		System.out.print("Enter your password: "); 
		String password = input.next();
		//for loop to check every spot in the array if the entered password has a match 
		for(int j = 0; j < login.length; j++) {
			if (login[usertype][j] != null && password.equals(login[usertype][j].getPassword())) {
				Pexists = true; 
				continue;
			}
		}
		
		//Prompt the user to enter their email
		System.out.print("Enter your email: "); 
		String email = input.next();
		//for loop to check every spot in the array if the entered email has a match 
		for(int j = 0; j < login.length; j++) {
			if (login[usertype][j] != null && email.equals(login[usertype][j].getEmail())) {
				Eexists = true; 
				continue;
			}		
		}
		
		//display an error message for all the conditions where there is an error in the credentials entered.
		if(Uexists == true && Pexists == true && Eexists== false){
			//email is incorrect
			System.out.println("Email incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		}
		else if(Uexists == true && Pexists == false && Eexists== true) {
			//password is incorrect
			System.out.println("Password incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		} 
		else if(Uexists == true && Pexists == false && Eexists== false) {
			//password and email incorrect
			System.out.println("Password & Email incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		} 
		else if(Uexists == false && Pexists == true && Eexists== true) {
			//username incorrect
			System.out.println("Username incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		}
		else if(Uexists == false && Pexists == true && Eexists== false) {
			//username and email incorrect
			System.out.println("Username & Email incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		}
		else if(Uexists == false && Pexists == false && Eexists== true) {
			//username and password incorrect
			System.out.println("Username and Password incorrect please enter all credentials again correctly.");
			
			//add to error counter
			error++;
		} 
		else if(Uexists == false && Pexists == false && Eexists== false)
		{
			//username, password, email all incorrect
			System.out.println("All login credentials are incorrect please enter all credentials again correctly.");
			System.out.println("Or please refresh and register in our system.");
			//add to error counter
			error++;
		}
			
		//only display the menu if the user has entered all their credentials correctly
			if(Uexists==true && Pexists == true && Eexists == true) {
				System.out.println("MENU");
				System.out.println("____________");
				System.out.println("1 : Modify a Users Profile");
				System.out.println("2 : Delete a Users Profile");
				System.out.println("3 : Add User Profile");
				System.out.println("4 : Add Herb, Delete Herb, or Modify Herb");
				System.out.println("5 : Search for herb");
				System.out.println("6 : Modify Profile");
				System.out.println("7 : Log out");

				System.out.print("Enter the number of your choice: ");
				int menu = input.nextInt(); 

				do {//provide user with choices, do while loop for any improper input 
					switch(menu) 
					{
					case 1: modifyUser(login); //if input is 1 send to modifyUser method
							break;
					case 2: deleteUser(login);//if input is 2 send to deleteUser method
							break;
					case 3: addUser(login);//if input is 3 send to addUser method
							break;
					case 4: adjustHerb(); //if input is 4 send to adjsutHerb method
							break;
					case 5: search();//if input is 5 send to search method
							break;
					case 6: modifyProfile(login, usertype);//if input is 6 send to modifyProfile method
							break;
					case 7: System.out.println("Closing System now. Bye"); //if input is 7 log the user out of the system
							System.exit(menu);
							break;
					default: System.out.println("That is not one of the options, try again.");//if the input is not a choice, display error message and provide menu again 
							break;
					}

					//menu choices again if they is an improper input.
					System.out.println("MENU");
					System.out.println("____________");
					System.out.println("1 : Modify a Users Profile");
					System.out.println("2 : Delete a Users Profile");
					System.out.println("3 : Add User Profile");
					System.out.println("4: Add Herb, Delete Herb, or Modify Herb");
					System.out.println("5 : Search for herb");
					System.out.println("6 : Modify Profile");
					System.out.println("7 : Logout");
					menu = input.nextInt();
					
					if(menu == 7)
					{
						System.out.println("Loging out of the system now. Goodbye."); 
						System.exit(menu);
					}
					
					}while(menu != 7);
			}
	} while ((Uexists == true && Pexists == true && Eexists== false) || (Uexists == true && Pexists == false && Eexists== true) || (Uexists == true && Pexists == false && Eexists== false) || (Uexists == false && Pexists == true && Eexists== true) || (Uexists == false && Pexists == true && Eexists== false) || (Uexists == false && Pexists == false && Eexists== true) || (Uexists == false && Pexists == false && Eexists== false) && (error < 5));//if the login credentials do not exist then prompt the user to login again	

		//display message if the user fails login attempt 3 times
	System.out.println("------------------------------");
	System.out.println("Closing System for security purposes, too many error logins. Try again in a couple minutes");
	}

	
	/*
	 * search method will prompt the user to enter a herbs: name, description, medical use, formula, or symptom. 
	 * the system will display all the information of the searched herb
	 */
	public static void search() {//search method
		Scanner s = new Scanner(System.in);
		
		//four different arrays that will hold different values: name, description, medical use, formula, and symptom
		 String[] herbName={"Chamomile","Echinacea","Feverfew","Ginger","Ginkgo","Saint John's Wort","Valerian"};
                    String[] herbDescrip={"Ananxiolytic and sedative.","Dietary supplement.","Dietary supplement.","Used as a spice and a folk medicine.","Improves blood circulation and acts as an antioxidant.","A flowering plant popular for depression.","A floweing plant popular for relaxation."};
                    String[] medicalUse={"For anxiety and relaxation.","For common cold and other infections.","For migraine, headache prevention, problems with menstruation, rheumatoid arthritis, psoriasis, allergies, asthma, tinnitus (ringing or roaring sounds in the ears), dizziness, nausea, vomiting, and for intestinal parasites.","For motion sickness, morning sickness, colic, upset stomach, gas, diarrhea, irritable bowel syndrome (IBS), and nausea.","For altitude sickness, cerebral vascular insufficiency, cognitive disorders, dementia, dizziness/vertigo","For depression and symptoms that sometimes go along with mood such as nervousness, tiredness, poor appetite, and trouble sleeping.","For sleep disorders, especially insomnia."};
                    String[] formula = {"Dry the flowers up and infuse into hot water to create your tea.","Place echinacea plants (flowers, leaves and roots) within boiled water to create your tea.","Dry the flowers up and infuse into hot water to create your tea.","Cut ginger into pieces and boil with hot water to create your tea.","Take ginkgo leaves and mix with boil water to create your tea.","Place the fresh flowers within hot water to create the tea.","Place valerian within the water to create the tea."};
                    String[] symptom={"Anxiety","Infections","Headaches","Heartburn, Diarrhea, Burping","Dementia, Alzheimer's, Fatigue","Depression","Insomnia, Anxiety"};
                    
                    //Print the list of herbs to the user to search from 
                    System.out.println("List of herbs:");
         //for loop to display all the herbs 
         for(int i=0;i<herbName.length;i++)//list out the name of herbs 
         {
                     System.out.println(herbName[i]);
         }
         
         //prompt the user to enter a name, description, medical use, or symptom of the herb they would like to seach
         System.out.println("Enter either a Herb name, Herb description, Medical Use, Formula or Symptom: ");

         String SearchInput = s.nextLine(); 
         System.out.println("Results:"); //print the results of set herb

         boolean found = false; //boolean value 'found' will indicate if the herb is found
         
         //for loop to check each herb in the array
         for(int i=0;i<herbName.length;i++)
         {
	     if(herbName[i]!=null){//if the herbname is not empty then execute next steps
	    	 		//the array will now check the position of 'i' to see if their are any matches, if there are any matches it will be displayed to the user
                     if(herbName[i].contains(SearchInput) || herbDescrip[i].contains(SearchInput) || medicalUse[i].contains(SearchInput) || formula[i].contains(SearchInput) || symptom[i].contains(SearchInput))
                     {
                                 found=true;//change boolean value to true if the herb is found
                                 System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+ ", Formula: " +formula[i]+ ", Symptom: "+symptom[i]);
                     }               
        
         }
	 }

         if(!found)//if there is no match then the system will display the to the user no match. 
         {
                     System.out.println("No match found.");
         }

	}//end of search method

	
	/*
	 * adjustHerb will provide three options to the user: add a herb and its info, delete a herb and its info, or modify a herb and its info
	 * only administrator users and herbalist users have the power to modify herbs
	 */
	public static void adjustHerb() {//adjustHerb method
		//four different arrays that will hold different values: name, description, medical use, formula, and symptom
		 String[] herbName={"Chamomile","Echinacea","Feverfew","Ginger","Ginkgo","Saint John's Wort","Valerian"};
                    String[] herbDescrip={"Ananxiolytic and sedative.","Dietary supplement.","Dietary supplement.","Used as a spice and a folk medicine.","Improves blood circulation and acts as an antioxidant.","A flowering plant popular for depression.","A floweing plant popular for relaxation."};
                    String[] medicalUse={"For anxiety and relaxation.","For common cold and other infections.","For migraine, headache prevention, problems with menstruation, rheumatoid arthritis, psoriasis, allergies, asthma, tinnitus (ringing or roaring sounds in the ears), dizziness, nausea, vomiting, and for intestinal parasites.","For motion sickness, morning sickness, colic, upset stomach, gas, diarrhea, irritable bowel syndrome (IBS), and nausea.","For altitude sickness, cerebral vascular insufficiency, cognitive disorders, dementia, dizziness/vertigo","For depression and symptoms that sometimes go along with mood such as nervousness, tiredness, poor appetite, and trouble sleeping.","For sleep disorders, especially insomnia."};
                    String[] formula = {"Dry the flowers up and infuse into hot water to create your tea.","Place echinacea plants (flowers, leaves and roots) within boiled water to create your tea.","Dry the flowers up and infuse into hot water to create your tea.","Cut ginger into pieces and boil with hot water to create your tea.","Take ginkgo leaves and mix with boil water to create your tea.","Place the fresh flowers within hot water to create the tea.","Place valerian within the water to create the tea."};
                    String[] symptom={"Anxiety","Infections","Headaches","Heartburn, Diarrhea, Burping","Dementia, Alzheimer's, Fatigue","Depression","Insomnia, Anxiety"};
         System.out.println("List of herbs:");
         
         //for loop that will display each herb's name
         for(int i=0;i<herbName.length;i++)
         {
                     System.out.println(herbName[i]);
         }

         boolean bCont=true;

         while  (bCont)
         {
        	 		//Prompt the user to select a choice on whether they would like to add, delete or modify a herb's info. Also an option to exit.
                     System.out.println("Please choose an operation: (case-sensitive) \n 1) Type 'Add' to add a new herb. \n 2) Type 'Modify' to modify an existing herb. \n 3) Type 'Delete' to delete an existing herb. \n 4) Type 'End' to exit.");
                     Scanner s=new Scanner(System.in);
                     String input=s.nextLine();

                     switch(input)
                     {
                     			//if the user selects "Add" they will be given all the prompts to enter information about herb
                                 case "Add":
                                 System.out.println("Please enter the details of the new herb.");
                                 System.out.println("Name:");
                                 String name =s.nextLine();
                                 System.out.println("Description:");
                                 String desc =s.nextLine();
                                 System.out.println("Medical use:");
                                 String gen =s.nextLine();
                                 System.out.println("Formula:");
                                 String form = s.nextLine();
                                 System.out.println("Symptoms:");
                                 String nSym =s.nextLine();
                                 herbName= incArray(herbName,1); //herbName will be sent to incArray method
                                 herbDescrip=incArray(herbDescrip,1); //herbDescrip will be sent to incArray method
                                 medicalUse=incArray(medicalUse,1); //medicalUse will be sent to incArray method
                                 formula = incArray(formula, 1);//formula will be sent to incArray method
                                 symptom=incArray(symptom,1); //symptom will be sent to incArray method
                                 herbName[herbName.length-1]=name;
                                 herbDescrip[herbDescrip.length-1]=desc;
                                 medicalUse[medicalUse.length-1]=gen;
                                 formula[formula.length-1]=form;
                                 symptom[symptom.length-1]=nSym;
                                 System.out.println("Added Successfully."); //once the information is entered a message will be displayed

                                 System.out.println("\nList of herbs:");//the system will display the list of herbs again
                                 
                                 //display all herbs and new one as well 
                                 for(int i=0;i<herbName.length;i++)
                                 {
                                             if(herbName[i]!=null)
                                            	 System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+ ", Formula: " +formula[i]+ ", Symptom: "+symptom[i]);
                                 }

                                 break;
                                 //if the user select "Modify" they will be asked the name of the herb they would like to modify
                                 case "Modify":
                                 System.out.println("Please enter the name of the herb you wish to modify.");
                                 String in= s.nextLine();
                                 
                                 //checek through all the herbs if there is a match to the name inputted 
                                 for(int i=0;i<herbName.length;i++)
                                 {
                                             if(in.equals(herbName[i]))
                                             {
                                            	 		//Prompt the user to enter what they would like to modify about the herb
                                                         System.out.println("Please enter what you'd like to modify about this herb: \n Type 1 for herb name. \n Type 2 for symptom(s). \n Type 3 for the herb description. \n Type 4 for medical use. \n Type 5 for formula.");
                                                         try
                                                         {  
                                                                     int ch=Integer.parseInt(s.nextLine());//make sure the entered value is an integer
                                                                     if(ch==1)//if input is 1 then the name will be changed by user
                                                                     {
                                                                                 System.out.println("Enter the new herb name:");
                                                                                 String newName= s.nextLine();
                                                                                 herbName[i]=newName;//save into array
                                                                     }
                                                                     else if(ch==2)//if input is 2 then the symptom will be changed by user
                                                                     {
                                                                                 System.out.println("Enter the new symptom(s):");
                                                                                 String newSym= s.nextLine();
                                                                                 try
                                                                                 {
                                                                                             symptom[i]=newSym;//save into array

                                                                                 }catch(Exception ex){};//if error occurs catch it

                                                                     }
                                                                     else if(ch==3)//if input is 3 then the description will be changed by the user
                                                                     {
                                                                                 System.out.println("Enter the new herb description:");
                                                                                 String newDesc= s.nextLine();
                                                                                 herbDescrip[i]=newDesc;//save into array
                                                                     }
                                                                     else if(ch==4)//if input is 4 then the medical use will be changed by the user
                                                                     {
                                                                                 System.out.println("Enter the new medical use data:");
                                                                                 String newUse = s.nextLine();
                                                                                 medicalUse[i] = newUse;
                                                                     }
                                                                     else if(ch==5)
                                                                     {
                                                                    	 System.out.println("Enter the new formula:");
                                                                    	 String newForm = s.nextLine();
                                                                    	 formula[i] = newForm;
                                                                     }
                                                         }catch(Exception ex){}
                                             }
                                             System.out.println();
                                 }

                                 System.out.println("\nList of herbs:"); //once completed the herbs will be listed once again 

                                 for(int i=0;i<herbName.length;i++)
                                 {
                                             if(herbName[i]!=null)
                                            	 System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+ ", Formula: " +formula[i]+ ", Symptom: "+symptom[i]);
                                 }

                                 break;
                                 //if the user selects "Delete" then the user will delete the herb of their choice
                                 case "Delete":
                                 System.out.println("Please enter the name of the herb you want to delete.");
                                 String inp= s.nextLine();
                                 
                                 //for loop to find the match of the name that is input
                                 for(int i=0;i<herbName.length;i++)
                                 {
                                	 		//match found, set all values to null 
                                             if(inp.equals(herbName[i]))
                                             {
                                                         herbName[i]=null;
                                                         symptom[i]=null;
                                                         herbDescrip[i]=null;
                                                         formula[i] = null;
                                                         medicalUse[i]=null;
                                                         System.out.println("Delete success.");
                                             }
                                 }
                                 
                                 //Display all herbs to user
                                 System.out.println("\nList of herbs:");

                                 for(int i=0;i<herbName.length;i++)
                                 {
                                             if(herbName[i]!=null)
                                            	 System.out.println(herbName[i]+", Medical use: "+medicalUse[i]+", Description: "+herbDescrip[i]+ ", Formula: " +formula[i]+ ", Symptom: "+symptom[i]);
                                 }
                                 
                                 break;
                                 //if 'End' is selected the user will be taken out of the adjustHerb method 
                                 case "End":
                                 System.out.println("Terminated.\n");
                                 bCont=false;
                                 break;
                                 default:
                                 break;

                     }
         }
}//end of adjustHerb method

	
	/*
	 * incArray is a method that increases the array size of a certain herb attribute, when adding a new herb
	 * the method has the parameter of which array needs increasing, and how many it needs to be increased by
	 */
	public static String[] incArray(String[] theArray, int increaseBy) {//incArray method
         int i = theArray.length; //set value of i to array length  
         int n = ++i;  //increase before any execution 
         String[] newArray = new String[n];  //new array will replace the old array

         for(int cnt=0;cnt<theArray.length;cnt++)//increase the value in the array 
         {  
                     newArray[cnt] = theArray[cnt];  //the newArray will add however many spaces to the current Array
         }  
         return newArray;  //return newArray to take place of old array
}

	
	/*
	 * modifyProfile will provide the user with options to adjust their: username, password, or email
	 * the program will check if the username is valid in with the current user
	 */
	public static void modifyProfile(HerbalistLogin[][] login, int usertype) {//modifyProfile method
		Scanner s=new Scanner(System.in);
		//user will be asked to enter their username 
		System.out.print("Enter current username: ");
		String username = s.next(); 
		
		//system will check if the user name is has a match within the system
		for(int j = 0; j < login.length; j++) {
			if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {

				//prompt the user to enter what they would like to do with their account 
				System.out.println("What would you like to change about your profile");
				System.out.println("1. User name"); 
				System.out.println("2. password"); 
				System.out.println("3. email"); 
				System.out.println("Enter Input: ");
				Scanner input = new Scanner(System.in);
				int ch = input.nextInt();

				try {
					
					if(ch == 1) {//if the user inputs 1, the system will prompt the user to enter a new username, and display to them once input
						
						HerbalistLogin modUsername = new HerbalistLogin(null, login[usertype][j].getPassword() , login[usertype][j].getEmail());
						modUsername.changeUsername();	
						System.out.println("New Credintials: " + modUsername.printDetails());
						login[usertype][j]=modUsername;
						
					}
					else if(ch == 2) {//if the user inputs 2, the system will prompt the user to enter a new password, and display to them once input
						HerbalistLogin modPassword = new HerbalistLogin(login[usertype][j].getUsername() , null, login[usertype][j].getEmail());
						modPassword.changePassword();	
						System.out.println("New Credintials: " + modPassword.printDetails());
						login[usertype][j]=modPassword;
					}
					else if(ch == 3) {//if the user inputs 3, the system will prompt the user to enter a new email, and display to them once input
						HerbalistLogin modEmail = new HerbalistLogin(login[usertype][j].getUsername() , login[usertype][j].getPassword(), null);
						modEmail.changeEmail();	
						System.out.println("New Credintials: " + modEmail.printDetails());
						login[usertype][j]=modEmail;
					}
					}catch(Exception ex) {}//if there is an error catch it
			}
			else//if an invalid username is input the system will display a message
				System.out.println("Invalid input."); 
				


		}

	}//end of modifyProfile method

	
	/*
	 * addUser method is for admins only
	 *prompt the user to enter credentials of a normal user, herbalist user, or admin user
	 */
	private static void addUser(HerbalistLogin[][] login) {//addUser method
		Scanner input = new Scanner(System.in);
		int usertype;
		
		boolean exists = false; 
		do {//ask user what type of user they would like to add
		  System.out.println("Select a User Type you would like to add");
		  System.out.println("Enter '0' for normal user");
		  System.out.println("Enter '1' for herbalist user");
		  System.out.println("Enter '2' for admin user");
		  System.out.println("User Type:");
		  usertype = input.nextInt();
		}while(usertype < 0 || usertype > 2);
		
		//provide a username to check if the user name is in the system already 
		System.out.println("Enter username: "); 
		String username = input.next();
		
		//for loop to check every spot in the array if the user enter has a match 
		for(int j = 0; j < login.length; j++) {//if there is a match display to the user that there is already an account with this name
			if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {
				System.out.println("User is in the system already."); 
				return; 
			}
			else {//HerbalistLogin class will prompt user to inputdetails for the new user
				HerbalistLogin login1 = new HerbalistLogin(username, null, null); 
				login1.inputDetails();
				System.out.println("Input complete."); 
				System.out.println(login1.printDetails()); //HerblistLogin will print the new user and its credentials 
				login[usertype][j] = login1;//store the user into the array 
				return;
			}
		}
		
	}//end of addUser method
	
	
	/*
	 * deleteUser method is for admins only
	 * prompt the user if they want to delete a users account from the system
	 * an admin can not delete another admin
	 */
	private static void deleteUser(HerbalistLogin[][] login) {//deleteUser method
		Scanner input = new Scanner(System.in);
		//Prompt the user on what user they would like to delete
		System.out.println("Please enter the user type you want to delete. \n 0 for normal user. \n 1 for herbalist user."); 
		int usertype = input.nextInt();
		System.out.println("Please enter the username you want to delete");
		String username = input.next(); 

		for(int j = 0; j < login.length; j++) {//check if ther user exists
			if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {
				HerbalistLogin deleteuser = new HerbalistLogin(null, null, null);//set all values to null 
				System.out.println("New Credintials: " + deleteuser.printDetails());//print out the users details which will be nothing 
				login[usertype][j] = deleteuser; //update array with deleted user
			}
	   }
	}//end of deleteUser method

	
	/*
	 * modifyUser method allows admins to adjust other users credentials 
	 * changing their username password and email 
	 */
	private static void modifyUser(HerbalistLogin[][] login) {//modifyUser method
	Scanner input = new Scanner(System.in);
	//Prompt user to enter what type of user they are adjusting 
	System.out.println("Enter 0 to edit a normal user profile");
	System.out.println("Enter 1 to edit a herbalist user profile");
	int usertype = input.nextInt(); 
	
	//enter the username of the user tehy wish to modify
	System.out.print("Enter the user's current username: ");
	String username = input.next(); 

	for(int j = 0; j < login.length; j++) {//system will check in the array for the user
		if (login[usertype][j] != null && username.equals(login[usertype][j].getUsername())) {

			//prompt user to choose what they would like to do with the user
			System.out.println("What would you like to change about the user's credentials");
			System.out.println("1. Username"); 
			System.out.println("2. Password"); 
			System.out.println("3. Email"); 
			System.out.println("Enter Input: ");
			Scanner s = new Scanner(System.in);
			int ch = s.nextInt();


	try {
		
		if(ch == 1) {//if user inputs 1, they will change their username 
			
			HerbalistLogin modUsername = new HerbalistLogin(null, login[usertype][j].getPassword() , login[usertype][j].getEmail());
			modUsername.changeUsername(); //HerbalistLogin will prompt the user for the new username
			System.out.println("New Credintials: " + modUsername.printDetails()); //display the users new credentials 
			login[usertype][j]=modUsername; //enter the user's new username into the array
			
		}
		else if(ch == 2) {//if user inputs 2, they will change their password 
			HerbalistLogin modPassword = new HerbalistLogin(login[usertype][j].getUsername() , null, login[usertype][j].getEmail());
			modPassword.changePassword();	//HerbalistLogin will prompt the user for the new password
			System.out.println("New Credintials: " + modPassword.printDetails()); //display the users new credentials 
			login[usertype][j]=modPassword; //enter the user's new password into the array 
		}
		else if(ch == 3) {//if user inputs 3, they will change their email 
			HerbalistLogin modEmail = new HerbalistLogin(login[usertype][j].getUsername() , login[usertype][j].getPassword(), null);
			modEmail.changeEmail();	//HerbalistLogin will prompt the suer for the new password 
			System.out.println("New Credintials: " + modEmail.printDetails()); //display the users new crednetials 
			login[usertype][j]=modEmail; //enter the suer's new email into the array 
		}
		}catch(Exception ex) {}//catch if there is an error 
	}
   }
  }//end of modifyUser()
	
}//end of system
