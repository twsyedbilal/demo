package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.OccupationDto;
import com.techweaversys.model.Occupation;

public class OccupationDtoConvertor implements Function<Occupation, OccupationDto>{

	@Override
	public OccupationDto apply(Occupation input) {
		OccupationDto dto = new OccupationDto();
		dto.setname(input.getname());
		dto.setcode(input.getcode());
		return dto;
	}
	

}
