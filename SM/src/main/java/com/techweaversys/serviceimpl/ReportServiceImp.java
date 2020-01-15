
package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techweaversys.conv.ReportConvertor;
import com.techweaversys.dto.AcountFeeDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.ReportSpaceDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Response;
import com.techweaversys.model.AcountFee;
import com.techweaversys.repository.AccountFeeRepository;
import com.techweaversys.service.ReportService;
import com.techweaversys.spec.ReportSpace;

@Service
@Transactional
public class ReportServiceImp implements ReportService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier("accountFeeRepository")
	private AccountFeeRepository accountFeeRepository;

	@Override
	public ResponseEntity<?> findAllwithpage(ReportSpaceDto reportDto) {
		logger.info("showing list of report " + reportDto);
		
		PageRequest pg = PageRequest.of(reportDto.getPage(), reportDto.getSize(), Direction.DESC,
				AppConstants.MODIFIED);
		
		Page<AcountFee> af = accountFeeRepository
				.findAll(new ReportSpace(reportDto.getClasss(), reportDto.getStudentName(), reportDto.getUidNo(),
						reportDto.getIdNo(), reportDto.getRegisterNo(), reportDto.getPaymentType()), pg);
		List<AcountFeeDto> list = af.stream().map(new ReportConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, af.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
