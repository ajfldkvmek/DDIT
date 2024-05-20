package board.atch.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import board.atch.vo.AtchFileVO;
import util.MyBatisUtil;


public class AtchFileDAOImpl implements IAtchFileDAO {

	private static IAtchFileDAO fileDAO;

	private AtchFileDAOImpl() {

	}

	public static IAtchFileDAO getInstance() {
		if (fileDAO == null) {
			fileDAO = new AtchFileDAOImpl();
		}

		return fileDAO;
	}

	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {

		SqlSession session = MyBatisUtil.getInstance();

		int cnt = 0;

		try {
			cnt = session.insert("atchFile.insertAtchFile", atchFileVO);
			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.insert("atchFile.insertAtchFileDetail", atchFileVO);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public boolean checkAtchFile(long atchFileId) {
		
		SqlSession session = MyBatisUtil.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		boolean chk = false;
		
		try {
			av = session.selectOne("atchFile.check", atchFileId);
			if(av.getCnt() > 0) chk = true; 
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + chk);
		return chk;
	}

	@Override
	public List<AtchFileVO> getDetailList(long atchFileId) {
		
		SqlSession session = MyBatisUtil.getInstance();
		List<AtchFileVO> atchList = new ArrayList<AtchFileVO>();
		
		try {
			atchList = session.selectList("atchFile.getDetailFile", atchFileId);

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return atchList;
	}

	
}
