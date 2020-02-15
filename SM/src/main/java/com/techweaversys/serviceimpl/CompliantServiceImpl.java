package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.List;
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

import com.techweaversys.conv.CompliantConvertor;
import com.techweaversys.dto.CompliantDto;
import com.techweaversys.dto.CompliantListDto;
import com.techweaversys.dto.CompliantSpceDto;
import com.techweaversys.dto.DocumentDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Compliant;
import com.techweaversys.model.CompliantTypes;
import com.techweaversys.model.Document;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.CompliantRepository;
import com.techweaversys.repository.CompliantTypesRepositry;
import com.techweaversys.repository.DocumentRepository;
import com.techweaversys.service.CompliantService;
import com.techweaversys.spec.ComplianteSpce;

@Service
@Transactional
public class CompliantServiceImpl implements CompliantService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CompliantRepository compliantRepository;

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private CompliantTypesRepositry compliantTypeRepositry;

	@Autowired
	private DocumentRepository documentBucketRepository;

	@Override
	public ResponseEntity<?> createData(CompliantDto compliantDto) {
		logger.info("Creating List Of Compliant..." + compliantDto);
		Compliant ct = new Compliant();
		if (compliantDto.getId() != null) {
			ct = compliantRepository.getOne(compliantDto.getId());

		}

		// save data with admission
		if (compliantDto.getAdmissionId() != null) {
			
				Admission sc = admissionRepository.getOne(compliantDto.getAdmissionId());
				ct.setAdmission(sc);
			
		}

		// save data with compliantType
		if (compliantDto.getComplianttypeid() != null) {
			
				CompliantTypes sc = compliantTypeRepositry.getOne(compliantDto.getComplianttypeid());
				ct.setCompliant(sc);
			
		}
		List<Document> document = new ArrayList<>();
		if (compliantDto.getDocumentdtolist() != null) {
			for (DocumentDto doc : compliantDto.getDocumentdtolist()) {
				Document du = new Document();
				if (doc.getId() != null) {
					du = documentBucketRepository.getOne(doc.getId());
					du.setFileName(doc.getFileName());
					du.setFileType(doc.getFileName());
					du.setName(doc.getName());
					du.setPath(doc.getPath());
					du.setStore(doc.getStore());
					du.setUrl(doc.getUrl());
				}

				document.add(du);
			}
			ct.setDocument(document);
		}
		ct.setRemark(compliantDto.getRemark());
		compliantRepository.save(ct);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<Compliant> bb = compliantRepository.findAll();
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		Compliant ct = compliantRepository.getOne(id);
		return Response.build(Code.OK, ct);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		Compliant ct = new Compliant();
		if (id != null) {
			ct = compliantRepository.getOne(id);
			ct = compliantRepository.save(ct);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(CompliantSpceDto dto) {

		logger.info("Showing list of Compliant " + dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<Compliant> c = compliantRepository.findAll(new ComplianteSpce(dto.getRemark()), bb);
		List<CompliantListDto> list = c.stream().map(new CompliantConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, c.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
