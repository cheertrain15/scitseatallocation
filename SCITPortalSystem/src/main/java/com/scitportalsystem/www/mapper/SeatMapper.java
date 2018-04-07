package com.scitportalsystem.www.mapper;

import java.util.ArrayList;

import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.SeatPlacement;

public interface SeatMapper {
	public MemberStaff getStaffInfo(String id);
	public int getMemberNum(String id);
	public int saveSeatInfo(SeatPlacement seatPlacement);
	public ArrayList<SeatPlacement> showSeatInfo(int seatCreator);
}
