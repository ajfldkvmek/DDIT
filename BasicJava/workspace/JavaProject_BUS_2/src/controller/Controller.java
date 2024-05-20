package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.BusService;
import service.TicketService;
import util.ScanUtil;
import util.View;
import vo.Bus;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
	BusService       busService = BusService.getInstance();
	TicketService ticketService = TicketService.getInstance();
	
	
	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case BUS_RESERVE:
				view = reserve();
				break;
			case TICKET_CREATE:
				view = ticketCreate();
				break;	
			}
		}
	}
	private View ticketCreate() {
		Bus bus = (Bus) sessionStorage.get("bus");
		ticketService.ticketCreate(bus);
		return null;
	}

	private View reserve() {
		String st = ScanUtil.nextLine("출발지역 >> ");
		String ed = ScanUtil.nextLine("도착지역 >> ");
		
		List<Bus> busList = busService.list(st, ed);
		printBusList(busList);
		printReserveMenu();
		while(true) {
			int select = ScanUtil.nextInt("메뉴를 선택하세요.");
			
			switch (select) {
			case 1:
				int busNo = ScanUtil.nextInt("예매 번호를 선택하세요.")-1;
				Bus bus = busList.get(busNo);
				sessionStorage.put("bus", bus);
				return View.TICKET_CREATE;
			case 2:
				return View.RESERVE_LIST;
			case 3:
				return View.HOME;
			default :
				System.out.println("다시 입력하세요.");
			}
			
		}
	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.BUS_RESERVE;
		case 2:
			return View.RESERVE_LIST;
		case 3:
			return View.RESERVE_CANCLE;
		default :
			return View.HOME;
		}
	}
}
