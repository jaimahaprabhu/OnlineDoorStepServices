package com.deloitte.service;

import java.util.Optional;

import com.deloitte.dto.UserDto;

public interface ServiceProviderUser {

	public Optional<UserDto> getLoginStatusAndDetails(String email, String pwd);

	public boolean doLogOut(String email);

	public boolean setUserDetails(UserDto userDto);
}
