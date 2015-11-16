package cinema;

public class Movie 
{
	String title;
	String genre;
	int runtime;
	
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
	
	
	
}
