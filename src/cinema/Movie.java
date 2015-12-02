package cinema;

public class Movie 
{
	String title;
	String genre;
	int runtime;
	//showtime?
	//ticketsremaining?
	
	public Movie (String genre, int runtime, String title)
	{
		this.genre = genre;
		this.runtime = runtime;
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getGenre() 
	{
		return genre;
	}

	public void setGenre(String genre) 
	{
		this.genre = genre;
	}

	public int getRuntime()
	{
		return runtime;
	}

	public void setRuntime(int runtime)
	{
		this.runtime = runtime;
	}
	
	public void display()
	{
		System.out.println("\nTitle: " + title);
		System.out.println("Genre: " + genre);
		System.out.println("Runtime: " + runtime + " mins");	
	}
	
	public String list()
	{
		//System.out.println(title);
		return title;
	}
	
	@Override
	public String toString()
	{	
		return String.format("%s%n%s%n%d mins", genre, title, runtime);
	}
	
}
