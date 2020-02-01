package com.techweaversys.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.LogDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Log;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.LogRepository;
import com.techweaversys.service.LogService;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private LogRepository logRepository;

	@Override
	public ResponseEntity<?> create(LogDto dto) {

		Log log = new Log();
		if (dto.getId() != null) {
			log = logRepository.getOne(log.getId());
		}
		if (dto.getAdmissionId() != null) {
			Admission admission = admissionRepository.getOne(dto.getAdmissionId());
			log.setAdmission(admission);
		}

		log.setLogInfo(dto.getLogInfo());
		log.setMessage(dto.getMessage());
		log.setName(dto.getName());
		logRepository.save(log);
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}
}
