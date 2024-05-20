package member.atch.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import member.atch.vo.AtchFileVO;
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
			cnt = session.insert("latchFile.insertAtchFile", atchFileVO);
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

			cnt = session.insert("latchFile.insertAtchFileDetail", atchFileVO);

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
		
		System.out.println(";다옹오ㅗ오오 왔어" + atchFileId);
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		
		boolean chk = false;
		try {
			cnt = session.selectOne("latchFile.check", atchFileId);
			if(cnt > 0) chk = true; 
			
			System.out.println("다옹옴ㄴㄴㅁㅇㅁㄴ엄ㅇㄴ" + cnt);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + chk);
		return chk;
	}

	@Override
	public String getDetail(long atchFileId) {
		
		SqlSession session = MyBatisUtil.getInstance();
		System.out.println("다오에서 첨부파일 번호 확인" + atchFileId);
		
		AtchFileVO av = null;
		String streFileNm = "";
		try {
			av = session.selectOne("mem_atchFile.getDetail", atchFileId);
			
			System.out.println("다오에서 확인>>> " + av.getStreFileNm());
			streFileNm = av.getStreFileNm();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return streFileNm;
	}
	
}
