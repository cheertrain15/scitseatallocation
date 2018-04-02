drop table askquestion;
drop table askquestionReply;
drop table basicEvaluation;
drop table itcertificate;
drop table itevaluation;
drop table jpcertificate;
drop table jpevaluation;
drop table memberstaff;
drop table memberstudent;
drop table memberstudentcertificate;
drop table memberstudentscore;
drop table memberstudentsurvey;
drop table news;
drop table memberbasic;
drop table registration;
drop table registerresult;
drop table survey;

commit;

drop sequence AskQuestionReplyNum_seq;
drop sequence askquestionNum_seq;
drop sequence basicEvaluationNum_seq;
drop sequence itevaluationnum_seq;
drop sequence jpevaluationnum_seq;
drop sequence membernum_seq;
drop sequence memberstudentscorenum_seq;
drop sequence memberstudentnum_seq;
drop sequence newsnum_seq;
drop sequence registrationnum_seq;
drop sequence surveynum_seq;
drop sequence surveyReplyNum_seq;
drop sequence teacherNum_seq;

commit;

----------------------------------------------------------------------------------
-- SC IT 마스터 웹 프로그램 학사 관리 Project : SC IT MASTER Potal System

-- 학색 정보 테이블
CREATE table memberbasic (
    memberNum number PRIMARY KEY,	            -- 회원번호
    id varchar2(20) not null unique,		    -- 아이디
    password varchar2(20) not null,	    	    -- 비밀번호
    memberClass varchar2(10) not null,		    -- 회원등급
    memberPicName varchar(1000),		        -- 회원 사진 파일 이름	
    memberSaverPicName varchar(1000),		    -- 실제로 서버에 저장된 회원 사진 파일 이름
    name varchar2(20) not null,			        -- 이름(실명)
    email varchar2(50) not null,		        -- 이메일
    emailApproval NUMBER(1) default 0 not null,  -- 이메일 인증 여부
    phone varchar2(11) not null,		        -- 전화번호
    address varchar2(200) not null,		         -- 주소
    postNum varchar2(10) not null,	        	-- 우편번호
    deleteStatus number(1) default 0 not null,	-- 논리적 삭제 여부
    deleteBy varchar2(20) not null,		        -- 논리적 삭제 실행자
    deleteDate date default sysdate     -- 논리적 삭제 실행일
    );

-- 회원 가입 시, 회원번호에 사용할 시퀀스    
CREATE sequence membernum_seq start with 1 increment by 1;

-- 테스트용 선생님 데이터
INSERT INTO memberbasic (
	membernum
	, id
	, password
	, memberclass
	, name
	, email
    , emailApproval
	, phone
	, address
	, postnum
	, deleteby
	) 
	values
	(
	membernum_seq.nextval
	, 'testid'
	, 'password'
	, 'teacher'
	, '이름'
	, 'aaa@aa.com'
    ,  1
	, '0104445555'
	, '서울시 강남구 삼성동 코엑스 4층'
	, '15425'
	, ' '
    );
    
    -- 테스트용 학생 데이터
INSERT INTO memberbasic (
	membernum
	, id
	, password
	, memberclass
	, name
	, email
    , emailApproval
	, phone
	, address
	, postnum
	, deleteby
	) 
	values
	(
	membernum_seq.nextval
	, 'testid2'
	, 'password'
	, 'student2'
	, '이름2'
	, 'aaa2@aa.com'
    , 1
	, '0104445555'
	, '서울시 강남구 삼성동 코엑스 4층'
	, '15425'
	,' ' );
    

--------------------------------------------------------------------------------


-- SCIT 회원들 중 학사 및 선생님의 담당부서에 대한 정보 테이블
CREATE table memberstaff(
	teacherNum number PRIMARY KEY,  			-- 학사번호
	id varchar2(20) not null CONSTRAINT FK_memberbasic3 
	 REFERENCES memberbasic(id),  				-- 회원 아이디
	inChargeAlumni varchar2(10) not null,		-- 담당기수
	inChargeSubject varchar2(10) not null		-- 담당과목
    );

-- SCIT 학사 및 선생님에 사용할 시퀀스
CREATE sequence teacherNum_seq start with 1 increment by 1;

