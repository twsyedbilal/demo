package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.SubjectMasterDto;
import com.techweaversys.model.SubjectMaster;

public class SubjectConvertor implements Function<SubjectMaster, SubjectMasterDto> {

	@Override
	public SubjectMasterDto apply(SubjectMaster a) {

		SubjectMasterDto smd = new SubjectMasterDto();
		smd.setSubjectName(a.getSubjectName());
		smd.setSubjectCode(a.getSubjectCode());
		smd.setSemester(a.getSemester());

		return smd;
	}

}
