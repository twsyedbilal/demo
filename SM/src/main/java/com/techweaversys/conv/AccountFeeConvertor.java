package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.AcountFeeDto;
import com.techweaversys.model.AcountFee;

public class AccountFeeConvertor  implements Function<AcountFee, AcountFeeDto> {

	@Override
	public AcountFeeDto apply(AcountFee a) {
		
		
		AcountFeeDto fd=new AcountFeeDto();
		fd.setActualPaid(a.getActualPaid());
		fd.setPaid(a.getPaid());
		fd.setBalance(a.getBalance());
		fd.setFee(a.getFee());
		fd.setId(a.getId());
		return fd;
	}

}