--테스트용 선생님 데이터 입력 
INSERT INTO memberstaff (
	teacherNum
	, id 
	,inChargeAlumni 
	,inChargeSubject
	) 
	values
	(
	teacherNum_seq.nextval
	, 'testid' 
	,'1'
	,'IT'
    );
    

-------------------------------------------------------------------------------

-- SC IT 회원들 주 학생의 기수 정보
CREATE table memberstudent(
	memberstudentNum Number Primary Key -- 학생번호
	, id varchar2(20) CONSTRAINT FK_memberbasic2 
	 REFERENCES memberbasic(id),	 -- 회원아이디
	alumni number(3) not null,	         -- 기수
	itMajor number(1) default 0,	     -- IT전공 유무
	jpMajor number(1) default 0, 	     -- 일본어전공 유무
	classroom varchar2(1) not null,	     -- 반
	groupnum number(2) not null,	     -- 조
	seat number(2) not null,	         -- 좌석
	late number(3) default 0,	         -- 지각
	early number(3) default 0,	         -- 조퇴
	absent number(3) default 0	         -- 결석
);

--학생번호 시퀀스 생성
create sequence memberstudentNum_seq start with 1 increment by 1;


-- 테스트용 학생 데이터 입력
insert into memberstudent(
	memberstudentNum
	, id 
	, alumni 
	, itMajor
	, jpMajor
	, classroom
	, groupnum 
	, seat 
	, late 
	, early 
	, absent 
    )
    values
    (
    memberstudentNum_seq.nextval
    , 'testid2'
	, 1
	, 0
	, 0
	, 'A'
	, 9
	, 25
	, 1
	, 1
	, 3
    );
    
--------------------------------------------------------------------------------

-- SCIT 공지사항에 대한 정보
CREATE table news(
	newsNum number PRIMARY KEY not null,			    -- 공지사항 글번호
	id varchar(20) CONSTRAINT FK_memberstudent 		-- 작성자 id
	 REFERENCES memberbasic(id) not null,		 
	targetAlumni NUMBER(3) not null,				    -- 공지사항 조회 대상자 (기수)
	targetClass varchar2(1) not null,				    -- 공지사항 조회 대상자 (반)
	newsTitle varchar2(100) not null,			        -- 공지사항 제목
	newsHeader varchar2(20),				            -- 공지사항 말머리
	newsContent varchar2(1000) not null,			    -- 공지사항 글 내용
	newsFileName varchar2(1000),				        -- 공지사항 첨부 파일 이름
	newsSavedFileName varchar2(1000),			        -- 실제로 서버에 저장된 첨부파일 이름
	newsDate date default sysdate,				        -- 공지사항 작성일
	newsDisplay number(1) default 1,			        -- 공지사항 노출
	newsHits number	default 0,							-- 공지사항 조회수
	deleteStatus number(1) default 0,			        -- 논리적 삭제여부
	deleteBy varchar2(20) not null,				        -- 논리적 삭제 실행자
	deleteDate date default sysdate				        -- 논리적 삭제 실행일
);

-- SCIT 공지사항 글번호에 사용할 시퀀스
CREATE sequence newsNum_seq start with 1 increment by 1;

--테스트용 공지사항 추가
insert into news(
    newsNum 
	, id 
	, targetAlumni
	, targetClass
    , newsTitle 
	, newsHeader 
	, newsContent 
	, newsFileName 
	, newsSavedFileName
	, newsDate 
	, newsDisplay 
	, newsHits
	, deleteStatus 
	, deleteBy 
	, deleteDate 
    )
    values
    (
    newsNum_seq.nextval
	, 'testid' 
	, 34
	, 'A'
    , 'TEST NEWS 빨리 나가고 싶다' 
	, '중요' 
	, '여러분은 여기서 이제 나갈 수 없습니다.'
	, ' ' 
	, ' '
	, SYSDATE
	, 1 
	, 0
	, 0
	, ' ' 
	, SYSDATE 
    );
   

--------------------------------------------------------------------------------    

