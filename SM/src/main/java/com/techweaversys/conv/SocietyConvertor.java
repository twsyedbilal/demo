package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.SocietyDto;
import com.techweaversys.model.SocietyEntity;

public class SocietyConvertor implements Function<SocietyEntity, SocietyDto> {

	

	@Override
	public SocietyDto apply(SocietyEntity se) {
		SocietyDto sd=new SocietyDto();
		sd.setname(se.getSocietyName());
		sd.setCode(se.getCode());
		sd.setId(se.getId());
		return null;
	}

}
