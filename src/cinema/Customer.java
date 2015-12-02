package cinema;

public class Customer extends Account
{
	String firstName;
	String lastName;
	int age;
	String email;
	
	public Customer()
	{
		super();
		setFirstName();
		setLastName();
		setAge();
		setEmail();	
	}

	public Customer(String username, String password) 
	{
		super(username, password);
	}
	
	public Customer(String username, String password, String firstName, String lastName, int age, String email)
	{
		//Calling constructor using this()
		this(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}
	
	public String setFirstName()
	{
		System.out.print("Enter first name: ");
		firstName = console.next();
		
		return firstName;
	}
	
	public String setLastName()
	{
		System.out.print("Enter last name: ");
		lastName = console.next();
		
		return lastName;
	}
	
	public int setAge()
	{
		System.out.print("Enter Age: ");
		age = console.nextInt();
		
		return age;
	}
	
	public String setEmail()
	{
		System.out.print("Enter Email: ");
		email = console.next();
		
		return email;
	}
	
	public String greeting()
	{
		return ("Greetings " + this.firstName + "!");
	}
	
	//To String
	@Override
	public String toString()
	{
		String str;
		
		str = "\n====Customer Details====" +
		"\nUsername: " + username +
		"\nFullname: " + firstName + " " + lastName +
		"\nAge: " + age + 
		"\nEmail: " + email;
		
		return str;
	}
	
	//To PrintFile
	public String toPrintFile()
	{
		String str;
		
		str = username + "\t" + password + "\t" +  firstName + "\t" + lastName + "\t" +  age + "\t" + email + "\t";
		
		return str;
	}
	
	// login()
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
	
} //end Customer
