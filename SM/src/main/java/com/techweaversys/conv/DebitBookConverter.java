package com.techweaversys.conv;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.DebitBookDto;
import com.techweaversys.dto.DebitSlaveDto;
import com.techweaversys.model.DebitBook;
import com.techweaversys.model.DebitSlave;

public class DebitBookConverter implements Function<DebitBook, DebitBookDto> {

	/*
	 * @Autowired private ModelMapper modelMapper;
	 */

	@Override
	public DebitBookDto apply(DebitBook i) {
		DebitBookDto dto = new DebitBookDto();
		dto.setId(i.getId());
		dto.setType(i.getType());

		if (i.getAdmission() != null) {
			AdmissionDto admissionDto = new AdmissionDto();
			admissionDto.setYear(i.getAdmission().getYear());
			admissionDto.setUidNo(i.getAdmission().getUidNo());
			admissionDto.setSurName(i.getAdmission().getSurName());
			admissionDto.setSubCasteId(i.getAdmission().getSubCaste().getId());
			admissionDto.setStudentsName(i.getAdmission().getStudentsName());
			admissionDto.setStudentRegNo(i.getAdmission().getStudentRegNo());
			admissionDto.setStatus(i.getAdmission().getStatus());
			admissionDto.setSocietyId(i.getAdmission().getSociety().getId());
			admissionDto.setSchoolTypeId(i.getAdmission().getSchoolType().getId());
			admissionDto.setSchoolId(i.getAdmission().getSchool().getId());
			admissionDto.setClassId(i.getAdmission().getClassOffered().getId());
			admissionDto.setCasteId(i.getAdmission().getCaste().getId());
			admissionDto.setOccupationId(i.getAdmission().getOccupation().getId());
			admissionDto.setNationalityId(i.getAdmission().getNationality().getId());
			admissionDto.setMotherTongueId(i.getAdmission().getMotherTongue().getId());
			admissionDto.setReligionId(i.getAdmission().getReligion().getId());
			admissionDto.setProfileId(i.getAdmission().getProfileId());
			admissionDto.setPlaceOfBirth(i.getAdmission().getPlaceOfBirth());
			admissionDto.setDate(i.getAdmission().getDate());
			admissionDto.setGender(i.getAdmission().getGender());
			admissionDto.setDateOfBirthInWords(i.getAdmission().getDateOfBirthInWords());
			admissionDto.setFathersName(i.getAdmission().getFathersName());
			admissionDto.setId(i.getAdmission().getId());
			admissionDto.setContactNo(i.getAdmission().getContactNo());
			admissionDto.setDateOfBirth(i.getAdmission().getDateOfBirth());
			admissionDto.setMothersName(i.getAdmission().getMothersName());
			admissionDto.setGuardiansName(i.getAdmission().getGuardiansName());
			admissionDto.setProfileId(i.getAdmission().getProfileId());
			admissionDto.setRollNo(i.getAdmission().getRollNo());
			admissionDto.setIdNo(i.getAdmission().getIdNo());
			admissionDto.setDateOfBirth(i.getAdmission().getDateOfBirth());
			admissionDto.setLiveStatus(i.getAdmission().getLiveStatus());
			admissionDto.setIdentityByMarkOrAadharNo(i.getAdmission().getIdentityByMarkOrAadharNo());

			dto.setAdmission(admissionDto);

		}

		/*
		 * if (i.getAdmission().getId() != null && i.getAdmission() != null) {
		 * AdmissionDto admissionDto = new AdmissionDto();
		 * 
		 * if (admission.getAddress() != null) { List<AddressDto> address = new
		 * ArrayList<>();
		 * 
		 * for (AddressDto a : admission.getAddress()) { AddressDto ad = new
		 * AddressDto();
		 * 
		 * ad.setCityId(a.getCityId()); ad.setCountryId(a.getCountryId());
		 * ad.setStateId(a.getStateId()); ad.setId(a.getId());
		 * ad.setPincode(a.getPincode()); ad.setType(a.getType());
		 * ad.setDetailAddress(a.getDetailAddress());
		 * 
		 * address.add(ad);
		 * 
		 * if (a.getId() != null) { ad = addressRepository.getOne(a.getId()); } if
		 * (a.getCityId() != null) { City city = cityRepository.getOne(a.getCityId());
		 * ad.setCity(city); }
		 * 
		 * if (a.getStateId() != null) { State state =
		 * stateRepository.getOne(a.getStateId()); ad.setState(state); } if
		 * (a.getCountryId() != null) { Country country =
		 * countryRepository.getOne(a.getCountryId()); ad.setCountry(country); }
		 * 
		 * ad.setDetailAddress(a.getDetailAddress()); address.add(a);
		 * 
		 * } admission.setAddress(address); } dto.setAdmission(admission);
		 * 
		 * if (i.getAdmission().getDocument() != null) { List<DocumentDto> docDto = new
		 * ArrayList<DocumentDto>();
		 * 
		 * for (Document ddd : i.getAdmission().getDocument()) { DocumentDto dd = new
		 * DocumentDto(); dd.setFileName(ddd.getFileName()); dd.setId(ddd.getId());
		 * dd.setName(ddd.getName()); dd.setPath(ddd.getPath());
		 * dd.setUrl(ddd.getUrl()); docDto.add(dd); } admission.setDocument(docDto); }
		 */

		if (i.getDebitSlave() != null) {
			List<DebitSlaveDto> list = new ArrayList<DebitSlaveDto>();

			if (i.getDebitSlave().size() > 0) {
				for (DebitSlave ds : i.getDebitSlave()) {
					DebitSlaveDto debitDto = new DebitSlaveDto();
					debitDto.setId(ds.getId());
					debitDto.setFromDate(ds.getFromDate());
					debitDto.setToDate(ds.getToDate());
					debitDto.setGivenQty(ds.getGivenQty());
					debitDto.setReturnQty(ds.getReturnQty());
					debitDto.setQty(ds.getQty());

					if (ds.getBook().getId() != null && ds.getBook() != null) {
						BookDto it = new BookDto();
						it.setcode(ds.getBook().getcode());
						it.setId(ds.getBook().getId());
						it.setname(ds.getBook().getname());
						debitDto.setBook(it);
					}
					list.add(debitDto);
				}
			}
			dto.setDebitSlave(list);
		}
		return dto;
	}
}
