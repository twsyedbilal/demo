package com.techweaversys.conv;

import com.techweaversys.dto.CompliantTypeDtobject;
import com.techweaversys.model.CompliantTypes;
import com.google.common.base.Function;
public class CompliantTypeConvertor implements Function<CompliantTypes, CompliantTypeDtobject> {

	@Override
	public CompliantTypeDtobject apply(CompliantTypes c) {
		CompliantTypeDtobject cd=new CompliantTypeDtobject();
		cd.setName(c.getName());
		cd.setCode(c.getCode());
		cd.setId(c.getId());
		return cd;
	}

}
