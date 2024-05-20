package lecture.service;

import lecture.dao.IinvolveDAO;
import lecture.dao.involveDAOImpl;
import lecture.vo.LectureVO;

public class involveServiceImple implements IinvolveService {

	private static IinvolveService involveService;
	
	private IinvolveDAO involveDAO;

	private involveServiceImple() {
		involveDAO = involveDAOImpl.getInstance();
	}
	
	public static IinvolveService getInstance() {
		
		if(involveService == null)
			involveService = new involveServiceImple();
		return involveService;
	}

	@Override
	public int registHeart(LectureVO lv) {

		int cnt = involveDAO.involveLecture(lv);
		
		return 0;
	}


	

}
