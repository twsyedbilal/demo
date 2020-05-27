package com.techweaversys.conv;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.techweaversys.dto.AddressDto;
import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.dto.MarkSlaveDto;
import com.techweaversys.dto.StudentMarkDto;
import com.techweaversys.model.Address;
import com.techweaversys.model.Admission;
import com.techweaversys.model.MarksSlave;
import com.techweaversys.model.StudentMark;

public class StudentMarkConvertor implements Function<StudentMark, StudentMarkDto> {

	@Override
	public StudentMarkDto apply(StudentMark sm) {
		StudentMarkDto smd = new StudentMarkDto();
		if (sm.getClasss().getId() != null && sm.getClasss() != null) {
			smd.setClasss(sm.getClasss().getId());
			}
			if (sm.getSubjectMaster().getId() != null && sm.getSubjectMaster() != null) {
			smd.setSubjectMaster(sm.getSubjectMaster().getId());
			}

			if (sm.getExamMaster().getId() != null && sm.getExamMaster() != null) {
			smd.setExamMaster(sm.getExamMaster().getId());
			}


		if (sm.getMarksSlaves() != null) {

			List<MarkSlaveDto> list = new ArrayList<MarkSlaveDto>();
			if (sm.getMarksSlaves().size() > 0) {
				for (MarksSlave s : sm.getMarksSlaves()) {
					MarkSlaveDto d = new MarkSlaveDto();
					d.setId(s.getId());
					d.setMark(s.getMark());
					d.setRemark(s.getRemark());

					if(s.getAdmission().getId() != null) {
						AdmissionDto aDto = new AdmissionDto();
						aDto.setStudentsName(s.getAdmission().getStudentsName());

						d.setAdmission(s.getAdmission().getId());
						}
						list.add(d);
						}
						smd.setSlavedto(list);
						}

						}
						return smd;

	}
}
