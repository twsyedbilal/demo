package com.techweaversys.conv;

import com.techweaversys.dto.CompliantDto;
import com.techweaversys.model.Compliant;

public class CompliantConvertor implements com.google.common.base.Function<Compliant, CompliantDto> {

	@Override
	public CompliantDto apply(Compliant c) {
		CompliantDto cd=new CompliantDto();
		cd.setName(c.getName());
		cd.setCode(c.getCode());
		cd.setId(c.getId());
		return cd;
	}

}