-- SCIT 학생의 지각통보
create table Registration(
    registrationNum NUMBER NOT NULL,            -- 지각통보 글 번호
    id varchar2(20) CONSTRAINT FK_MemberStudent2
    REFERENCES memberbasic(id) NOT NULL, 		-- 글 작성자 아이디
    registrationContent Varchar(300) NOT NULL,  -- 지각통보 글 내용
    estimatedTime Varchar(30) NOT NULL,         -- 도착 예정 시간
    registrationDate DATE default sysdate,      -- 지각통보 글 작성일
    registerResult number(1) default 0,			-- 지각 처리 결과 (0=정상, 1=지각, 2=결석)
    deleteStatus NUMBER(1) default 0 NOT NULL,  -- 논리적 삭제 여부
    deleteBy Varchar2(20) NOT NULL,             -- 논리적 삭제 실행자
    deleteDate Date default sysdate             -- 논리적 삭제 실행일
);

create sequence registrationNum_seq start with 1 increment by 1;

--테스트용 학생의 지각 보고서
insert into registration(
    registrationNum 
    , id
    , registrationContent 
    , estimatedTime 
    , registrationDate 
    , registerResult
    , deleteStatus 
    , deleteBy 
    , deleteDate 
    )
    values
    (
    registrationNum_seq.nextval
    , 'testid2'
    , '쌤 저 늦잠자서 늦어요 ㅈㅅ'
    , '오후 9시 00분'
    , Sysdate 
    , 0
    , 0 
    , ' '
    , sysdate
    );

--------------------------------------------------------------------------------

--SCIT RegisterResult(출결 결과 ) 테이블

create table RegisterResult(
    registerResult number(1) primary key,			-- 출결결과 (0=출석, 1=지각, 2=결석)
    registerResultName varchar(10) not null				-- 출결결과의 뜻(0=출석, 1=지각, 2=결석)
);

--RegisterResult 테이블에 사용할 자료 입력 (0번 == 정상)
insert into RegisterResult(
    registerResult ,
    registerResultName
    )
    values
    (
    0 ,
    '출석'
    );
    
--RegisterResult 테이블에 사용할 자료 입력 (1번 == 지각)
insert into RegisterResult(
    registerResult ,
    registerResultName
    )
    values
    (
    1 ,
    '지각'
    );
    
--RegisterResult 테이블에 사용할 자료 입력 (2번 == 결석)
insert into RegisterResult(
    registerResult ,
    registerResultName
    )
    values
    (
    2 ,
    '결석'
    );    


--------------------------------------------------------------------------------

-- SCIT 학생의 자격증 보유 현황
create table MemberStudentCertificate(
    id varchar(20) CONSTRAINT FK_memberbasic4 
	 REFERENCES memberbasic(id) NOT NULL,    -- 회원ID
    itCertificate Number(1) default 0 NOT NULL,     -- 정보처리기사/산업기사 유무
    jpCertificate Number(1) default 0 NOT NULL,  -- JLPT
    otherCertificate Varchar2(300) NOT NULL         -- 기타 자격증
);

insert into MemberStudentCertificate(
	id
	, itCertificate
	, jpCertificate
	, otherCertificate
	)
	values
	(
	'testid2'
	, 1
	, 0
	, ' '
	);

create table itCertificate(
    itCertificateNum Number(1) Primary Key   -- 자격증 번호
    , itCertificateName Varchar2(100) -- 자격증 이름
    );
    

--IT자격증 없을시의  데이터 입력
insert into itCertificate (
    itCertificateNum 
    , itCertificateName
    )
    values
    (
    0 
    , '없음'
    );
    
--정보처리산업기사  데이터 입력
insert into itCertificate (
    itCertificateNum 
    , itCertificateName
    )
    values
    (
    1
    , '정보처리산업기사'
    );
    
--정보처리기사  데이터 입력
insert into itCertificate (
    itCertificateNum 
    , itCertificateName
    )
    values
    (
    2
    , '정보처리기사'
    );
    
--정보처리기사&산업기사  데이터 입력
insert into itCertificate (
    itCertificateNum 
    , itCertificateName
    )
    values
    (
    3
    , '정보처리기사, 정보처리산업기사'
    );
    

--JLPT 자격증 테이블 생성    
create table jpCertificate(
    jpCertificateNum Number(1) Primary Key   -- 자격증 번호
    , jpCertificateName Varchar2(100) -- 자격증 이름
    );
    
