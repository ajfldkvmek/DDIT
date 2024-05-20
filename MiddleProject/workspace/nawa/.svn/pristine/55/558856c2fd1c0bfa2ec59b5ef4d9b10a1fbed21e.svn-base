package lecture.dao;

import java.util.List;

import lecture.vo.LectureVO;
import member.vo.MemberVO;

public interface ILecDAO {


	/**
	 * 상세 강의정보를 가져오기 위한 메서드
	 * @param memId 상세강의정보를 가져오기 위한 회원 ID
	 * @return 상세강의정보를 담은 LectureVO객체
	 */
	LectureVO getLecture(String lecNo);

	/**
	 * LectureVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param lv 등록할 강의정보를 담은 VO객체
	 * @return DB작업이 성공하며 1, 실패하면 0이 반환된다.
	 */
	int insertLecture(LectureVO lv);

	/**
	 * LectureVO에 담긴 데이터를 update하기 위한 메서드
	 * @param lv 등록할 회우너정보를 담은 VO객체
	 * @return DB작업이 성공하며 1, 실패하면 0이 반환된다.
	 */
	int updateLecture(LectureVO lv);

	/**
	 * 회원정보를 delete하기 위한 메서드
	 * @param lecNo 삭제할 강의 NO
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	int deleteLecture(String lecNo);

	List<LectureVO> getLecList(String tutNo);

	MemberVO getTutorInfo(String memName);

	List<LectureVO> lectureSearch(LectureVO lv);

	int getTotalLectureCount(LectureVO lv);


}
