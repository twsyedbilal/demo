package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.PhoneSectionDto;
import com.techweaversys.model.PhoneSection;

public class PhonesectionConvertor implements Function<PhoneSection, PhoneSectionDto> {

	@Override
	public PhoneSectionDto apply(PhoneSection p) {
		
		
		PhoneSectionDto pp =new PhoneSectionDto();
		pp.setRemark(p.getRemark());
		pp.setRemainingBalance(p.getRemainingBalance());
		pp.setId(p.getId());
		return pp;
	}

}
