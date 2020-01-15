package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.CompliantTypeDto;
import com.techweaversys.model.CompliantType;

public class CompliantTypeConvertor implements Function<CompliantType, CompliantTypeDto> {

	@Override
	public CompliantTypeDto apply(CompliantType b) {
		CompliantTypeDto cd=new CompliantTypeDto();
		cd.setRemark(b.getRemark());
		cd.setId(b.getId());
		return cd;
	}

}
