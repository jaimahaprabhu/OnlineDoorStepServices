package com.deloitte.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.dto.UserDto;
import com.deloitte.service.ServiceProviderUserImpl;
import com.deloitte.utils.CommonConstants;

@RestController
@CrossOrigin(origins = CommonConstants.SERVER_ADDRESS)
public class ServiceProviderApi {

	@Autowired
	ServiceProviderUserImpl serviceProviderUserImpl;

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	@PostMapping(CommonConstants.LOGIN)
	@CrossOrigin(origins = CommonConstants.SERVER_ADDRESS)
	public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password) {
		Optional<UserDto> userDtoOpt = serviceProviderUserImpl.getLoginStatusAndDetails(email, password);
		return !userDtoOpt.isEmpty() ? new ResponseEntity<>(userDtoOpt.get(), HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param email
	 * @return
	 */
	@PutMapping(CommonConstants.LOGOUT)
	public ResponseEntity<Boolean> logout(@RequestParam String email) {
		return new ResponseEntity<>(serviceProviderUserImpl.doLogOut(email), HttpStatus.OK);
	}

	/**
	 * @param userDto
	 * @return
	 */
	@PostMapping(value = CommonConstants.REGISTRATION, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Boolean> registerUser(@RequestBody UserDto userDto) {
		serviceProviderUserImpl.setUserDetails(userDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
