package theHerbalistSystem;
import java.util.*;
public class SystemLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int usertype = input.nextInt();
		
		if (usertype == 0 ) {
		normalUserMenu();
		}
		else if (usertype == 1) {
		herbalistUserMenu();
		}
		
		else if (usertype == 2) {
		adminUserMenu();
		}

	}

	public static void normalUserMenu() {
		//menu screen for regular user
		System.out.println("MENU");
		System.out.println("____________");
		System.out.println("1 : Modify Profile");
		System.out.println("2 : Search for herb");
		System.out.println("3 : Log out");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int menu = input.nextInt();
		
		//menu is looped until the user enters 3 which logs them out and stops the system.
		do {
		
		switch(menu) 
		{
		case 1: modifyProfile(); 
				break;
		case 2: searchForHerb(); 
				break;
		case 3: System.out.println("Closing System now. Bye"); //logout menu takes you back to main menue of system
				continue;
		default: System.out.println("That is not one of the options, try again."); 
				break;
		}
		
		System.out.println("MENU");
		System.out.println("____________");
		System.out.println("1 : Modify Profile");
		System.out.println("2 : Search for herb");
		System.out.println("3 : Log out");
		System.out.print("Enter a number: ");
		menu = input.nextInt();
		}while(menu != 3);
	}
	
	public static void herbalistUserMenu() {
		//menu for a herbalist user
		System.out.println("MENU");
		System.out.println("____________");
		System.out.println("1 : Modify Profile");
		System.out.println("2 : Add Herb");
		System.out.println("3 : Modify Herb");
		System.out.println("4 : Delete Herb");
		System.out.println("5 : Search for herb");
		System.out.println("6 : Log out");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int menu = input.nextInt();
		
		//menu is looped until the user enters 3 which logs them out and stops the system.
		do {
		
		switch(menu) 
		{
		case 1: modifyProfile(); 
				break;
		case 2: addHerb();
				break;
		case 3: modifyHerb();
				break;
		case 4: deleteHerb();
				break;
		case 5: searchForHerb(); 
				break;
		case 6: System.out.println("Closing System now. Bye"); //logout menu takes you back to main menue of system
				continue;
		default: System.out.println("That is not one of the options, try again."); 
				break;
		}
		
		System.out.println("MENU");
		System.out.println("____________");
		System.out.println("1 : Modify Profile");
		System.out.println("2 : Add Herb");
		System.out.println("3 : Modify Herb");
		System.out.println("4 : Delete Herb");
		System.out.println("5 : Search for herb");
		System.out.println(" : Log out");
		menu = input.nextInt();
		}while(menu != 6
				);
		
	}
	
	public static void adminUserMenu() {
		//menu for a admin  user
				System.out.println("MENU");
				System.out.println("____________");
				System.out.println("1 : Modify User Profile");
				System.out.println("2 : Delete User Profile");
				System.out.println("3 : Add User Profile");
				System.out.println("4 : Add Herb");
				System.out.println("5 : Modify Herb");
				System.out.println("6 : Delete Herb");
				System.out.println("7 : Search for herb");
				System.out.println("8 : Log out");
				
				Scanner input = new Scanner(System.in);
				System.out.print("Enter a number: ");
				int menu = input.nextInt();
				
				//menu is looped until the user enters 3 which logs them out and stops the system.
				do {
				
				switch(menu) 
				{
				case 1: modifyUserProfile(); 
						break;
				case 2: deleteUserProfile();
						break;
				case 3: addUserProfile();
						break;
				case 4: addHerb();
						break;
				case 5: modifyHerb(); 
						break;
				case 6: deleteHerb();
						break;
				case 7: searchForHerb();
						break;
				case 8: System.out.println("Closing System now. Bye"); //logout menu takes you back to main menue of system
						continue;
				default: System.out.println("That is not one of the options, try again."); 
						break;
				}
				
				System.out.println("MENU");
				System.out.println("____________");
				System.out.println("1 : Modify User Profile");
				System.out.println("2 : Delete User Profile");
				System.out.println("3 : Add User Profile");
				System.out.println("4 : Add Herb");
				System.out.println("5 : Modify Herb");
				System.out.println("6 : Delete Herb");
				System.out.println("7 : Search for herb");
				System.out.println("8 : Log out");
				menu = input.nextInt();
				}while(menu != 8);
	}
  
	private static void modifyUserProfile() {
		// TODO Auto-generated method stub
		 System.out.println("test editing user profile from admin user");
		  return;
	}

	private static void addUserProfile() {
		// TODO Auto-generated method stub
		 System.out.println("test adding user profile from admin user");
		  return;
	}

	private static void deleteUserProfile() {
		// TODO Auto-generated method stub
		 System.out.println("test deleting user profile from admin user");
		  return;
	}

	private static void deleteHerb() {
		// TODO Auto-generated method stub
		 System.out.println("test deleteing herb from herbalist user");
		  return;
	}

private static void modifyHerb() {
		// TODO Auto-generated method stub
	 System.out.println("test editing herb from herbalist user");
	  return;
	}

private static void addHerb() {
		// TODO Auto-generated method stub
	 System.out.println("test adding herb from herbalist user");
	  return;
	}

public static void modifyProfile()
  {
	  System.out.println("test mod normal user profile");
	  return;
  }
  
  public static void searchForHerb()
  {
	  System.out.println("test search for herb ");
	  return;
  }

}