--JLPT 무소유 데이터 입력
insert into jpCertificate (
    jpCertificateNum 
    , jpCertificateName
    )
    values
    (
    0
    , '없음'
    );    

--JLPT 1급 데이터 입력
insert into jpCertificate (
    jpCertificateNum 
    , jpCertificateName
    )
    values
    (
    1
    , 'JLPT 1급'
    );    
    
--JLPT 2급 데이터 입력
insert into jpCertificate (
    jpCertificateNum 
    , jpCertificateName
    )
    values
    (
    2
    , 'JLPT 2급'
    );    
    
--JLPT 3급 데이터 입력
insert into jpCertificate (
    jpCertificateNum 
    , jpCertificateName
    )
    values
    (
    3
    , 'JLPT 3급'
    );    
    
--------------------------------------------------------------------------------

-- SCIT 학생 설문조사 결과
create table MemberStudentSurvey(
    surveyReplyNum NUMBER Primary key ,         -- 설문조사 응답 번호
    surveyNum Number,                           -- 설문조사 양식 번호
    id varchar(20) CONSTRAINT FK_memberbasic5 
	 REFERENCES memberbasic(id) NOT NULL,		-- 회원ID
    surveyTitle Varchar2(100) NOT NULL,         -- 설문조사 제목
    participate Number(1) default 0 NOT NULL,   -- 설문조사 참여 여부
    participateDate DATE                        -- 설문조사 참여일/수정일
);

create sequence surveyReplyNum_seq start with 1 increment by 1;

--테스트용 설문조사 참여 데이터 입력
insert into MemberStudentSurvey(
    surveyReplyNum 
    , surveyNum 
    , id 	
    , surveyTitle
    , participate 
    , participateDate
    )
    values
    (
    surveyReplyNum_seq.nextval
    , 1 
    , 'testid2'
    , '여길 나가야겠어. 안되잖아?!'
    , 1
    , sysdate
    );

--------------------------------------------------------------------------------

-- SCIT 학생 설문조사 답변 양식(*Prototype)
create table Survey(
    surveyNum NUMBER Primary Key,               	-- 설문조사 양식 번호
    id varchar2(20) CONSTRAINT FK_memberbasic6 
	 REFERENCES memberbasic(id) NOT NULL,			-- 회원ID
    surveyTitle Varchar2(100) NOT NULL,         	-- 설문조사 제목
    surveyWrittenDate	Date	NOT NULL,			-- 설문조사 작성일
    surveyStartDate		Date	NOT NULL,			-- 설문조사 시작일
    surveyEndDate		Date	NOT NULL,			-- 설문조사 종료일
    frontBack NUMBER(1) default 2 NOT NULL,     	-- 선호하는 자리(앞/뒤)
    sideCenter NUMBER(1) default 2 NOT NULL,    	-- 선호하는 자리(벽쪽/가운데)
    avoidMember Varchar2(10),		            	-- 같은 조가 되기 싫은 사람
    etcMessage Varchar2(1000)                   	-- 비고란
);

create sequence surveyNum_seq start with 1 increment by 1;

--테스트용 설문조사 응답 자료 넣기
insert into Survey(
    surveyNum 
    , id 
    , surveyTitle
    , surveyWrittenDate
    , surveyStartDate
    , surveyEndDate
    , frontBack 
    , sideCenter 
    , avoidMember 
    , etcMessage 
    ) 
    values
    (
    surveyNum_seq.nextval
    , 'testid2'
    , '1차 자리 설문조사'
    , sysdate
    , sysdate
    , sysdate
    , 0 
    , 1
    , '문희규' 
    , '금요일마다 집에 일찍 보내주세요.'
    );

--------------------------------------------------------------------------------

