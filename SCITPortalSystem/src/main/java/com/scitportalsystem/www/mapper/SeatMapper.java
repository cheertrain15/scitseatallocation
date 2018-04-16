package com.scitportalsystem.www.mapper;

import java.util.ArrayList;

import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.SeatPlacement;
import com.scitportalsystem.www.vo.SeatStudent;

public interface SeatMapper {
	public MemberStaff getStaffInfo(String id);
	public int getMemberNum(String id);
	public int saveSeatInfo(SeatPlacement seatPlacement);
	public ArrayList<SeatPlacement> showSeatInfo(int seatCreator);
	public int deleteSeatInfo(int seatPlacementNum);
	public SeatPlacement modifySeatPlacement(int seatPlacementNum);
	public int modifiedSeatSave(SeatPlacement seatPlacement);
	public ArrayList<SeatStudent> seatForStudents(int teacherAlumni);
	
}
