
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import print.Print;
import service.BusServie;
import service.TicketService;
import util.ScanUtil;
import util.View;
import vo.Bus;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	BusServie busServie = BusServie.getInstance();
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
			case BUS_LIST:
				view = busList();
				break;
			case BUS_RESERVE:
				view = busReserve();
				break;
			case TICKET_CREATE:
				view = ticketCreate();
			break;
			case SELECT_LIST:
				view = list();
				break;
			}
		}
	}

	private View ticketCreate() {

		Bus bus = (Bus) sessionStorage.get("bus");
		return null;
	}

	private View list() {
		String st = ScanUtil.nextLine("출발지: ");
		String dest = ScanUtil.nextLine("도착지: ");
		busServie.list(st, dest);

		List<Bus> list = busServie.list(st, dest);
		printList(list);
		return View.BUS_RESERVE;
	}

	private View busReserve() {
		int busNo = ScanUtil.nextInt("몇번 예약 할래? ");
		Bus bus = busList.get(busNo);
		sessionStorage.put("bus", bus);
		switch (yn) {
		case 1:
			Bus list = busServie.reserve(select);
			printReserve(list);
			System.out.println("예약 완료");
			return View.HOME;
		default:
			return View.BUS_RESERVE;
		}
	}

	private View busList() {
		List<Bus> list = busServie.printBusList();
		printBusList(list);

		return View.SELECT_LIST;
	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.BUS_LIST;
		default:
			return View.HOME;
		}
	}
}
