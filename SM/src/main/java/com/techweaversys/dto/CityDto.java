package com.techweaversys.dto;

public class CityDto {

	private Long id;
	private String name;
	private StateDto stateDto;

	public CityDto() {
		super();
	}

	public CityDto(Long id, String name, StateDto stateDto) {
		super();
		this.id = id;
		this.name = name;
		this.stateDto = stateDto;
	}

	public StateDto getStateDto() {
		return stateDto;
	}

	public void setStateDto(StateDto stateDto) {
		this.stateDto = stateDto;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stateDto == null) ? 0 : stateDto.hashCode());
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
		CityDto other = (CityDto) obj;
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
		if (stateDto == null) {
			if (other.stateDto != null)
				return false;
		} else if (!stateDto.equals(other.stateDto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityDto [id=" + id + ", name=" + name + ", stateDto=" + stateDto + "]";
	}

}
