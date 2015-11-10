package cinema;

public abstract class Ticket 
{
	String movie;
	String description;
	int time;
	String date;
	
	public abstract Ticket createTicket();
	
}
