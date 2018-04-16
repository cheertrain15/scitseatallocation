package com.scitportalsystem.www.dao;


import java.util.ArrayList;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.SeatMapper;
import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.SeatPlacement;
import com.scitportalsystem.www.vo.SeatStudent;


@Repository
public class SeatDAO{
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(SeatDAO.class);
	
		public MemberStaff getStaffInfo(String id) {
			
			logger.info("** LOADING getStaffInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			MemberStaff foundStaff = null;
			try{
				foundStaff = mapper.getStaffInfo(id);
			} catch (Exception e){
				
			}
			logger.info("** LOADED getStaffInfo() **");
			
			return foundStaff;
		}
		
		public int getMemberNum(String id) {
			
			logger.info("** LOADING getMemberNum() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int foundMemberNum = 0;
			try{
				foundMemberNum = mapper.getMemberNum(id);
			} catch (Exception e){
				
			}
			logger.info("** LOADED getMemberNum() **");
			
			return foundMemberNum;
		}

		
		public int saveSeatInfo(SeatPlacement seatPlacement) {
			logger.info("** LOADING saveSeatInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				result = mapper.saveSeatInfo(seatPlacement);
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED saveSeatInfo() **");
			
			return result;
		}
		
		
		public ArrayList<SeatPlacement> showSeatInfo(int seatCreator) {
			logger.info("** LOADING showSeatInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			ArrayList<SeatPlacement> result = null;
			try{
				result = mapper.showSeatInfo(seatCreator);
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED showSeatInfo() **");
			
			return result;
		}
		
		
		public int deleteSeatInfo(int seatPlacementNum) {
			logger.info("** LOADING deleteSeatInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				result = mapper.deleteSeatInfo(seatPlacementNum);
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED deleteSeatInfo() **");
			
			return result;
		}
		
		public SeatPlacement modifySeatPlacement(int seatPlacementNum) {
			logger.info("** LOADING modifySeatPlacement() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			SeatPlacement result = null;
			try{
				result = mapper.modifySeatPlacement(seatPlacementNum);
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED modifySeatPlacement() **");
			return result;
		}
		
		public int modifiedSeatSave(SeatPlacement seatPlacement) {
			logger.info("** LOADING modifiedSeatSave() **");
				SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
				int result = 0;
				try{
					result = mapper.modifiedSeatSave(seatPlacement);
				} catch (Exception e){
					e.printStackTrace();
				}
			logger.info("** LOADED modifiedSeatSave() **");
			return result;
		}
		
		public ArrayList<SeatStudent> seatForStudents(int teacherAlumni){
			logger.info("** LOADING seatForStudents() **");
				SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
				ArrayList<SeatStudent> result = null;
				try{
					result = mapper.seatForStudents(teacherAlumni);
				} catch (Exception e){
					e.printStackTrace();
				}
			logger.info("** LOADED seatForStudents() **");
			return result;
		}
	
	}
