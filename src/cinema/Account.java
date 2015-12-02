package cinema;

import java.util.*;

public abstract class Account 
{
	Scanner console = new Scanner(System.in);
	
	String username;
	String password;
	
	public Account ()
	{
		getUsername();
		getPassword();
	}
	
	public Account (String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	//abstract login method
	public abstract boolean login(String username, String password);
	
	//abstract logout method
	public abstract boolean logout();
	
	public String getUsername ()
	{
		System.out.print("Enter Username: ");
		username = console.next();
		
		return username;
	}
	
	public String getPassword ()
	{
		System.out.print("Enter Password: ");
		password = console.next();
		
		return password;
	}
}
