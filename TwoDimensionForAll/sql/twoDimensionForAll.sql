drop table member;
commit;

create table members (
    id varchar2(100) primary key
);
commit;

drop table video;
commit;

create table video(
    videonum number primary key,
    videoname varchar2(60) not null,
    videogenre varchar2(30) not null,
    videosource varchar2(1000) not null,
    videothumbnail varchar2(1000) not null,
    videoregisterdate DATE not null
);
commit;

create sequence videonum_seq start with 1;
commit;

create table userfavourite (
	favouritenum number primary key,
    id varchar2(100) not null,
    favouritevideo number
);
commit;

create sequence userfavouritenum_seq;
commit;

create table userhistory (
	historynum number primary key,
    id varchar2(100) not null,
    historyvideo number
);
commit;

create sequence userhistorynum_seq;
commit;

--8 여기부터는 데이터 추가하는 구간 8--

drop table video;

-- 장난 잘 치는 타가기 양 --

insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (0
    ,'Karakai Jozu no Takagi-san Episode 1'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v1536tJ2jNppwKjALUJOAew@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );

    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 2'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v8369rQRTonoFATMSqZATFr@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 3'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v02bfeffwNqehW2Ef04G3x0@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 4'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v08d2gpAEgxNNwpcgBcvBxx@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 5'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v60d3iOIOgugI3OOOn1qqzz@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 6'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v236ezpopHHozSwwyS4yps4@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
     insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 7'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v7d3blHl9aea3emmrye39F1@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Karakai Jozu no Takagi-san Episode 8'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/vcc9fBjsBBjqqmaa7agkgIk@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv1536tJ2jNppwKjALUJOAew%2F5.png'
    ,SYSDATE
    );
    
    
    -- 식극의 소마(박혜인씨가 추천한 애니) --
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 1'
    ,'Animation'
    ,'http://cxvgjgifqet.site/video0/id_3040.heqa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 2'
    ,'Animation'
    ,'http://cxvgjgifqet.site/video0/id_3041.heqa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 3'
    ,'Animation'
    ,'http://cxvgjgifqet.site/video0/id_3042.heqa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 4'
    ,'Animation'
    ,'http://cxvgjgifqet.site/video0/id_3043.heqa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 5'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29208.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 6'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29209.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 7'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29210.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 8'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29211.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 9'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29212.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 10'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29193.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 11'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29194.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shokugeki no Soma Episode 12'
    ,'Animation'
    ,'http://a0000001114.site/video1/id_29195.hqsa'
    ,'https://test.cjeqqwsa.xyz/img/ani_video/29208.jpg'
    ,SYSDATE
    );


	-- 소녀종말여행--

	 insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shoujo Shuumatsu Ryokou Episode 1'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v2335o3WLDXkkP3WuuLukjk@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv23133hNMc7ccyE7eEyuohj%2F2.png'
    ,SYSDATE
    );
    
    insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shoujo Shuumatsu Ryokou Episode 2'
    ,'Animation'
    ,'http://tv.kakao.com/embed/player/cliplink/v2ed4XU11c71ZGZXoHmH1rj@my?service=daum_tistory'
    ,'http://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv23133hNMc7ccyE7eEyuohj%2F2.png'
    ,SYSDATE
    );

	 -- 심야 식당 시즌 1 --
     insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shinya Shokudou S1 Ep.1'
    ,'Drama'
    ,'https://kakaotv.daum.net/embed/player/cliplink/53689024?service=und_player'
    ,'https://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv120c1tcHQPcNDDOawP6N6H%2F5.png'
    ,SYSDATE
    );
    
     insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shinya Shokudou S1 Ep.2'
    ,'Drama'
    ,'https://kakaotv.daum.net/embed/player/cliplink/53689268?service=undefined&section=undefined'
    ,'https://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv120c1tcHQPcNDDOawP6N6H%2F5.png'
    ,SYSDATE
    );
    
     insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shinya Shokudou S1 Ep.3'
    ,'Drama'
    ,'https://cdn.videofarm.daum.net/vod/vcd95WOUUvXWU66wOYVCaVW/mp4_360P_1M_T1/movie.mp4?px-time=1520394216&px-hash=40689fed50de4a62682bc5de8edfeb4b&px-bps=1404283&px-bufahead=12'
    ,'https://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv120c1tcHQPcNDDOawP6N6H%2F5.png'
    ,SYSDATE
    );
    
       insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shinya Shokudou S1 Ep.4'
    ,'Drama'
    ,'https://kakaotv.daum.net/embed/player/cliplink/53689916?service=undefined&section=undefined'
    ,'https://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv120c1tcHQPcNDDOawP6N6H%2F5.png'
    ,SYSDATE
    );
    
      insert into video
    (VIDEONUM
    ,VIDEONAME
    ,VIDEOGENRE
    ,VIDEOSOURCE
    ,VIDEOTHUMBNAIL
    ,VIDEOREGISTERDATE)
    VALUES
    (videonum_seq.nextval
    ,'Shinya Shokudou S1 Ep.5'
    ,'Drama'
    ,'https://kakaotv.daum.net/embed/player/cliplink/53688937?service=undefined&section=undefined'
    ,'https://t1.daumcdn.net/thumb/C320x180.fjpg.q75/?fname=http%3A%2F%2Ft1.daumcdn.net%2Ftvpot%2Fthumb%2Fv120c1tcHQPcNDDOawP6N6H%2F5.png'
    ,SYSDATE
    );
    
        
commit;
    


