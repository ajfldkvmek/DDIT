package lecture.service;

import lecture.dao.IheartDAO;
import lecture.dao.heartDAOImpl;
import lecture.vo.LectureVO;

public class heartServiceImple implements IheartService{

	private static IheartService heartService;
	
	private IheartDAO heartDAO;
	
	private heartServiceImple() {
		heartDAO = heartDAOImpl.getInstance();
	}
	
	public static IheartService getInstance() {
		
		if(heartService == null)
			heartService = new heartServiceImple();
		return heartService;
	}

	@Override
	public int registHeart(LectureVO lv) {

		int cnt = heartDAO.updateHeart(lv);
		
		return cnt;
	}

}
