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
import org.springframework.web.bind.annotation.PathVariable;

import com.techweaversys.conv.BranchDtoConvertor;
import com.techweaversys.dto.BranchDto;
import com.techweaversys.dto.BranchSpacedto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.BranchEntity;
import com.techweaversys.repository.BranchRepository;
import com.techweaversys.service.BranchService;
import com.techweaversys.spec.BranchSpec;

@Service
@Transactional
public class BranchSerivceImpl implements BranchService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BranchRepository BranchRepository;

	@Override
	public ResponseEntity<?> saveData(BranchDto dto) {
		logger.info("Creating user: " + dto);
		BranchEntity bb = new BranchEntity();
		if (dto.getId() != null) {
			bb = BranchRepository.getOne(dto.getId());
		}

		bb.setBrancCode(dto.getBranchCode());
		bb.setBranchName(dto.getBranchName());
		BranchRepository.save(bb);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		Optional<BranchEntity> bb = BranchRepository.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<BranchEntity> list = BranchRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		BranchEntity bb = new BranchEntity();
		if (id != null) {
			bb = BranchRepository.getOne(id);
			bb.setDeleted(true);
			BranchRepository.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(BranchSpacedto dto) {
		logger.info("showing list of users", dto);
		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<BranchEntity> branchs = BranchRepository.findAll(new BranchSpec(dto.getBranchName(), dto.getBranchCode()), pg);
		List<BranchDto> list = branchs.stream().map( new BranchDtoConvertor() ).collect( Collectors.toList() );
		PageDto pageDto = new PageDto(list, branchs.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	
}
