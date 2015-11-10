package cinema;

public class Customer extends Account
{
	String firstName;
	String lastName;
	int age;
	int contactNumber;
	String address;
	
	public Customer()
	{
		super();
		getFirstName();
		getLastName();
		getAge();
		getContactNo();
		getAddress();
	}

	public Customer(String username, String password) 
	{
		super(username, password);
	}
	
	public Customer(String username, String password, String firstName, String lastName, int age, int contactNumber, String address)
	{
		//Calling constructor using this()
		this(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	public String getFirstName()
	{
		System.out.print("Enter first name: ");
		firstName = console.next();
		
		return firstName;
	}
	
	public String getLastName()
	{
		System.out.print("Enter last name: ");
		lastName = console.next();
		
		return lastName;
	}
	
	public int getAge()
	{
		System.out.print("Enter Age: ");
		age = console.nextInt();
		
		return age;
	}
	
	public int getContactNo()
	{
		System.out.print("Enter Contact Number: ");
		contactNumber = console.nextInt();
		
		return contactNumber;
	}
	
	public String getAddress()
	{
		console.nextLine();
		System.out.print("Enter Address: ");
		address = console.nextLine();
		
		return address;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
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
		"\nContact Number: (+353)" + contactNumber +
		"\nAddress: " + address;
		
		return str;
	}
	
	//To PrintFile
	public String toPrintFile()
	{
		String str;
		
		str = username + "\t" + password + "\t" +  firstName + "\t" + lastName + "\t" +  age + "\t" + contactNumber +  "\t" + address + "\t";
		
		return str;
	}
	
	// login()
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
	
	public void buyTicket(char type)
	{
		//DO SOMETHING
	}
	
} //end Customer
