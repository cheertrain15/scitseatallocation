drop table member;
drop sequence member_seq;
commit;

--Member --

Create Table Member(
    memberNum NUMBER primary key
    , memberId varchar2(30) unique
    , memberPassword varchar2(30) not null
    , memberName varchar2(50) not null
    , memberEmail varchar2(100) not null
    , memberPhone varchar2(11) not null
    , memberGender varchar2(6) not null
    
    , memberAddress varchar2(200) not null
    
    , memberDesireField varchar2(100) not null
    , memberDesirePayment NUMBER not null
    , memberDesireCommuteDistance NUMBER (4,2) not null
    , memberDesiredWorkingTime NUMBER (2) not null
    
    , memberRecieveNotice NUMBER (1) Default 1
    , memberRegisteredDate DATE Default SYSDATE
    
    , memberDeletedStatus NUMBER (1) Default 0
    , memberDeletedBy varchar(30)
    , memberDeletedTime DATE DEFAULT SYSDATE
);

CREATE SEQUENCE member_seq;

insert into 
    member
    (
    memberNum 
    , memberId 
    , memberPassword 
    , memberName 
    , memberEmail 
    , memberPhone
    , memberGender 
    
    , memberAddress
    
    , memberDesireField 
    , memberDesirePayment
    , memberDesireCommuteDistance 
    , memberDesiredWorkingTime
    
    , memberRecieveNotice 
    , memberRegisteredDate
    
    , memberDeletedStatus 
    , memberDeletedBy 
    , memberDeletedTime 
    ) 
    values
    (
    member_seq.nextval
    , 'admin'
    , 'admin'
    , 'admin'
    , 'admin@admin'
    , '9999999999'
    , 'Male'
    
    , 'admin'

    , 'admin'
    , 0
    , 0
    , 0
    
    , 0
    , SYSDATE
    
    , 0
    , 'N/A'
    , ''
    );

commit;

-- COMPANY -- 

CREATE TABLE COMPANY(
     companyNum NUMBER primary key
    , companyName varchar2(50) unique
    , companyCEO varchar2(50) not null
    , companyEmail varchar2(100) not null
    , companyPhone varchar2(11) not null
    
    , companyAddress varchar2(200) not null
   
    
    , companyField varchar2(100) not null
    , companyPayment NUMBER not null
    , companyWorkingTime NUMBER (2) not null
    , companyEmployee NUMBER 
    , companyCapital NUMBER
    , companyFoundation DATE Default NULL
    , companyHomepage varchar2(200)
    
    , companyRegisteredDate DATE Default SYSDATE
    , companyDeletedStatus NUMBER (1) Default 0
    , companyDeletedBy varchar(30)
    , companyDeletedTime DATE DEFAULT SYSDATE
    , companyUpdatedBy varchar(30)
    , companyUpdatedTime DATE DEFAULT SYSDATE
    
    , companyImageFileRoot varchar2(400)
    );
    
CREATE SEQUENCE company_seq;   

commit;

INSERT INTO 
    COMPANY(
     companyNum 
    , companyName
    , companyCEO 
    , companyEmail
    , companyPhone 
    
    , companyAddress
    , companyField 
    , companyPayment 
    , companyWorkingTime 
    , companyEmployee
    , companyCapital
    , companyFoundation
    , companyHomepage
    
    , companyRegisteredDate 
    , companyDeletedStatus 
    , companyDeletedBy 
    , companyDeletedTime 
    , companyUpdatedBy 
    , companyUpdatedTime 
    
    , companyImageFileRoot
    ) values (
  company_seq.nextval
    , 'adminCom'
    , 'adminCom'
    , 'adminCom@admin'
    , '99999999999'
    
    , 'adminCom'
    , 'adminCom'
    , 0
    , 0
    , 0
    , 0
    , null
    , 'adminCom'
    
    , SYSDATE
    , 0
    , 'adminCom'
    , SYSDATE
    , 'adminCom'
    , SYSDATE
    
    , 'https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png'
    );
    
    commit;
    
-- REPLY -- 
drop table companyReply;
drop sequence companyreply_seq;
drop table userReply;
drop sequence userReply_seq;
commit;

Create Table CompanyReply (
    companyReplyNum NUMBER Primary Key
    , writer varchar2(100) not null
    , memberNum number not null
    , companyNum number not null
    , replyMessage varchar2(1000) not null
    , replyDate DATE DEFAULT SYSDATE
    , replyDeletedStatus NUMBER(1) DEFAULT 0
    , replyDeletedDate DATE DEFAULT SYSDATE
    , replyDeletedBy varchar2(100)
    , companyScore NUMBER (2,1) not null
);

Create Sequence companyReply_seq;

commit;

insert into  
    CompanyReply 
    (
    companyReplyNum 
    , writer
    , memberNum
    , companyNum 
    , replyMessage 
    , replyDate 
    , replyDeletedStatus 
    , replyDeletedDate
    , replyDeletedBy 
    , companyScore 
    ) values (
     companyReply_seq.nextval
    , 'admin'
    , 1
    , 1
    , 'from : admin'
    , SYSDATE
    , 0
    , SYSDATE
    , 'admin'
    , 4.9
    );
    
    commit;
    

Create Table UserReply (
   userReplyNum NUMBER Primary Key
    , writer varchar2(100) not null
    , memberNum number not null 
    , companyReplyNum number not null
    , replyMessage varchar2(1000) not null
    , replyDate DATE DEFAULT SYSDATE
    , replyDeletedStatus NUMBER(1) DEFAULT 0
    , replyDeletedDate DATE DEFAULT SYSDATE
    , replyDeletedBy varchar2(100)
);

Create Sequence UserReply_seq;

commit;

insert into  
    UserReply 
    (
    userReplyNum 
    , writer 
    , memberNum
    , companyReplyNum 
    , replyMessage 
    , replyDate 
    , replyDeletedStatus 
    , replyDeletedDate
    , replyDeletedBy 
    ) values (
     UserReply_seq.nextval
    , 'subadmin'
    , 1
    , 2
    , 'from : subadmin'
    , SYSDATE
    , 0
    , SYSDATE
    , 'subadmin'
    );
    
    commit;
    
    --Score--
    Create Table CompanyEvaluation(
    companyNum NUMBER primary key
    , companyScore NUMBER(2,1) not null
    );
    
    insert into 
        CompanyEvaluation
        (
         companyNum 
         , companyScore 
        )
        values 
        (
        1,
        4.9
        );
        
        commit;
    
    drop table score;
    commit;
    
    Create Table Score(
    score NUMBER primary key
    ,rate varchar2(1) not null
    );
    
    commit;

    insert into Score(score , rate) values (0 , 'F');
    insert into Score(score , rate) values (1 , 'E');
    insert into Score(score , rate) values (2 , 'D');
    insert into Score(score , rate) values (3 , 'C');
    insert into Score(score , rate) values (4 , 'B');
    insert into Score(score , rate) values (5 , 'A');
    
    commit;
            
    
