package com.scitportalsystem.www.dao;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.SeatMapper;
import com.scitportalsystem.www.vo.MemberStaff;


@Repository
public class SeatDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(SeatDAO.class);
	
		public MemberStaff getStaffInfo() {
			
			logger.info("** LOADING getStaffInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			MemberStaff foundStaff = null;
			try{
				foundStaff = mapper.getStaffInfo();
				System.out.println("VO : " + foundStaff);
			} catch (Exception e){
				
			}
			logger.info("** LOADED getStaffInfo() **");
			
			return foundStaff;
		}
	
	}
