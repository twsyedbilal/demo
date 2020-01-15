package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.AcountFeeDto;
import com.techweaversys.model.AcountFee;

public class ReportConvertor  implements Function<AcountFee, AcountFeeDto>{

	@Override
	public AcountFeeDto apply(AcountFee aa) {	

		AcountFeeDto ad=new AcountFeeDto();
		
		return ad;
	}
	
	
	
	

}
