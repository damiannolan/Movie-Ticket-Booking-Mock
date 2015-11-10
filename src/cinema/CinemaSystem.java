package cinema;

import java.io.*;
import java.util.*;

public class CinemaSystem 
{
	static final int MAX_USERS = 10;

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		// Scanner for user input
		Scanner console = new Scanner(System.in);

		// Files
	

		// Variables
		int option;
		int count = 0;
		String username, pass;
		boolean found = false;
		int currentUser = 0;
		
		Customer [] c = new Customer[MAX_USERS];

		// Header
		System.out.println("******************Welcome******************");
		System.out.println("********************To*********************");
		System.out.println("**************Kryptic Cinemas**************");

		do 
		{
			System.out.println("\nSignup (1), Login (2), Admin (3), Quit (-1)");
			System.out.print("Please choose an option: ");
			option = console.nextInt();
		} while (option != 1 && option != 2 && option != 3 && option != -1);

		while (option != -1) 
		{
			switch (option) {
			case 1:
				System.out.println("\n=====Sign Up=====");
				//Using new PrintWriter(newFileWriter("file", true)) to append text
				//Must include throws IOExecption
				PrintWriter usersFileOut = new PrintWriter(new FileWriter("userAccountFile.txt", true));

				Customer customer = new Customer();

				System.out.println(customer.toString());
				usersFileOut.println(customer.toPrintFile());

				System.out.println("\nWelcome to Kryptic Cinemas. Your user information has been saved.\nPlease Login to continue.");
				usersFileOut.close();
				break;
			case 2:
				System.out.println("\n=====Login======");
				Scanner usersFileIn = new Scanner(new FileReader("userAccountFile.txt"));
				
				//Populate Customer Array with user file contents
				//============================================================
				//MAYBE MOVE THIS CODE TO BEGINNING AND USE EXCEPTION HANDLING
				count = 0;
				while (usersFileIn.hasNext()) 
				{
					c[count] = new Customer(usersFileIn.next(), usersFileIn.next(), usersFileIn.next(), usersFileIn.next(), usersFileIn.nextInt(), usersFileIn.nextInt(), usersFileIn.nextLine());
					
					count++;
				} //end while
				System.out.println("Number of accounts: " + count);
				usersFileIn.close();
				//MAYBE MOVE THIS CODE TO BEGINNING AND USE EXCEPTION HANDLING
				//============================================================
				
				System.out.print("Enter username: ");
				username = console.next();
				System.out.print("Enter password: ");
				pass = console.next();
				
				int i = -1;
				
				while(found == false && i < count)
				{
					i++;
					found = c[i].login(username, pass);
					System.out.println(found);
								
				} //end while
				
				if(found)
				{
					System.out.println("Login Successful!");
					currentUser = i;
				}
				else
				{
					System.out.println("Login failed! Please try again.");
				} //end if/else
				
				System.out.println("\n" + c[currentUser].greeting());
				System.out.println(c[currentUser].toString());
				
				break;
			case 3:
				break;
			default:
			} //end switch

			do 
			{
				System.out.println("\nSignup (1), Login (2), Admin (3), Quit (-1)");
				System.out.print("Please choose an option: ");
				option = console.nextInt();
			} while (option != 1 && option != 2 && option != 3 && option != -1);

		} //end while (option != -1)

		// usersFile.close();

	} // main

}
