package com.techweaversys.conv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Function;
import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.dto.CompliantListDto;
import com.techweaversys.dto.CompliantTypeDto;
import com.techweaversys.dto.DocumentDto;
import com.techweaversys.model.Compliant;


public class CompliantConvertor implements Function<Compliant, CompliantListDto> {

	@Autowired
	private ModelMapper modelMapper;



	@Override
	public CompliantListDto apply(Compliant b) {
		CompliantListDto cd=new CompliantListDto();
		cd.setRemark(b.getRemark());
		cd.setId(b.getId());
		
		AdmissionDto it = modelMapper.map(b.getAdmission(), AdmissionDto.class);
		cd.setAdmisiondto(it);
		
		CompliantTypeDto co = modelMapper.map(b.getCompliant(), CompliantTypeDto.class);
		cd.setComplianttypedto(co);
		
		List<DocumentDto> list = modelMapper.map(b.getDocument(), DocumentDto.class);
		cd.setDocumentdtolist(list);
		
		return cd;
	}

}
