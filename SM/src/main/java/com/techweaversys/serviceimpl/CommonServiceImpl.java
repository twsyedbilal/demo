package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.CityDto;
import com.techweaversys.dto.CountryDto;
import com.techweaversys.dto.StateDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Response;
import com.techweaversys.model.City;
import com.techweaversys.model.Country;
import com.techweaversys.model.State;
import com.techweaversys.repository.CityRepository;
import com.techweaversys.repository.CountryRepository;
import com.techweaversys.repository.StateRepository;
import com.techweaversys.service.CommonService;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
		
	@Autowired
	private CountryRepository countryRepository;
		
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> getCountryList() {
		logger.info("fetching country List ");
		List<Country> country = countryRepository.findAll();
		List<CountryDto> countryDto = country.stream().map(c -> modelMapper.map(c, CountryDto.class))
				.collect(Collectors.toList());
		return Response.build(Code.OK, countryDto);
	}

	@Override
	public ResponseEntity<?> getStateList(Long countryId) {
		logger.info("fetching states list");
		List<State> state = stateRepository.findAllByCountryId(countryId);
		List<StateDto> stateDto = state.stream().map(s -> modelMapper.map(s, StateDto.class))
				.collect(Collectors.toList());
		return Response.build(Code.OK, stateDto);
	}

	@Override
	public ResponseEntity<?> getCityList(Long stateId) {
		logger.info("fetching city list");
		List<City> city = cityRepository.findAllByStateId(stateId);
		List<CityDto> cityDto = city.stream().map(c -> modelMapper.map(c, CityDto.class)).collect(Collectors.toList());
		return Response.build(Code.OK, cityDto);
	}

	@Override
	public ResponseEntity<?> getCountryById(Long id) {
		Country country = countryRepository.getOne(id);
		CountryDto dto = modelMapper.map(country, CountryDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> getStateById(Long id) {
		City city = cityRepository.getOne(id);
		CityDto dto = modelMapper.map(city, CityDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> getCityById(Long id) {
		State state = stateRepository.getOne(id);
		StateDto dto = modelMapper.map(state, StateDto.class);
		return Response.build(Code.OK, dto);
	}

}
