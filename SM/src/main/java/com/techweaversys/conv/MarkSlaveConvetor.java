package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.MarkSlaveDto;
import com.techweaversys.dto.MotherTongueDto;
import com.techweaversys.model.MarksSlave;
import com.techweaversys.model.MotherTongueEntity;

public class MarkSlaveConvetor implements Function<MarksSlave, MarkSlaveDto> {

	
	
	@Override
    public MarkSlaveDto apply(MarksSlave ss) {
		MarkSlaveDto sd=new MarkSlaveDto();
            sd.setMark(ss.getMark());
            sd.setRemark(ss.getRemark());
          sd.setId(ss.getId());
            return sd;
    }

}
