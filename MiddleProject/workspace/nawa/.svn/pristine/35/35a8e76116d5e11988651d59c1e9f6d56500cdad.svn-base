package lecture.comm.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import lecture.comm.vo.AtchFileVO;
import util.MyBatisUtil;

public class AtchFileDaoImpl implements IAtchFileDao{

	
	private static IAtchFileDao fileDao;
	
	private AtchFileDaoImpl() {
		
	}
	
	public static IAtchFileDao getInstance() {
		if(fileDao == null) {
			fileDao = new AtchFileDaoImpl();
		}
		
		return fileDao;
	}
	
	
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {

		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("atchFile.insertAtchFile", atchFileVO);
			
			if(cnt > 0) {
				session.commit();
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		}finally {
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
			
			if(cnt > 0) {
				session.commit();
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		AtchFileVO atchFileDetail = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			atchFileDetail = session.selectOne("atchFile.getAtchFileDetail",atchFileVO);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return atchFileDetail;
		
	}

	

}
