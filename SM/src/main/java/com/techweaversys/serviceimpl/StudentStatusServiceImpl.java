package com.techweaversys.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.StudentStatus;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.StudentStatusRepository;
import com.techweaversys.service.StudentStatusService;

@Service
@Transactional
public class StudentStatusServiceImpl implements StudentStatusService {
	
	@Autowired
	private StudentStatusRepository studentStatusRepository;

	@Autowired
	private AdmissionRepository admissionRepository;

	
	@Override
	public ResponseEntity<?> create(StudentStatus studentStatus) {

		if (studentStatus.getId() != null) {
			studentStatus = studentStatusRepository.getOne(studentStatus.getId());
		}
		if (studentStatus.getAdmission() != null) {
			if (studentStatus.getAdmission().getId() != null) {
				Admission admission = admissionRepository.getOne(studentStatus.getAdmission().getId());
				studentStatus.setAdmission(admission);
				admission.setStatus(studentStatus.getStatus());
			}
		}

		studentStatus.setStatus(studentStatus.getStatus());
		studentStatus.setAdmission(studentStatus.getAdmission());
		studentStatusRepository.save(studentStatus);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		StudentStatus s = studentStatusRepository.getOne(id);
		return Response.build(Code.OK, s);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		StudentStatus studentStatus = new StudentStatus();
		if (id != null) {
			studentStatus = studentStatusRepository.getOne(id);
			studentStatus.setDeleted(true);
			studentStatusRepository.save(studentStatus);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<StudentStatus> list = studentStatusRepository.findAll();
		return Response.build(Code.OK, list);
	}
}