-- 1:1문의 기능용 테이블 작성
create table AskQuestion(
    AskQuestionNum NUMBER Primary Key,             	-- 문의 글번호
    id varchar2(20) CONSTRAINT FK_memberbasic7 
	 REFERENCES memberbasic(id) NOT NULL,    -- 문의 글 작성자 회원ID 
    AskQuestionTitle Varchar2(100) NOT NULL,    	-- 문의 제목
    AskQuestionContent Varchar2(1000) NOT NULL, 	-- 문의 글 내용
    AskQuestionDate DATE default sysdate NOT NULL, 	-- 문의 글 작성일
    deleteStatus NUMBER(1) default 0 NOT NULL,      -- 논리적 삭제 여부
    deleteBy Varchar2(20) NOT NULL,                 -- 논리적 삭제 실행자
    deleteDate Date default sysdate NOT NULL        -- 논리적 삭제 실행일
);

create sequence AskQuestionNum_seq start with 1 increment by 1;

--테스트용 1:1문의 생성하기
insert into AskQuestion(
    AskQuestionNum 
    , id 
    , AskQuestionTitle
    , AskQuestionContent 
    , AskQuestionDate 
    , deleteStatus 
    , deleteBy 
    , deleteDate 
    )
    values
    (
    AskQuestionNum_seq.nextval
    , 'testid2'
    , '쌤...배가 아파요'
    , '끄아아아악'
    , Sysdate
    , 0
    , ' '
    , sysdate
    );

--------------------------------------------------------------------------------

-- SCIT 학생 평가 자료
create table MemberStudentScore(
    MemberStudentScoreNum Number Primary Key, 	        -- 학생 평가 테이블 번호
    id varchar2(20) CONSTRAINT FK_memberbasic8 
	 REFERENCES memberbasic(id) NOT NULL,   	-- 회원ID
    itEvaluation Number CONSTRAINT FK_memberbasic9 
	 REFERENCES memberbasic(memberNum) NOT NULL,    -- IT 평가
    jpEvaluation Number CONSTRAINT FK_memberbasic10 
	 REFERENCES memberbasic(memberNum) NOT NULL,    -- 일본어 평가
    basicEvaluation Number CONSTRAINT FK_memberbasic11 
	 REFERENCES memberbasic(memberNum) NOT NULL     -- 선생님의 평가
);

create sequence MemberStudentScoreNum_seq start with 1 increment by 1;

--테스트용 학생 성적표 생성하기
insert into MemberStudentScore(
    MemberStudentScoreNum 
    ,id
    ,itEvaluation
    ,jpEvaluation
    ,basicEvaluation
    )
    values
    (
    MemberStudentScoreNum_seq.nextval
    ,'testid2'
    ,2
    ,2
    ,2
    );
    
    
--------------------------------------------------------------------------------

-- SCIT 학생 평가 자료 (IT)
create table itEvaluation(
    itEvaluationNum NUMBER Primary Key,            -- IT 평가표 번호
    id varchar2(20) CONSTRAINT FK_memberbasic12 
	 REFERENCES memberbasic(id) NOT NULL,		-- 회원ID
    itTestFirst NUMBER(3) NOT NULL,             -- IT 1차 역량평가
    itTestSecond NUMBER(3) NOT NULL,            -- IT 2차 역량평가
    itTestThird NUMBER(3) NOT NULL,             -- IT 3차 역량평가    
    itProjectFirst NUMBER(3) NOT NULL,          -- IT 1차 프로젝트
    itProjectSecond NUMBER(3) NOT NULL,         -- IT 2차 프로젝트
    itProjectThird NUMBER(3) NOT NULL,          -- IT 3차 프로젝트
    itProjectFInal NUMBER(3) NOT NULL           -- IT 단체 프로젝트  
);

--IT 평가표 번호 시퀀스 생성
create sequence itEvaluationNum_seq start with 1 increment by 1;

--테스트용 학생 IT 성적표 생성
insert into itEvaluation(
    itEvaluationNum 
    , id
    , itTestFirst
    , itTestSecond 
    , itTestThird
    , itProjectFirst 
    , itProjectSecond 
    , itProjectThird
    , itProjectFInal 
    )
    values
    (
    itEvaluationNum_seq.nextval
    , 'testid2'
    , 33
    , 36 
    , 80
    , 70 
    , 90 
    , 100
    , 40 
    );
    

--------------------------------------------------------------------------------

