package kr.or.ddit.controller.database;

public class MybatisController {

	
	/*  12 장.
	 * 
	 * 		1. 마이바티스란?
	 * 			
	 * 			마이바티스는 자바 퍼시스턴스 프레임워크의 하나로 XML서술자나 어노테이션을 사용하여 저장 프로시저나
	 * 			SQL문으로 객체들을 연결시킨다
	 * 			마이바티스는 Apache라이선스 2.0으로 배포되는 자유 소프트웨어
	 * 
	 * 			1) 마이바티스를 사용함으로써 얻을 수 있는 이점
	 * 			- SQL의 체계적인 관리
	 * 			- 자바 객체와 SQL 입출력값의 투명한 바인딩
	 * 			- 동적 SQL조합
	 * 
	 * 
	 * 
	 * 			3) 마이바티스 설정
	 * 				
	 * 				3-1) 의존관계 정의
	 * 				- 총 6가지 라이브러리를 등록하여 관계 정의
	 * 
	 * 
	 * 
	 * 				3-2) 스프링과 연결 설정
	 * 				- root-context.xml 설정
	 * 				- 총 3가지 등록하여 설정(추가로 Mapper를 등록하기 위한 basePackage 정보도 추가)
	 * 					
	 * 
	 * 
	 * 				3-3) 마이바티스 설정
	 * 				- webapp/WEB-INF/mybatisAlias/mybatisAlias.xml 설정
	 * 				- 마이바티스 설정은 root-context.xml의 'sqlSessionFactory; 설정 시, property 요소로 적용
	 * 
	 * 
	 * 			4) 관련 테입르 생성
	 * 				- board 테이블 생성
	 * 				- member 테이블 생성
	 * 				- member_auth 테이블 생성
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 		2. Mapper 인터페이스
	 * 
	 * 			- 인터페이스의 구현을 mybatis-spring에서 자동으로 생성할 수 있다.
	 * 
	 * 			1) 마이바티스 구현
	 * 				
	 * 				1-1) Mapper인터페이스 
	 * 				- BoardMapper.java 생성
	 * 
	 * 				1-2) Mapper 인터페이스와 매핑할 Mapper
	 * 				- sqlMap/boardMapper_SQL.xml 생성
	 * 			
	 * 				1-3) 게시판 구현 설명
	 * 				- 게시판 컨트롤러 만들ㅇ기 (board/CrudBoardController)
	 * 				- 게시판 등록 화면 컨트롤러 메소드 만들기(crudRegister:get)
	 *				- 게시판 등록 화면 만들기(crud/register.jsp)
	 *
	 *
	 *				-게시판 등록 기능 컨트롤러 메소드 만들기(crudRegister:post)
	 *  			-게시판 등록 기능 서비스 인터페이스 메소드 만들기
	 *  			-게시판 등록 기능 서비스 클래스 메소드 만들기
	 *  			-게시판 등록 기능 Mapper 인터페이스 메소드 만들기
	 *  			-게시판 등록 기능 Mapper xml 쿼리 만들기
	 *  			-게시판 등록 완료 페이지 만들기
	 *  
	 *  
	 *  			- 게시판 목록 화면 컨트롤러 메서드 만들기(crudList:get)
	 *  			- 게시판 목록 화면 서비스 인터페이스 메서드 만들기
	 *  			- 게시판 목록 화면 서비스 클래스 메서드 만들기
	 *  			- 게시판 목록 화면 Mapper 인터페이스 메서드 만들기
	 *  			- 게시판 목록 화면 Mapper xml 쿼리 만들기
	 *  			- 게시판 목록 화면 만들기
	 *  
	 *  
	 *  
	 *  
	 *  			- 게시판 상세화면 컨트롤러 메소드 만들기
	 *  			- 게시판 상세화면 서비스 인터페이스 메소드 만들기
	 *  			- 게시판 상세화면 서비스 클래스 메소드 만들기
	 *  			- 게시판 상세화면 Mapper 인터페이스 메소드 만들기
	 *  			- 게시판 상세화면 Mapper xml 쿼리 만들기
	 *  			- 게시판 상세화면 만들기(crud/read.jsp)
	 *  
	 *  
	 *  
	 *  			- 게시판 수정
	 *  			- 게시판 수정 화면 서비스 인터페이스 메소드 만들기
	 *  			- 게시판 수정 화면 서비스 클래스 메서드 만들기
	 *  			- 게시판 수정 화면 Mapper 인터페이스 메서드 만들기
	 *				- 게시판 수정 화면 Mapper.xml 쿼리 만들기
	 *				- 게시판 수정 화면("crud/register.jsp)만들기
	 *
	 *				- 게시판 수정 기능 컨트롤러 메소드 만들기(crudModify:post)
	 *				- 게시판 수정 기능 서비스 인터페이스 만들기
	 *				- 게시판 수정 기능 서비스 클래스 만들기
	 *				- 게시판 수정 기능 Mapper 인터페이스 메서드 만들기
	 *				- 게시판 수정 기능 Mapper xml쿼리 만들기
	 *				
	 *
	 *
	 *
	 *				- 게시판 삭제 기능 컨트롤러 메소드 만들기	
	 *				- 게시판 삭제 기능 서비스 인터페이스 메소드 만들기
	 *				- 게시판 삭제 기능 서비스 클래스 만들기
	 *  			- 게시판 삭제 Mapper 인터페이스 만들기
	 *  			- Mapper.xml 쿼리 만들기
	 *  			
	 *  			
	 *  			- 게시판 목록 화면 검색 페이지 추가(crud/board/list.jsp)
	 *  			- 게시판 검색 기능 컨트롤러 메서드 추가(crudSearch:post)
	 *  			- 게시판 검색 기능 서비스 인터페이스 메서드 추가
	 *  			- 게시판 검색 기능 서비스 클래스추가
	 *  			- Mapper 인터페이스 추가
	 *  			- Mapper.xml추가
	 *  
	 *  
	 *  	3. 별칭 적용
	 *  		
	 *  		- TypeAlias 로 매핑 파일에서 반복적으로 사용할 패키지 이름을 정의함
	 *  
	 *  		1) 마이바티스 설정
	 *  
	 *  			1-1) mybatisAlias.xml 설정
	 *  			- typeAlias 설정을 한다
	 *  
	 *  			1-2) boardMapper_SQL.xml의 type의 설정을 별칭으로 설정
	 *  				- mybatisAlias가 설정되어 있지 않는 경우엔 
	 *  					타입으로 설정하고자 하는 타입 형태를 패키지 명이 포함되어 잇는 구조로 설정
	 *  
	 *  	4. '_' 로 구분된 컬럼명 자동 매핑
	 *  
	 *  			- 마이바티스  설정의 mapUnderscoreToCamelCase 프로퍼티 값을 true로 지정하면 '_'로 구분된
	 *  				컬럼명을 소문자 낙타표기법으로 자동 매핑 할 수 있따.
	 *  
	 *  
	 *  			1) mybatixAlias.xml 설정
	 *  				- <settings>
	 *  				-	<setting name="mapUnserScoreCamelCase" value="true"/>
	 *  				- </settings>
	 *  			
	 *  			1-2) 매핑 파일 수정( alias 이미 설정되어 있는 경우 삭제 )
	 *  			
	 *  
	 *  
	 *  	5. 기본키 취득
	 *  		- mybatis는 useGeneratedKeys 속성을 이용하여 insert할 때,
	 *  			 데이터베이스 측에서 채변된 기본키를 취득할 수 있다		
	 *  
	 *  		1) 마이바티스 설정
	 *  
	 *  			1-1) 매핑 파일 수정(boardMapper_SQL.xml) - create 부분의 속성 추가
	 *  
	 *  			> useGeneratedKeys="true"와 keyProperty="boardNo" 속성 추가로 사용
	 *  			> <selectKey keyProperty="boardNo" resultType="int" order="BEFORE">
	 *  			> 	select seq 어쩌고
	 * 				> </selectKey>
	 * 				> insert 어쩌꼬
	 * 				
	 * 				>>	아래 insert 쿼리가 실행되기전 selectKey태그 내에 있는 쿼리가 먼저 실행되도록 order을 BEFORE로 설정
	 * 
	 * 
	 * 				- select seq_board.currval from dual
	 * 				>> 위 select 쿼리 사용시 currval을 사용하는데 있어 사용불가에 대한 에러가 발생할 수 있음
	 * 					currval을 사용할 때 에는 
	 * 					select seq_board.nextval from dual로 먼저 최초 실행 후
	 * 					select seq_board.currval from dual로 사용하면 에러 없음(다른 방법도 있지만 이ㅔㄱ 나음)
	 * 
	 * 
	 * 			2-2) 컨트롤러 메서드에서 crudRegister 부분의 등록이 되거나서 리턴되는 방향성을 수정
	 * 			- 원래는 완료페이지로 가지만 board에 담겨있는 boardNo를 이용한다면 해당 작성글의 상세페이지로 이동 가능
	 * 
	 * 	
	 * 		6. 동적 SQL
	 * 
	 * 			- 마이바티스는 동적 SQL을 조립하는 구조를 지원하고 있으며, SQL 조립 규칙을 매핑 파일에 정의할 수 있따
	 * 
	 * 			1) 동적으로 SQL을 조립하기 위한 SQL요소
	 * 
	 * 			- <where> 		where절 앞 뒤에 내용을 더 추가하거나 삭제할 때
	 * 
	 * 			- <if> 			조건을 만족할 때만 SQL 조립할 수 있게만드는 요소
	 * 
	 * 			- <choose> 		여러 항목에서 조건에 만족할 때만 SQL 수행
	 * 
	 * 			- <foreach>	 	컬렉션이나 배열에 대해 반복처리 하기 위한
	 * 
	 *			- <set>		 	set절 앞 뒤에 내용 추가하거나 삭제
	 *			 
	 * 
	 * 
	 * 
	 * 
	 * 		7. 일대다 관계 테이블 매핑
	 * 
	 * 			- 마이바티스 기능을 활용하여 매핑파일을 적절하게 정의하면 일대다 관계 테이블 매핑을 쉽게 처리할 수 있다.
	 * 			
	 * 			1) 게시판 구현 설명
	 * 			- 회원등록 화면 컨트롤러 만들기(crud/CrudMemberController)
	 * 			- 회원등록 화면 컨트롤러 메서드 만들기
	 * 			- 회원 등록 화면 만들기
	 * 
	 * 	
	 * 			- 회원 등록 기능 컨트롤러 메서드 만들기( crudMemberRegister:post)
	 * 			- 회원 등록 기능 서비스 인터페이스 만들기
	 * 			- 회원 등록 기능 서비스 클래스 만들기
	 * 			- 회원등록 기능 Mapper 인터페이스 만들기
	 * 			- Mapper xml 쿼리 만들기
	 * 			- 완료페이지 만들기( crud/member/succes.jsp )
	 * 
	 * 
	 * 
	 * 			- 회원 목록 화면 컨트롤러 메서드 만들기(crudMemberList:get)
	 * 			- 회원 목록 화면 서비스 인터페이스 메서드 만들기
	 * 			- 회원 목록 화면 서비스 클래스 메서드 만들기
	 * 			- 회원 목록 화면 Mapper 인터페이스 메서드 만들기
	 * 			- Mapper xml 쿼리 만들기
	 * 			- 회원 목록 하면 페이지 만들기( crud/member/list.jsp)
	 * 
	 * 
	 * 			- 회원 상세화면 컨트롤러 메소드 만들기(crudMemberRead:get)
	 * 			- 회원 상세화면 서비스 인터페이스 메소드 만들기
	 * 			- 회우너 상세화면 서비스 클래스 메서드 만들기
	 * 			- 회원 상세화면 Mapper 인터페이스 메서드 만들기
	 * 			- Mapper xml 쿼리 만들기
	 * 			- 회원 상세화면 만들기(crud/member/read.jsp)
	 * 
	 * 
	 * 			- 회원 수정 화면 컨트롤러 메소드 만들기
	 * 			- 회원 수정 화면 서비스 인터페이스 메서드 만들기
	 * 			- 회원 수정 화면 클래스 메서드 만들기
	 * 			- 회원 수정 화면 Mapper 인터페이스 만들기
	 * 			- 회원 수정 화면 Mapper 쿼리 만들기
	 * 			- 회원 수정 화면 페이지 만들기(crud/member/modify.jsp)
	 * 
	 * 
	 * 			- 회원 수정 기능 컨트롤러메소드 만들기
	 * 			- 회원 수정 기능 인터페이스 메서드 만들기
	 * 			- 회원 수정 기능 서비스 클래스 메서드 만들기
	 * 			- 회원 수정 기능 Mapper 인터페이스 메서드 만들기
	 * 			- Mapper sql 쿼리 만들기
	 * 			- 회원 수정 완료 페이지 만들기(위에서만듦)
	 * 
	 * 
	 * 
	 * 
	 * 			- 회원 삭제 기능 컨트롤러메소드 만들기
	 * 			- 회원 삭제 기능 인터페이스 메서드 만들기
	 * 			- 회원 삭제 기능 서비스 클래스 메서드 만들기
	 * 			- 회원 삭제 기능 Mapper 인터페이스 메서드 만들기
	 * 			- Mapper sql 쿼리 만들기
	 * 			- 회원 삭제 완료 페이지 만들기(위에서만듦)
	 * 			
	 */
	
	
	
	
}
