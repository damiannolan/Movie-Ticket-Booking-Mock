package cinema;

import java.io.*;
import java.util.*;

public class CinemaSystem 
{
	static final int MAX_USERS = 10;
	static final int MAX_MOVIES = 10;
	static final int MAX_ADMINS = 3;

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		// Scanner for user input
		Scanner console = new Scanner(System.in);

		// Variables
		int option, choice;
		int count = 0;
		String username, pass;
		boolean found = false;
		int currentUser = 0;
		int movieCount = 0;
		int ticketChoice;
		String movieGenre, movieName;
		int movieRuntime;
		
		//Object arrays
		Customer [] c = new Customer[MAX_USERS];
		Movie [] movies = new Movie[MAX_MOVIES];
		Admin [] admin = new Admin[MAX_ADMINS];

		// Header
		System.out.println("******************Welcome******************");
		System.out.println("********************To*********************");
		System.out.println("**************Kryptic Cinemas**************");
		
		//Initialize ticket prices and display
		BookingAgent.initTicketPrices();
		System.out.println("Ticket prices are as follows: ");
		BookingAgent.showTicketPrices();

		//Initial do/while
		do 
		{
			System.out.println("\nSignup (1), Login (2), Admin (3), Quit (-1)");
			System.out.print("Please choose an option: ");
			option = console.nextInt();
		} while (option != 1 && option != 2 && option != 3 && option != -1);

		while (option != -1) 
		{
			switch (option) 
			{
				case 1:
					//Sign up for new users
					System.out.println("\n=====Sign Up=====");
				
					//Using new PrintWriter(newFileWriter("file", true)) to append text
					//Must include throws IOExecption
					PrintWriter usersFileOut = new PrintWriter(new FileWriter("userAccountFile.txt", true));
					
					//Calling the new Customer() constructor the user will be prompted to enter their details
					Customer customer = new Customer();
	
					//Customer details will be stored in the file - userAccountFile.txt
					System.out.println(customer.toString());
					usersFileOut.println(customer.toPrintFile());
	
					System.out.println("\nWelcome to Kryptic Cinemas. Your user information has been saved.\nPlease Login to continue.");
					
					//File is closed
					usersFileOut.close();
					break;
				case 2:
					//Login for existing users
					System.out.println("\n=====User Login======");
				
					Scanner usersFileIn = new Scanner(new FileReader("userAccountFile.txt"));
					
					//Populate Customer object Array with userAccountFile contents
					count = 0;
					while (usersFileIn.hasNext()) 
					{
						c[count] = new Customer(usersFileIn.next(), usersFileIn.next(), usersFileIn.next(), usersFileIn.next(), usersFileIn.nextInt(), usersFileIn.nextLine());
						
						count++;
					} //end while
					System.out.println("Number of accounts: " + count);
					
					//File is closed
					usersFileIn.close();
					
					//Prompt the current user to enter a username and password
					System.out.print("Enter username: ");
					username = console.next();
					System.out.print("Enter password: ");
					pass = console.next();
					
					//Looping through the customer object array
					//Attempt to login() using the details just entered from the user
					int i = -1;				
					while(found == false && i < (count -1))
					{
						i++;
						found = c[i].login(username, pass);
						//System.out.println(found);
													
					} //end while
					
					//If the details are correct you will be successfully logged in
					if(found)
					{
						System.out.println("Login Successful!");
						currentUser = i;
						
						System.out.println("\n" + c[i].greeting());
						
						//Populate Movies Object Array from the file - movies.txt
						Scanner movieFile = new Scanner(new FileReader("movies.txt"));
						
						movieCount = 0;
						while(movieFile.hasNext())
						{
							movies[movieCount] = new Movie(movieFile.next(), movieFile.nextInt(), movieFile.nextLine());
							
							movieCount++;
						}
						
						//Close movieFile
						movieFile.close();
						
						//Prompt the user for the next step
						//Initial read
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
									}
									break;
								case 3:
									//Book a ticket
									int movieChoice;
									
									for(i = 0; i < movieCount; i++)
									{
										//.list() the movies so user can choose
										System.out.println((i + 1) + " " + movies[i].list());
									}
									
									//Choose the movie
									System.out.print("\n\tPlease choose the corresponding number to your movie choice: ");
									movieChoice = console.nextInt();
									
									//Choose ticket type using eNum
									do
									{
										System.out.print("\n\tPlease choose Adult(0), Student(1) or Child(2): ");
										ticketChoice = console.nextInt();
									} while (ticketChoice != 0 && ticketChoice != 1 && ticketChoice != 2);
									TicketType ticketType = TicketType.values()[ticketChoice];
									
									//Book the ticket via the BookingAgent which returns a new ticket object
									Ticket ticket = BookingAgent.purchaseTicket(c[currentUser], movies[movieChoice - 1], ticketType);
									System.out.println("\nTicket Purhcased for:\n" + ticket.toString());
									
									//Imagination land - this is the ticket being printed from a machine. In this case, to a file.
									ticket.printToFile();
									
									//Tickets print to file - tickets.txt
									System.out.println("\nYour Ticket has been Printed");
									break;
								default:
							}
							
							//Subsequent Read
							System.out.println("\nShow Customer Details (1), Display Movies (2), Order Ticket (3), Logout (-1)");
							System.out.print("Please choose an option: ");
							choice = console.nextInt();
						} //end choice while
						
