package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.BranchDto;
import com.techweaversys.model.BranchEntity;

public class BranchDtoConvertor implements Function<BranchEntity, BranchDto> {

	@Override
	public BranchDto apply(BranchEntity b) {
		BranchDto dto = new BranchDto();
		dto.setcode(b.getBrancCode());
		dto.setname(b.getBranchName());
		dto.setId(b.getId());
		return dto;
	}

}
