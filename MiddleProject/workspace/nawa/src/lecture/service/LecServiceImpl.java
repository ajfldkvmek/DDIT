package lecture.service;

import java.util.List;

import lecture.dao.ILecDAO;
import lecture.dao.LecDAOImpl;
import lecture.vo.LectureVO;
import member.vo.MemberVO;

public class LecServiceImpl implements ILecService{

	private static ILecService lecService;
	
	private ILecDAO lecDAO;
	
	private LecServiceImpl() {
		lecDAO = LecDAOImpl.getInstance();
	}
	
	public static ILecService getInstance() {
		
		if(lecService == null) 
			lecService = new LecServiceImpl();
		
		return lecService;
	}


	@Override
	public LectureVO getLecture(String lecNo) {

		LectureVO lv = lecDAO.getLecture(lecNo);
		MemberVO mv = lecDAO.getTutorInfo(lv.getTutNo());
		lv.setMemAdd1(mv.getMem_add1());
		lv.setMemAdd2(mv.getMem_add2());
		lv.setMemId(mv.getMem_id());
		lv.setMemEmail(mv.getMem_email());
		lv.setMemTel(mv.getMem_telno());
		lv.setMemName(mv.getMem_name());
		
		return lv;
	}

	@Override
	public int registLecture(LectureVO lv) {

		int cnt = lecDAO.insertLecture(lv);
		
		return 0;
	}

	@Override
	public int modifyLec(LectureVO lv) {

		int cnt = lecDAO.updateLecture(lv);
		
		return cnt;
	}

	@Override
	public int removeLecture(String lecNo) {
		
		int cnt = lecDAO.deleteLecture(lecNo);
		
		return cnt;
	}

	@Override
	public List<LectureVO> getLecList(String tutNo) {
		
		return lecDAO.getLecList(tutNo);
		
	}

	@Override
	public int getTotalPostCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LectureVO> lectureSearch(LectureVO lv) {
		return lecDAO.lectureSearch(lv);
	}

	@Override
	public int getTotalLectureCount(LectureVO lv) {
		
		return lecDAO.getTotalLectureCount(lv);
	}

	@Override
	public void updateCnt(int countNo) {
		lecDAO.updateCnt(countNo);
		
	}

	@Override
	public void lecScore(int lecNo) {
		lecDAO.lecScore(lecNo);
		
	}

	@Override
	public LectureVO updateScore(String lecNo) {
		lecDAO.updateScore(lecNo);
		
		return null;
	}



	
	
	
}
