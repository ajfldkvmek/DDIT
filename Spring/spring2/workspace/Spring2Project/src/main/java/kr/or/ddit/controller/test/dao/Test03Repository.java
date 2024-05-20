package kr.or.ddit.controller.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.controller.test.vo.StudentVO;

@Repository
public class Test03Repository {
	
		// 기능구현
		// - 학생 전체 가져오기
		// - 학생 한명 정보 가져오기
		// - 이름, 이메일 정보를 활용해 학생 아이디 가져오기
		// - 아이디, 이름, 이메일 정보를 활용해 학생 비밀번호 가져오기
		// 등등 필요에 의한 기능을 구현해주세요.

	private List<StudentVO> studentList = new ArrayList<StudentVO>();
	
	private String[] ids = {"a001","b001","c001","d001","e001","f001"};
	private String[] pws = {"1234","1234","1234","1234","1234","1234"};
	private String[] names = {"안희재","김현태","김나혜","김영상","최현명","신하림"};
	private String[] phones = {
		"011-1122-4783","016-4734-1523","010-1234-1234","019-9879-2243","010-4536-1234",
		"010-7564-4352"
	};
	
	public Test03Repository() {
		// StudentVO를 활용하여 403호 학생 5명을 초기화해주세요.
		for(int i = 0; i < ids.length; i++) {
			StudentVO student = new StudentVO();
			student.setMemId(ids[i]);
			student.setMemPw(pws[i]);
			student.setMemName(names[i]);
			student.setMemEmail(ids[i] + "@naver.com");
			student.setMemPhone(phones[i]);
			studentList.add(student);
		}
	}
	
	public StudentVO getVO(int i) {
		return studentList.get(i);
	}
	
	public int idx(String memId) {
		int a = 0;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getMemId().equals(memId)) {
				a = i;
				break;
			}
		}
		return a;
	}
	
	public boolean login(String memId, String memPw) {
		
		boolean memberChk = false;
		
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getMemId().equals(memId) &&
					studentList.get(i).getMemPw().equals(memPw)) {
				memberChk = !memberChk;
				break;
			}
		}
		return memberChk;
	}
	
	public StudentVO loginInfo(String memId) {
		
		StudentVO sv = new StudentVO();
		
		for(StudentVO s : studentList) {
			if(s.getMemId().equals(memId)) {
				sv = s;
				break;
			}
		}
		
		return sv;
	}
	
	public String findId(String memName, String memEmail) {
		
		String id = "";
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getMemName().equals(memName) &&
					studentList.get(i).getMemEmail().equals(memEmail)) {
				id = studentList.get(i).getMemId();
				break;
			}
		}
		return id;
	}

	public String findPw(StudentVO studentVO) {
		
		String pw = "";
		String id = studentVO.getMemId();
		String email = studentVO.getMemEmail();
		String name = studentVO.getMemName();
		
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getMemName().equals(name) &&
					studentList.get(i).getMemEmail().equals(email) &&
					studentList.get(i).getMemId().equals(id)) {
				pw = studentList.get(i).getMemPw();
				break;
			}
		}
		return pw;
	}
	
	
}
