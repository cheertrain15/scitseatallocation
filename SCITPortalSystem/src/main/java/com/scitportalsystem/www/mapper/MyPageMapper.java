package com.scitportalsystem.www.mapper;

import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.MemberStudentCertificate;

public interface MyPageMapper {
	/**
	 * 학사 정보 및 직원 추가 정보 입력  Mapper
	 */
	
	// staff 추가 정보 입력(공간 생성)
	public int insertStaff(MemberStaff staff);
	
	// staff 추가 정보 출력 
	public MemberStaff selectStaff(String id);
	
	// staff 정보 업데이트(화면상 입력)
	public int updateStaff(MemberStaff staff);

	// student 자격증 정보 입력(공간 생성)
	public int insertStudentCertificate(MemberStudentCertificate certificate);
	
	// student 자격증 정보 출력
	public MemberStudentCertificate selectStudentCerti(String id);
	
	// student 학사정보 입력(공간 생성)
	public int memberstudent(MemberStudent student);

	// student 자격증 정보 업데이트
	public int updateStudentCerti(MemberStudentCertificate certificate);
	
	// student 학사 정보 업데이트
	public int updateStudentInfo(MemberStudent student);
	
	// student 학사 정보 출력
	public MemberStudent selectStudentInfo(String id);
	
	
}
