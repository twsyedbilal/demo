package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techweaversys.conv.ExamDtoCon;
import com.techweaversys.dto.ExamDto;
import com.techweaversys.dto.ExameSpec;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.ExamMaster;
import com.techweaversys.model.ExamSlave;
import com.techweaversys.model.SubjectMaster;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.ExamRepository;
import com.techweaversys.repository.SubjectMasterRepository;
import com.techweaversys.service.ExamService;
import com.techweaversys.spec.ExamSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private ClassRepository cr;

	@Autowired
	private SubjectMasterRepository smr;

	@Override
	public ResponseEntity<?> saveData(ExamDto dto) {

		logger.info("Creating Exam List :" + dto);
		ExamMaster em = new ExamMaster();

		if (dto.getId() != null) {
			em = examRepository.getOne(dto.getId());
		}
		em.setExamName(dto.getExamName());
		em.setExamStartDate(dto.getExamStartDate());
		em.setExamEndDate(dto.getExamEndDate());

		// save class details with exam get by Id
		if (dto.getClasss() != null) {
			ClassEntity ce = cr.getOne(dto.getClasss());
			em.setClasssEntity(ce);

		}
		if (dto.getSubjectid() != null && dto.getSubjectid().size() > 0) {
			List<ExamSlave> list = new ArrayList<ExamSlave>();
			for (Long d : dto.getSubjectid()) {
				SubjectMaster m = smr.getOne(d);
				ExamSlave e = new ExamSlave();
				e.setSubjectMaster(m);
				e.setExamMaster(em);
				list.add(e);
			}

			em.setExamSlave(list);
		}

		examRepository.save(em);
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		Optional<ExamMaster> em = examRepository.findById(id);
		return Response.build(Code.OK, em);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<ExamMaster> emlist = examRepository.findAll();
		return Response.build(Code.OK, emlist);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		ExamMaster em = new ExamMaster();

		if (id != null) {
			em = examRepository.getOne(id);
			em.setDeleted(true);
			examRepository.save(em);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(ExameSpec dto) {
		logger.info("Showing List OF " + dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<ExamMaster> c = examRepository
				.findAll(new ExamSpec(dto.getExamName(), dto.getExamEndtDate(), dto.getExamStarttDate()), bb);
		List<ExamDto> list = c.stream().map(new ExamDtoCon()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, c.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

	@Override
	public ResponseEntity<?> getByclassId(Long id) {
		ExamMaster list = examRepository.findByClasssId(id);
		return Response.build(Code.OK, list);
	}
}
