package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.ExamDto;
import com.techweaversys.model.ExamMaster;

public class ExamDtoCon implements Function<ExamMaster, ExamDto> {

	@Override
	public ExamDto apply(ExamMaster c) {
		ExamDto cd=new ExamDto();
		
		
		cd.setExamName(c.getExamName());
		cd.setExamStartDate(c.getExamStartDate());
		cd.setExamEndDate(c.getExamEndDate());
		cd.setId(c.getId());
		return cd;
	}
}