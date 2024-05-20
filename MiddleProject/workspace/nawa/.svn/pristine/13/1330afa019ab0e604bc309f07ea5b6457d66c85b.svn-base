package lecture.service;

import java.util.List;

import lecture.vo.LectureVO;

public interface ILecService {


	/**
	 * 강의 상세정보를 가져오기 위한 메서드
	 * @param memId 강의 상세정보를 가져오기 위한 회원 ID
	 * @return 회원정보를 담은 LectureVO객체 리턴함
	 */
	LectureVO getLecture(String memId);

	/**
	 * 강의등록을 위한 메서드
	 * @param lv 등록할 강의정보를 담은 VO객체
	 * @return 등록 성공하며 1, 실패하면 0이 반환된다.
	 */
	int registLecture(LectureVO lv);
	
	/**
	 * 회원정보를 수정하기 위한 메서드
	 * @param lv 등록할 회우너정보를 담은 VO객체
	 * @return 작업이 성공하며 1, 실패하면 0이 반환된다.
	 */
	int modifyLec(LectureVO lv);
	
	/**
	 * 강의정보를 delete하기 위한 메서드
	 * @param lecNo 삭제할 게시글 게시글NO
	 * @return 작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	int removeLecture(String lecNo);

	List<LectureVO> getLecList(String tutNo);

	int getTotalPostCount();

	List<LectureVO> lectureSearch(LectureVO lv);

	int getTotalLectureCount(LectureVO lv);

	

}
