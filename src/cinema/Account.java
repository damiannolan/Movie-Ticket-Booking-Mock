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
