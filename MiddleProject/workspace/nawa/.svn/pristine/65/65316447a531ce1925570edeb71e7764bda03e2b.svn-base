package meet.service;

import java.util.List;

import meet.dao.IMeetDAO;
import meet.dao.MeetDAOImpl;
import meet.vo.MbVO;
import meet.vo.MeetVO;

public class MeetServiceImpl implements IMeetService{

	private static IMeetService meetService;
	
	private IMeetDAO meetDAO;
	
	private MeetServiceImpl() {
		meetDAO = MeetDAOImpl.getInstance();
		
	}
	
	public static IMeetService getInstance() {
		
		if(meetService == null) 
			meetService = new MeetServiceImpl();
		
		return meetService;
	}

	@Override
	public List<MeetVO> displayAllMeet() {
		return meetDAO.displayAllMeet();
		
	}

	@Override
	public MeetVO getDetail(String meetNo) {
		MeetVO mv =  meetDAO.getDetail(meetNo);
		return mv;
		
	}

	@Override
	public int deleteMeet(String meetNo) {
		int cnt = meetDAO.deleteMeet(meetNo);
		return cnt;
	}

	@Override
	public int insertMeet(MeetVO mv) {
		int cnt =meetDAO.insertMeet(mv);
		return cnt;
		
	}

	@Override
	public int modifyMeet(MeetVO mv) {
		System.out.println("서비스"+mv);
		int cnt = meetDAO.modifyMeet(mv);
		return cnt;
	}

	@Override
	public int meetJoin(MeetVO mv) {
		int cnt = meetDAO.meetJoin(mv);
		return cnt;
	}

	@Override
	public List<MeetVO> meetSearch(MeetVO mv) {
		List<MeetVO> meetList =  meetDAO.meetSearch(mv);
		return meetList;
	}
	
	//*************************************************
	@Override
	public int mbcheck(MeetVO mv) {
		System.out.println("mbcheck 서비스");
		return meetDAO.mbcheck(mv);
//		int chk=0;
//		if(chk ==0) {
//			return 0;
//		}else if( chk>=1) {
//			return meetDAO.mbcheck(mv);
//		}
//		if(chk == 0) return; //멤버 아니니까 컨트롤러로돌아감
//		else {
//			insert수행되
//		}
	}
	@Override
	public int mbInsert(MbVO mb) {
		int cnt = meetDAO.mbInsert(mb);
		return cnt;
	}

	@Override
	public List<MbVO> displayAllMeetBoard(String meetNo) {
		List<MbVO> mbList =  meetDAO.displayAllMeetBoard(meetNo);
		System.out.println("리스트서비스: "+mbList);
		return mbList;
	}

	@Override
	public MbVO getMbDetail(int mb_no) {
		MbVO mb = meetDAO.getMbDetail(mb_no);
		return mb;
	}

	@Override
	public void updateMbViewCnt(int mb_no) {
		meetDAO.updateMbViewCnt(mb_no);
		
	}


	
	
	
}
