package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.UserAddDto;
import com.techweaversys.dto.UserEditDto;
import com.techweaversys.dto.UserSpecDto;
import com.techweaversys.exception.UserAlreadyExistsException;
import com.techweaversys.service.UserService;

@RestController
@RequestMapping("/rest/api/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value ="add")
	public ResponseEntity<?> addUser(@RequestBody UserAddDto dto) throws UserAlreadyExistsException{
		return userService.addUser(dto);
	}
	@PostMapping(value ="edit")
	public ResponseEntity<?> editUser(@RequestBody UserEditDto dto)throws UserAlreadyExistsException{
		return userService.editUser(dto);
	}
	
	@PostMapping(value ="set")
	public ResponseEntity<?> resetPassword(@RequestBody UserEditDto dto){
		return userService.resetPassword(dto);
	}
	
	@GetMapping(value ="deactive/{id}")
	public ResponseEntity<?> deactivateUser(@PathVariable Long id){
		return userService.deactivateUser(id);
	}
	
	@PostMapping(value ="list")
	public ResponseEntity<?> listUser(@RequestBody UserSpecDto dto){
		return userService.listUser(dto);
		
	}
	
	@GetMapping(value ="findAll")
	public ResponseEntity<?> findAll(){
		return userService.findAll();
		
	}
	

}
