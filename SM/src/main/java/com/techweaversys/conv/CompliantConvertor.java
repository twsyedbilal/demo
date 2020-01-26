package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.CompliantDto;
import com.techweaversys.model.Compliant;


public class CompliantConvertor implements Function<Compliant, CompliantDto> {



	@Override
	public CompliantDto apply(Compliant b) {
		CompliantDto cd=new CompliantDto();
		cd.setRemark(b.getRemark());
		cd.setId(b.getId());
		return cd;
	}

}
