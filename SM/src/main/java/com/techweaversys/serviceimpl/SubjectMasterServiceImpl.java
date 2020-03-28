package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.SubjectConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.SubjectMasterDto;
import com.techweaversys.dto.SubjectMasterSpaceDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.SubjectMaster;
import com.techweaversys.model.User;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.SubjectMasterRepository;
import com.techweaversys.repository.UserRepository;
import com.techweaversys.service.SubjectMasterService;
import com.techweaversys.spec.SubjectMasterSpace;

@Service
@Transactional
public class SubjectMasterServiceImpl implements SubjectMasterService {

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Autowired
	private SubjectMasterRepository subjectMasterRepository;
 
	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private UserRepository ur;

	@Override
	public ResponseEntity<?> create(SubjectMasterDto dto) {

		SubjectMaster j = new SubjectMaster();
		logger.info("Creating SubjectData  " + dto);
		if (dto.getId() != null) {
			j = subjectMasterRepository.getOne(dto.getId());
		}
		// save data class with subject
		if (dto.getClasssId() != null) {
			ClassEntity c = classRepository.getOne(dto.getClasssId());
			j.setClasss(c);
		}

		// save data class with user
		if (dto.getUserId() != null) {
			User c = ur.getOne(dto.getUserId());
			j.setUser(c);
		}

		// subjectMasterRepository.save(j);
		j.setSemester(dto.getSemester());
		j.setSubjectName(dto.getSubjectName());
		j.setSubjectCode(dto.getSubjectCode());
		j.setbookName(dto.getBookName());
		subjectMasterRepository.save(j);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> deletedById(Long id) {

		SubjectMaster r = new SubjectMaster();

		if (id != null) {
			r = subjectMasterRepository.getOne(id);
			r.setDeleted(true);
			subjectMasterRepository.save(r);

		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<SubjectMaster> r = subjectMasterRepository.findById(id);
		return Response.build(Code.OK, r);
	}

	@Override
	public ResponseEntity<?> getSubjectByClass(Long classid) {

		List<SubjectMaster> list = subjectMasterRepository.findAllByClasssId(classid);
		
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(SubjectMasterSpaceDto dto) {
		logger.info("Showing list of subject", dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<SubjectMaster> sm = subjectMasterRepository.findAll(new SubjectMasterSpace(dto.getSemester(),
				dto.getSubjectCode(), dto.getSubjectName(), dto.getBookName()), bb);
		List<SubjectMasterDto> list = sm.stream().map(new SubjectConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, sm.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<SubjectMaster> list = subjectMasterRepository.findAll();
		return Response.build(Code.OK, list);
	}
}
