package meet.service;

import java.util.List;

import meet.dao.MeetDAOImpl;
import meet.vo.MbVO;
import meet.vo.MeetVO;

public interface IMeetService {

	public List<MeetVO> displayAllMeet();

	public MeetVO getDetail(String meetNo);

	public int deleteMeet(String meetNo);

	public int insertMeet(MeetVO mv);

	public int modifyMeet(MeetVO mv);

	public int meetJoin(MeetVO mv);

	public List<MeetVO> meetSearch(MeetVO mv);
	
	
	//---------------------------------------------

	/**
	 * 모임게시판에 insert하기전 mem_id, meet_no가 있는 apply_no인지 체크함
	 * @param mv
	 * @return int chk 숫자 1 반환시 패스
	 */
	public int mbcheck(MeetVO mv);
	
	public int mbInsert(MbVO mb);
	/**
	 * 모임게시판에 전체글띄우기
	 * @param meetNo 
	 * @return
	 */
	public List<MbVO> displayAllMeetBoard(String meetNo);

	public MbVO getMbDetail(int mb_no);

	public void updateMbViewCnt(int mb_no);



	
}
