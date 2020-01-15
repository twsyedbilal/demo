package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.SubCasteDto;
import com.techweaversys.model.SubCaste;

public class SubCasteDtoConvertor implements Function<SubCaste, SubCasteDto> {

	@Override
	public SubCasteDto apply(SubCaste input) {
		SubCasteDto dto = new SubCasteDto();
		dto.setSubCasteName(input.getSubCasteName());
		dto.setSubCasteCode(input.getSubCastecode());
		return dto;
	}

}
