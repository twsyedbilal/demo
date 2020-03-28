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
		if (sm.getClasss() != null) {
			smd.setClasssid(sm.getClasss().getId());
		}

		if (sm.getExamMaster() != null) {
			smd.setExamId(sm.getExamMaster().getId());
		}

		if (sm.getSubjectMaster() != null) {
			smd.setSubjectId(sm.getSubjectMaster().getId());
		}

		if (sm.getMarksSlaves() != null) {

			List<MarkSlaveDto> list = new ArrayList<MarkSlaveDto>();
			if (sm.getMarksSlaves().size() > 0) {
				for (MarksSlave s : sm.getMarksSlaves()) {
					MarkSlaveDto d = new MarkSlaveDto();
					d.setId(s.getId());
					d.setMark(s.getMark());
					d.setRemark(s.getRemark());

					list.add(d);

				}
			}

		}
		return smd;

	}
}
