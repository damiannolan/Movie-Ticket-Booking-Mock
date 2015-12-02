package cinema;

public class BookingAgent 
{
	public static double ADULTPRICE;
	public static double STUDENTPRICE;
	public static double CHILDPRICE;
	
	public static void initTicketPrices()
	{
		ADULTPRICE = 10.00;
		STUDENTPRICE = 7.00;
		CHILDPRICE = 5.00;
	}
	
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
				ticketPrice = BookingAgent.CHILDPRICE;
				break;
			default:
				ticketPrice = BookingAgent.ADULTPRICE;
		}
		
		return new Ticket(customer, movie, ticketType, ticketPrice); 
	}
	
	public static void showTicketPrices()
	{
		System.out.println("Adult: " + ADULTPRICE);
		System.out.println("Student: " + STUDENTPRICE);
		System.out.println("Child: " + CHILDPRICE);
	}
}
/*
TicketType ticketType = TicketType.values()[x] where x must be 0, 1 2
icketType.values()[x] where x must be 0, 1 2
TicketType ticketType = TicketType.values()[userInputTicketType];
TicketType.valueOf("ADULT");*/
