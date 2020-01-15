package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.NationalityDto;
import com.techweaversys.model.NationalityEntity;

public class NotionalityDtoConvertor implements Function<NationalityEntity, NationalityDto> {

	@Override
	public NationalityDto apply(NationalityEntity ss) {
		NationalityDto sd=new NationalityDto();
		sd.setName(ss.getName());
		sd.setCode(ss.getCode());
		sd.setId(ss.getId());
		return sd;
	}
}
