package service;

import java.util.List;

import dao.EventDAO;
import vo.Event;


public class EventService {
	private static EventService singleTon = null;

	public EventService() {
	};

	public static EventService getInstance() {
		if (singleTon == null) {
			singleTon = new EventService();
		}
		return singleTon;
	}

	EventDAO eventDAO = new EventDAO();
	
	public List<Event> reserveEvent() {
	
		return eventDAO.reserveEvent();
	}
	
}