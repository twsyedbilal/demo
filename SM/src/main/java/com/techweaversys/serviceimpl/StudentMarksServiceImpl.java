
package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.AttendanceDto;
import com.techweaversys.dto.MarkSlaveDto;
import com.techweaversys.dto.StudentMarkDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Attendance;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.ExamMaster;
import com.techweaversys.model.MarksSlave;
import com.techweaversys.model.SocietyEntity;
import com.techweaversys.model.StudentMark;
import com.techweaversys.model.SubjectMaster;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.ExamRepository;
import com.techweaversys.repository.StudentMarksRepository;
import com.techweaversys.repository.SubjectMasterRepository;
import com.techweaversys.service.StudentMarksService;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class StudentMarksServiceImpl implements StudentMarksService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentMarksRepository studentMarksRepository;

	@Autowired
	private ClassRepository cr;

	@Autowired
	private SubjectMasterRepository smr;

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private AdmissionRepository adrepo;

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> create(StudentMarkDto dto) {
		logger.info("");
		StudentMark sh = new StudentMark();
		if (null != dto.getId()) {
			sh = studentMarksRepository.getOne(dto.getId());
		}

		// save classs details with StudentMark details get by Id
		if (dto.getClasssid() != null) {
			ClassEntity b = cr.getOne(dto.getClasssid());
			sh.setClasss(b);
		}
		// save exam details with StudentMark details get by Id
		if (dto.getExamId() != null) {
			ExamMaster b = examRepository.getOne(dto.getExamId());
			sh.setExamMaster(b);
		}

		// save exam details with StudentMark details get by Id
		if (dto.getSubjectId() != null) {
			SubjectMaster b = smr.getOne(dto.getSubjectId());
			sh.setSubjectMaster(b);
		}

		if (dto.getSlavedto() != null && dto.getSlavedto().size() > 0) {
			List<MarksSlave> list = new ArrayList<MarksSlave>();
			for (MarkSlaveDto d : dto.getSlavedto()) {
				MarksSlave m = new MarksSlave();
				m.setMark(d.getMark());
				m.setRemark(d.getRemark());

				Admission a = adrepo.getOne(d.getAdmissionId());
				m.setAdmission(a);
				m.setStudentMark(sh);
				list.add(m);
			}
			sh.setMarksSlaves(list);
		}
		studentMarksRepository.save(sh);
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<StudentMark> bb = studentMarksRepository.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {

		StudentMark bb = new StudentMark();
		if (id != null) {
			bb = studentMarksRepository.getOne(id);
			bb.setDeleted(true);
			studentMarksRepository.save(bb);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<StudentMark> st = studentMarksRepository.findAll();
		StudentMarkDto dto = modelMapper.map(st, StudentMarkDto.class);
		return Response.build(Code.OK, st);
	}

	@Override
	public ResponseEntity<?> getByclassId(Long id) {
		StudentMark list = studentMarksRepository.findByClasssId(id);
	//	StudentMarkDto dto = modelMapper.map(list, StudentMarkDto.class);
		return Response.build(Code.OK, list);
	}
	}


