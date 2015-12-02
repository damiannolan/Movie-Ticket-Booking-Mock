package cinema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Admin extends Account 
{

	public Admin() 
	{
		super();
	}

	public Admin(String username, String password) 
	{
		super(username, password);
	}
	
	//login()
	@Override
	public boolean login(String username, String password)
	{
		boolean found;
		
		if(username.equals(this.username) && password.equals(this.password))
		{
			found = true;
			//System.out.println("Login Successful");
		}
		else
		{
			found = false;
			//System.out.println("Login failed, please try again");
		}
		
		return found;
	}
	
	@Override
	public boolean logout()
	{
		return false;
	}
	
	public void addMovie(String genre, String name, int runtime) throws IOException
	{
		PrintWriter movieFile = new PrintWriter(new FileWriter("movies.txt", true));
		
		movieFile.println("\n" + genre + " " + runtime + " " + name);
		
		movieFile.close();
		
		System.out.println("Added Movie. movies.txt has been updated");
	}

}
