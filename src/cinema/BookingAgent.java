package cinema;

public class BookingAgent 
{
	public static double ADULTPRICE = 10.00;
	public static double STUDENTPRICE = 7.00;
	public static double CHILDTICKET = 5.00;
	
	public static Ticket purchaseTicket(Customer customer, Movie movie, TicketType ticketType)
	{
		double ticketPrice = 0;
		
		switch(ticketType)
		{
			case ADULT:
				ticketPrice = BookingAgent.ADULTPRICE;
				break;
			case STUDENT:
				ticketPrice = BookingAgent.STUDENTPRICE;
				break;
			case CHILD:
				ticketPrice = BookingAgent.CHILDTICKET;
				break;
			default:
				ticketPrice = BookingAgent.ADULTPRICE;
		}
		
		return new Ticket(customer, movie, ticketType, ticketPrice); 
	}
}
/*
TicketType ticketType = TicketType.values()[x] where x must be 0, 1 2
icketType.values()[x] where x must be 0, 1 2
TicketType ticketType = TicketType.values()[userInputTicketType];
TicketType.valueOf("ADULT");*/
