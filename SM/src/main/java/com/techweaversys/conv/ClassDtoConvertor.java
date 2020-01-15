package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.ClassDto;
import com.techweaversys.model.ClassEntity;

public class ClassDtoConvertor implements Function<ClassEntity, ClassDto> {

	@Override
	public ClassDto apply(ClassEntity ss) {
		ClassDto vv=new ClassDto();
		
		vv.setClassName(ss.getClassName());
		vv.setCode(ss.getCode());
		vv.setFees(ss.getFees());
		vv.setId(ss.getId());
		return vv;
	}
	
}
