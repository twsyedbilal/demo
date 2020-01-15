package com.techweaversys.dto;

public class StateDto {

	private Long id;
	private String name;
	private CountryDto countryDto;

	public StateDto() {
		super();
	}

	public StateDto(Long id, String name, CountryDto countryDto) {
		super();
		this.id = id;
		this.name = name;
		this.countryDto = countryDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CountryDto getCountryDto() {
		return countryDto;
	}

	public void setCountryDto(CountryDto countryDto) {
		this.countryDto = countryDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryDto == null) ? 0 : countryDto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateDto other = (StateDto) obj;
		if (countryDto == null) {
			if (other.countryDto != null)
				return false;
		} else if (!countryDto.equals(other.countryDto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StateDto [id=" + id + ", name=" + name + ", countryDto=" + countryDto + "]";
	}

}
