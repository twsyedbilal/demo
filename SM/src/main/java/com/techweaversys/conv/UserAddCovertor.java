
package com.techweaversys.conv;

import java.util.function.Function;

import com.techweaversys.dto.UserAddDto;
import com.techweaversys.enums.StatusType;
import com.techweaversys.model.User;

public class UserAddCovertor implements Function<UserAddDto, User> {

	@Override
	public User apply(UserAddDto t) {
		User user = new User();
		user.setStatus(StatusType.Active.toString());
		user.setUsername(t.getUsername());
		user.setPassword(t.getPassword());
		user.setName(t.getName());
		user.setEmail(t.getEmail());
		user.setMobile(t.getMobile());
		return user;
	}

}
