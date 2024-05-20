package lecture.service;

import java.util.List;

import lecture.dao.IPageDAO;
import lecture.dao.pageDAOImpl;
import lecture.vo.LectureVO;

public class PageServiceImple implements IPageService {

	private static IPageService pageService;
	
	private IPageDAO pageDAO;
	
	private PageServiceImple() {
		pageDAO = pageDAOImpl.getInstance();
	}

	public static IPageService getInstance() {

		if(pageService == null) {
			pageService = new PageServiceImple();
		}
		return pageService;
	}

	@Override
	public List<LectureVO> getPostListWithPaging(LectureVO lv) {
		return pageDAO.getPostListWithPaging(lv);
	}

	@Override
	public int getTotalPostCount() {
		return pageDAO.getTotalPostCount();
	}

	@Override
	public int getSearchPostCount() {
		return pageDAO.getSearchCount();
	}
}
