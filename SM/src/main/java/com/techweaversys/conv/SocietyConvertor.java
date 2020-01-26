package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.SocietyDto;
import com.techweaversys.dto.SubjectMasterDto;
import com.techweaversys.model.SocietyEntity;
import com.techweaversys.model.SubjectMaster;

public class SocietyConvertor implements Function<SocietyEntity, SocietyDto> {

	

	@Override
	public SocietyDto apply(SocietyEntity se) {
		SocietyDto sd=new SocietyDto();
		sd.setSocietyName(se.getSocietyName());
		sd.setCode(se.getCode());
		sd.setId(se.getId());
		return null;
	}

}
