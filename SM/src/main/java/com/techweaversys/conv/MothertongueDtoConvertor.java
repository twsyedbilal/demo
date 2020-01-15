package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.MotherTongueDto;
import com.techweaversys.model.MotherTongueEntity;

public class MothertongueDtoConvertor implements Function<MotherTongueEntity, MotherTongueDto> {

	
	
	@Override
    public MotherTongueDto apply(MotherTongueEntity ss) {
            MotherTongueDto sd=new MotherTongueDto();
            sd.setName(ss.getName());
            sd.setCode(ss.getCode());
            sd.setId(ss.getId());
            return sd;
    }

}
