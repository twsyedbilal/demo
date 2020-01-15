package com.techweaversys.conv;

import java.util.function.Function;

import com.techweaversys.dto.UserListDto;
import com.techweaversys.model.User;

public class UserDtoAutoConvertor implements Function<User, UserListDto> {

	@Override
	public UserListDto apply(User t) {
		UserListDto dto = new UserListDto();
		dto.setUsername(t.getUsername());
		dto.setId( t.getId() );
		dto.setName( t.getName() );
		return dto;
	}

}
