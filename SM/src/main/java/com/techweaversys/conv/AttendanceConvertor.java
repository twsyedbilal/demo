package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.AttendanceDto;
import com.techweaversys.model.Attendance;

public class AttendanceConvertor implements Function<Attendance, AttendanceDto>{

	@Override
	public AttendanceDto apply(Attendance a) {
	 
		AttendanceDto v=new AttendanceDto();
		
		v.setTypes(a.getTypes());
		v.setReason(a.getReason());
		v.setAbsent(a.getAbsent());
		v.setPresent(a.getPresent());
		v.setId(a.getId());
		
		return v;
	}
}
