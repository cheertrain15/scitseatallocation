package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.SeatMapper;
import com.scitportalsystem.www.vo.EvaluationCount;
import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.SeatAvoid;
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
		
		public ArrayList<SeatPlacement> showSeatInfoForStudent(int alumni) {
			logger.info("** LOADING showSeatInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			ArrayList<SeatPlacement> result = null;
			try{
				result = mapper.showSeatInfoForStudent(alumni);
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED showSeatInfo() **");
			
			return result;
		}
		
		public int defaultStudentSeat(int seatPlacementNum) {
			logger.info("** LOADING deleteSeatInfo() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				result = mapper.defaultStudentSeat(seatPlacementNum);
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED deleteSeatInfo() **");
			
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
		
		public int cancelStudentSeat(int[] studentNumOfStudentList) {
			logger.info("** LOADING cancelStudentSeat() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				//TODO : Find a way of updating a list type object in sql.
				for(int i = 0 ; i < studentNumOfStudentList.length ; i++ ) {
				result += mapper.cancelStudentSeat(studentNumOfStudentList[i]);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED cancelStudentSeat() **");
			return result;
		
		}
		
		public int dispatchSeatForStudent(List<SeatStudent> seatStudent) {
			logger.info("** LOADING dispatchSeatForStudent() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				//TODO : Find a way of updating a list type object in sql.
				for(int i = 0 ; i < seatStudent.size() ; i++ ) {
				result += mapper.dispatchSeatForStudent(seatStudent.get(i));
				}
			} catch (Exception e){
				e.printStackTrace();
			}
			logger.info("** LOADED dispatchSeatForStudent() **");
			return result;
		}
		
		public int modifiedSeatStudentPlacement(SeatPlacement seatPlacement) {
			logger.info("** LOADING modifiedSeatStudentPlacement() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				result = mapper.modifiedSeatStudentPlacement(seatPlacement);
			} catch (Exception e){
				e.printStackTrace();
			}
		logger.info("** LOADED modifiedSeatStudentPlacement() **");
		return result;
		}
		
		public EvaluationCount getEvaluationCount(int alumni) {
			logger.info("** LOADING getEvaluationCount() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			EvaluationCount result = null;
			try{
				result = mapper.getEvaluationCount(alumni);
			} catch (Exception e){
				e.printStackTrace();
			}
		logger.info("** LOADED getEvaluationCount() **");
		return result;
		}
		
		public int conductedSurvey() {
			logger.info("** LOADING conductedSurvey() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			int result = 0;
			try{
				result = mapper.conductedSurvey();
			} catch (Exception e){
				e.printStackTrace();
			}
		logger.info("** LOADED conductedSurvey() **");
		return result;
		}
		
		public ArrayList<SeatAvoid> filterPerson() {
			logger.info("** LOADING filterPerson() **");
			SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
			ArrayList<SeatAvoid> result = null;
			try{
				result = mapper.filterPerson();
			} catch (Exception e){
				e.printStackTrace();
			}
		logger.info("** LOADED filterPerson() **");
		return result;
		}
		
	}
