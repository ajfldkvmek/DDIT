package service;

import java.util.List;

import vo.Ticket;

public class TicketService {
	
	private static TicketService instance = null;
	private TicketService() {}
	public static TicketService getInstance() {
		if(instance == null) 
			instance = new TicketService();
		return instance;
	}
	
}
