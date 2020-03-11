package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.AttendanceConvertor;
import com.techweaversys.dto.AttendanceDto;
import com.techweaversys.dto.AttendanceSpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Attendance;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.SubjectMaster;
import com.techweaversys.model.User;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.AttendanceRepository;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.SubjectMasterRepository;
import com.techweaversys.repository.UserRepository;
import com.techweaversys.service.AttendanceService;
import com.techweaversys.spec.AttendanceSpec;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public AttendanceRepository attendanceRepository;

	@Autowired
	public ClassRepository classRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public AdmissionRepository admissionRepository;

	@Autowired
	public SubjectMasterRepository smr;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> create(AttendanceDto dto) {
		logger.info("Creating Attendance: " + dto);
		Attendance a = new Attendance();
		if (dto.getId() != null) {
			a = attendanceRepository.getOne(dto.getId());
		}

		// save class details get by Id
		if (dto.getClasss() != null) {
			ClassEntity b = classRepository.getOne(dto.getClasss().getId());
			a.setClasss(b);
		}

		// save user details get by Id
		if (dto.getUserdto() != null) {
			User b = userRepository.getOne(dto.getUserdto().getId());
			a.setUser(b);
		}

		// save addmission details get by Id
		if (dto.getAdmission() != null) {
			Admission b = admissionRepository.getOne(dto.getAdmission().getId());
			a.setAdmission(b);
		}

		// save subjectMaster details get by Id
		if (dto.getSubjectdto() != null) {
			SubjectMaster b = smr.getOne(dto.getSubjectdto().getId());
			a.setSubject(b);
		}

		a.setTypes(dto.getTypes());
		a.setReason(dto.getReason());
		a.setAbsent(dto.getAbsent());
		a.setPresent(dto.getPresent());
		attendanceRepository.save(a);

		return Response.build(Code.OK, Messages.CREATED);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		Attendance attendance = attendanceRepository.getOne(id);
		AttendanceDto dto = modelMapper.map(attendance, AttendanceDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<Attendance> list = attendanceRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		Attendance a = new Attendance();
		if (id != null) {
			a = attendanceRepository.getOne(id);
			a.setDeleted(true);
			attendanceRepository.save(a);
		}
		return Response.build(Code.OK, Messages.DELETED);

	}

	@Override
	public ResponseEntity<?> findAllwithpage(AttendanceSpaceDto dto) {
		logger.info("Showing list of attendance", dto);
		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<Attendance> attendance = attendanceRepository
				.findAll(new AttendanceSpec(dto.getAbsent(), dto.getPresent(), dto.getReason(), dto.getTypes()), pg);
		List<AttendanceDto> list = attendance.stream().map(new AttendanceConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, attendance.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> findByClassId(Long id) {
		Attendance attendance = attendanceRepository.findByClasssId(id);
		AttendanceDto dto = modelMapper.map(attendance, AttendanceDto.class);
		return Response.build(Code.OK, dto);
	}

}
