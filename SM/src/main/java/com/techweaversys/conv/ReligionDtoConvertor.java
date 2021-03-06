package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.ReligionDto;
import com.techweaversys.model.Religion;

public class ReligionDtoConvertor implements Function<Religion, ReligionDto>{

	@Override
	public ReligionDto apply(Religion input) {
		ReligionDto dto = new ReligionDto();
		dto.setname(input.getname());
		dto.setcode(input.getcode());
		return dto;
	}
}
