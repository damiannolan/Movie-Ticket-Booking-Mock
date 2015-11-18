package cinema;

import java.io.*;
import java.util.*;

public class CinemaSystem 
{
	static final int MAX_USERS = 10;
	static final int MAX_MOVIES = 10;

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		// Scanner for user input
		Scanner console = new Scanner(System.in);

		// Files
	

		// Variables
		int option, choice;
		int count = 0;
		String username, pass;
		boolean found = false;
		int currentUser = 0;
		int movieCount = 0;
		
		Customer [] c = new Customer[MAX_USERS];
		Movie [] movies = new Movie [MAX_MOVIES];

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
				//MAYBE MOVE THIS CODE
				count = 0;
				while (usersFileIn.hasNext()) 
				{
					c[count] = new Customer(usersFileIn.next(), usersFileIn.next(), usersFileIn.next(), usersFileIn.next(), usersFileIn.nextInt(), usersFileIn.nextLine());
					
					count++;
				} //end while
				System.out.println("Number of accounts: " + count);
				usersFileIn.close();
				//MAYBE MOVE THIS CODE
				//============================================================
				
				System.out.print("Enter username: ");
				username = console.next();
				System.out.print("Enter password: ");
				pass = console.next();
				
				int i = -1;
				
				while(found == false && i < (count -1))
				{
					i++;
					found = c[i].login(username, pass);
					//System.out.println(found);
												
				} //end while
				
				if(found)
				{
					System.out.println("Login Successful!");
					currentUser = i;
					
					System.out.println("\n" + c[i].greeting());
					
					//Populate Movies Array
					Scanner movieFile = new Scanner(new FileReader("movies.txt"));
					
					movieCount = 0;
					while(movieFile.hasNext())
					{
						movies[movieCount] = new Movie(movieFile.next(), movieFile.nextInt(), movieFile.nextLine());
						
						movieCount++;
					}
					
					System.out.println("\nShow Customer Details (1), Display Movies (2), Order Ticket (3), Logout (-1)");
					System.out.print("Please choose an option: ");
					choice = console.nextInt();	
					
					while(choice != -1)
					{
						switch(choice)
						{
							case 1:
								//Show customer details
								
								System.out.println(c[currentUser].toString());
								break;
							case 2:
								//Display movies on show
								
								for(i = 0; i < movieCount; i++)
								{
									movies[i].display();
									//System.out.println(movies[i].getClass());
								}
								break;
							case 3:
								//Order a ticket
								int movieChoice;
								
								for(i = 0; i < movieCount; i++)
								{
									//change getTitle() add remaintickets?
									System.out.println((i + 1) + " " + movies[i].getTitle());
								}
								
								System.out.print("\n\tPlease choose the corresponding number to your movie choice: ");
								movieChoice = console.nextInt();
								
								System.out.print("\n\tPlease choose Adult(0), Student(1) or Child(2): ");
								TicketType ticketType = TicketType.values()[console.nextInt()];
								
								Ticket ticket = BookingAgent.purchaseTicket(c[currentUser], movies[movieChoice - 1], ticketType);
								
								System.out.println("\nTicket Purhcased for:\n" + ticket.toString());
								break;
							default:
						}
						
						System.out.println("\nShow Customer Details (1), Display Movies (2), Order Ticket (3), Logout (-1)");
						System.out.print("Please choose an option: ");
						choice = console.nextInt();
					} //end choice while
					
					found = c[currentUser].logout();
					System.out.println("User has been logged out. Goodbye!");
					
				}
				else
				{
					System.out.println("Login failed! Please try again.");
				} //end if/else	
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
