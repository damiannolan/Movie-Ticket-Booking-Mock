package cinema;

public class Ticket 
{
	Movie movie;
	Customer customer;
	TicketType ticketType;
	double price;
	
	public Ticket(Customer customer, Movie movie, TicketType ticketType, double price)
	{
		this.customer = customer;
		this.movie = movie;
		this.ticketType = ticketType;
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		String str;
		
		str = movie.title + "\nPrice: " + price;
		
		return str;
	}
	
}
