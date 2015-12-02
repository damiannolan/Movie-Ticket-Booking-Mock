package cinema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	
	public void printToFile() throws IOException
	{
		PrintWriter ticketsFile = new PrintWriter(new FileWriter("tickets.txt", true));
		
		ticketsFile.println("=====Ticket=====");
		ticketsFile.println(movie.toString());
		ticketsFile.println(ticketType.name() + " €" + price);
		ticketsFile.println("=====Ticket=====");
		
		ticketsFile.close();
	}
	
}
