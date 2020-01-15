package com.techweaversys.conv;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.techweaversys.dto.AddressDto;
import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.model.Address;
import com.techweaversys.model.Admission;

public class AdmissionDtoConvertor implements Function<Admission, AdmissionDto> {

	@Override
	public AdmissionDto apply(Admission ad) {

		AdmissionDto dto = new AdmissionDto();

		dto.setStatus(ad.getStatus());
		dto.setLiveStatus(ad.getLiveStatus());
		dto.setUidNo(ad.getUidNo());
		dto.setIdNo(ad.getIdNo());
		dto.setStudentRegNo(ad.getStudentRegNo());
		dto.setYear(ad.getYear());
		dto.setDate(ad.getDate());
		dto.setSurName(ad.getSurName());
		dto.setFathersName(ad.getFathersName());
		dto.setMothersName(ad.getMothersName());
		dto.setGuardiansName(ad.getGuardiansName());
		dto.setDateOfBirthInWords(ad.getDateOfBirthInWords());
		dto.setIdentityByMarkOrAadharNo(ad.getIdentityByMarkOrAadharNo());
		dto.setPlaceOfBirth(ad.getPlaceOfBirth());
		dto.setContactNo(ad.getContactNo());
		dto.setStudentsName(ad.getStudentsName());
		dto.setId(ad.getId());
		dto.setGender(ad.getGender());
		dto.setDateOfBirth(ad.getDateOfBirth());
		dto.setIncome(ad.getIncome());

		if (ad.getClassOffered() != null) {
			dto.setClassId(ad.getClassOffered().getId());
		}
		if (ad.getSchool() != null) {
			dto.setSchoolId(ad.getSchool().getId());
		}
		if (ad.getSchoolType() != null) {
			dto.setSchoolTypeId(ad.getSchoolType().getId());
		}
		if (ad.getCaste() != null) {
			dto.setCastId(ad.getCaste().getId());
		}
		if (ad.getSubCaste() != null) {
			dto.setSubCastId(ad.getSubCaste().getId());
		}
		if (ad.getMotherTongue() != null) {
			dto.setMothertongId(ad.getMotherTongue().getId());
		}
		if (ad.getOccupation() != null) {
			dto.setOccupationId(ad.getOccupation().getId());
		}
		if (ad.getReligion() != null) {
			dto.setReligionId(ad.getReligion().getId());
		}
		if (ad.getSociety() != null) {
			dto.setSocietyId(ad.getSociety().getId());
		}
		if (ad.getNationality() != null) {
			dto.setNationalityId(ad.getNationality().getId());
		}

		if (ad.getAddress() != null) {

			List<AddressDto> list = new ArrayList<AddressDto>();
			if (ad.getAddress().size() > 0) {
				for (Address s : ad.getAddress()) {
					AddressDto d = new AddressDto();
					d.setId(s.getId());
					d.setDetailAddress(s.getDetailAddress());
					d.setPincode(s.getPinCode());
					if (s.getCity() != null) {
						d.setCityId(s.getCity().getId());
					}
					if (s.getCountry() != null) {
						d.setCountryId(s.getCountry().getId());
					}
					if (s.getState() != null) {
						d.setStateId(s.getState().getId());
					}

					list.add(d);
				}
			}
			dto.setAddress(list);
		}
		return dto;
	}
}
