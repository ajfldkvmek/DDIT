package meet.dao;

import java.util.List;

import meet.vo.MbVO;
import meet.vo.MeetVO;

public interface IMeetDAO {

	public List<MeetVO> displayAllMeet();

	public MeetVO getDetail(String meetNo);

	public int deleteMeet(String meetNo);

	public int insertMeet(MeetVO mv);

	public int modifyMeet(MeetVO mv);

	public int meetJoin(MeetVO mv);

	public List<MeetVO> meetSearch(MeetVO mv);
	/**
	 * 모임게시판 만들기전 체크하기
	 * @param mv
	 * @return
	 */
	public int mbcheck(MeetVO mv);
	
	public int mbInsert(MbVO mb);

	public List<MbVO> displayAllMeetBoard(String meetNo);

	public MbVO getMbDetail(int mb_no);

	public void updateMbViewCnt(int mb_no);


}
