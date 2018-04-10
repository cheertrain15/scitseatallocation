--문희규 : 자리 배치 자료를 저장하기 위한 sql

--좌석 배치도를 저장하는 테이블이다.
create Table seatPlacement(
	seatPlacementNum Number Primary Key		--좌석 배치도의 고유 번호
	, seatCreator Number	NOT NULL		--좌석 배치도 작성자
	, seatAlumni Number		NOT NULL		--이 배치도를 활용할 기수
	, seatClassroom varchar(1)	NOT NULL	--이 배치도를 활용할 반
	, seatCount	Number		NOT NULL		--현재 존재하는 좌석의 수 
	, seatContent CLOB		NOT NULL		--좌석 배치도에 대한 html 내용
	, seatCreatedDate Date NOT NULL			--작성일
	);

--좌석 배치도의 고유 	
create sequence seatPlacementNum_seq;

