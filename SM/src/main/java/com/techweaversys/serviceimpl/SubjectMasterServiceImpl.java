package com.techweaversys.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.SubjectMasterDto;
import com.techweaversys.dto.SubjectMasterSpaceDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.SubjectMaster;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.SubjectMasterRepository;
import com.techweaversys.service.SubjectMasterService;

@Service
@Transactional
public class SubjectMasterServiceImpl implements SubjectMasterService {

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Autowired
	private SubjectMasterRepository subjectMasterRepository;

	@Autowired
	private ClassRepository classRepository;

	@Override
	public ResponseEntity<?> create(SubjectMasterDto dto) {

		SubjectMaster j = new SubjectMaster();
		logger.info("Creating SubjectData  " + dto);
		if (dto.getId() != null) {
			j = subjectMasterRepository.getOne(dto.getId());
		}

		if (dto.getClasss().getId() != null) {
			ClassEntity c = classRepository.getOne(dto.getClasss().getId());
			j.setClasss(c);
		}
		subjectMasterRepository.save(j);
		j.setSemester(dto.getSemester());
		j.setSubjectName(dto.getSubjectName());
		j.setSubjectCode(dto.getSubjectCode());
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
		SubjectMaster r = subjectMasterRepository.getOne(id);
		return Response.build(Code.OK, r);
	}

	@Override
	public ResponseEntity<?> getSubjectByClass(Long classid) {

		List<SubjectMaster> list = subjectMasterRepository.findAllByClasssId(classid);
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(SubjectMasterSpaceDto dto) {
		/*
		 * logger.info("showing list of report " + dto); PageRequest pageable =
		 * PageRequest.of(dto.getPage(), dto.getSize(), Direction.DESC,
		 * AppConstants.MODIFIED); Page<SubjectMaster> af =
		 * subjectMasterRepository.findAll( new SubjectMasterSpace(dto.getSubjectCode(),
		 * dto.getSubjectName(), dto.getSemester()), pageable); List<SubjectMasterDto>
		 * list = af.stream().map(new SubjectConvertor()).collect(Collectors.toList());
		 * PageDto pageDto = new PageDto(list, af.getTotalElements());
		 */
		return Response.build(Code.OK);


	}
}
