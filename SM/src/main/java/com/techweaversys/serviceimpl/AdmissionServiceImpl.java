package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.AdmissionDtoConvertor;
import com.techweaversys.dto.AddressDto;
import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.dto.AdmissionSpecDto;
import com.techweaversys.dto.DocumentDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.exception.AdmissionAlreadyExiststException;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Address;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Caste;
import com.techweaversys.model.City;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.Country;
import com.techweaversys.model.Document;
import com.techweaversys.model.MotherTongueEntity;
import com.techweaversys.model.NationalityEntity;
import com.techweaversys.model.Occupation;
import com.techweaversys.model.Religion;
import com.techweaversys.model.SchoolEntityy;
import com.techweaversys.model.SchoolType;
import com.techweaversys.model.SocietyEntity;
import com.techweaversys.model.State;
import com.techweaversys.model.StudentStatus;
import com.techweaversys.model.SubCaste;
import com.techweaversys.repository.AddressRepository;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.CasteRepository;
import com.techweaversys.repository.CityRepository;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.CountryRepository;
import com.techweaversys.repository.DocumentRepository;
import com.techweaversys.repository.LogRepository;
import com.techweaversys.repository.MotherTongueRepository;
import com.techweaversys.repository.NationalityRepository;
import com.techweaversys.repository.OccupationRepository;
import com.techweaversys.repository.ReligionRepository;
import com.techweaversys.repository.SchoolRepositriy;
import com.techweaversys.repository.SchoolTypeRepository;
import com.techweaversys.repository.SocietyRepository;
import com.techweaversys.repository.StateRepository;
import com.techweaversys.repository.StudentStatusRepository;
import com.techweaversys.repository.SubCasteRepository;
import com.techweaversys.service.AdmissionService;
import com.techweaversys.spec.AdmissionSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class AdmissionServiceImpl implements AdmissionService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private ClassRepository cr;

	@Autowired
	private SchoolRepositriy sr;

	@Autowired
	private SchoolTypeRepository str;

	@Autowired
	private ReligionRepository religionRepository;

	@Autowired
	private CasteRepository casteRepository;

	@Autowired
	private SubCasteRepository subCasteRepository;

	@Autowired
	private OccupationRepository occupationRepository;

	@Autowired
	private MotherTongueRepository motherTongueRepository;

	@Autowired
	private SocietyRepository societyRepository;

	@Autowired
	private NationalityRepository nationalityRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private DocumentRepository documentBucketRepository;

	@Autowired
	private StudentStatusRepository studentStatusRepository;

	@Autowired
	private LogRepository logRepository;

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	/*
	 * NAME : MAJID CODE : Creating Admission form of Students
	 */

	@Override
	public ResponseEntity<?> saveadmission(AdmissionDto admission) throws AdmissionAlreadyExiststException {
		logger.info("save admission Form");
		Admission sh = new Admission();
		Optional<Admission> optadm;
		if (null != admission.getId()) {
			sh = admissionRepository.getOne(admission.getId());
			if (!admission.getUidNo().equals(admission.getUidNo())) {
				optadm = admissionRepository.findOneByUidNo(admission.getUidNo());
				if (optadm.isPresent()) {
					logger.info("Admission Already Exist!");
					throw new AdmissionAlreadyExiststException(Messages.ADMISSION_AlREADY);
				}
			}
		} else {
			optadm = admissionRepository.findOneByUidNo(admission.getUidNo());
			if (optadm.isPresent()) {
				logger.info("Admission Already Exist!");
				throw new AdmissionAlreadyExiststException(Messages.ADMISSION_AlREADY);
			}
		}

		if (null != admission.getId()) {
			StudentStatus s = new StudentStatus();
			s.setStatus(admission.getStatus());
			studentStatusRepository.save(s);
		}

		// save admission details with Class details get by Id
		if (admission.getClassId() != null) {
			ClassEntity b = cr.getOne(admission.getClassId());
			sh.setClassOffered(b);

		}

		// save admission details with School details get by Id
		if (admission.getSchoolId() != null) {
			SchoolEntityy school = sr.getOne(admission.getSchoolId());
			sh.setSchool(school);
		}
		// save admission details with School Type get by Id
		if (admission.getSchoolTypeId() != null) {
			SchoolType st = str.getOne(admission.getSchoolTypeId());
			sh.setSchoolType(st);
		}
		// save admission details with Religion get by Id
		if (admission.getReligionId() != null) {
			Religion religion = religionRepository.getOne(admission.getReligionId());
			sh.setReligion(religion);
		}
		// save admission details with Caste get by Id
		if (admission.getCastId() != null) {
			Caste caste = casteRepository.getOne(admission.getCastId());
			sh.setCaste(caste);
		}
		// save admission details with SubCaste get by Id
		if (admission.getSubCastId() != null) {
			SubCaste subCaste = subCasteRepository.getOne(admission.getSubCastId());
			sh.setSubCaste(subCaste);
		}
		// save admission details with Occupation get by Id
		if (admission.getOccupationId() != null) {
			Occupation occupation = occupationRepository.getOne(admission.getOccupationId());
			sh.setOccupation(occupation);
		}
		// save admission details with MotherTongue get by Id
		if (admission.getMothertongId() != null) {
			MotherTongueEntity MotherTongue = motherTongueRepository.getOne(admission.getMothertongId());
			sh.setMotherTongue(MotherTongue);
		}
		// save admission details with Nationality get by Id
		if (admission.getNationalityId() != null) {
			NationalityEntity nationality = nationalityRepository.getOne(admission.getNationalityId());
			sh.setNationality(nationality);
		}
		// save admission details with Society get by Id
		if (admission.getSocietyId() != null) {
			SocietyEntity society = societyRepository.getOne(admission.getSocietyId());
			sh.setSociety(society);
		}

		//
		List<Document> document = new ArrayList<>();
		if (admission.getDocument() != null) {
			for (DocumentDto doc : admission.getDocument()) {
				Document du = new Document();
				if (doc.getId() != null) {
					du = documentBucketRepository.getOne(doc.getId());
				}
				document.add(du);
			}
			sh.setDocument(document);
		}

		// save admission details with Address
		List<Address> address = new ArrayList<>();
		if (admission.getAddress() != null) {

			for (AddressDto a : admission.getAddress()) {
				Address ad = new Address();
				if (a.getId() != null) {
					ad = addressRepository.getOne(a.getId());
				}

				if (a.getCityId() != null) {
					City city = cityRepository.getOne(a.getCityId());
					ad.setCity(city);
				}

				if (a.getStateId() != null) {
					State state = stateRepository.getOne(a.getStateId());
					ad.setState(state);
				}
				if (a.getCountryId() != null) {
					Country country = countryRepository.getOne(a.getCountryId());
					ad.setCountry(country);
				}
				ad.setDetailAddress(a.getDetailAddress());
				ad.setPinCode(a.getPincode());
				address.add(ad);
			}
			sh.setAddress(address);
		}

		// to get current year
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String yearInString = String.valueOf(year);

		sh.setDocument(document);
		admission.setYear(yearInString);
		sh.setYear(admission.getYear());
		sh.setUidNo(admission.getUidNo());
		sh.setIdNo(admission.getIdNo());
		sh.setStudentRegNo(admission.getStudentRegNo());
		sh.setYear(admission.getYear());
		sh.setDate(admission.getDate());
		sh.setContactNo(admission.getContactNo());
		sh.setDateOfBirth(admission.getDateOfBirth());
		sh.setDateOfBirthInWords(admission.getDateOfBirthInWords());
		sh.setFathersName(admission.getFathersName());
		sh.setGuardiansName(admission.getGuardiansName());
		sh.setMothersName(admission.getMothersName());
		sh.setIdentityByMarkOrAadharNo(admission.getIdentityByMarkOrAadharNo());
		sh.setIncome(admission.getIncome());
		sh.setPlaceOfBirth(admission.getPlaceOfBirth());
		sh.setSurName(admission.getSurName());
		sh.setStudentsName(admission.getStudentsName());
		sh.setLiveStatus(admission.getLiveStatus());
		sh.setGender(admission.getGender());

		admissionRepository.save(sh);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getByIdAdmi(Long id) {
		Admission s = admissionRepository.getOne(id);
		AdmissionDto dto = modelMapper.map(s, AdmissionDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> findAllAdmission() {
		List<Admission> list = admissionRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> deletId(Long id) {
		Admission bb = new Admission();
		if (id != null) {
			bb = admissionRepository.getOne(id);
			bb.setDeleted(true);
			admissionRepository.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findalladmissionWithPage(AdmissionSpecDto dto) {
		logger.info("showing list of Admission", dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<Admission> admission = admissionRepository.findAll(new AdmissionSpec(dto.getStudentsName(), dto.getUidNo(),
				dto.getIdNo(), dto.getYear(), dto.getDate(), dto.getClassOffered(), dto.getStatus()), bb);

		List<AdmissionDto> list = admission.stream().map(new AdmissionDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, admission.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}
}
