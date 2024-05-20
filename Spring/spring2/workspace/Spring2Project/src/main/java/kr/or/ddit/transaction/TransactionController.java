package kr.or.ddit.transaction;

public class TransactionController {
	
	/*
	 * 
	 *  15. 트랜잭션
	 *  
	 *  1. 트랜잭션 설명
	 *  - 한번에 이루어지는 작업의 단위를 의미
	 *  
	 *  	# 트랜잭션 성격(ACID)
	 *  	원자성(A), 일관성(C), 격리성(I), 영속성(D)
	 *  
	 *  
	 *  
	 *  
	 *  2. 트랜잭션 설정
	 *  		
	 *  	- root-context.xml 설정
	 *  		> 네임스페이스, 스키마 추가
	 *  	
	 *  	- transcationManager 빈 등록
	 *  	
	 *  	- 어노테이션 기반의 트랜잭션 제어 활성화
	 *  
	 *  
	 *  3. 트랜잭션 적용
	 *  	[테스트는 AOP가 적용된 CrudController와 연계된 ServiceImpl에서 한다]
	 *  	
	 *  	# 트랜잭션 상황 부여
	 *  		예) 회원은 반드시 하나의 권한을 가진다는 비지니스 규칙이 있다.
	 *  			회원과 회원권한 테이블이 각각  개별로 존재하지만 회우너 정보를 저장할 때 반드시 회원권한 정보를 동시에 저장해야한다
	 *  			클래스나 메소드에 대해 @Transactional 어노테이션을 부여하여 트랜잭션을 적용할 수 있다.
	 *  
	 *  	# 서비스 구현 객체에 트랜잭션 적용
	 *  
	 *  		- 회원 정보를 저장하다가 실패하거나 회원 권한 정보를 저장하다가 실패햐며 회원 테이블과 회원 권한 테이블 모두 저장되지 않는다.
	 *  		 회원정보와 권한정보가 모두 저장에 성공했을 경우 비로소 회원 테이블과 권한테이블에 저장이 이루어진다. (수정 삭제도 마찬가지)
	 *  
	 *  
	 *  	# @Transactional의 예외처리 견해
	 *  		@Transactional을 적용하고 중간에 에러를 발생시긴 후 롤백된 상태를 확인하려 했으나 롤백이 되지 않고 데이터 베이스가 동록된다
	 *  		>>> 난 롤백했는데 왜 등록됨???
	 *  
	 *  		그 이유는 스프링 프레임워크에서는 기본적으로 check Exception에 대헤서는 롤백처리를 하지 않도록 설계되어있다
	 *  		기본적으로 스프링에서 트랜잭션 처리는 RuntimeException(Unchecked EXception)계열 이라면 Rollback처리를 합
	 *  		
	 *  		### 트랜잭션으로 국한된 롤백 정책이 아니라 스프링 프레임워크에서의 기본 정책에 대한 내용일 뿐임
	 *  		실제로 트랜잭션 롤백처리, CheckedException vs UnCheckedException 등을 검색해보면 잘못된 정보가 매우 많음
	 *  	
	 *  		************************
	 *  		예외처리 시 트랜잭션 처리 에 대한 정보가 잘못 표기된 경우가 많음
	 *  		이럴 때 되고 저럴 때 되고 가 아니라 기본적인 스프링트랜잭션 정책이 있고,
	 *  		그 외 옵션으로 특정 에러가 발생했을 떄, 롤백 진행할 수 있도록 제공
	 *  
	 *  
	 *  
	 *  	# Exception(예외) & Error(에러)
	 *  	
	 *  	- Exception : 개발 알고리즘에서 발생하는 오류로 개발자가 작성한 코드에서 발생하므로 예외를 상황에 맞춰 처리할 수 있음
	 *  
	 *  
	 *  	- Error		: 시스템에서 발생하는 심각한 수준의 에러로 개발자가 미리 예측해서 대응 불가(예외처리 신경슬 필요 x)
	 *  		
	 *  
	 *  
	 *  	- CheckedException vs UnCheckedException
	 *  	> RuntimeException의 상속 여부에 따라 CheckedException과 UnCheckedException으로 나뉨
	 *  
	 *  
	 *  
	 *  				|   CheckedException 				|	UnCheckedException						|
	 *  -------------------------------------------------------------------------------------------------
	 *  	예외처리 여부	|	반드시 예외처리 코드가 있어야 함			|	강제는 아님
	 *  	예외 확인 시점	|	콤퍼알 단계부터 실행안됨					|	런타임중에 확인됨
	 *  	클래스		|	IOException, SQLException 등		|  	NullPoint 등
	 *  
	 *  
	 *  	
	 *  ************* 트랜잭션도 AOP의 개념이 반영된 관점지향프로그래밍이라 할 수 있ㅇ므
	 *  
	 *  	
	 *  # RuntimeException 계열
	 *  	- ArithmaticException
	 *  	- ArrayStoreException
	 *  	- ArrayIndexOutofBountException
	 *  	- ClassCastException
	 *  	- NullPointerException
	 *  	- NegativeArraySizeException
	 *  	- NoClassDefFountException
	 *  	- OutofMemoryException
	 *  	- IndexOutofBoundsException
	 *  	- IllegalArgumentException
	 *  	- 등
	 *  
	 *  
	 *  # 선언적 트랜잭션 @Transactional
	 *  
	 *  		- 컨트롤러 메소드 각 단위로 세밀한 트랜잭션 속성 제어가 가능함
	 *  		- 해당 어노테이션이 클래스 수준에서 선언되면 선언 클래스 및 해당 하위 클래스의 모든 메소드에서 기본값으로 적용됨
	 *  		- RuntimeException 계열, Error 예외에 대해서는 Rollback가능
	 *  		
	 *  		1) isolation(격리수준)
	 *  			- 각 트랜잭션이 존재할 때, 트랜잭션들 끼리 서로 고립된 수준을 나타내며 
	 *  				서로간에 가용된 데이터를 컨트롤할지에 대한 부분들을 설정할 수 잇다
	 *  				> 기본값은 Default
	 *  				> 새로  시작된 트랜잭션에만 적용되므로, Propagation.REQUIRED 또는
	 *  											Propataion.REQUIREs_NEW와 함계 사용되도록 독점설계됨
	 *  
	 *  
	 *  		1-1) 옵션
	 *  			*** 용어
	 *  			# Dirty read
	 *  				- Commit이 이루어 지지 않은 다른 트랜잭션의 데이터를 읽는 것
	 *  
	 *  			# None-repeatable read
	 *  				- 처리중인 트랜잭션에서 다른 트랜잭션이 commit한 데이터를 읽을 수 있는 것을 의미
	 *  
	 *  			# Phantom read	
	 *  				- 자신이 처리중인 트랜잭션에서 처리했던 냉용 안에서 다른 트랜잭션이 데이터를 수정후 commit 하더라도
	 *  					자신의 트랜잭션에서 처리한 내용만 사용한느 것을 의미
	 *  
	 *  
	 *  		- DEFAULT 			: 기본데이터 저장소의 기본 격리 수준 사용
	 *  
	 *  
	 *  		- READ-COMMITTED	: Dirty read가 방지됨을 나타내는 상수
	 *  								no-repeatable read 및 phantom read가 발생할 수 있다
	 *  			> 하나의 트랜잭션 처리가 이루어진 변경 내용이 commit된 후, 다른 트랜잭션에서 조회가 가능함
	 *  			> A트랜잭션이 데이터를 변경하고 B트랜잭션이 조회를 진행할 때, B트랜잭션은 shared lock이 걸림
	 *  
	 *  		- READ-UNCOMMITTED	: Dirty read, none repeatable read, phantom read가 발생할 수 있음을 나타내는 상수
	 *  
	 *  			> 다른 트랜잭션의 내용이 Commit, 또는 Rollback되거나 되지 않아도 다른 트랜잭션에서 조회 가능
	 *  
	 *  
	 *			- REPEATABLE_READ	: Dirty read, Non-repeatable read가 방지됨을 나타내는 상수
	 *									Phantom read가 발생할 수 있습니다.
	 *					> 트랜잭션 Commit이 일어난 데이터에 대해서 조회가 가능
	 *					( 트랜잭션 완료 시까지 조회에 대한 Shared lock이 걸리지 않음 )
	 *
	 *
	 *			- SERIALIZABLE		: Dirty read, none repeatable read, phantom read가 방지됨을 나타내는 상수
	 *					
	 *					> phantom read가 발생하지 않습니다
	 *					> 거의 사용 x
	 *
	 *		
	 *
	 *		2) propagation (전파옵션)
	 *
	 *			- 기존 진행중인 트랜잭션 외에 추가적으로 진행중인 트랜잭션이 존재할 때 추가적인 트랜잭션에 대해서 어떻게 처리할 지에 대한 설정
	 *			- 추가적인 트랜잭션을 기존 트랜잭션에 포함시켜 함께 처리할 수 도 있고 
	 *				추가적인 트랜잭션처럼 별도의 트랜잭션으로 추가할 수 도 있고
	 *				다른 트랜잭션처럼 진행되다 에러를 발생 시킬수 도 있다
	 *
	 *			2-1) 옵션
	 *			- REQUIRED : 현재 트랜잭션을 지원하고 존재하지 않는 경우 새 트랜잭션을 만듭니다.
	 *					> propagation 기본 DEFAULT 옵션
	 *					> 부모/자식간에 상관관계에서 자식부분의 트랜잭션이 rollback 처리 시, 부모까지 영향이
	 *						가서 rollback 처리 됩니다.
	 *			- REQUIRES_NEW : 새로운 트랜잭션을 생성한다.
	 *					> rollback은 각각 이루어진다.
	 *			- SUPPORTS : 현재 트랜잭션이 있으면 현재 트랜잭션을 지원하고 트랜잭션이 없으면 트랜잭션이
	 *					아닌 다른 방식으로 실행합니다.
	 *			- MANDATORY : 현재 트랜잭션을 지원하고, 없으면 예외를 발생시킵니다.
	 *					> 독립적인 트랜잭션으로 진행하면 안되는 경우 사용
	 *			- NESTED : 현재 트랜잭션이 있는 경우 중첩된(부모-자식) 트랜잭션 내에서 실행하고 그렇지 않은
	 *							경우 REQUIRED와 같이 동작합니다.
	 *					> 부모에서 예외가 발생했을 때, 자식까지 영향이 가서 Commit되지 않는다.
	 *			- NEVER : 트랜잭션이 아닌 방식으로 실행하고 트랜잭션이 있으면 예외를 발생시킵니다.
	 *					> 실행자체가 트랜잭션을 필요로 하지 않고, 트랜잭션이 존재한다면 예외를 발생시킨다.
	 *					> Existing transaction found for transaction marked with
	 *						propagation 'never'
	 *
	 *	
	 *		3) readOnly (읽기전용 설정)
	 *
	 *			- 읽기 전용인 경우 설정할 수 있는 bool flag, 런타임 시 최적화를 허용한다
	 *			- 기본값은 false
	 *			- readonly 속성을 설정했다해서 읽기전용으로 무조건 설정된다는 보장이 없음
	 *				> 읽기전용에 대한 힌트를 분석할 수 없은 트랜잭션인 경우 throw를  던지지 않고 
	 *				조용히 힌트를 무시하고 쓰기와 같은 트랜잭션이 실행된다
	 *				> 그래서 꼮 무조건 읽기전용이라고는 못함
	 *
	 *
	 *		4) timeout (트랜잭션 제한시간)
	 *
	 *			- 기본값은 -1로 무제한
	 *			- timeout은 클라이언트와 서버와의 통신 중 서버측 문제로 다음 처리를 이어나가지 못하는 deadlock을 방지할 수 있는 속성
	 *			- 클라이언트와 서버간의 restful api를 개발시 고려해 볼 속성
	 *			
	 *
	 *
	 *		5) rollbackfor
	 *			- 트랜잭션 롤백을 유발해야 하는 예외 유형을 나타내는 0개 이상의 예외 유형을 나타내는 0개 이상ㅇ의 예외 유형을 정의
	 *			- 기본적으로 트랜잭션은 롤백되지만 runtimeException과 error외에 다른 종류의 예외는 롤백 안됨
	 *			- 기본적인 정책 이외에 에러를 처리할 경우 해당 에러를 선언해야 롤백 정책을 추가할 수 있음
	 *
	 *
	 *
	 *				
	 */


}
