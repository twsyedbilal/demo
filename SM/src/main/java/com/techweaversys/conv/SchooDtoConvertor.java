package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.SchoolDto;
import com.techweaversys.model.SchoolEntityy;

public class SchooDtoConvertor implements Function<SchoolEntityy, SchoolDto> {

	@Override
	public SchoolDto apply(SchoolEntityy bb) {
		SchoolDto dto = new SchoolDto();
		dto.setSchoolAddress(bb.getSchoolAddress());
		dto.setSchoolCode(bb.getSchoolCode());
		dto.setSchoolName(bb.getSchoolName());
		dto.setId(bb.getId());
		return dto;
	}

}