-- SCIT 학생 평가 자료 (일본어)
create table jpEvaluation(
    jpEvaluationNum NUMBER Primary key,            -- 일본어 평가 번호
   	id varchar2(20) CONSTRAINT FK_memberbasic13 
	 REFERENCES memberbasic(id) NOT NULL,		-- 회원ID
    jpTestFirst NUMBER(3) NOT NULL,             -- 일본어 1차 역량평가
    jpTestSecond NUMBER(3) NOT NULL,            -- 일본어 2차 역량평가
    jpTestThird NUMBER(3) NOT NULL,             -- 일본어 3차 역량평가    
    jpOralTestFirst NUMBER(3) NOT NULL,         -- 일본어 1차 인터뷰
    jpOralTestSecond NUMBER(3) NOT NULL,        -- 일본어 2차 인터뷰
    jpOralTestThird NUMBER(3) NOT NULL,         -- 일본어 3차 인터뷰
    jpTestIntroduction NUMBER(3) NOT NULL,      -- 일본어 자기 소개 스피치  
    jpTestPresentation NUMBER(3) NOT NULL       -- 일본어 프로젝트 발표
);

create sequence jpEvaluationNum_seq start with 1 increment by 1;

--테스트용 학생 일본어 성적 정보 입력
insert into jpEvaluation(
    jpEvaluationNum 
    , id 
    , jpTestFirst 
    , jpTestSecond 
    , jpTestThird 
    , jpOralTestFirst 
    , jpOralTestSecond 
    , jpOralTestThird 
    , jpTestIntroduction 
    , jpTestPresentation 
    )
    values
    (
    jpEvaluationNum_seq.nextval
    , 'testid2' 
    , 54 
    , 66 
    , 42 
    , 14 
    , 68 
    , 88 
    , 41 
    , 70 
    );


--------------------------------------------------------------------------------

-- SCIT 학생 평가 자료 (Basic)
create table basicEvaluation(
    basicEvaluationNum NUMBER Primary Key,         -- Basic 평가 번호
    id varchar2(20) CONSTRAINT FK_memberbasic14 
	 REFERENCES memberbasic(id) NOT NULL,		-- 회원ID
    basicAttendance NUMBER(3) NOT NULL,         -- 출결 평가
    basicAction NUMBER(3) NOT NULL,             -- 언행 평가
    basicBehaviour NUMBER(3) NOT NULL,          -- 수업 태도 
    basicRule NUMBER(3) NOT NULL,               -- 내규 엄수
    basicExplanatory NUMBER(3) NOT NULL,        -- 사유서 작성 횟수
    basicConsult NUMBER(3) NOT NULL             -- 교수님과의 면담 횟수
);

create sequence basicEvaluationNum_seq start with 1 increment by 1;

--테스트용 학생 BASIC 점수 생성
insert into basicEvaluation(
    basicEvaluationNum 
    , id 
    , basicAttendance
    , basicAction
    , basicBehaviour 
    , basicRule 
    , basicExplanatory 
    , basicConsult 
    ) 
    values
    (
    basicEvaluationNum_seq.nextval 
    , 'testid2'
    , 80
    , 70
    , 50 
    , 60 
    , 2 
    , 4
    );
    
--------------------------------------------------------------------------
-- 2018.03.31 추가된것 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
--------------------------------------------------------------------------

--1:1문의의 댓글 정보
create table AskQuestionReply (
	AskQuestionReplyNum		number	primary key,	--리플번호
	AskQuestionNum NUMBER CONSTRAINT FK_AskQuestionNum 
	 REFERENCES AskQuestion(AskQuestionNum) NOT NULL,		-- 1:1문의 글번호
	id			varchar2(20) not null,			--작성자 ID
	text			varchar2(1000) not null,					--리플내용
	inputdate		date 	default sysdate					--작성날짜
);

--1:1 문의 댓글의 시퀀스 생성
create sequence AskQuestionReplyNum_seq start with 1 increment by 1;

--1:1 문의 댓글 샘플데이터 입력
insert into AskQuestionReply (
	AskQuestionReplyNum		
	, AskQuestionNum  
	, id
	, text
	, inputdate
	)
	values
	(
	AskQuestionReplyNum_seq.nextval
	, 1
	, 'testid2'
	, '일본 가즈아아아아!'
	, sysdate
	);
    
    commit;