						//Log the user out - Setting the found property back to false
						found = c[currentUser].logout();
						System.out.println("User has been logged out. Goodbye!");
						
					} // END if (found) block
					else
					{
						System.out.println("Login failed! Please try again.");
					} //end if/else	
					break;
				case 3:
					//An Admin can add movies to the movies.txt and change ticket prices for adults, students and children.
					Scanner adminFile = new Scanner(new FileReader("admin.txt"));
				
					//Populate Admin object Array with adminFile contents
					count = 0;
					while (adminFile.hasNext()) 
					{
						admin[count] = new Admin(adminFile.next(), adminFile.next());
						
						count++;
					} //end while
					System.out.println("Number of Admins: " + count);
				
					adminFile.close();
				
					/*
					 * Prompt for admin username and password
					 * Login for Admin
					 * 
					 * username = admin
					 * pass = adminpass
					 * 
					 */
					System.out.print("Enter Admin username: ");
					username = console.next();
					System.out.print("Enter password: ");
					pass = console.next();
					
					//Looping through the admin object array
					//Attempt to login() using the user name and pass
					i = -1;				
					while(found == false && i < (count -1))
					{
						i++;
						found = admin[i].login(username, pass);
						//System.out.println(found);
													
					} //end while
					
					if(found)
					{
						System.out.println("Login Successful");
						currentUser = i;
						
						//Initial Read
						System.out.println("\nAdd Movie (1), Change Ticket Prices (2), Logout (-1)");
						System.out.print("Please choose an option: ");
						choice = console.nextInt();
						
						while (choice != -1)
						{
							switch(choice)
							{
								case 1:
									//Add movie
									//Take in movie info
									System.out.print("Enter movie genre: ");
									movieGenre = console.next();
									
									//flush buffer
									console.nextLine();
	
									System.out.print("Enter movie name: ");
									movieName = console.nextLine();
									
									System.out.print("Enter movie runtime: ");
									movieRuntime = console.nextInt();
									
									//Use the addMovie() method to write it to the movies.txt file
									admin[currentUser].addMovie(movieGenre, movieName, movieRuntime);
									break;
								case 2:
									//Change Ticket Prices
									BookingAgent.showTicketPrices();
									//Only temporarily changes ticket prices because if program is restarted they will
									//be re-initialised from the initTicketPrices() method on BookingAgent
									
									System.out.println("\nTemporarily change ticket price for: Adult(1), Student(2), Child(3)");
									System.out.print("Enter option: ");
									option = console.nextInt();
									
									switch(option)
									{
										case 1:
											//Change Adult ticket price
											System.out.print("Enter new price for Adult: ");
											BookingAgent.ADULTPRICE = console.nextDouble();
											
											System.out.println("New Adult price = " + BookingAgent.ADULTPRICE);
											break;
										case 2:
											//Change Student ticket price
											System.out.print("Enter new price for Student: ");
											BookingAgent.STUDENTPRICE = console.nextDouble();
											
											System.out.println("New Student price = " + BookingAgent.STUDENTPRICE);
											break;
										case 3:
											//Change Child ticket price
											System.out.print("Enter new price for Child: ");
											BookingAgent.CHILDPRICE = console.nextDouble();
											
											System.out.println("New Child price = " + BookingAgent.CHILDPRICE);
											break;
										default:
									
									} //END Ticket Price Switch
									break;
								default:		
							} //END choice Switch 
							
							//Subsequent Read
							System.out.println("\nAdd Movie (1), Change Ticket Prices (2), Logout (-1)");
							System.out.print("Please choose an option: ");
							choice = console.nextInt();
						}// end choice while
						
						found = admin[currentUser].logout();
						System.out.println("User has been logged out. Goodbye!");
					}
					else
					{
						System.out.println("\nLogin failed! Please use a valid Admin login");
					}
					
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


	} // END main
} // END CLASS - CinemaSystem
