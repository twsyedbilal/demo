package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.CasteDto;
import com.techweaversys.model.Caste;

public class CasteDtoConvertor implements Function<Caste, CasteDto>{

	@Override
	public CasteDto apply(Caste input) {
		CasteDto dto = new CasteDto();
		dto.setCasteName(input.getCasteName());
		dto.setCasteCode(input.getCasteCode());
		return dto;
	}
}