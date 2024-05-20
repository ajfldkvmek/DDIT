package kr.or.ddit.controller.database;

public class DatabaseConnectController {

	
	/*
	 * 	11장. 데이터 베이스 연동
	 * 
	 * 		1. Oracle 11g 설치
	 * 		
	 * 			- Oracle win32_lgR2_clinet와 OracleXE112_win64로 오라클 클라이언트, 서버를 설치
	 * 
	 * 			# 오라클 클라이언트 및 서버 설치 참고
	 * 			- https://junesker.tistory.com/79
	 * 			- https://junesker.tistory.com/80
	 * 
	 *  	2. Oracle SQLDeveloper  설치
	 *  
	 *  		- slqdeveloper를 설치
	 *  
	 *  		# 오라클 SQLdeveloper 설치참고
	 * 			- https://junesker.tistory.com/81
	 * 
	 * 
	 * 		3. 데이터 소스 설정
	 * 
	 * 			- 애플리케이션 데이터베이스에 접근하기 위한 추상화된 연결을 제공한는 역할을한다
	 * 
	 * 			# 스프링에서 설정할수 있는 데이터 소스
	 * 			> JDBC 드라이버를 통해 선언된 데이터 소스
	 * 			> JNDI 에 등록된 데이터 소스
	 * 			> 커네션 풀링을 하는 데이터 소스
	 * 			> DBCP2에 등록된 데이터 소스
	 * 
	 * 		JNDI란?
	 * 		JNDI(Java Naming and Directory Interface)
	 * 		= 디렉터리 서비스에서 제공하는 데이터 및 객체를 발견하고 참고하기 위한 자바 API
	 * 
	 * 		데이터베이스 JDBC 라이브러리 설정
	 * 		- pom.xml에 의존성 추가
	 * 	
	 * 		# 데이터 소스 설정
	 * 		- root-context.xml 설정
	 * 
	 * 		
	 * 
	 * 		4. CRUD 게시판
	 * 		- 데이터베이스 데이터에 접근하여 처리하는 방식
	 * 
	 * 		# 데이터베이스 처리방식
	 * 		> 스프링 JDBC
	 * 		> JPA
	 * 		> 마이바티스
	 * 
	 * 
	 * 
	 * 			*** 우리는 마이바티스 쓸거임 ***
	 * 			
	 * 			1) 오라클 데이터베이스 계정 생성
	 * 
	 * 			2) 생성 SQL
	 * 
	 * 				create table board(
	 * 					board_no number(8) not null,
	 * 					title varchar2(200) not null,
	 * 					content varchar2(4000) not null,
	 * 					writer varchar2(50) not null,
	 * 					reg_date date default sysdate null,
	 * 					constraint pk_board primary key(board_no)
	 * 				);
	 * 					
	 * 					
	 * 			3) 장성할 화면(기본화면)
	 * 				- 등록 화면
	 * 				- 등록 처리 후 화면
	 * 				- 목록 화면
	 * 				- 상세보기 화면
	 * 				- 수정 화면
	 * 				- 수정 처리 후 화면
	 * 				- 삭제처리 후  화면
	 * 		
	 * 	5. 스프링 jdbc
	 * 		- SQL로만 데이터 베이스를 쉽게 처리할 수 있도록 도와주는 JDBCTemplate클래스를 제공한다
	 * 
	 * 		# JDBCTemplate가 제공하는 주요 메소드
	 * 
	 * 		queryForObject 	- 하나의 결과 처리
	 * 		
	 * 		queryForMap		- 하나의 결과 레코드 정보를 Map 형태로 매핑
	 * 
	 * 		queryForList	- 여러개
	 * 
	 * 		query			- ResultSetExtractor, RowCallbackHandler 와 함께 조회할 때 사용
	 * 		
	 * 		update			- 데이터를 변경할 때
	 * 
	 * 
	 * 		# 스프링 JDCB 설정
	 * 
	 * 		- spring-jdbc 의존관계 설정
	 * 			> 의존관계 설정에서 spring-jdbc 설정 처리함(pom.xml)
	 * 
	 * 		- 데이터소스 설정
	 * 			> jdbcTemplate 클래스를 빈으로 정의(우리는 따로 안함)
	 * 
	 * 
	 * 		# 게시판 구현 설명
	 * 			기본적인 CRUE를 바탕으로 한 구현
	 * 			
	 * 
	 * 	6. JPA (java persistence api)
	 * 	- 자바 표준 ORM
	 *			>> 구현되어 있는 클래스에 테이블을 매핑하기 위한 프레임워크
	 *
	 *	[장점]
	 *	- SQL 위주의 쿼리를 작성하지 않아도됨
	 *	- 코드의 양이 줄어듦
	 *	- 객체위주의 코드의 작성으로 가독성이 좋아짐(생상성 상승)
	 *	- 객체를 사용하는 시점에 쿼리를 전달하거나 동일한 트랜잭션 안에서 처리 내용이 같음을 보장(패러다임 불일치 해결)
	 *
	 *
	 *	# Entity
	 *	- 데이터 베이스에서 지속적으로 저장된 데이터를 자바 객체에 매핑한 것
	 *	- 메모리 상에 자바 객체의 인스턴스 형태로 존재하며 EntityManager에 의해 데이터베이스 데이터와 동기화한다
	 *
	 *
	 *	# EntityManager
	 *	- 필요에 따라 Entity와 데이터베이스의 데이터를 동기화함
	 *	- EntityManager에서 제공하는 Entity 조작 api를 이용해 Entity에 대하 CRUD 작업을 할 수 있다.
	 *
	 *
	 *	# Entity 상태
	 *	- New 상태
	 *	- 관리 상태
	 *	- 분리 상태
	 *	- 삭제된 상태
	 *
	 *
	 *	# JPA 관련 어노테이션
	 *
	 *	자바빈즈 클래스 객체가 곧 테이블 구조와 같은 형태이기 떄문에, VO클래스 내 @Entity 어노테이션을 통해 
	 *	해당 객체가 테이블과 같은 Entity임을 설정하고 @Table어노테이션으로 테이블 명을 설정해주면 
	 *	VO클래스는 데이터베이스내 생성되어 있는 데이블과 연결되기 위한 준비완료
	 *
	 *	ex) 
	 *	@Entity	
	 *	@Table(name="board")
	 *	public clases Board(){}	
	 *
	 *	그리고 각 필드(맴버 변수)에 @Column(name="board_no") 어노테이션으로 테이블 컬럼과 매핑 설정
	 *	설정된 Entity들을 이용하여 jpa 객체를 통해 함수를 호출하면(persist, find 등등) 호출된 함수를 통해 
	 *	Spring Data JPA가 자동으로 Entity를 분석하여 함수에 따른 쿼리를 자동생성하여 
	 *	결과를 실행, 조회, 수정, 등을 처리해준다
	 *	
	 *	기존 SQL 쿼리를 이용하여 서비스를 처리할 때에 필드가 추가되면 
	 *	필드와 관련되어 있는 기능, sql, 추가된필드 등을 수정해야하는 번거로움이 발생하지만 
	 *	JPA는 필드 추가 후 테이블 정보와 매핑만 시켜주면 JPA가 자동으로 분석을 진행한다
	 *	그리고 사용자는 데이터베이스 종류가 변경된다 하더라고 문제없음
	 *	(JPA는 sql을 직접 건들이지 않고 함수와 같은 기능들로만 쿼리를 요청하고 데이터베이스와 통신하기 떄문)
	 *
	 *
	 *	JPA는 JPA구현체인 hibernate를 이용하며 사용합니다
	 *	그러기 위해선 관련 의존관계를 등록 후 사용해야 합니다.
	 *	SQL문을 이용하여 데이터 베이스를 연동하여 데이터를 가공하는 게 아닌, 
	 *	Method를 통해 데이터베이스를 조작할 수 있다는 장접이 있어
	 *	객체모델을 이용하여 비즈니스 로직을 구성하는 데에만 집중할 수 있다
	 *
	 *	하지만! 프로젝트의 규모가 크고 복잡할 경우 설계가 실패할 경우 품질이 매우 떨어짐
	 *	설계라인의 정확성과 검증이 필수
	 *
	 *
	 *	[용어]
	 *	### ORM이란?
	 *		> 객체에 데이터를 읽고 쓰는 방법으로 관계형 DB에 데이터를 쓰고 읽는 기술(우리는 mybatis)
	 *
	 *	면접에서 ORM뭐 써봤냐?? >>> mybatis 씀 ㅇㅇ
	 *
	 *
	 *
	 *	# 의존 관계 정의
	 *	- pom.xml에 mybatis 설정을 위한 의존관계를 등록하도록 하자
	 *		
	 *		> mybatis
	 *		> mybatis-spring
	 *		> mybatis-jdbc
	 *		> commons-dbcp2
	 *		> log4jdcb-log4j2-jdbc4
	 *		> ojdbc6 or ojdbc8
	 *
	 *	# 스프링과 마이바티스 연결 설정
	 *	- root-context.xml 설정
	 *
	 *		> dataSource 설정
	 *		> selSessionFactory 설정
	 *		> selSessionTempalte 설정
	 *	
	 *	# 마이바티스 설정
	 *	- webapp/WEB-INF/mybatisAlias/mybatisAlias.xml
	 *
	 * 	# 마이바티스 구현
	 * 	- mapper 패키지 안에 Mapper.xml
	 * 		> mapper 패키지 안에 BoardMapper.xml
	 * 
	 * 
	 */
}
